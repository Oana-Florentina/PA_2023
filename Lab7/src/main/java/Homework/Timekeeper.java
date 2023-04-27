package Homework;

/**
 * A class that keeps track of elapsed time and stops an exploration if the time limit is exceeded.
 */
public class Timekeeper implements Runnable {
    /**
     * The time limit in milliseconds.
     */
    private final long timeLimit;

    /**
     * The exploration to be timed.
     */
    private final Exploration exploration;

    /**
     * A flag indicating whether the timekeeper is still running.
     */
    private volatile boolean isRunning;

    /**
     * The elapsed time in milliseconds.
     */
    private volatile long elapsedTime;

    /**
     * Creates a new Timekeeper object.
     *
     * @param timeLimit   the time limit in milliseconds
     * @param exploration the exploration to be timed
     */
    public Timekeeper(long timeLimit, Exploration exploration) {
        this.timeLimit = timeLimit;
        this.exploration = exploration;
        this.isRunning = true;
        this.elapsedTime = 0;
    }

    /**
     * Stops the timekeeper.
     */
    public void stop() {
        this.isRunning = false;
    }

    /**
     * Gets the elapsed time.
     *
     * @return the elapsed time in milliseconds
     */
    public long getElapsedTime() {
        return elapsedTime;
    }

    /**
     * Runs the timekeeper.
     */
    @Override
    public void run() {
        long startTime = System.currentTimeMillis();
        while (isRunning) {
            elapsedTime = System.currentTimeMillis() - startTime;
            if (elapsedTime >= timeLimit) {
                System.out.println("Exploration time limit exceeded");
                exploration.stopRobots();
                stop();
            }
            try {
                Thread.sleep(1000); // update every second
            } catch (InterruptedException e) {
                System.out.println("Interrupted while sleeping: " + e.getMessage());
            }
        }
    }
}
