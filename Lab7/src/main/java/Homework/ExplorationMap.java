package Homework;

import java.util.ArrayList;
import java.util.List;

/**
 * ExplorationMap class represents a 2D matrix of cells, where each cell may hold a list of tokens
 * and is used to track the exploration progress of the robots.
 */
public class ExplorationMap {
    /**
     * A 2D matrix of cells, where each cell may hold a list of tokens.
     */
    private final List<Token>[][] matrix;
    /**
     * The number of rows and columns of the matrix.
     */
    private final int n;
    /**
     * The number of cells in the matrix that are filled with tokens.
     */
    private int filledCells;

    /**
     * Creates a new ExplorationMap instance with the given number of rows and columns.
     * Initializes the matrix with empty lists of tokens for each cell.
     *
     * @param n the number of rows and columns of the matrix
     */
    public ExplorationMap(int n) {
        this.n = n;
        this.matrix = new List[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = new ArrayList<>();
            }
        }
    }

    /**
     * Attempts to visit the cell at the given row and column with the given robot.
     * If the cell is empty, the robot stores its tokens in the cell and the method returns true.
     * If the cell is not empty, the method returns false.
     *
     * @param row   the row of the cell to visit
     * @param col   the column of the cell to visit
     * @param robot the robot that attempts to visit the cell
     * @return true if the cell was visited successfully and false otherwise
     */
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

    /**
     * Returns the number of rows and columns of the matrix.
     *
     * @return the number of rows and columns of the matrix
     */
    public int getN() {
        return n;
    }

    /**
     * Returns a string representation of the matrix,
     * where each cell is represented by its list of tokens.
     *
     * @return a string representation of the matrix
     */
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
