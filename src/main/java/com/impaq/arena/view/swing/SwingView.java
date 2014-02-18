package com.impaq.arena.view.swing;

import static com.google.common.base.Throwables.propagate;
import com.impaq.arena.view.swing.common.BaseAnimation;
import com.impaq.arena.view.swing.common.Layer;
import com.impaq.arena.view.swing.common.Node;
import com.impaq.arena.view.swing.common.Stage;
import com.impaq.arena.view.swing.common.animation.SpriteAnimation;
import com.impaq.arena.view.swing.sprite.IntroSprite;

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
        final SpriteAnimation spriteAnimation = new SpriteAnimation(stage, introSprite, 40000);
        spriteAnimation.play();
        await(spriteAnimation);
        background.remove(introSprite);
    }

    private void await(final BaseAnimation animation) {
        try {
            animation.awaitFinish();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            throw propagate(ex);
        }
    }

}
