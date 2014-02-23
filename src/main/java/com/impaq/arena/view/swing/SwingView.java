package com.impaq.arena.view.swing;

import com.impaq.arena.player.Player;
import com.impaq.arena.view.swing.common.Animation;
import com.impaq.arena.view.swing.common.Component;
import com.impaq.arena.view.swing.common.Sprite;
import com.impaq.arena.view.swing.common.Stage;
import com.impaq.arena.view.swing.common.animation.SpriteAnimation;
import java.awt.Point;

/**
 *
 * @author jaro
 */
public class SwingView {

    private final Stage stage = Stage.get();
    private Player right;
    private Player left;
    private final Castels castels = new Castels(new Point(0, 100));
    private final PlayerInfo leftPlayerInfo = new PlayerInfo(PlayerInfo.Side.LEFT, new Point());
    private final PlayerInfo rightPlayerInfo = new PlayerInfo(PlayerInfo.Side.RIGHT, new Point(500, 0));

    public void dispose() {
        stage.dispose();
    }

    public void displayIntro() {
        // animate(new IntroSprite(new Point(0, 100)), 8000);
        // animate(new BackgroundSprite(new Point(0, 100)), 2000);

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
        castels.updateCastels(left.getCastle().getHeight(), right.getCastle().getHeight()).awaitFinish();
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
        execute(getOponentInfo(player).spyWarriors());
    }

    void spyCastel(Player player) {
        execute(getOponentInfo(player).spyCastle());
    }

    void spyBuilders(Player player) {
        execute(getOponentInfo(player).spyBuilders());
    }

    void spyWizzard(Player player) {
        execute(getOponentInfo(player).spyWizzards());
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

    private void execute(Animation animation) {
        animation.play();
        animation.awaitFinish();
    }

}
