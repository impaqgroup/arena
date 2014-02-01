package com.impaq.arena;

import com.impaq.arena.rounds.impl.DefaultRoundManager;
import com.impaq.arena.view.VisualisationProvider;

/**
 * Hello world!
 *
 */
public class App {
    
    public static void main(String[] args) {
        final GameBoard gameBoard = new GameBoard(new DefaultRoundManager() {
            {
                add(new RoundStrategy() {
                    
                    @Override
                    public void body() {
                        budujZamek();
                    }
                });
            }
        }, new DefaultRoundManager() {
            {
                add(new RoundStrategy() {
                    
                    @Override
                    public void body() {
                        budujZamek();
                    }
                });
            }
        });
        gameBoard.registerListener(new VisualisationProvider().get());
        gameBoard.startGame();
    }
}
