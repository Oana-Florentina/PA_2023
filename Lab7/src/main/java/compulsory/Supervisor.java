package compulsory;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import java.util.List;
import java.util.ArrayList;

public class Supervisor {
    private List<Robot> robots;
    private int[][] sharedMemory;
    private Map map;

    public Supervisor(List<Robot> robots, int[][] sharedMemory, Map map) {
        this.robots = robots;
        this.sharedMemory = sharedMemory;
        this.map = map;
    }

    public void startAll() {
        for (Robot robot : robots) {
            start(robot);
        }
    }

    public void pauseAll() {
        for (Robot robot : robots) {
            pause(robot);
        }
    }

    private void start(Robot robot) {
        Thread thread = new Thread(() -> {
            while (!isDone()) {
                synchronized (robot) {
                    robot.move();
                    int row = robot.getCurrentRow();
                    int col = robot.getCurrentCol();
                    if (!map.isVisited(row, col)) {
                        map.markVisited(row, col);
                        System.out.println(robot.getName() + " visited cell (" + row + ", " + col + ")");
                        robot.extractTokens();
                    }
                }
            }
        });
        thread.start();
    }

    private void pause(Robot robot) {
        // To be implemented
    }

    private boolean isDone() {
        for (Robot robot : robots) {
            if (!robot.isDone()) {
                return false;
            }
        }
        return true;
    }
}
