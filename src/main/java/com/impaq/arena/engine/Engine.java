package com.impaq.arena.engine;

import com.impaq.arena.player.Player;
import com.impaq.arena.rounds.IRoundManager;
import com.impaq.arena.visualisation.IVisualisation;
import com.impaq.arena.visualisation.impl.EmptyVisualisation;
import com.impaq.arena.visualisation.impl.Visualisation;

public class Engine {

    private static Player firstPlayer;
    private static Player secondPlayer;
    private static Player activePlayer;
    private static Player unactivePlayer;
    private static int actionCount = 0;
    private static int spyActionCount = 0;
    private static boolean isFistPlayerActive = true;
    private int roundNumber = 1;

    protected Engine(IRoundManager firstPlayerRoundManager,
	    IRoundManager secondPlayerRoundManager) {
	firstPlayer = new Player(firstPlayerRoundManager);
	secondPlayer = new Player(secondPlayerRoundManager);
	this.setPlayers();
    }

    private void setPlayers() {
	activePlayer = firstPlayer;
	unactivePlayer = secondPlayer;
    }

    protected void startGame() {
	
	Visualisation.getInstance().StartGame();
	Visualisation.getInstance().Refresh(firstPlayer, secondPlayer);

	while (!gameOver()) {
	    Visualisation.getInstance().RoundInfo(roundNumber, isFistPlayerActive);
	    activePlayer.getRoundManager().getNext().body();
	    switchPlayer();
	    actionCount = 0;
	    spyActionCount = 0;
	    Visualisation.getInstance().Refresh(firstPlayer, secondPlayer);
	}
	showWinner();
    }

    private void switchPlayer() {
	if (activePlayer.equals(firstPlayer)) {
	    activePlayer = secondPlayer;
	    unactivePlayer = firstPlayer;
	    isFistPlayerActive = true;
	    roundNumber++;
	} else {
	    activePlayer = firstPlayer;
	    unactivePlayer = secondPlayer;
	    isFistPlayerActive = false;
	}
    }

    private void showWinner() {
	if (firstPlayer.isWinner() || secondPlayer.isLoser()) {
	    Visualisation.getInstance().FirstPlayerWin();
	}
	if (secondPlayer.isWinner() || firstPlayer.isLoser()) {
	    Visualisation.getInstance().SecondPlayerWin();
	}
    }

    private boolean gameOver() {
	return firstPlayer.isLoser() || firstPlayer.isWinner()
		|| secondPlayer.isLoser() || secondPlayer.isWinner();
    }

    protected static Player getActivePlayer() {
	return activePlayer;
    }

    protected static Player getUnactivePlayer() {
	return unactivePlayer;
    }

    protected static Player getFirstPlayer() {
	return firstPlayer;
    }

    protected static Player getSecondPlayer() {
	return secondPlayer;
    }

    protected static int getActionCount() {
	return actionCount;
    }

    protected static int getSpyActionCount() {
	return spyActionCount;
    }

    protected static void incrementAction() {
	actionCount++;
    }

    protected static void incrementSpyAction() {
	spyActionCount++;
    }
    
    protected static boolean isFirstPlayerAction(){
	return isFistPlayerActive;
    }
}
