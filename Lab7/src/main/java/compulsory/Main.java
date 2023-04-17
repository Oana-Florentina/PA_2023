package compulsory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Initialize parameters
        int n = 3;  // Map size
        int numRobots = 3;  // Number of robots
        int numTokens = n;  // Number of tokens per robot

        // Create shared memory
        int[][] sharedMemory = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sharedMemory[i][j] = i*n + j + 1;  // Assign a unique token value to each cell
            }
        }

        // Create map
        Map map = new Map(n);
        boolean visited[][]= new boolean[n][n];
        // Create robots
        List<Robot> robots = new ArrayList<>();
        for (int i = 0; i < numRobots; i++) {
            Robot robot = new Robot("Robot" + (i+1), i+1, map.getMap(), visited, n, sharedMemory);
            robots.add(robot);
        }

        // Create supervisor
        Supervisor supervisor = new Supervisor(robots, sharedMemory, map);

        // Start robots
        supervisor.startAll();

    }

}
