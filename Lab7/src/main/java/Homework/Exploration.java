package Homework;

import java.util.ArrayList;
import java.util.List;

/**
 * Exploration class represents a simulation of multiple robots exploring a shared memory area.
 * The exploration is limited by a time limit specified in the constructor.
 * The Exploration class provides methods to start, pause, resume and stop the robots.
 */
public class Exploration {
    /**
     * The shared memory used by the robots for communication.
     */
    private final SharedMemory mem;
    /**
     * The map representing the area to explore.
     */
    private final ExplorationMap map;
    /**
     * The list of robots participating in the exploration.
     */
    private final List<Robot> robots;
    /**
     * The timekeeper used to limit the duration of the exploration.
     */
    private final Timekeeper timekeeper;

    /**
     * Constructs an Exploration object with the specified parameters.
     *
     * @param n         the size of the shared memory and exploration map
     * @param numRobots the number of robots participating in the exploration
     * @param timeLimit the time limit for the exploration in milliseconds
     */
    public Exploration(int n, int numRobots, long timeLimit) {
        this.mem = new SharedMemory(n);
        this.map = new ExplorationMap(n);
        this.robots = new ArrayList<>(numRobots);
        for (int i = 1; i <= numRobots; i++) {
            this.robots.add(new Robot("Robot " + i, mem, map, n));
        }
        this.timekeeper = new Timekeeper(timeLimit, this);
        Thread timekeeperThread = new Thread(timekeeper);
        timekeeperThread.setDaemon(true);
        timekeeperThread.start();
    }

    /**
     * Starts all the robots participating in the exploration.
     */
    public void startRobots() {
        for (Robot robot : robots) {
            new Thread(robot).start();
            robot.setRunning(true);
        }
    }

    /**
     * Pauses all the robots participating in the exploration.
     */
    public void pauseRobots() {
        for (Robot robot : robots) {
            robot.setRunning(false);
        }
    }

    /**
     * Resumes all the robots participating in the exploration.
     */
    public void resumeRobots() {
        for (Robot robot : robots) {
            robot.setRunning(true);
            synchronized (robot) {
                robot.notify();
            }
        }
    }

    /**
     * Stops all the robots participating in the exploration.
     */
    public void stopRobots() {
        for (Robot robot : robots) {
            robot.setRunning(false);
            synchronized (robot) {
                robot.notify();
            }
        }
    }

    public List<Robot> getRobots() {
        return this.robots;
    }
}
