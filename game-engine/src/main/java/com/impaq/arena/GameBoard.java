package com.impaq.arena;

import com.google.common.eventbus.EventBus;
import com.impaq.arena.api.PlayerStrategy;
import com.impaq.arena.event.GameStarted;
import com.impaq.arena.event.PlayerTurnStart;
import com.impaq.arena.event.RoundExecutionFailed;
import com.impaq.arena.event.RoundStart;
import com.impaq.arena.event.GameEnd;
import com.impaq.arena.player.Builders;
import com.impaq.arena.player.Castle;
import com.impaq.arena.player.Player;
import com.impaq.arena.player.Warriors;
import com.impaq.arena.player.Wizards;

public class GameBoard {

	private final Player firstPlayer;
    private final RoundExecutor firstPlayerExecutor;
	private final Player secondPlayer;
    private final RoundExecutor secondPlayerExecutor;
	private final EventBus eventBus = new EventBus();
	private final PropertySource properties = new PropertySource();

	public GameBoard(String firstPlayerId, PlayerStrategy firstPlayerStrategy,
            String secondPlayerId, PlayerStrategy secondPlayerStrategy) {
		properties.load();
        firstPlayer = createPlayer(firstPlayerId, firstPlayerStrategy);
        secondPlayer = createPlayer(secondPlayerId, secondPlayerStrategy);
        firstPlayerExecutor = new RoundExecutor(firstPlayer, secondPlayer, eventBus);
        secondPlayerExecutor = new RoundExecutor(secondPlayer, firstPlayer, eventBus);
	}

	private Player createPlayer(String id, PlayerStrategy strategy) {
		return new Player(id, strategy, createCastle(), createBuilders(),
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
		endGame();
	}

	public void initialize() {
		eventBus.post(new GameStarted(firstPlayer, secondPlayer));
	}

	public void executeRound() {
        eventBus.post(new PlayerTurnStart(firstPlayer));
		try {
			firstPlayerExecutor.playRound();
		} catch (Exception ex) {
			eventBus.post(new RoundExecutionFailed(firstPlayer, ex));
		}
        eventBus.post(new PlayerTurnStart(secondPlayer));
		try {
			secondPlayerExecutor.playRound();
		} catch (Exception ex) {
			eventBus.post(new RoundExecutionFailed(secondPlayer, ex));
		}
		
	}

	private void endGame() {
		Player winner = null;
		if (firstPlayer.isWinner() || secondPlayer.isLoser()) {
            winner = firstPlayer;
		}
		if (secondPlayer.isWinner() || firstPlayer.isLoser()) {
            winner = (winner == null) ? secondPlayer : null;
		}
        eventBus.post(new GameEnd(winner));
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
