package com.impaq.arena.client.view.swing;

import com.impaq.arena.client.view.swing.common.Animation;
import com.impaq.arena.client.view.swing.common.Component;
import com.impaq.arena.client.view.swing.common.Sprite;
import com.impaq.arena.client.view.swing.common.animation.Parallel;
import com.impaq.arena.client.view.swing.common.animation.Pause;
import com.impaq.arena.client.view.swing.common.animation.SpriteAnimation;
import com.impaq.arena.client.view.swing.sprite.BackgroundSprite;
import com.impaq.arena.client.view.swing.sprite.IntroSprite;
import com.impaq.arena.client.view.swing.sprite.shapes.NumberNode;
import com.impaq.arena.player.Player;
import com.impaq.arena.client.view.swing.common.Stage;

import java.awt.Point;

/**
 *
 * @author jaro
 */
public class SwingView {

    private final Stage stage = Stage.get();
    private Player right;
    private Player left;
    private final Castles castels = new Castles(new Point(0, 100));
    private final PlayerInfo leftPlayerInfo = new PlayerInfo(PlayerInfo.Side.LEFT, new Point());
    private final PlayerInfo rightPlayerInfo = new PlayerInfo(PlayerInfo.Side.RIGHT, new Point(500, 0));
    private Player lastPlayer;
    private NumberNode roundNumber = new NumberNode(new Point(470, 150), 1);

    public void dispose() {
        stage.dispose();
    }

    public void displayIntro() {
        animate(new IntroSprite(new Point(0, 100)), 8000);
        final BackgroundSprite background = new BackgroundSprite(new Point(0, 100));
        animate(background, 2000);
    }

    private void animate(final Sprite sprite, final int time) {
        final Component background = stage.getBackground();
        background.add(sprite);
        final SpriteAnimation spriteAnimation = new SpriteAnimation(sprite, time);
        spriteAnimation.play();
        spriteAnimation.awaitFinish();
        background.remove(sprite);
    }

    void updateCastels() {
        updatePlayers();
        castels.updateCastles(left.getCastle().getHeight(), right.getCastle().getHeight()).awaitFinish();
    }

    private void updatePlayers() {
        leftPlayerInfo.update(left);
        rightPlayerInfo.update(right);
    }

    void initialize(Player left, Player right) {
        this.left = left;
        this.right = right;
        castels.initialize(left.getCastle().getHeight(), right.getCastle().getHeight());
        leftPlayerInfo.update(left);
        rightPlayerInfo.update(right);
        final BackgroundSprite background = new BackgroundSprite(new Point(0, 100));
        background.last();
        stage.getBackground().add(background);
        stage.getBackground().add(castels);
        stage.getBackground().add(leftPlayerInfo);
        stage.getBackground().add(rightPlayerInfo);
        stage.getBackground().add(roundNumber);
    }

    void spyWarriors(Player player) {
        execute(getOponentInfo(player).spyWarriors(), activePlayerIndicator(player));
    }

    void spyCastel(Player player) {
        execute(getOponentInfo(player).spyCastle(), activePlayerIndicator(player));
    }

    private Animation activePlayerIndicator(Player player) {
        if (player == lastPlayer) {
            return new Pause(0);
        } else if (lastPlayer == null) {
            lastPlayer = player;
            return getInfo(player).showArrow();
        }
        lastPlayer = player;
        return Parallel.of(getInfo(player).showArrow(), getOponentInfo(player).hideArrow());
    }

    void spyBuilders(Player player) {
        execute(getOponentInfo(player).spyBuilders(), activePlayerIndicator(player));
    }

    void spyWizzard(Player player) {
        execute(getOponentInfo(player).spyWizards(), activePlayerIndicator(player));
    }

    private PlayerInfo getInfo(Player player) {
        if (player == left) {
            return leftPlayerInfo;
        } else {
            return rightPlayerInfo;
        }
    }

    private PlayerInfo getOponentInfo(Player player) {
        if (player != left) {
            return leftPlayerInfo;
        } else {
            return rightPlayerInfo;
        }
    }

    private void execute(Animation... animations) {
        final Animation animation = Parallel.of(animations);
        animation.play();
        animation.awaitFinish();
    }

    void killWizzards(Player player) {
        execute(getOponentInfo(player).killWizards(), activePlayerIndicator(player));
        updatePlayers();
    }

    void killBuilders(Player player) {
        execute(getOponentInfo(player).killBuilders(), activePlayerIndicator(player));
        updatePlayers();
    }

    void killWarriors(Player player) {
        execute(getOponentInfo(player).killWarriors(), activePlayerIndicator(player));
        updatePlayers();
    }

    void buildCastle(Player player) {
        execute(getInfo(player).buildCastle(), activePlayerIndicator(player));
        updateCastels();
    }

    void destroyCastle(Player player) {
        execute(getOponentInfo(player).destroyCastle(), activePlayerIndicator(player));
        updateCastels();
    }

    void addBuilders(Player player) {
        execute(getInfo(player).addBuilders(), activePlayerIndicator(player));
        updatePlayers();
    }

    void addWizards(Player player) {
        execute(getInfo(player).addWizards(), activePlayerIndicator(player));
        updatePlayers();
    }

    void addWarriors(Player player) {
        execute(getInfo(player).addWarriors(), activePlayerIndicator(player));
        updatePlayers();
    }

    void updateRoundNumber(int number) {
        if (number > 10) {
            roundNumber.getPosition().move(475, 150);
        } else if (number > 100) {
            roundNumber.getPosition().move(480, 150);
        } else if (number > 1000) {
            roundNumber.getPosition().move(485, 150);
        }
        roundNumber.setValue(number);
    }

}
