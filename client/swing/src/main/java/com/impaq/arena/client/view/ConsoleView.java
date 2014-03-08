package com.impaq.arena.client.view;

import com.impaq.arena.server.engine.GameBoardView;
import com.impaq.arena.server.event.AttackBuilders;
import com.impaq.arena.server.event.AttackCastle;
import com.impaq.arena.server.event.AttackWarriors;
import com.impaq.arena.server.event.RecruitBuilders;
import com.impaq.arena.server.event.RecruitWarriors;
import com.impaq.arena.server.event.RecruitWizards;
import com.impaq.arena.server.event.BuildCastle;
import com.impaq.arena.server.event.Event;
import com.impaq.arena.server.event.GameEnd;
import com.impaq.arena.server.event.GameStarted;
import com.impaq.arena.server.event.AttackWizards;
import com.impaq.arena.server.event.PlayerTurnStart;
import com.impaq.arena.server.event.RoundStart;
import com.impaq.arena.server.event.SpyBuilders;
import com.impaq.arena.server.event.SpyCastle;
import com.impaq.arena.server.event.SpyWarriors;
import com.impaq.arena.server.event.SpyWizards;
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
        first = event.getPlayerOne();
        second = event.getPlayerTwo();
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
     out.printf("Wizards: " + firstPlayer.getWizards().getCount()+ "\n");
     out.printf("Castle: " + firstPlayer.getCastle().getHeight()
     + "\n");
     out.printf("\n");
     out.printf("Second player: " + "\n");
     out.printf("Builders: " + secondPlayer.getBuilders().getCount()
     + "\n");
     out.printf("Warriors: " + secondPlayer.getWarriors().getCount()
     + "\n");
     out.printf("Wizards: " + secondPlayer.getWizards().getCount()
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
    public void onGameEnd(GameEnd gameEnd) {
        println("And The Winner is " + playerName(gameEnd) + " !!!!!");
    }

    private String playerName(GameEnd gameEnd) {
        return gameEnd.getWinner() == first ? "Blue player" : "Red player";
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
    public void onAttackCastle(AttackCastle event) {
        println(playerName(event) + " destroyed " + event.getValue() + " levels of enemy castel.");
    }

    @Override
    public void onAttackBuilders(AttackBuilders event) {
        println(playerName(event) + " kill " + event.getValue() + " builders.");
    }

    @Override
    public void onAttackWizards(AttackWizards event) {
        println(playerName(event) + " kill " + event.getValue() + " wizards.");
    }

    @Override
    public void onAttackWarriors(AttackWarriors event) {
        println(playerName(event) + " kill " + event.getValue() + " warriors.");
    }

    @Override
    public void onRecruitBuilders(RecruitBuilders event) {
        println(playerName(event) + " added " + event.getValue() + " builders.");
    }

    @Override
    public void onRecruitWizards(RecruitWizards event) {
        println(playerName(event) + " added " + event.getValue() + " wizards.");
    }

    @Override
    public void onRecruitWarriors(RecruitWarriors event) {
        println(playerName(event) + " added " + event.getValue() + " warriors.");
    }

    @Override
    public void onRoundStart(RoundStart event) {
        println(event.getNumber() + " round started.");
    }

    private void println(String line) {
        out.println(line);
    }

    @Override
    public void onPlayerTurnStart(PlayerTurnStart event) {

    }
}
