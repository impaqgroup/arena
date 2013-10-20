package com.impaq.arena.visualisation.impl;

import java.io.Console;

import com.impaq.arena.player.Player;
import com.impaq.arena.visualisation.IVisualisation;

public class ConsoleVisualisation implements IVisualisation {

    public void FirstPlayerWin() {
	System.out.printf("Gracz 1 WYGRYWA!!");
    }

    public void SecondPlayerWin() {
	System.out.printf("Gracz 2 WYGRYWA!!");
    }

    public void Refresh(Player firstPlayer, Player secondPlayer) {
	System.out.printf("First player: " + "\n");
	System.out.printf("Builders: " + firstPlayer.getBuilders().getCount()+ "\n");
	System.out.printf("Warriors: " + firstPlayer.getWarriors().getCount()+ "\n");
	System.out.printf("Wizzards: " + firstPlayer.getWizards().getCount()+ "\n");
	System.out.printf("Castle: " + firstPlayer.getCastle().getHeight()
		+ "\n");
	System.out.printf("\n");
	System.out.printf("Second player: " + "\n");
	System.out.printf("Builders: " + secondPlayer.getBuilders().getCount()
		+ "\n");
	System.out.printf("Warriors: " + secondPlayer.getWarriors().getCount()
		+ "\n");
	System.out.printf("Wizzards: " + secondPlayer.getWizards().getCount()
		+ "\n");
	System.out.printf("Castle: " + secondPlayer.getCastle().getHeight()
		+ "\n");
    }

    public void RoundInfo(int roundNumber, boolean isFistPlayerActive) {
	System.out.printf("\n");
	System.out.printf("\n");
	System.out.printf("Round number: " + roundNumber + "\n");
	System.out.printf("Action of the "
		+ (isFistPlayerActive ? "first player" : "second player") + "\n");
    }

    public void StartGame() {
	System.out.printf("Game started\n\n\n");
    }

    public void KillWizards(int wizardsStrength, boolean firstPlayerAction) {
	System.out.printf( (firstPlayerAction ? "First player" : "Second player") + " kill " + wizardsStrength + " wizards.\n");
    }

    public void KillWarriors(int wizardsStrength, boolean firstPlayerAction) {
	System.out.printf( (firstPlayerAction ? "First player" : "Second player") + " kill " + wizardsStrength + " warriors.\n");
    }

    public void KillBuilders(int wizardsStrength, boolean firstPlayerAction) {
	System.out.printf( (firstPlayerAction ? "First player" : "Second player") + " kill " + wizardsStrength + " builders.\n");
    }

    public void DestroyCastle(int warriorsStrength, boolean firstPlayerAction) {
	System.out.printf( (firstPlayerAction ? "First player" : "Second player") + " destroy " + warriorsStrength + " castle.\n");
    }

    public void BuildCastle(int buildersProductivity, boolean firstPlayerAction) {
	System.out.printf( (firstPlayerAction ? "First player" : "Second player") + " build " + buildersProductivity + " castle.\n");
    }

    public void AddBuilders(int count, boolean firstPlayerAction) {
	System.out.printf( (firstPlayerAction ? "First player" : "Second player") + " add " + count + " builders.\n");
    }

    public void AddWizards(int count, boolean firstPlayerAction) {
	System.out.printf( (firstPlayerAction ? "First player" : "Second player") + " add " + count + " wizards.\n");
    }

    public void AddWarriors(int count, boolean firstPlayerAction) {
	System.out.printf( (firstPlayerAction ? "First player" : "Second player") + " add " + count + " warriors.\n");
    }

    public void CheckCastleHeight(boolean firstPlayerAction) {
	System.out.printf( (firstPlayerAction ? "First player" : "Second player") + " check enemy castle height.\n");
    }

    public void CheckWarriorCount(boolean firstPlayerAction) {
	System.out.printf( (firstPlayerAction ? "First player" : "Second player") + " check enemy warriors count.\n");
    }

    public void CheckWizardCount(boolean firstPlayerAction) {
	System.out.printf( (firstPlayerAction ? "First player" : "Second player") + " check enemy wizards count.\n");
    }

    public void CheckBuildersCount(boolean firstPlayerAction) {
	System.out.printf( (firstPlayerAction ? "First player" : "Second player") + " check enemy builders count.\n");
    }

}
