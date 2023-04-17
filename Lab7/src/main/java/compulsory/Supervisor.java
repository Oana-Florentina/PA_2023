package compulsory;
import java.util.List;

/**
 * The Supervisor class manages the execution of multiple robots in a shared environment.
 */
public class Supervisor {
    private List<Robot> robots;
    private int[][] sharedMemory;
    private Map map;
    /**
     * Constructs a new Supervisor object.
     * @param robots the list of robots to be managed
     * @param sharedMemory the shared memory that the robots will access
     * @param map the map representing the environment being explored
     */
    public Supervisor(List<Robot> robots, int[][] sharedMemory, Map map) {
        this.robots = robots;
        this.sharedMemory = sharedMemory;
        this.map = map;
    }
    /**
     * Starts all the robots.
     */
    public void startAll() {
        for (Robot robot : robots) {
            start(robot);
        }
    }
    /**
     * Pause all the robots.
     */
    public void pauseAll() {
        for (Robot robot : robots) {
            pause(robot);
        }
    }
    /**
     * Starts the given robot in a new thread.
     * @param robot the robot to be started
     */
    private void start(Robot robot) {
        Thread thread = new Thread(() -> {
            while (!isDonee()) {
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
        robot.setThread(thread);
        thread.start();

    }

    /**
     * Checks if all the robots have completed their tasks.
     * @return true if all robots are done, false otherwise
     */
    private boolean isDonee() {
        for (Robot robot : robots) {
            if (!robot.isDone()) {
                return false;
            }
        }

        return true;
    }
    /**
     * Pauses the given robot's thread if it is currently running.
     * @param robot the robot to be paused
     */
    private void pause(Robot robot) {
        Thread robotThread = robot.getThread();
        if (robotThread != null && robotThread.isAlive()) {
            robotThread.interrupt();
            System.out.println(robot.getName() + " paused");
        }
        //TODO;
    }

}
