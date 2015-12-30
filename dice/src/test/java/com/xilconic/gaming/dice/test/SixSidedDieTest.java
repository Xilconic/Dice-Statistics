package com.xilconic.gaming.dice.test;

import com.xilconic.gaming.dice.SixSidedDie;

import org.junit.Assert;
import org.junit.Test;

/**
 * Unit tests for {@link SixSidedDie}.
 */
public class SixSidedDieTest {

    @Test
    public void testDefaultConstructor() {
        SixSidedDie die = new SixSidedDie();

        Assert.assertEquals(false, die.isRolled());
    }

    @Test
    public void testRoll() {
        SixSidedDie die = new SixSidedDie();

        die.roll();

        Assert.assertEquals(true, die.isRolled());
    }

    @Test
    public void testGetRolledResultBeforeRolling() {
        SixSidedDie die = new SixSidedDie();

        try {
            die.getRolledValue();
            Assert.fail("An 'IllegalStateException' should be thrown when 'getRolledValue()' is called before 'roll()'.");
        } catch (IllegalStateException e) {
            Assert.assertEquals("Method 'roll()' should have been called before calling 'getRolledValue()'.", e.getMessage());
        }
    }
}
