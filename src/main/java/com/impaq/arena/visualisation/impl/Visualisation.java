package com.impaq.arena.visualisation.impl;

import com.impaq.arena.player.Player;
import com.impaq.arena.visualisation.IVisualisation;

public class Visualisation implements IVisualisation {

    private static IVisualisation instance;

    public static IVisualisation getInstance() {
	if (instance == null) {
	    instance = VisualisationFactory.getVisualisation();
	}
	return instance;
    }

    public void FirstPlayerWin() {
	instance.FirstPlayerWin();
    }

    public void SecondPlayerWin() {
	instance.SecondPlayerWin();
    }

    public void Refresh(Player firstPlayer, Player secondPlayer) {
	instance.Refresh(firstPlayer, secondPlayer);
    }

    public void RoundInfo(int roundNumber, boolean isFistPlayerActive) {
	instance.RoundInfo(roundNumber, isFistPlayerActive);
    }

    public void StartGame() {
	instance.StartGame();
    }

    public void KillWizards(int wizardsStrength, boolean firstPlayerAction) {
	instance.KillWizards(wizardsStrength, firstPlayerAction);;
    }

    public void KillWarriors(int wizardsStrength, boolean firstPlayerAction) {
	instance.KillWarriors(wizardsStrength, firstPlayerAction);
    }

    public void KillBuilders(int wizardsStrength, boolean firstPlayerAction) {
	instance.KillBuilders(wizardsStrength, firstPlayerAction);
    }

    public void DestroyCastle(int warriorsStrength, boolean firstPlayerAction) {
	instance.DestroyCastle(warriorsStrength, firstPlayerAction);
    }

    public void BuildCastle(int buildersProductivity, boolean firstPlayerAction) {
	instance.BuildCastle(buildersProductivity, firstPlayerAction);
    }

    public void AddBuilders(int count, boolean firstPlayerAction) {
	instance.AddBuilders(count, firstPlayerAction);
    }

    public void AddWizards(int count, boolean firstPlayerAction) {
	instance.AddWizards(count, firstPlayerAction);
    }

    public void AddWarriors(int count, boolean firstPlayerAction) {
	instance.AddWarriors(count, firstPlayerAction);
    }

    public void CheckCastleHeight(boolean firstPlayerAction) {
	instance.CheckCastleHeight(firstPlayerAction);
    }

    public void CheckWarriorCount(boolean firstPlayerAction) {
	instance.CheckWarriorCount(firstPlayerAction);
    }

    public void CheckWizardCount(boolean firstPlayerAction) {
	instance.CheckWizardCount(firstPlayerAction);
    }

    public void CheckBuildersCount(boolean firstPlayerAction) {
	instance.CheckBuildersCount(firstPlayerAction);
    }

}
