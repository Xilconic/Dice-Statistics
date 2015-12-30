package com.xilconic.gaming.dice.test.mocks;

import com.xilconic.gaming.dice.random.RandomIntegerGenerator;

/**
 * Stub of {@link RandomIntegerGenerator} that throws exceptions with each method call.
 */
public class RandomIntegerGeneratorStub implements RandomIntegerGenerator {
    @Override
    public int getFromInclusiveRange(int start, int end) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }
}
