package Homework;


import java.util.ArrayList;
import java.util.List;

public class ExplorationMap {
    private final List<Token>[][] matrix;
    private final int n;
    private int filledCells;
    public ExplorationMap(int n) {
        this.n = n;
        this.matrix = new List[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = new ArrayList<>();
            }
        }
    }

    public boolean visit(int row, int col, Robot robot) {
        synchronized (matrix[row][col]) {
            if (matrix[row][col].isEmpty()) {
                matrix[row][col].addAll(robot.extractTokens());
                filledCells++;
                System.out.println(robot.getName() + " explored cell [" + row + "][" + col + "] and stored tokens " + matrix[row][col]);
                if (filledCells == matrix.length * matrix[0].length) {
                    System.out.println("Map completed!");
                }
                return true;
            } else {
                return false;
            }
        }
    }
    public int getN() {
        return n;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (List<Token>[] row : matrix) {
            for (List<Token> cell : row) {
                if (cell.isEmpty()) {
                    sb.append("[]");
                } else {
                    sb.append(cell.toString());
                }
                sb.append("\t");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
