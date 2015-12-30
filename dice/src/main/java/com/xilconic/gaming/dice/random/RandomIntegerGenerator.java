package com.xilconic.gaming.dice.random;

/**
 * Defines the interface of a random number generator for integers.
 */
public interface RandomIntegerGenerator {

    /**
     * Generates an integer in the range [{@code start}, {@code end}].
     *
     * @param start The inclusive start of the range.
     * @param end   The inclusive end of the range.
     * @return An integer within the given range.
     * @throws IllegalArgumentException When {@code end} is less than {@code start}.
     */
    int getFromInclusiveRange(int start, int end) throws IllegalArgumentException;
}
