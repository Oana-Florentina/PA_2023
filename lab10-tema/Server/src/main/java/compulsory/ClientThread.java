package compulsory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket clientSocket;
    private GameServer gameServer;

    public ClientThread(Socket clientSocket, GameServer gameServer) {
        this.clientSocket = clientSocket;
        this.gameServer = gameServer;
    }

    @Override
    public void run() {
        try (
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)
        ) {
            out.println("Welcome to Gomoku! You are connected to the game server.");

            String request;
            while ((request = in.readLine()) != null) {
                if (request.equals("exit")) {
                    break;
                } else if (request.equals("create game")) {
                    gameServer.createGame(out);
                } else if (request.equals("join game")) {
                    gameServer.joinGame(out);
                } else if (request.startsWith("submit move")) {
                    String[] tokens = request.split(" ");
                    if (tokens.length == 4) {
                        int gameId = Integer.parseInt(tokens[2]);
                        int move = Integer.parseInt(tokens[3]);
                        gameServer.submitMove(out, gameId, move);
                    } else {
                        out.println("Invalid submit move command. Please specify game ID and move.");
                    }
                } else {
                    out.println("Invalid command. Available commands: create game, join game, submit move <gameId> <move>, exit");
                }
            }
        } catch (IOException e) {
            System.err.println("Error handling client request: " + e.getMessage());
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println("Error closing client socket: " + e.getMessage());
            }
        }
    }
}
