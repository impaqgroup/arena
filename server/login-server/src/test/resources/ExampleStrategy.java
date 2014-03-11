import com.impaq.arena.api.Game;
import com.impaq.arena.api.PlayerStrategy;

public class ExampleStrategy implements PlayerStrategy {

    private int round = 0;

    @Override
    public void playRound(Game game) {
        switch (round % 3) {
            case 0:
                play1(game); break;
            case 1:
                play2(game); break;
            case 2:
                play3(game); break;
        }
        round++;
    }

    private void play1(Game game) {
        if (game.spyEnemyWizardsCount() > 8) {
            if (game.myWizardsCount() < 4) {
                game.recruitWizards();
                game.recruitWizards();
            } else {
                game.recruitBuilders();
                game.recruitBuilders();
            }
            game.attackEnemyWizards();
        } else if (game.spyEnemyCastleHeight() > 30) {
            game.recruitWarriors();
            game.recruitWarriors();
            game.attackEnemyCastle();
        } else {
            game.recruitBuilders();
            game.recruitBuilders();
            game.buildMyCastle();
        }
    }

    private void play2(Game game) {
        if (game.spyEnemyWarriorsCount() > 8) {
            if (game.myWizardsCount() < 4) {
                game.recruitWizards();
                game.recruitWizards();
            } else {
                game.recruitBuilders();
                game.recruitBuilders();
            }
            game.attackEnemyWarriors();
        } else if (game.spyEnemyCastleHeight() > 30) {
            game.recruitWarriors();
            game.recruitWarriors();
            game.attackEnemyCastle();
        } else {
            game.recruitBuilders();
            game.recruitBuilders();
            game.buildMyCastle();
        }
    }

    private void play3(Game game) {
        if (game.spyEnemyBuildersCount() > 8) {
            if (game.myWizardsCount() < 4) {
                game.recruitWizards();
                game.recruitWizards();
            } else {
                game.recruitBuilders();
                game.recruitBuilders();
            }
            game.attackEnemyBuilders();
        } else if (game.spyEnemyCastleHeight() > 30) {
            game.recruitWarriors();
            game.recruitWarriors();
            game.attackEnemyCastle();
        } else {
            game.recruitBuilders();
            game.recruitBuilders();
            game.buildMyCastle();
        }
    }
}
