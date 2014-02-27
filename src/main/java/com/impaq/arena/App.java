package com.impaq.arena;

import com.impaq.arena.view.ConsoleView;
import com.impaq.arena.view.ViewProvider;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        final GameBoard gameBoard = new GameBoard(new TeamBlueStrategy(), new TeamRedStrategy());
        gameBoard.registerView(new ViewProvider().get());
        gameBoard.registerView(new ConsoleView());
        gameBoard.startGame();
    }
}
