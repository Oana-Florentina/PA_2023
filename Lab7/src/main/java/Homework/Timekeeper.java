package Homework;

public class Timekeeper implements Runnable {
    private final long timeLimit; // time limit in milliseconds
    private final Exploration exploration;
    private volatile boolean isRunning;
    private volatile long elapsedTime; // elapsed time in milliseconds

    public Timekeeper(long timeLimit, Exploration exploration) {
        this.timeLimit = timeLimit;
        this.exploration = exploration;
        this.isRunning = true;
        this.elapsedTime = 0;
    }

    public void stop() {
        this.isRunning = false;
    }

    public long getElapsedTime() {
        return elapsedTime;
    }

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
