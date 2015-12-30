package com.xilconic.gaming.dice.test;

import com.xilconic.gaming.dice.SixSidedDie;
import com.xilconic.gaming.dice.test.mocks.PredefinedRandomIntegerGenerator;
import com.xilconic.gaming.dice.test.mocks.RandomIntegerGeneratorStub;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Unit tests for {@link SixSidedDie}.
 */
public class SixSidedDieTest {

    @Test
    public void testDefaultConstructor() {
        SixSidedDie die = new SixSidedDie(new RandomIntegerGeneratorStub());

        Assert.assertEquals(false, die.isRolled());
    }

    @Test
    public void testRoll() {
        ArrayList<Integer> results = new ArrayList<>();
        results.add(1);

        SixSidedDie die = new SixSidedDie(new PredefinedRandomIntegerGenerator(results));

        die.roll();

        Assert.assertEquals(true, die.isRolled());
    }

    @Test
    public void testGetRolledResultAfterRoll() {
        ArrayList<Integer> results = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            results.add(i);
        }

        SixSidedDie die = new SixSidedDie(new PredefinedRandomIntegerGenerator(results));

        for (int i = 0; i < results.size(); i++) {
            die.roll();

            Assert.assertEquals((int) results.get(i), die.getRolledValue());
        }
    }

    @Test
    public void testGetRolledResultBeforeRolling() {
        ArrayList<Integer> results = new ArrayList<>();
        results.add(1);

        SixSidedDie die = new SixSidedDie(new PredefinedRandomIntegerGenerator(results));

        try {
            die.getRolledValue();
            Assert.fail("An 'IllegalStateException' should be thrown when 'getRolledValue()' is called before 'roll()'.");
        } catch (IllegalStateException e) {
            Assert.assertEquals("Method 'roll()' should have been called before calling 'getRolledValue()'.", e.getMessage());
        }
    }
}
