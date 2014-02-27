package com.impaq.arena;

import com.google.common.eventbus.EventBus;
import com.impaq.arena.event.GameStarted;
import com.impaq.arena.event.RoundExecutionFailed;
import com.impaq.arena.event.RoundStart;
import com.impaq.arena.event.Winner;
import com.impaq.arena.player.Builders;
import com.impaq.arena.player.Castle;
import com.impaq.arena.player.Player;
import com.impaq.arena.player.PropertyNames;
import com.impaq.arena.player.Warriors;
import com.impaq.arena.player.Wizards;

public class GameBoard {

	private final Player firstPlayer;
	private final Player secondPlayer;
	private final EventBus eventBus = new EventBus();
	private final PropertySource properties = new PropertySource();

	public GameBoard(Strategy firstPlayerStrategy, Strategy secondPlayerStrategy) {
		properties.load();
		firstPlayer = createPlayer(firstPlayerStrategy);
		secondPlayer = createPlayer(secondPlayerStrategy);
	}

	private Player createPlayer(Strategy strategy) {
		return new Player(strategy, createCastle(), createBuilders(),
				createWizards(), createWarriors());
	}

	private Warriors createWarriors() {
		return new Warriors(
				properties.getInt(PropertyNames.WARRIORS_START_COUNT),
				properties.getDouble(PropertyNames.WARRIORS_STRENGTH));
	}

	private Wizards createWizards() {
		return new Wizards(
				properties.getInt(PropertyNames.WIZARDS_START_COUNT),
				properties.getDouble(PropertyNames.WIZARDS_STRENGTH));
	}

	private Builders createBuilders() {
		return new Builders(
				properties.getInt(PropertyNames.BUILDERS_START_COUNT),
				properties.getDouble(PropertyNames.BUILDERS_PRODUCTIVITY));
	}

	private Castle createCastle() {
		return new Castle(properties.getInt(PropertyNames.CASTLE_MAX_HEIGHT),
				properties.getInt(PropertyNames.CASTLE_START_HEIGHT));
	}

	public void startGame() {
		initialize();
		int round = 0;
		while (!isGameOver()) {
			eventBus.post(new RoundStart(++round));
			executeRound();
		}
		showWinner();
	}

	public void initialize() {
		eventBus.post(new GameStarted(firstPlayer, secondPlayer));
	}

	public void executeRound() {
		try {
			firstPlayer.getStrategy().next().execute(eventBus, firstPlayer, secondPlayer);
		} catch (Exception ex) {
			eventBus.post(new RoundExecutionFailed(firstPlayer, ex));
		}
		try {
			secondPlayer.getStrategy().next().execute(eventBus, secondPlayer, firstPlayer);
		} catch (Exception ex) {
			eventBus.post(new RoundExecutionFailed(secondPlayer, ex));
		}
		
	}

	private void showWinner() {

		// FIXME add notification about draw
		if (firstPlayer.isWinner() || secondPlayer.isLoser()) {
			eventBus.post(new Winner(firstPlayer));
		}
		if (secondPlayer.isWinner() || firstPlayer.isLoser()) {
			eventBus.post(new Winner(secondPlayer));
		}
	}

	public Player getFirstPlayer() {
		return firstPlayer;
	}

	public Player getSecondPlayer() {
		return secondPlayer;
	}

	public boolean isGameOver() {
		return firstPlayer.isLoser() || firstPlayer.isWinner()
				|| secondPlayer.isLoser() || secondPlayer.isWinner();
	}

	public void registerView(GameBoardView listener) {
		eventBus.register(listener);
	}

	public void unregisterView(GameBoardView listener) {
		eventBus.unregister(listener);
	}

}
