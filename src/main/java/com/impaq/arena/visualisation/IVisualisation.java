package com.impaq.arena.visualisation;

import com.impaq.arena.player.Player;

public interface IVisualisation {

	public void FirstPlayerWin();
	public void SecondPlayerWin();
	
	public void Refresh( Player firstPlayer, Player secondPlayer);
	public void RoundInfo(int roundNumber, boolean isFistPlayerActive);
	public void StartGame();
	
	public void KillWizards(int wizardsStrength, boolean firstPlayerAction);
	public void KillWarriors(int wizardsStrength, boolean firstPlayerAction);
	public void KillBuilders(int wizardsStrength, boolean firstPlayerAction);
	
	public void DestroyCastle(int warriorsStrength,boolean firstPlayerAction);
	public void BuildCastle(int buildersProductivity,boolean firstPlayerAction);
	
	public void AddBuilders(int count, boolean firstPlayerAction);
	public void AddWizards(int count, boolean firstPlayerAction);
	public void AddWarriors(int count, boolean firstPlayerAction);
	
	public void CheckCastleHeight(boolean firstPlayerAction);
	public void CheckWarriorCount(boolean firstPlayerAction);
	public void CheckWizardCount(boolean firstPlayerAction);
	public void CheckBuildersCount(boolean firstPlayerAction);
	
}
