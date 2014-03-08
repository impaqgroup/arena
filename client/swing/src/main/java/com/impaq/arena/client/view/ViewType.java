package com.impaq.arena.client.view;

import com.impaq.arena.server.engine.GameBoardView;
import com.impaq.arena.client.view.swing.SwingViewPresenter;
import com.impaq.arena.engine.GameConfig;

/**
 * 
 * @author jaro
 */
public enum ViewType {

	EMPTY {

		@Override
		public GameBoardView create(GameConfig config) {
			return new NullView();
		}

	},
	CONSOLE {

		@Override
		public GameBoardView create(GameConfig config) {
			return new ConsoleView();
		}

	},
	SWING {

		@Override
		public GameBoardView create(GameConfig config) {
			return new SwingViewPresenter(config);
		}

	};

	public static ViewType from(String value) {
		return (value == null || value.isEmpty()) ? CONSOLE : valueOf(value.toUpperCase());
	}

	public abstract GameBoardView create(GameConfig config);
}
