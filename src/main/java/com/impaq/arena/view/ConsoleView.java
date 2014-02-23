package com.impaq.arena.view;

import com.impaq.arena.engine.event.GameStarted;
import com.impaq.arena.GameBoardView;
import com.impaq.arena.engine.event.BuildCastle;
import com.impaq.arena.engine.event.DestroyCastle;
import com.impaq.arena.engine.event.Event;
import com.impaq.arena.engine.event.SpyBuilders;
import com.impaq.arena.engine.event.SpyCastle;
import com.impaq.arena.engine.event.SpyWarriors;
import com.impaq.arena.engine.event.SpyWizards;
import com.impaq.arena.engine.event.Winner;
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
        out.println("Game started");
    }

    private boolean isExecutedByFirst(Event event) {
        return first == event.getPlayer();
    }

    /*
     public void firstPlayerWin() {
     out.printf("Gracz 1 WYGRYWA!!");
     }

     public void secondPlayerWin() {
     out.printf("Gracz 2 WYGRYWA!!");
     }

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


     public void killWizards(int wizardsStrength, boolean firstPlayerAction) {
     out.printf( (firstPlayerAction ? "First player" : "Second player") + " kill " + wizardsStrength + " wizards.\n");
     }

     public void KillWarriors(int wizardsStrength, boolean firstPlayerAction) {
     out.printf( (firstPlayerAction ? "First player" : "Second player") + " kill " + wizardsStrength + " warriors.\n");
     }

     public void killBuilders(int wizardsStrength, boolean firstPlayerAction) {
     out.printf( (firstPlayerAction ? "First player" : "Second player") + " kill " + wizardsStrength + " builders.\n");
     }

     public void destroyCastle(int warriorsStrength, boolean firstPlayerAction) {
     out.printf( (firstPlayerAction ? "First player" : "Second player") + " destroy " + warriorsStrength + " castle.\n");
     }

     public void buildCastle(int buildersProductivity, boolean firstPlayerAction) {
     out.printf( (firstPlayerAction ? "First player" : "Second player") + " build " + buildersProductivity + " castle.\n");
     }

     public void addBuilders(int count, boolean firstPlayerAction) {
     out.printf( (firstPlayerAction ? "First player" : "Second player") + " add " + count + " builders.\n");
     }

     public void addWizards(int count, boolean firstPlayerAction) {
     out.printf( (firstPlayerAction ? "First player" : "Second player") + " add " + count + " wizards.\n");
     }

     public void addWarriors(int count, boolean firstPlayerAction) {
     out.printf( (firstPlayerAction ? "First player" : "Second player") + " add " + count + " warriors.\n");
     }


     */
    @Override
    public void onWinner(Winner winner) {
        out.println("And The Winner is " + playerName(winner) + " !!!!!");
    }

    private String playerName(Winner winner) {
        return winner.getWinner() == first ? "First player" : "Second player";
    }

    @Override
    public void onSpyWizards(SpyWizards event) {
        out.println(playerName(event) + "is checking enemy wizards.");
    }

    @Override
    public void onSpyWarriors(SpyWarriors event) {
        out.println(playerName(event) + "is checking enemy warriors count.");
    }

    private String playerName(Event event) {
        return isExecutedByFirst(event) ? "First player" : "Second player";
    }

    @Override
    public void onSpyCastel(SpyCastle event) {
        out.println(playerName(event) + " check enemy castle height.");
    }

    @Override
    public void onSpyBuilders(SpyBuilders event) {
        out.println(playerName(event) + " check enemy builders count.");
    }

    @Override
    public void onBuildCastle(BuildCastle event) {
        out.println(playerName(event) + " built" + event.getValue() + " levels of castel.");
    }

    @Override
    public void onDestroyCastel(DestroyCastle event) {
        out.println(playerName(event) + " destroyed " + event.getValue() + " levels of enemy castel.");
    }
}
