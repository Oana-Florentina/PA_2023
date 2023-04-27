package Homework;
import java.util.Scanner;
/**
 * ExplorationController is responsible for controlling the exploration
 * simulation by interacting with the user through the command line interface.
 * The user can start, pause, resume or stop the exploration by typing 's', 'p', 'r' or 'q' respectively.
 */
public class ExplorationController {
    private Exploration exploration;
    private Scanner scanner;
    private Timekeeper timekeeper;
    /**
     * Constructs an ExplorationController with an associated Exploration object and Timekeeper object.
     * @param exploration the exploration object to be controlled
     * @param timekeeper  the timekeeper object to keep track of the time limit
     */
    public ExplorationController(Exploration exploration, Timekeeper timekeeper) {
        this.exploration = exploration;
        this.timekeeper = timekeeper;
        this.scanner = new Scanner(System.in);
    }
    /**
     * Starts the exploration and listens for user input to control the simulation.
     * The user can start, pause, resume or stop the exploration by typing 's', 'p', 'r' or 'q' respectively.
     */
    public void start() {
        System.out.println("Press 's' to start the exploration, 'p' to pause the exploration, 'r' to resume it or 'q' to quit the program ");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("s")) {
                System.out.println("Exploration started");
                exploration.startRobots();
                new Thread(timekeeper).start();
                break;
            }
        }
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("p")) {
                System.out.println("Exploration paused, press 'r' to resume");
                exploration.pauseRobots();
            } else if (input.equals("r")) {
                System.out.println("Exploration resumed");
                exploration.resumeRobots();
            } else if (input.equals("q")) {
                System.out.println("Exiting program...");
                exploration.stopRobots();
                timekeeper.stop();
                System.out.println("Exploration time: " + timekeeper.getElapsedTime() / 1000 + " seconds");
                for (Robot robot : exploration.getRobots())
                    System.out.println(robot.getName() + " has placed " + robot.getNumTokensPlaced() + " tokens in the matrix");
                System.exit(0);
            }
        }
    }
    /**
     * The main method creates an Exploration object with a specified size,
     * number of robots and time limit.
     * It also creates a Timekeeper object and an ExplorationController object
     * with the Exploration and Timekeeper objects as parameters.
     * Finally, it starts the ExplorationController.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Exploration exploration = new Exploration(4, 3, 30000);
        Timekeeper timekeeper = new Timekeeper(30000, exploration);
        ExplorationController controller = new ExplorationController(exploration, timekeeper);
        controller.start();
    }
}
