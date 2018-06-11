package com.aa.data.ignite;

import com.aa.data.Generator;
import com.aa.model.FcOutput;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteDataStreamer;
import org.apache.ignite.Ignition;

/**
 *
 */
public class IgLoader {
    public static void main(String[] args) {
        try (Ignite client = Ignition.start(IgniteClusterStart.config(false))) {
            IgniteDataStreamer<Long, FcOutput> streamer = client.dataStreamer("test");

            Generator generator = new Generator(1_000_000);

            long start = System.currentTimeMillis();

            ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

            final LongAdder cnt = new LongAdder();

            for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
                pool.execute(() -> {
                    for (Map<Long, FcOutput> batch : generator) {

                        cnt.add(batch.size());

                        streamer.addData(batch);
                    }
                });
            }

            pool.shutdown();
            pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);

            streamer.flush();

            long end = System.currentTimeMillis();

            System.out.println("All data loaded in " + (end - start) + ", entries: " + cnt);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
