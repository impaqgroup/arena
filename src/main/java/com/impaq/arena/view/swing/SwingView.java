package com.impaq.arena.view.swing;

import com.impaq.arena.player.Player;
import com.impaq.arena.view.swing.common.Component;
import com.impaq.arena.view.swing.common.Node;
import com.impaq.arena.view.swing.common.Sprite;
import com.impaq.arena.view.swing.common.Stage;
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
    private Castels castels = new Castels(new Point(0, 100));
    private PlayerInfo playerInfo = new PlayerInfo(new Point());

    public void dispose() {
        stage.dispose();
    }

    public void displayIntro() {
        animate(new IntroSprite(new Point(0, 100)), 8000);
        animate(new BackgroundSprite(new Point(0, 100)), 2000);
        stage.getBackground().add(castels);
        stage.getBackground().add(playerInfo);
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
        castels.updateCastels(left.getCastle().getHeight(), right.getCastle().getHeight());
        playerInfo.setBuildersNumber(left.getBuilders().getCount());
        playerInfo.setWizzardsNumber(left.getWizards().getCount());
    }

    void initialize(Player left, Player right) {
        this.left = left;
        this.right = right;
        castels.initialize(left.getCastle().getHeight(), right.getCastle().getHeight());
        playerInfo.setBuildersNumber(5);
        playerInfo.setWizzardsNumber(20);
        
    }

}
