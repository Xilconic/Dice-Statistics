package com.xilconic.gaming.dice.test.mocks;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Unit tests for {@link PredefinedRandomIntegerGenerator}.
 */
public class PredefinedRandomIntegerGeneratorTest {
    @Test
    public void testGetFromInclusiveRange() {
        List<Integer> resultCollection = new ArrayList<>(3);
        resultCollection.add(1);
        resultCollection.add(2);
        resultCollection.add(4);

        PredefinedRandomIntegerGenerator rng = new PredefinedRandomIntegerGenerator(resultCollection);

        Assert.assertEquals((long) resultCollection.get(0), rng.getFromInclusiveRange(1, 4));
        Assert.assertEquals((long) resultCollection.get(1), rng.getFromInclusiveRange(1, 4));
        Assert.assertEquals((long) resultCollection.get(2), rng.getFromInclusiveRange(1, 4));
    }

    @Test
    public void testGetFromInclusiveRangeWithDrawnResultLessThanStartThrowsIllegalArgumentException() {
        List<Integer> resultCollection = new ArrayList<>(3);
        resultCollection.add(1);

        PredefinedRandomIntegerGenerator rng = new PredefinedRandomIntegerGenerator(resultCollection);

        try {
            rng.getFromInclusiveRange(2, 3);
            Assert.fail("'getFromInclusiveRange(int, int)' should have thrown an IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Result set drew an invalid value (1) given the range [2, 3].", e.getMessage());
        }
    }

    @Test
    public void testGetFromInclusiveRangeWithDrawnResultGreaterThanEndThrowsIllegalArgumentException() {
        List<Integer> resultCollection = new ArrayList<>(3);
        resultCollection.add(4);

        PredefinedRandomIntegerGenerator rng = new PredefinedRandomIntegerGenerator(resultCollection);

        try {
            rng.getFromInclusiveRange(2, 3);
            Assert.fail("'getFromInclusiveRange(int, int)' should have thrown an IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Result set drew an invalid value (4) given the range [2, 3].", e.getMessage());
        }
    }

    @Test
    public void testGetFromInclusiveRangeWithEndLessThanStartThrowsIllegalArgumentException() {
        List<Integer> resultCollection = new ArrayList<>(3);
        resultCollection.add(1);

        PredefinedRandomIntegerGenerator rng = new PredefinedRandomIntegerGenerator(resultCollection);

        try {
            rng.getFromInclusiveRange(1, 0);
            Assert.fail("'getFromInclusiveRange(int, int)' should have thrown an IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            Assert.assertEquals("Parameter 'end' cannot be less than parameter 'start'.", e.getMessage());
        }
    }
}
