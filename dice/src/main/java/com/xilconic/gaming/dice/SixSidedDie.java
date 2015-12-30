package com.xilconic.gaming.dice;

/**
 * Class representing a 6-sided die.
 */
public class SixSidedDie implements Die {
    private boolean isRolled;

    @Override
    public boolean isRolled() {
        return isRolled;
    }

    @Override
    public void roll() {
        isRolled = true;
    }

    @Override
    public int getRolledValue() throws IllegalStateException {
        if (!isRolled) {
            throw new IllegalStateException("Method 'roll()' should have been called before calling 'getRolledValue()'.");
        }
        return 0;
    }
}
