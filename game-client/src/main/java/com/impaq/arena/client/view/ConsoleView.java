package com.impaq.arena.client.view;

import com.impaq.arena.GameBoardView;
import com.impaq.arena.event.AddBuilders;
import com.impaq.arena.event.AddWarriors;
import com.impaq.arena.event.AddWizards;
import com.impaq.arena.event.BuildCastle;
import com.impaq.arena.event.DestroyCastle;
import com.impaq.arena.event.Event;
import com.impaq.arena.event.GameStarted;
import com.impaq.arena.event.KillBuilders;
import com.impaq.arena.event.KillWarriors;
import com.impaq.arena.event.KillWizards;
import com.impaq.arena.event.RoundStart;
import com.impaq.arena.event.SpyBuilders;
import com.impaq.arena.event.SpyCastle;
import com.impaq.arena.event.SpyWarriors;
import com.impaq.arena.event.SpyWizards;
import com.impaq.arena.event.Winner;
import com.impaq.arena.player.Player;
import java.io.PrintStream;

public class ConsoleView implements GameBoardView {

    private Player first;
    private Player second;

    private final PrintStream out;

    public ConsoleView() {
        this(System.out);
    }

    public ConsoleView(PrintStream out) {
        this.out = out;
    }

    @Override
    public void onGameStart(GameStarted event) {
        first = event.getLeft();
        second = event.getRight();
        println("Game started");
    }

    private boolean isExecutedByFirst(Event event) {
        return first == event.getPlayer();
    }

    /*

     public void updatePlayers(Player firstPlayer, Player secondPlayer) {
     out.printf("First player: " + "\n");
     out.printf("Builders: " + firstPlayer.getBuilders().getCount()+ "\n");
     out.printf("Warriors: " + firstPlayer.getWarriors().getCount()+ "\n");
     out.printf("Wizzards: " + firstPlayer.getWizards().getCount()+ "\n");
     out.printf("Castle: " + firstPlayer.getCastle().getHeight()
     + "\n");
     out.printf("\n");
     out.printf("Second player: " + "\n");
     out.printf("Builders: " + secondPlayer.getBuilders().getCount()
     + "\n");
     out.printf("Warriors: " + secondPlayer.getWarriors().getCount()
     + "\n");
     out.printf("Wizzards: " + secondPlayer.getWizards().getCount()
     + "\n");
     out.printf("Castle: " + secondPlayer.getCastle().getHeight()
     + "\n");
     }

     public void showRoundInfo(int roundNumber, boolean isFistPlayerActive) {
     out.printf("\n");
     out.printf("\n");
     out.printf("Round number: " + roundNumber + "\n");
     out.printf("Action of the "
     + (isFistPlayerActive ? "first player" : "second player") + "\n");
     }


     */
    @Override
    public void onWinner(Winner winner) {
        println("And The Winner is " + playerName(winner) + " !!!!!");
    }

    private String playerName(Winner winner) {
        return winner.getWinner() == first ? "Blue player" : "Red player";
    }

    @Override
    public void onSpyWizards(SpyWizards event) {
        println(playerName(event) + "is checking enemy wizards.");
    }

    @Override
    public void onSpyWarriors(SpyWarriors event) {
        println(playerName(event) + "is checking enemy warriors count.");
    }

    private String playerName(Event event) {
        return isExecutedByFirst(event) ? "Blue player" : "Red player";
    }

    @Override
    public void onSpyCastle(SpyCastle event) {
        println(playerName(event) + " check enemy castle height.");
    }

    @Override
    public void onSpyBuilders(SpyBuilders event) {
        println(playerName(event) + " check enemy builders count.");
    }

    @Override
    public void onBuildCastle(BuildCastle event) {
        println(playerName(event) + " built " + event.getValue() + " levels of castel.");
    }

    @Override
    public void onDestroyCastel(DestroyCastle event) {
        println(playerName(event) + " destroyed " + event.getValue() + " levels of enemy castel.");
    }

    @Override
    public void onKillBuilders(KillBuilders event) {
        println(playerName(event) + " kill " + event.getValue() + " builders.");
    }

    @Override
    public void onKillWizards(KillWizards event) {
        println(playerName(event) + " kill " + event.getValue() + " wizards.");
    }

    @Override
    public void onKillWarriors(KillWarriors event) {
        println(playerName(event) + " kill " + event.getValue() + " warriors.");
    }

    @Override
    public void onAddBuilders(AddBuilders event) {
        println(playerName(event) + " added " + event.getValue() + " builders.");
    }

    @Override
    public void onAddWizards(AddWizards event) {
        println(playerName(event) + " added " + event.getValue() + " wizards.");
    }

    @Override
    public void onAddWarriors(AddWarriors event) {
        println(playerName(event) + " added " + event.getValue() + " warriors.");
    }

    @Override
    public void onRoundStart(RoundStart event) {
        println(event.getNumber() + " round started.");
    }

    private void println(String line) {
        out.println(line);
    }

}
