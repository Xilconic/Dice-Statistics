package com.xilconic.gaming.dice.test.mocks;

import com.xilconic.gaming.dice.random.RandomIntegerGenerator;

import java.util.List;

/**
 * Uses a predefined array to get random numbers from in order, to be used in tests.
 */
public class PredefinedRandomIntegerGenerator implements RandomIntegerGenerator {
    private int currentIndex;
    private List<Integer> results;

    /**
     * Initializes an instance of {@link PredefinedRandomIntegerGenerator} that uses a predefined
     * collection of integers as 'randomly generated values'.
     *
     * @param results The collection to draw results from.
     */
    public PredefinedRandomIntegerGenerator(List<Integer> results) {
        this.results = results;
    }

    @Override
    public int getFromInclusiveRange(int start, int end) throws IllegalArgumentException {
        if (end < start) {
            throw new IllegalArgumentException("Parameter 'end' cannot be less than parameter 'start'.");
        }
        int result = results.get(currentIndex++);
        if (result < start || result > end) {
            String message = String.format("Result set drew an invalid value (%d) given the range [%d, %d].",
                    result, start, end);
            throw new IllegalArgumentException(message);
        }
        return result;
    }
}
