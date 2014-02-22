package com.impaq.arena;

import org.mockito.Mockito;

import static org.mockito.Mockito.when;

import com.impaq.arena.player.Builders;
import com.impaq.arena.player.Castle;
import com.impaq.arena.player.Player;
import com.impaq.arena.player.Warriors;
import com.impaq.arena.player.Wizards;

public class TestGameBoard extends GameBoard {

    private static Strategy oponentRoundManager = Mockito.mock(Strategy.class);
        
    private final Player spyPlayer;
    private final Player spyOponent;
    
    private final TestEventBus eventBus = new TestEventBus();
    
	public TestGameBoard(Strategy firstPlayerStrategy ) {
		super(firstPlayerStrategy, oponentRoundManager);
		spyPlayer = Mockito.spy(getFirstPlayer());
		spyOponent = Mockito.spy(getSecondPlayer());
	}

	@Override
    public void executeRound() {
		spyPlayer.getStrategy().next().execute(eventBus, spyPlayer, spyOponent);
    }
	
	public TestGameBoard setOponentBuildersCount( int count ) {
		spyBuildersCount(spyOponent, count);
		return this;
	}
	
	public TestGameBoard setBuildersCount( int count ) {
		spyBuildersCount(spyPlayer, count);
		return this;
	}
	
	private void spyBuildersCount(Player player, int count){
		Builders spyBuilders = Mockito.spy(player.getBuilders());
		when (player.getBuilders()).thenReturn(spyBuilders) ;
		when (spyBuilders.spy()).thenReturn(count);
	}

	public TestGameBoard setOponentWarriorsCount( int count ) {
		spyWarriorsCount(spyOponent, count);
		return this;
	}
	
	public TestGameBoard setWarriorsCount( int count ) {
		spyWarriorsCount(spyPlayer, count);
		return this;
	}
	
	private void spyWarriorsCount( Player player, int count ) {
		Warriors spyWarriors = Mockito.spy(player.getWarriors());
		when (player.getWarriors()).thenReturn(spyWarriors) ;
		when (spyWarriors.spy()).thenReturn(count);
	}
	
	public TestGameBoard setOponentWizzardsCount( int count ) {
		spyWizzardsCount(spyOponent, count);
		return this;
	}
	
	public TestGameBoard setWizzardsCount( int count ) {
		spyWizzardsCount(spyPlayer, count);
		return this;
	}
	
	private void spyWizzardsCount( Player player, int count ) {
		Wizards spyWizards = Mockito.spy(player.getWizards());
		when (player.getWizards()).thenReturn(spyWizards) ;
		when (spyWizards.spy()).thenReturn(count);
	}
	
	public TestGameBoard setOponentCastleHeight( int height ) {
		spyCastleHeight(spyOponent, height);
		return this;
	}
	
	public TestGameBoard setCastleHeight( int height ) {
		spyCastleHeight(spyPlayer, height);
		return this;
	}
	
	private void spyCastleHeight( Player player, int height ) {
		Castle spyCastle = Mockito.spy(player.getCastle());
		when (player.getCastle()).thenReturn(spyCastle) ;
		when (spyCastle.spy()).thenReturn(height);
	}

	public TestEventBus getEventBus() {
		return eventBus;
	}
}
