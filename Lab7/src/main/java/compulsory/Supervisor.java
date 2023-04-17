package compulsory;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Supervisor {
    private List<Robot> robots;

    public Supervisor(List<Robot> robots) {
        this.robots = robots;
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

    public void start(Robot robot) {
        // TODO: start the given robot
    }

    public void pause(Robot robot) {
        // TODO: pause the given robot
    }

    public boolean isDone() {
        // Check if all cells on the map have been visited
        for (Robot robot : robots) {
            if (!robot.isDone()) {
                return false;
            }
        }
        return true;
    }

    public void run() {
        // Start all robots and wait until they are done exploring the map
        startAll();
        while (!isDone()) {
            // TODO: Implement some kind of waiting or sleeping mechanism here, so that the supervisor thread doesn't busy-wait
        }
        pauseAll();
    }
}