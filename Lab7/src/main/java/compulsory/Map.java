package compulsory;
import java.util.ArrayList;
import java.util.List;

/**
 * The Map class represents an n x n square matrix, each cell being an individual location of the map.
 */
public class Map {
    /**
     * The size of the map (n x n).
     */
    private int n;
    private int[][] map;
    private boolean[][] visited;
    /**
     * Constructs a new Map object with the specified size.
     *
     * @param n the size of the map (n x n)
     */
    public Map(int n) {
        this.n = n;
        this.map = new int[n][n];
        this.visited = new boolean[n][n];
    }

    public boolean isVisited(int row, int col) {
        return visited[row][col];
    }

    public void markVisited(int row, int col) {
        visited[row][col] = true;
    }

    public List<int[]> getUnvisitedCells() {
        // Return a list of all unvisited cells on the map
        List<int[]> unvisitedCells = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (!visited[row][col]) {
                    int[] cell = {row, col};
                    unvisitedCells.add(cell);
                }
            }
        }
        return unvisitedCells;
    }

    public int[][] getMap() {
        return this.map;
    }
    public void printMap() {
        for (int row = 0; row < map.length; row++) {
            for (int col = 0; col < map[0].length; col++) {
                System.out.print(map[row][col] + " ");
            }
            System.out.println();
        }
    }
    public void addTokensToCell(int row, int col, int[] tokens) {
        if (row >= 0 && row < n && col >= 0 && col < n && !visited[row][col]) {
            map[row][col] += tokens.length;
            for (int i = 0; i < tokens.length; i++) {
                int token = tokens[i];
                if (token > 0 && token <= n * n * n) {
                    int x = (token - 1) / (n * n);
                    int y = (token - 1) / n % n;

                    if (x == row && y == col && !visited[x][y]) {
                        visited[x][y] = true;
                    }
                }
            }
        }
    }

}