package com.impaq.arena.view;

import com.impaq.arena.GameBoardView;
import com.impaq.arena.view.swing.SwingViewPresenter;

/**
 *
 * @author jaro
 */
public enum VisualisationType {

    EMPTY {

                @Override
                public GameBoardView create() {
                    return new EmptyVisualisation();
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

    public static VisualisationType from(String value) {
        return (value == null || value.isEmpty()) ? CONSOLE : valueOf(value.toUpperCase());
    }

    public abstract GameBoardView create();
}
