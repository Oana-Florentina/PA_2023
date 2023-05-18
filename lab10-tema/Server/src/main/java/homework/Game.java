package homework;

public class Game {
    private Player currentPlayer;
    private Board board;
    private boolean gameOver;
    private Player winner;

    public Game() {
        currentPlayer = Player.PLAYER1;
        board = new Board();
        gameOver = false;
        winner = null;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Board getBoard() {
        return board;
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public Player getWinner() {
        return winner;
    }

    public boolean makeMove(int move) {
        int row = move / Board.SIZE;
        int col = move % Board.SIZE;

        if (row >= 0 && row < Board.SIZE && col >= 0 && col < Board.SIZE && board.isEmptyCell(row, col)) {
            char symbol = currentPlayer.getSymbol();
            board.setCell(row, col, symbol);

            if (checkWin(row, col)) {
                gameOver = true;
                winner = currentPlayer;
            } else if (isBoardFull()) {
                gameOver = true;
            } else {
                switchPlayer();
            }

            return true;
        }

        return false;
    }

    private boolean checkWin(int row, int col) {
        char symbol = currentPlayer.getSymbol();

        // Check row
        int count = 0;
        for (int c = col - 4; c <= col + 4; c++) {
            if (c >= 0 && c < Board.SIZE && board.getCell(row, c) == symbol) {
                count++;
                if (count >= 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // Check column
        count = 0;
        for (int r = row - 4; r <= row + 4; r++) {
            if (r >= 0 && r < Board.SIZE && board.getCell(r, col) == symbol) {
                count++;
                if (count >= 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // Check diagonal (top-left to bottom-right)
        count = 0;
        int startRow = Math.max(row - 4, 0);
        int startCol = Math.max(col - 4, 0);
        int endRow = Math.min(row + 4, Board.SIZE - 1);
        int endCol = Math.min(col + 4, Board.SIZE - 1);
        for (int r = startRow, c = startCol; r <= endRow && c <= endCol; r++, c++) {
            if (board.getCell(r, c) == symbol) {
                count++;
                if (count >= 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        // Check diagonal (top-right to bottom-left)
        count = 0;
        startRow = Math.max(row - 4, 0);
        startCol = Math.min(col + 4, Board.SIZE - 1);
        endRow = Math.min(row + 4, Board.SIZE - 1);
        endCol = Math.max(col - 4, 0);
        for (int r = startRow, c = startCol; r <= endRow && c >= endCol; r++, c--) {
            if (board.getCell(r, c) == symbol) {
                count++;
                if (count >= 5) {
                    return true;
                }
            } else {
                count = 0;
            }
        }

        return false;
    }

    private boolean isBoardFull() {
        for (int row = 0; row < Board.SIZE; row++) {
            for (int col = 0; col < Board.SIZE; col++) {
                if (board.isEmptyCell(row, col)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == Player.PLAYER1) ? Player.PLAYER2 : Player.PLAYER1;
    }
    public void start() {
        board.initializeCells();
    }
}
