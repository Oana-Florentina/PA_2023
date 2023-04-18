package Compulsory;

import java.util.List;

public class Robot implements Runnable {
    private final String name;
    private final SharedMemory mem;
    private final ExplorationMap map;
    private final int numTokensToExtract;

    public Robot(String name, SharedMemory mem, ExplorationMap map, int numTokensToExtract) {
        this.name = name;
        this.mem = mem;
        this.map = map;
        this.numTokensToExtract = numTokensToExtract;
    }

    public String getName() {
        return name;
    }

    public List<Token> extractTokens() {
        return mem.extractTokens(numTokensToExtract);
    }

    @Override
    public void run() {
        while (true) {
            int n = map.getN();
            int row = (int) (Math.random() * n);
            int col = (int) (Math.random() * n);
            if (map.visit(row, col, this)) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted while sleeping: " + e.getMessage());
                }
            }
        }
    }
}
