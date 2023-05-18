package homework;

public enum Player {
    PLAYER1('X'),
    PLAYER2('O');

    private char symbol;

    Player(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }

    public String getName() {
        return "Player " + (ordinal() + 1);
    }
}