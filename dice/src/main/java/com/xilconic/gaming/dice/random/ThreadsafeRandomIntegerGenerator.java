package com.xilconic.gaming.dice.random;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Defines a thread-safe implementation of {@link RandomIntegerGenerator}.
 */
public class ThreadsafeRandomIntegerGenerator implements RandomIntegerGenerator {
    private ThreadLocalRandom rng;

    public ThreadsafeRandomIntegerGenerator() {
        this.rng = ThreadLocalRandom.current();
    }

    @Override
    public int getFromInclusiveRange(int start, int end) throws IllegalArgumentException {
        return rng.nextInt(start, end++);
    }
}
