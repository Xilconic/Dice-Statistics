package com.xilconic.gaming.dice;

import com.xilconic.gaming.dice.random.RandomIntegerGenerator;

/**
 * Class representing a 6-sided die.
 */
public class SixSidedDie implements Die {
    private boolean isRolled;
    private RandomIntegerGenerator rng;
    private int rolledValue;

    /**
     * Instantiates a new instance of {@link SixSidedDie} using the given random number generator
     * to determine rolled results.
     *
     * @param rng The random number generator.
     */
    public SixSidedDie(RandomIntegerGenerator rng) {
        this.rng = rng;
    }

    @Override
    public boolean isRolled() {
        return isRolled;
    }

    @Override
    public void roll() {
        isRolled = true;
        rolledValue = rng.getFromInclusiveRange(1, 6);
    }

    @Override
    public int getRolledValue() throws IllegalStateException {
        if (!isRolled) {
            throw new IllegalStateException("Method 'roll()' should have been called before calling 'getRolledValue()'.");
        }
        return rolledValue;
    }
}
