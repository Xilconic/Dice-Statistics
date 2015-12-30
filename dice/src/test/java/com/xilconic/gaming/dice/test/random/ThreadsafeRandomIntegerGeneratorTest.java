package com.xilconic.gaming.dice.test.random;

import com.xilconic.gaming.dice.random.ThreadsafeRandomIntegerGenerator;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for {@link ThreadsafeRandomIntegerGenerator}.
 */
public class ThreadsafeRandomIntegerGeneratorTest {
    @Test
    public void testGetFromInclusiveRange() {
        ThreadsafeRandomIntegerGenerator generator = new ThreadsafeRandomIntegerGenerator();
        final int lowerBound = 5;
        final int upperBound = 12;

        for (int i = 0; i < 10000; i++) {
            int result = generator.getFromInclusiveRange(lowerBound, upperBound);
            assertIsInRange(lowerBound, upperBound, result);
        }
    }

    private void assertIsInRange(int expectedLowerBound, int expectedUpperBound, int actual) {
        String errorMessage = String.format("Expected in range [%d,%d], but was %d",
                expectedLowerBound, expectedUpperBound, actual);
        Assert.assertEquals(errorMessage, true, actual <= expectedUpperBound);
        Assert.assertEquals(errorMessage, true, expectedLowerBound <= actual);
    }
}
