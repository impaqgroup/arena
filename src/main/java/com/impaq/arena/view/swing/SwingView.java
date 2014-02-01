package com.impaq.arena.view.swing;

import com.impaq.arena.view.swing.common.SpriteAnimation;
import com.impaq.arena.view.swing.common.Animation;
import com.impaq.arena.view.swing.common.Stage;
import com.impaq.arena.view.swing.common.Node;
import com.impaq.arena.view.swing.common.Layer;
import com.google.common.base.Throwables;
import static com.google.common.base.Throwables.propagate;
import com.impaq.arena.view.swing.sprite.IntroSprite;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jaro
 */
public class SwingView {

    private final Stage stage = new Stage();

    public void dispose() {
        stage.dispose();
    }

    public void displayIntro() {
        stage.initialize();
        final IntroSprite introSprite = new IntroSprite();
        final Layer<Node> background = stage.getBackground();
        background.add(introSprite);
        final SpriteAnimation spriteAnimation = new SpriteAnimation(stage, introSprite, 12000);
        spriteAnimation.play();
        await(spriteAnimation);
        background.remove(introSprite);
    }

    private void await(final Animation animation) {
        try {
            animation.awaitFinish();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            throw propagate(ex);
        }
    }

}
