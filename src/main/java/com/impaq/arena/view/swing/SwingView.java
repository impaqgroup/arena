package com.impaq.arena.view.swing;

import static com.google.common.base.Throwables.propagate;
import com.impaq.arena.view.swing.common.BaseAnimation;
import com.impaq.arena.view.swing.common.Layer;
import com.impaq.arena.view.swing.common.Node;
import com.impaq.arena.view.swing.common.Sprite;
import com.impaq.arena.view.swing.common.Stage;
import com.impaq.arena.view.swing.common.animation.SpriteAnimation;
import com.impaq.arena.view.swing.sprite.BackgroundSprite;
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
        animate(new IntroSprite(), 8000);
        animate(new BackgroundSprite(), 2000);

    }

    private void animate(final Sprite sprite, final int time) {
        final Layer<Node> background = stage.getBackground();
        background.add(sprite);

        final SpriteAnimation spriteAnimation = new SpriteAnimation(stage, sprite, time);
        spriteAnimation.play();
        await(spriteAnimation);
        background.remove(sprite);
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
