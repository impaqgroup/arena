package com.impaq.arena.client.view;

import com.impaq.arena.GameBoardView;
import com.impaq.arena.client.view.swing.SwingViewPresenter;

/**
 *
 * @author jaro
 */
public enum ViewType {

    EMPTY {

                @Override
                public GameBoardView create() {
                    return new NullView();
                }

            }, CONSOLE {

                @Override
                public GameBoardView create() {
                    return new ConsoleView();
                }

            }, SWING {

                @Override
                public GameBoardView create() {
                    return new SwingViewPresenter();
                }

            };

    public static ViewType from(String value) {
        return (value == null || value.isEmpty()) ? CONSOLE : valueOf(value.toUpperCase());
    }

    public abstract GameBoardView create();
}
