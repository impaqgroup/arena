package com.impaq.arena;

import com.impaq.arena.view.ConsoleView;
import com.impaq.arena.view.ViewProvider;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        final GameBoard gameBoard = new GameBoard(new BlueTeamStrategy(), new TeamRedStrategy());
        gameBoard.registerListener(new ViewProvider().get());
        gameBoard.registerListener(new ConsoleView());
        gameBoard.startGame();
    }
}
