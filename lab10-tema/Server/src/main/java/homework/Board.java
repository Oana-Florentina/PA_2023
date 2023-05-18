package homework;


public class Board {
   public char[][] cells;
    public static final int SIZE = 6;

    public Board() {
        cells = new char[SIZE][SIZE];
        initializeCells();
    }

    void initializeCells() {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                cells[row][col] = '-';
            }
        }
    }

    public void setCell(int row, int col, char symbol) {
        cells[row][col] = symbol;
    }

    public char getCell(int row, int col) {
        return cells[row][col];
    }

    public boolean isEmptyCell(int row, int col) {
        return cells[row][col] == '-';
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                sb.append(cells[row][col]);
                sb.append(' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}