package Homework;

import java.util.List;

public class Robot implements Runnable {
    private final String name;
    private final SharedMemory mem;
    private final ExplorationMap map;
    private final int numTokensToExtract;
    private volatile boolean isRunning;
    private volatile boolean isPaused;

    public Robot(String name, SharedMemory mem, ExplorationMap map, int numTokensToExtract) {
        this.name = name;
        this.mem = mem;
        this.map = map;
        this.numTokensToExtract = numTokensToExtract;
        this.isPaused = false;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    public String getName() {
        return name;
    }

    public List<Token> extractTokens() {
        return mem.extractTokens(numTokensToExtract);
    }

    public void pause() {
        this.isPaused = true;
    }

    public void resume() {
        synchronized (this) {
            this.isPaused = false;
            notifyAll();
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            synchronized (this) {
                while (isPaused) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted while waiting: " + e.getMessage());
                    }
                }
            }

            int n = map.getN();
            int row = (int) (Math.random() * n);
            int col = (int) (Math.random() * n);
            if (map.visit(row, col, this)) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    System.out.println("Interrupted while sleeping: " + e.getMessage());
                }
            }
            synchronized (this) {
                while (!isRunning || isPaused) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        System.out.println("Interrupted while waiting: " + e.getMessage());
                    }
                }
            }
        }
    }

}
