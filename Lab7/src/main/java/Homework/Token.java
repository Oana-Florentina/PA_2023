package Homework;

/**
 * The `Token` class represents a token with a unique number.
 */
public class Token {
    /**
     * The number associated with this token.
     */
    private final int number;

    /**
     * Constructs a new `Token` with the given number.
     *
     * @param number the number associated with this token
     */
    public Token(int number) {
        this.number = number;
    }

    /**
     * Returns the number associated with this token.
     *
     * @return the number associated with this token
     */
    public int getNumber() {
        return number;
    }

    /**
     * Returns a string representation of this token.
     *
     * @return a string representation of this token
     */
    @Override
    public String toString() {
        return "Token " + number;
    }
}
