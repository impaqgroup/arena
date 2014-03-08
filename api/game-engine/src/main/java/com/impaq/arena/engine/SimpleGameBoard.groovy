package com.impaq.arena.engine

import com.impaq.arena.api.PlayerStrategy
import com.impaq.arena.player.Player

class SimpleGameBoard {

    private final GameConfig config;
    private final PlayerStrategyExecutor firstPlayerExecutor;
    private final PlayerStrategyExecutor secondPlayerExecutor;

    SimpleGameBoard(String firstPlayerId, PlayerStrategy firstPlayerStrategy,
                    String secondPlayerId, PlayerStrategy secondPlayerStrategy) {
        this(new DefaultGameConfig(), firstPlayerId, firstPlayerStrategy, secondPlayerId, secondPlayerStrategy)
    }

    SimpleGameBoard(GameConfig config, String firstPlayerId, PlayerStrategy firstPlayerStrategy,
            String secondPlayerId, PlayerStrategy secondPlayerStrategy) {
        this.config = config;
        Player firstPlayer = new Player(firstPlayerId, firstPlayerStrategy, this.config);
        Player secondPlayer = new Player(secondPlayerId, secondPlayerStrategy, this.config);
        this.firstPlayerExecutor = buildPlayerStrategyExecutor(firstPlayer, secondPlayer);
        this.secondPlayerExecutor = buildPlayerStrategyExecutor(secondPlayer, firstPlayer);
    }

    protected PlayerStrategyExecutor buildPlayerStrategyExecutor(Player player, Player opponent) {
        return new SimplePlayerStrategyExecutor(player, opponent)
    }

    final Player firstPlayer() {
        return firstPlayerExecutor.getPlayer();
    }

    final Player secondPlayer() {
        return secondPlayerExecutor.getPlayer();
    }

    final void playGame() {
        startGame(firstPlayer(), secondPlayer());
		int round = 0;
		while (!isGameOver(round, firstPlayer(), secondPlayer())) {
			playRound(++round);
		}
		endGame(firstPlayer(), secondPlayer());
	}

	protected void startGame(Player firstPlayer, Player secondPlayer) {
	}

    protected void playRound(int round) {
        playRound(firstPlayerExecutor);
        playRound(secondPlayerExecutor);
	}

    protected void playRound(PlayerStrategyExecutor playerExecutor) {
        playerExecutor.playRound();
    }

    protected final boolean isGameOver(int roundNumber, Player firstPlayer, Player secondPlayer) {
        return firstPlayer.isLoser() || firstPlayer.isWinner() ||
            secondPlayer.isLoser() || secondPlayer.isWinner() ||
            roundNumber >= config.maxRoundNumber();
    }

    protected void endGame(Player firstPlayer, Player secondPlayer) {
    }
}
