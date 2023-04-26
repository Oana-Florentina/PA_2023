package Homework;

import java.util.Scanner;

public class ExplorationController {
    private Exploration exploration;
    private Scanner scanner;
    private Timekeeper timekeeper;

    public ExplorationController(Exploration exploration, Timekeeper timekeeper) {
        this.exploration = exploration;
        this.timekeeper = timekeeper;
        this.scanner = new Scanner(System.in);
    }

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
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        Exploration exploration = new Exploration(5, 3, 30000);
        Timekeeper timekeeper = new Timekeeper(30000, exploration);
        ExplorationController controller = new ExplorationController(exploration, timekeeper);
        controller.start();
    }
}
