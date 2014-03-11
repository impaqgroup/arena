package com.impaq.arena.server.engine

import com.google.common.eventbus.EventBus
import com.impaq.arena.api.Game
import com.impaq.arena.api.PlayerStrategy
import com.impaq.arena.engine.GameConfig
import com.impaq.arena.engine.SimpleGameBoard
import com.impaq.arena.player.Player
import com.impaq.arena.server.event.*
import groovy.transform.TypeChecked

@TypeChecked
class EventDrivenGameBoard extends SimpleGameBoard {

    private final EventBus eventBus = new EventBus();

    EventDrivenGameBoard(GameConfig config, String firstPlayerId, PlayerStrategy firstPlayerStrategy,
            String secondPlayerId, PlayerStrategy secondPlayerStrategy) {
        super(config, firstPlayerId, firstPlayerStrategy, secondPlayerId, secondPlayerStrategy)
    }

    @Override
    protected void startGame() {
        super.startGame()
        eventBus.post(new GameStarted(firstPlayer, secondPlayer));
    }

    @Override
    protected void playRound(int round) {
        eventBus.post(new RoundStart(round))
        super.playRound(round)
    }

    @Override
    protected void playRound(Player player, Player opponent) {
        eventBus.post(new PlayerTurnStart(player));
        try {
            super.playRound(player, opponent)
        } catch (Exception ex) {
            eventBus.post(new RoundExecutionFailed(player, ex));
        }
    }

    @Override
    protected Game nextRoundOf(Player player, Player opponent) {
        return new EventDrivenGameRound(player, opponent, eventBus)
    }

    @Override
    protected void endGame() {
        super.endGame()
        Player winner = null;
        if (firstPlayer.isWinner() || secondPlayer.isLoser()) {
            winner = firstPlayer;
        }
        if (secondPlayer.isWinner() || firstPlayer.isLoser()) {
            winner = (winner == null) ? secondPlayer : null;
        }
        eventBus.post(new GameEnd(winner));
    }

    public void registerView(GameBoardView listener) {
        eventBus.register(listener);
    }

    public void unregisterView(GameBoardView listener) {
        eventBus.unregister(listener);
    }
}
