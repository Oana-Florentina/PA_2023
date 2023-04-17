package compulsory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * The Map class represents the layout of the grid that the robots will traverse.
 */
public class Robot implements Runnable {
    private String name;
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
        this.rand = new Random();

        // Randomly initialize starting position
        this.currentRow = rand.nextInt(n);
        this.currentCol = rand.nextInt(n);

        // Extract n tokens from shared memory and store them in the robot's token list
        int numTokens = n;
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
            }
        }
    }


    public boolean isDone() {
        // Check if all cells have been visited and all tokens have been extracted
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                if (!visited[row][col] || map[row][col] != 0) {
                    return false;
                }
            }
        }

        return true;
    }

    public void move() {
        // Move the robot in a random direction, as long as it doesn't go out or into a visited cell
        int[] rowOffsets = {-1, 0, 1, 0};
        int[] colOffsets = {0, 1, 0, -1};
        int numDirections = 4;

        int direction = rand.nextInt(numDirections);
        int newRow = currentRow + rowOffsets[direction];
        int newCol = currentCol + colOffsets[direction];

        if (newRow >= 0 && newRow < map.length && newCol >= 0 && newCol < map[0].length && !visited[newRow][newCol]) {
            currentRow = newRow;
            currentCol = newCol;
           // System.out.println(name + " visited cell [" + currentRow + ", " + currentCol + "]");
        }
    }
    /**
     * updates the state of the map and visited cells by extracting tokens
     * from shared memory and storing them in the current position of the robot.
     */
    public void extractTokens() {
        // Extract n tokens from shared memory and store them in the current position on the map
        int numTokens = tokens.size();
        for (int i = 0; i < numTokens; i++) {
            synchronized (map) {
                map[currentRow][currentCol] = tokens.remove(0);
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
