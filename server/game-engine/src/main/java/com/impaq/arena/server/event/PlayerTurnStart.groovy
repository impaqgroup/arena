package com.impaq.arena.server.event;

import com.impaq.arena.player.Player;

class PlayerTurnStart {

    final Player player;

    PlayerTurnStart(Player player) {
        this.player = player
    }
}
