package com.impaq.arena.view.swing;

import com.impaq.arena.player.Player;
import com.impaq.arena.view.swing.common.Animation;
import com.impaq.arena.view.swing.common.Component;
import com.impaq.arena.view.swing.common.Sprite;
import com.impaq.arena.view.swing.common.Stage;
import com.impaq.arena.view.swing.common.animation.Parallel;
import com.impaq.arena.view.swing.common.animation.SpriteAnimation;
import com.impaq.arena.view.swing.sprite.BackgroundSprite;
import com.impaq.arena.view.swing.sprite.IntroSprite;
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

    public void dispose() {
        stage.dispose();
    }

    public void displayIntro() {
        animate(new IntroSprite(new Point(0, 100)), 8000);
        final BackgroundSprite background = new BackgroundSprite(new Point(0, 100));
        animate(background, 2000);
        background.last();
        stage.getBackground().add(background);
        stage.getBackground().add(castels);
        stage.getBackground().add(leftPlayerInfo);
        stage.getBackground().add(rightPlayerInfo);
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
    }

    void spyWarriors(Player player) {
        execute(getOponentInfo(player).spyWarriors(), getInfo(player).showArrow());
    }

    void spyCastel(Player player) {
        execute(getOponentInfo(player).spyCastle(), getInfo(player).showArrow());
    }

    void spyBuilders(Player player) {
        execute(getOponentInfo(player).spyBuilders(), getInfo(player).showArrow());
    }

    void spyWizzard(Player player) {
        execute(getOponentInfo(player).spyWizards(), getInfo(player).showArrow());
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
        execute(getOponentInfo(player).killWizards(), getInfo(player).showArrow());
        updatePlayers();
    }

    void killBuilders(Player player) {
        execute(getOponentInfo(player).killBuilders(), getInfo(player).showArrow());
        updatePlayers();
    }

    void killWarriors(Player player) {
        execute(getOponentInfo(player).killWarriors(), getInfo(player).showArrow());
        updatePlayers();
    }

    void buildCastle(Player player) {
        execute(getInfo(player).buildCastle(), getInfo(player).showArrow());
        updateCastels();
    }

    void destroyCastle(Player player) {
        execute(getOponentInfo(player).destroyCastle(), getInfo(player).showArrow());
        updateCastels();
    }

    void addBuilders(Player player) {
        execute(getInfo(player).addBuilders(), getInfo(player).showArrow());
        updatePlayers();
    }

    void addWizards(Player player) {
        execute(getInfo(player).addWizards(), getInfo(player).showArrow());
        updatePlayers();
    }

    void addWarriors(Player player) {
        execute(getInfo(player).addWarriors(), getInfo(player).showArrow());
        updatePlayers();
    }

}
