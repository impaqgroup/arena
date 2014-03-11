package com.impaq.arena.engine

import com.impaq.arena.api.Game
import com.impaq.arena.api.PlayerStrategy
import com.impaq.arena.player.Player
import groovy.transform.TypeChecked

@TypeChecked
class SimpleGameBoard {

    protected final GameConfig config;
    protected final Player firstPlayer;
    protected final Player secondPlayer;

    SimpleGameBoard(String firstPlayerId, PlayerStrategy firstPlayerStrategy,
                    String secondPlayerId, PlayerStrategy secondPlayerStrategy) {
        this(new DefaultGameConfig(), firstPlayerId, firstPlayerStrategy, secondPlayerId, secondPlayerStrategy)
    }

    SimpleGameBoard(GameConfig config, String firstPlayerId, PlayerStrategy firstPlayerStrategy,
            String secondPlayerId, PlayerStrategy secondPlayerStrategy) {
        this.config = config
        this.firstPlayer = new Player(firstPlayerId, firstPlayerStrategy, this.config)
        this.secondPlayer = new Player(secondPlayerId, secondPlayerStrategy, this.config)
    }


    final Player firstPlayer() {
        return firstPlayer
    }

    final Player secondPlayer() {
        return secondPlayer
    }

    final void playGame() {
        startGame();
		int round = 0;
		while (!isGameOver(round)) {
			playRound(++round);
		}
		endGame();
	}

	protected void startGame() {
	}

    protected void playRound(int round) {
        playRound(firstPlayer, secondPlayer);
        playRound(secondPlayer, firstPlayer);
	}

    protected void playRound(Player player, Player opponent) {
        player.getStrategy().playRound(nextRoundOf(player, opponent))
    }

    protected Game nextRoundOf(Player player, Player opponent) {
        return new SimpleGameRound(player, opponent)
    }

    protected final boolean isGameOver(int roundNumber) {
        return firstPlayer.isLoser() || firstPlayer.isWinner() ||
            secondPlayer.isLoser() || secondPlayer.isWinner() ||
            roundNumber >= config.maxRoundNumber();
    }

    protected void endGame() {
    }
}
