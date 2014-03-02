package com.impaq.arena;

import org.mockito.Mockito;

import com.impaq.arena.api.PlayerStrategy;
import com.impaq.arena.player.Player;

public class TestGameBoard extends GameBoard {

    private static PlayerStrategy oponentRoundManager = Mockito.mock(PlayerStrategy.class);

    private final Player spyPlayer;
    private final Player spyOponent;

    private final TestEventBus eventBus = new TestEventBus();

	public TestGameBoard(PlayerStrategy firstPlayerStrategy ) {
		super("", firstPlayerStrategy, "", oponentRoundManager);
		spyPlayer = Mockito.spy(getFirstPlayer());
		spyOponent = Mockito.spy(getSecondPlayer());
	}

//	@Override
//    public void executeRound() {
//		spyPlayer.getStrategy().next().execute(eventBus, spyPlayer, spyOponent);
//    }
//
//	public void executeRound(int number){
//		while (number != 1 ) {
//			spyPlayer.getStrategy().next();
//			number--;
//		}
//		executeRound();
//	}
//
//	public TestGameBoard setOponentBuilders( int count ) {
//		setBuilders(spyOponent, count);
//		return this;
//	}
//
//	public TestGameBoard setBuilders( int count ) {
//		setBuilders(spyPlayer, count);
//		return this;
//	}
//
//	private void setBuilders(Player player, int count){
//		Builders spyBuilders = Mockito.spy(player.getBuilders());
//		when (player.getBuilders()).thenReturn(spyBuilders) ;
//		when (spyBuilders.spy()).thenReturn(count);
//	}
//
//	public TestGameBoard setOponentWarriors( int count ) {
//		setWarriors(spyOponent, count);
//		return this;
//	}
//
//	public TestGameBoard setWarriors( int count ) {
//		setWarriors(spyPlayer, count);
//		return this;
//	}
//
//	private void setWarriors( Player player, int count ) {
//		Warriors spyWarriors = Mockito.spy(player.getWarriors());
//		when (player.getWarriors()).thenReturn(spyWarriors) ;
//		when (spyWarriors.spy()).thenReturn(count);
//	}
//
//	public TestGameBoard setOponentWizards( int count ) {
//		setWizards(spyOponent, count);
//		return this;
//	}
//
//	public TestGameBoard setWizards( int count ) {
//		setWizards(spyPlayer, count);
//		return this;
//	}
//
//	private void setWizards( Player player, int count ) {
//		Wizards spyWizards = Mockito.spy(player.getWizards());
//		when (player.getWizards()).thenReturn(spyWizards) ;
//		when (spyWizards.spy()).thenReturn(count);
//	}
//
//	public TestGameBoard setOponentCastle( int height ) {
//		setCastle(spyOponent, height);
//		return this;
//	}
//
//	public TestGameBoard setCastle( int height ) {
//		setCastle(spyPlayer, height);
//		return this;
//	}
//
//	private void setCastle( Player player, int height ) {
//		Castle spyCastle = Mockito.spy(player.getCastle());
//		when (player.getCastle()).thenReturn(spyCastle) ;
//		when (spyCastle.spy()).thenReturn(height);
//	}
//
//	public TestEventBus getEventBus() {
//		return eventBus;
//	}
}
