package Homework;
import java.util.ArrayList;
import java.util.List;
public class Exploration {
    private final SharedMemory mem;
    private final ExplorationMap map;
    private final List<Robot> robots;
    private volatile boolean isRunning;
    private final Timekeeper timekeeper;

    public Exploration(int n, int numRobots,long timeLimit) {
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
    public void startRobots() {
        for (Robot robot : robots) {
            new Thread(robot).start();
            robot.setRunning(true);
        }
    }

    public void pauseRobots() {
        for (Robot robot : robots) {
            robot.setRunning(false);
        }
    }

    public void resumeRobots() {
        for (Robot robot : robots) {
            robot.setRunning(true);
            synchronized (robot) {
                robot.notify();
            }
        }
    }
    public void stopRobots() {
        for (Robot robot : robots) {
            robot.setRunning(false);
            synchronized (robot) {
                robot.notify();
            }
        }
    }


    public boolean isRunning() {
        return isRunning;
    }
    public List<Robot> getRobots() {
        return this.robots;
    }

}
