package Compulsory;

import java.util.ArrayList;
import java.util.List;

public class Exploration {
    private final SharedMemory mem;
    private final ExplorationMap map;
    private final List<Robot> robots;

    public Exploration(int n, int numRobots) {
        this.mem = new SharedMemory(n);
        this.map = new ExplorationMap(n);
        this.robots = new ArrayList<>(numRobots);
        for (int i = 1; i <= numRobots; i++) {
            this.robots.add(new Robot("Robot " + i, mem, map, n));
        }
    }

    public void start() {
        List<Thread> threads = new ArrayList<>();
        for (Robot robot : robots) {
            Thread thread = new Thread(robot);
            threads.add(thread);
            thread.start();
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                System.out.println("Interrupted while waiting for thread to finish: " + e.getMessage());
            }
        }
        System.out.println("Exploration complete!");
        System.out.println(map.toString());
    }

}
