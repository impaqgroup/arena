package com.impaq.arena;

import com.impaq.arena.api.Game;
import com.impaq.arena.api.PlayerStrategy;

public class TeamRedStrategy implements PlayerStrategy {

    @Override
    public void playRound(Game game) {
        if (game.spyEnemyBuildersCount()> 10) {
            game.recruitWizzards();
            game.recruitWizzards();
            game.attackEnemyBuilders();
        } else {
            game.recruitWarriors();
            game.recruitWarriors();
            game.attackEnemyCastle();
        }
    }
}
