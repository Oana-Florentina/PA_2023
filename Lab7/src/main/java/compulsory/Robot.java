package compulsory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
/**
 * The Map class represents the layout of the grid that the robots will traverse.
 */
public class Robot implements Runnable {
    private String name;
    int n;
    private int id;
    private int[][] map;
    private boolean[][] visited;
    private int currentRow;
    private int currentCol;
    private List<Integer> tokens;
    private Random rand;
    private Thread thread;

    public Thread getThread() {
        return thread;
    }
    public void setThread(Thread thread) {
        this.thread = thread;
    }
    /**
     * Constructs a new Robot object with the given name, ID, map, visited cell tracker, grid size, and shared memory.
     * @param name The name of the robot.
     * @param id The ID of the robot.
     * @param map The layout of the grid.
     * @param visited The 2D array keeping track of which cells have been visited.
     * @param n The size of the grid.
     * @param sharedMemory The shared memory containing the tokens.
     */
    public Robot(String name, int id, int[][] map, boolean[][] visited, int n, int[][] sharedMemory) {
        this.name = name;
        this.id = id;
        this.map = map;
        this.visited = visited;
        this.tokens = new ArrayList<>();
        this.n=n;
        this.rand = new Random();
        // Randomly initialize starting position
        this.currentRow = rand.nextInt(n);
        this.currentCol = rand.nextInt(n);
        // Extract n tokens from shared memory and store them in the robot's token list
        int numTokens = n*n;
        while (numTokens > 0) {
            int tokenIndex = rand.nextInt(n*n);
            int tokenValue = sharedMemory[tokenIndex / n][tokenIndex % n];
            if (!tokens.contains(tokenValue)) {
                tokens.add(tokenValue);
                numTokens--;
            }
        }
    }

    @Override
    public void run() {
        while (!isDone()) {
            move();
            if (!isDone()) {
                extractTokens();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }


    public boolean isDone() {
        // Check if all cells have been visited and all tokens have been extracted
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                if (!visited[row][col] ) {
                    return false;
                }
            }
        }



        return true;
    }

    public void move() {
        // Move the robot to a random position on the map that hasn't been visited yet
        int n = map.length;
        int numCells = n * n;
        int[] randomOrder = rand.ints(numCells, 0, numCells).toArray();

        for (int i = 0; i < numCells; i++) {
            int cellIndex = randomOrder[i];
            int row = cellIndex / n;
            int col = cellIndex % n;

            if (!visited[row][col]) {
                currentRow = row;
                currentCol = col;
                // System.out.println(name + " visited cell [" + currentRow + ", " + currentCol + "]");
                break;
            }
        }
    }

    /**
     * updates the state of the map and visited cells by extracting tokens
     * from shared memory and storing them in the current position of the robot.
     */
    public void extractTokens() {
        // Extract n tokens from shared memory and store them in the current position on the map
        int numTokens = n;

        for (int i = 0; i < numTokens; i++) {
            int tokenValue = tokens.remove(0);
            synchronized (map) {
                map[currentRow][currentCol] = tokenValue;
            }
        }
        synchronized (visited) {
            visited[currentRow][currentCol] = true;
        }
    }


    public String getName() {
        return this.name;
    }

    public int getCurrentRow() {
        return this.currentRow;
    }
    public int getCurrentCol() {
        return this.currentCol;
    }
}
