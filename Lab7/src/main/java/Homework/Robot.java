package Homework;

import java.util.List;

/**
 * A robot that can explore an exploration map and place tokens on its cells.
 */
public class Robot implements Runnable {
    /**
     * The name of the robot.
     */
    private final String name;

    /**
     * The shared memory object to extract tokens from.
     */
    private final SharedMemory mem;

    /**
     * The exploration map to place tokens on.
     */
    private final ExplorationMap map;

    /**
     * The number of tokens to extract from the shared memory object at a time.
     */
    private final int numTokensToExtract;

    /**
     * Whether the robot is currently running or not.
     */
    private volatile boolean isRunning;

    /**
     * Whether the robot is currently paused or not.
     */
    private volatile boolean isPaused;

    /**
     * The number of tokens the robot has placed on the exploration map.
     */
    private int numTokensPlaced;

    /**
     * Constructs a new robot with the given name, shared memory object, exploration map,
     * and number of tokens to extract.
     *
     * @param name               the name of the robot
     * @param mem                the shared memory object to extract tokens from
     * @param map                the exploration map to place tokens on
     * @param numTokensToExtract the number of tokens to extract from the shared memory object at a time
     */
    public Robot(String name, SharedMemory mem, ExplorationMap map, int numTokensToExtract) {
        this.name = name;
        this.mem = mem;
        this.map = map;
        this.numTokensToExtract = numTokensToExtract;
        this.isPaused = false;
    }

    /**
     * Sets whether the robot is currently running or not.
     *
     * @param isRunning true if the robot should be running, false otherwise
     */
    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }

    /**
     * Returns the name of the robot.
     *
     * @return the name of the robot
     */
    public String getName() {
        return name;
    }

    /**
     * Extracts the given number of tokens from the shared memory object.
     *
     * @return a list of the extracted tokens
     */
    public List<Token> extractTokens() {
        return mem.extractTokens(numTokensToExtract);
    }

    /**
     * Returns the number of tokens the robot has placed on the exploration map.
     *
     * @return the number of tokens the robot has placed on the exploration map
     */
    public int getNumTokensPlaced() {
        return numTokensPlaced;
    }

    /**
     * Runs the robot's exploration algorithm.
     */
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
                numTokensPlaced += n;
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
