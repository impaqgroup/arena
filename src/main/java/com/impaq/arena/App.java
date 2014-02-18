package com.impaq.arena;

import com.impaq.arena.rounds.impl.DefaultStrategy;
import com.impaq.arena.view.ConsoleView;
import com.impaq.arena.view.ViewProvider;

/**
 * Hello world!
 *
 */
public class App {
    
    public static void main(String[] args) {
        final GameBoard gameBoard = new GameBoard(new DefaultStrategy() {
            {
                add(new RoundStrategy() {
                    
                    @Override
                    public void body() {
                        budujZamek();
                        if(wysokoscZamkuWroga()>10)
                        zabijMagow();
                    }
                });
            }
        }, new DefaultStrategy() {
            {
                add(new RoundStrategy() {
                    
                    @Override
                    public void body() {
                        budujZamek();
                    }
                });
            }
        });
        gameBoard.registerListener(new ViewProvider().get());
        gameBoard.registerListener(new ConsoleView());
        gameBoard.startGame();
    }
}
