package com.aa.data.gigaspaces;

import com.aa.data.Generator;
import com.aa.model.FcOutput;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import org.openspaces.core.GigaSpace;
import org.openspaces.core.GigaSpaceConfigurer;
import org.openspaces.core.space.SpaceProxyConfigurer;

/**
 *
 */
public class GSLoader {
    public static void main(String[] args) throws InterruptedException {
        GigaSpace space = new GigaSpaceConfigurer(new SpaceProxyConfigurer("test")).gigaSpace();

        Generator generator = new Generator(1_000_000);

        ExecutorService pool = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        long start = System.currentTimeMillis();

        final LongAdder cnt = new LongAdder();

        for (int i = 0; i < Runtime.getRuntime().availableProcessors(); i++) {
            pool.execute(() -> {
                for (Map<Long, FcOutput> batch : generator) {

                    cnt.add(batch.size());

                    space.writeMultiple(batch.values().toArray());
                }
            });
        }

        pool.shutdown();
        pool.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);

        long end = System.currentTimeMillis();

        System.out.println("All data loaded in " + (end - start) + ", entries: " + cnt.longValue());
    }
}
