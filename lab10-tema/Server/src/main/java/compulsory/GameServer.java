package compulsory;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import homework.*;
public class GameServer {
    public static final int PORT = 8100;

    private int gameIdCounter;
    private Map<Integer, Game> games;

    public GameServer() {
        gameIdCounter = 1;
        games = new HashMap<>();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started. Listening on port " + PORT);

            while (true) {
                System.out.println("Waiting for a client...");
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket);

                // Handle client connection in a separate thread
                new ClientThread(clientSocket, this).start();
            }
        } catch (IOException e) {
            System.err.println("Server error: " + e.getMessage());
        }
    }

    public void createGame(PrintWriter out) {
        Game game = new Game();
        games.put(gameIdCounter, game);
        out.println("Game created. Game ID: " + gameIdCounter);
        gameIdCounter++;
    }

    public void joinGame(PrintWriter out) {
        if (games.isEmpty()) {
            out.println("No game available to join. Please create a game first.");
        } else {
            int gameId = games.keySet().iterator().next();
            Game game = games.get(gameId);
            if (game.isGameOver()) {
                out.println("Game " + gameId + " has already ended. Please join another game.");
            } else {
                game.start();
                out.println("Game " + gameId + " joined. Current player: " + game.getCurrentPlayer().getName());
                out.println(game.getBoard().toString());
            }
        }
    }

    public void submitMove(PrintWriter out, int gameId, int move) {
        Game game = games.get(gameId);
        if (game == null) {
            out.println("Invalid game ID. Please join an existing game.");
        } else if (game.isGameOver()) {
            out.println("Game " + gameId + " has already ended. Please join another game.");
        } else if (game.getCurrentPlayer() != Player.PLAYER1 && game.getCurrentPlayer() != Player.PLAYER2) {
            out.println("Player is not assigned. Please join the game first.");
        } else {
            boolean moveResult = game.makeMove(move);
            if (moveResult) {
                out.println("Move successful. Current player: " + game.getCurrentPlayer().getName());
                out.println(game.getBoard().toString());

                if (game.isGameOver()) {
                    if (game.getWinner() != null) {
                        out.println("Game over. The winner is: " + game.getWinner().getName());
                    } else {
                        out.println("Game over. It's a draw.");
                    }
                }
            } else {
                out.println("Invalid move. Please select an empty cell.");
            }
        }
    }
    public static void main(String[] args) {
        GameServer gameServer = new GameServer();
        gameServer.start();
    }
}