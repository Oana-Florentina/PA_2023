package Homework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * A shared memory that contains a list of tokens.
 */
public class SharedMemory {
    /**
     * The list of tokens in the shared memory.
     */
    private final List<Token> tokens;

    /**
     * Constructs a shared memory with tokens based on the given size.
     *
     * @param n the size of the map (n x n).
     */
    public SharedMemory(int n) {
        tokens = new ArrayList<>(n * n * n);
        for (int i = 1; i <= n * n * n; i++) {
            tokens.add(new Token(i));
        }
        Collections.shuffle(tokens);
    }

    /**
     * Extracts a specified number of tokens from the shared memory.
     *
     * @param howMany the number of tokens to extract.
     * @return a list of tokens that were extracted.
     */
    public synchronized List<Token> extractTokens(int howMany) {
        List<Token> extracted = new ArrayList<>();
        for (int i = 0; i < howMany; i++) {
            if (tokens.isEmpty()) {
                break;
            }
            extracted.add(tokens.remove(0));
        }
        return extracted;
    }
}
