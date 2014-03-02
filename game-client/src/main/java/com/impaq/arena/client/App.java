package com.impaq.arena.client;

import com.impaq.arena.GameBoard;
import com.impaq.arena.client.view.ConsoleView;
import com.impaq.arena.client.view.ViewProvider;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        final GameBoard gameBoard = new GameBoard("blue", new TeamBlueStrategy(), "red", new TeamRedStrategy());
        gameBoard.registerView(new ViewProvider().get());
        gameBoard.registerView(new ConsoleView());
        gameBoard.startGame();
    }
}
