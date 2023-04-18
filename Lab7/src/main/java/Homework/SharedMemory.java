package Homework;

import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class SharedMemory {
    private final List<Token> tokens;

    public SharedMemory(int n) {
        tokens = new ArrayList<>(n * n * n);
        for (int i = 1; i <= n * n * n; i++) {
            tokens.add(new Token(i));
        }
        Collections.shuffle(tokens);
    }

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
