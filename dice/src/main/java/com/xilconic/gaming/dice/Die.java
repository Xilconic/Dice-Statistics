package com.xilconic.gaming.dice;

/**
 * Interface representing a die that can be rolled to get a resulting value.
 */
public interface Die {
    /**
     * Indicates if this die has been rolled or not.
     * @return true if this die has been rolled; false otherwise.
     */
    boolean isRolled();

    /**
     * Rolls the die to generate a result.
     */
    void roll();

    /**
     * Gets the integer representing the rolled result.
     * @return An integer.
     * @throws IllegalStateException When this method is called when {@link #isRolled} returns false.
     */
    int getRolledValue() throws IllegalStateException;
}
