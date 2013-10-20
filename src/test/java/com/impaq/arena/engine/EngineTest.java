package com.impaq.arena.engine;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.impaq.arena.rounds.IRound;
import com.impaq.arena.rounds.IRoundManager;
import com.impaq.arena.rounds.impl.EmptyRound;
import com.impaq.arena.rounds.impl.EmptyRoundManager;
import com.impaq.arena.visualisation.impl.ConsoleVisualisation;

public class EngineTest {

	private Engine engine;
	private EmptyRoundManager firstPlayerRoundManager;
	private EmptyRoundManager secondPlayerRoundManager;

	@Before
	public void engine_class_exists() {
		firstPlayerRoundManager = new EmptyRoundManager();
		secondPlayerRoundManager = new EmptyRoundManager();
		engine = new Engine(firstPlayerRoundManager, secondPlayerRoundManager);
	}

	@Test
	public void engine_contains_two_players_active_and_unactive() {
		Assert.assertNotNull(engine.getActivePlayer());
		Assert.assertNotNull(engine.getUnactivePlayer());
		Assert.assertNotSame(engine.getActivePlayer(), engine.getUnactivePlayer());
	}

	@Test
	public void first_player_win_when_build_castle(){
	    firstPlayerRoundManager.add( new IRound(){

		public void body() {
		    Actions.BudujZamek();
		}}  );
	    secondPlayerRoundManager.add(new EmptyRound());
	    engine.startGame();
	    
	    Assert.assertTrue( Engine.getFirstPlayer().isWinner() );
	    Assert.assertFalse( Engine.getFirstPlayer().isLoser() );
	    Assert.assertFalse( Engine.getSecondPlayer().isLoser() );
	    Assert.assertFalse( Engine.getSecondPlayer().isWinner() );
	}

	@Test
	public void second_player_is_looser_when_player_one_destroy_castle(){
	    firstPlayerRoundManager.add( new IRound(){

		public void body() {
		    Actions.ZniszczZamekWroga();
		}}  );
	    secondPlayerRoundManager.add(new EmptyRound());
	    engine.startGame();
	    
	    Assert.assertFalse( Engine.getFirstPlayer().isWinner() );
	    Assert.assertFalse( Engine.getFirstPlayer().isLoser() );
	    Assert.assertTrue( Engine.getSecondPlayer().isLoser() );
	    Assert.assertFalse( Engine.getSecondPlayer().isWinner() );
	}
	
	@Test
	public void first_player_lose_when_his_castle_is_destroy(){
	    secondPlayerRoundManager.add( new IRound(){

		public void body() {
		    Actions.ZniszczZamekWroga();
		}}  );
	    firstPlayerRoundManager.add(new EmptyRound());
	    engine.startGame();
	    
	    Assert.assertFalse( Engine.getFirstPlayer().isWinner() );
	    Assert.assertTrue( Engine.getFirstPlayer().isLoser() );
	    Assert.assertFalse( Engine.getSecondPlayer().isLoser() );
	    Assert.assertFalse( Engine.getSecondPlayer().isWinner() );
	}

	@Test
	public void second_player_win_when_build_castle(){
	    secondPlayerRoundManager.add( new IRound(){

		public void body() {
		    Actions.BudujZamek();
		}}  );
	    firstPlayerRoundManager.add(new EmptyRound());
	    engine.startGame();
	    
	    Assert.assertFalse( Engine.getFirstPlayer().isWinner() );
	    Assert.assertFalse( Engine.getFirstPlayer().isLoser() );
	    Assert.assertFalse( Engine.getSecondPlayer().isLoser() );
	    Assert.assertTrue( Engine.getSecondPlayer().isWinner() );
	}	
}
