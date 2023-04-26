package Homework;

import java.util.Scanner;

public class ExplorationController {
    private Exploration exploration;
    private Scanner scanner;

    public ExplorationController(Exploration exploration) {
        this.exploration = exploration;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("Press 's' to start the exploration");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("s")) {
                System.out.println("Exploration started");
                exploration.startRobots();
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
            }
        }
    }
    public static void main(String[] args) {
        Exploration exploration = new Exploration(5, 3);
        ExplorationController controller = new ExplorationController(exploration);
        controller.start();
    }
}
