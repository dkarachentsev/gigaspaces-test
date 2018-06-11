package com.aa.data;

import com.aa.model.FcOutput;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;
import org.jetbrains.annotations.NotNull;

/**
 *
 */
public class Generator implements Iterable<Map<Long, FcOutput>> {
    private static final int BATCH_SIZE = 1000;
    private final long max;

    private final AtomicLong cnt = new AtomicLong(0);

    public Generator(long max) {
        this.max = max;
    }

    @NotNull @Override public Iterator<Map<Long, FcOutput>> iterator() {
        return new FcIterator(max, cnt);
    }

    private static class FcIterator implements Iterator<Map<Long, FcOutput>> {
        private long intCnt;
        private AtomicLong cnt;
        private final long max;

        private FcIterator(long max, AtomicLong cnt) {
            this.max = max;
            this.cnt = cnt;
        }

        /** {@inheritDoc} */
        @Override public boolean hasNext() {
            return cnt.get() < max;
        }

        /** {@inheritDoc} */
        @Override public Map<Long, FcOutput> next() {
            long id = cnt.getAndAdd(BATCH_SIZE);

            Random rnd = ThreadLocalRandom.current();
            Map<Long, FcOutput> batch = new HashMap<>(BATCH_SIZE);

            for (final long last = id + BATCH_SIZE; id < last; id++) {
                FcOutput entity = new FcOutput("aaa", "bbb", id, 12345, 12345,
                    12345, (char)rnd.nextInt(Character.MAX_VALUE), (int)id, 12345, 12345);

                batch.put(entity.getKey(), entity);
            }

            return batch;
        }
    }
}
