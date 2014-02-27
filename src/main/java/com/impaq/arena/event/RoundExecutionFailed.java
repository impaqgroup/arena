package com.impaq.arena.event;

import com.impaq.arena.player.Player;

public class RoundExecutionFailed {

	private final Player player;

	private final Throwable cause;

	public RoundExecutionFailed(Player player, Throwable cause) {
		super();
		this.player = player;
		this.cause = cause;
	}

	public Player getPlayer() {
		return player;
	}

	public Throwable getCause() {
		return cause;
	}
}
