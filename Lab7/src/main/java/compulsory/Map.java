package compulsory;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Map {
    private int n;
    private int[][] map;
    private boolean[][] visited;

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
}