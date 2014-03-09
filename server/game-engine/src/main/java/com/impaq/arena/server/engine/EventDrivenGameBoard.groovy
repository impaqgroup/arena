package com.impaq.arena.server.engine

import com.google.common.eventbus.EventBus
import com.impaq.arena.api.PlayerStrategy
import com.impaq.arena.engine.GameConfig
import com.impaq.arena.engine.PlayerStrategyExecutor
import com.impaq.arena.engine.SimpleGameBoard
import com.impaq.arena.server.event.GameEnd
import com.impaq.arena.server.event.GameStarted
import com.impaq.arena.server.event.PlayerTurnStart
import com.impaq.arena.server.event.RoundExecutionFailed
import com.impaq.arena.server.event.RoundStart
import com.impaq.arena.player.Player

class EventDrivenGameBoard extends SimpleGameBoard {

    private final EventBus eventBus = new EventBus();

    EventDrivenGameBoard(GameConfig config, String firstPlayerId, PlayerStrategy firstPlayerStrategy,
            String secondPlayerId, PlayerStrategy secondPlayerStrategy) {
        super(config, firstPlayerId, firstPlayerStrategy, secondPlayerId, secondPlayerStrategy)
    }

    @Override
    protected PlayerStrategyExecutor buildPlayerStrategyExecutor(Player player, Player opponent) {
        return new EventDrivenPlayerStrategyExecutor(player, opponent, eventBus)
    }

    @Override
    protected void startGame(Player firstPlayer, Player secondPlayer) {
        super.startGame(firstPlayer, secondPlayer)
        eventBus.post(new GameStarted(firstPlayer, secondPlayer));
    }

    @Override
    protected void playRound(int round) {
        eventBus.post(new RoundStart(round))
        super.playRound(round)
    }

    @Override
    protected void playRound(PlayerStrategyExecutor playerExecutor) {
        eventBus.post(new PlayerTurnStart(playerExecutor.getPlayer()));
        try {
            super.playRound(playerExecutor)
        } catch (Exception ex) {
            eventBus.post(new RoundExecutionFailed(playerExecutor.getPlayer(), ex));
        }
    }

    @Override
    protected void endGame(Player firstPlayer, Player secondPlayer) {
        super.endGame(firstPlayer, secondPlayer)
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
