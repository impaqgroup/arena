package com.impaq.arena.view.swing;

import static com.google.common.base.Throwables.propagate;
import com.google.common.collect.ImmutableList;
import static com.google.common.collect.ImmutableList.of;
import com.impaq.arena.PropertySource;
import com.impaq.arena.player.Player;
import com.impaq.arena.player.PropertyNames;
import com.impaq.arena.view.swing.common.BaseAnimation;
import com.impaq.arena.view.swing.common.Layer;
import com.impaq.arena.view.swing.common.Node;
import com.impaq.arena.view.swing.common.Sprite;
import com.impaq.arena.view.swing.common.Stage;
import com.impaq.arena.view.swing.common.Transparency;
import com.impaq.arena.view.swing.common.animation.FadeIn;
import com.impaq.arena.view.swing.common.animation.SpriteAnimation;
import com.impaq.arena.view.swing.sprite.BackgroundSprite;
import com.impaq.arena.view.swing.sprite.CastelLeftSprite;
import com.impaq.arena.view.swing.sprite.CastelRightSprite;
import com.impaq.arena.view.swing.sprite.IntroSprite;

/**
 *
 * @author jaro
 */
public class SwingView {

    private final Stage stage = new Stage();
    private Player right;
    private Player left;
    private final Sprite leftCastel = new CastelLeftSprite();
    private final Sprite leftCastelFade = new CastelLeftSprite();
    private final Sprite rightCastel = new CastelRightSprite();
    private final Sprite rightCastelFade = new CastelRightSprite();
    private final Transparency fade = new Transparency(ImmutableList.<Node>of(leftCastelFade, rightCastelFade));
    private final PropertySource properties = new PropertySource() {{load();}};
    private final int maxCastel = properties.getInt(PropertyNames.CASTLE_MAX_HEIGHT);

    public void dispose() {
        stage.dispose();
    }

    public void displayIntro() {
        stage.initialize();
        animate(new IntroSprite(), 8000);
        animate(new BackgroundSprite(), 2000);
        stage.getBackground().addAll(
                of(
                        new Layer<Node>(ImmutableList.<Node>of(leftCastel, rightCastel)),
                        fade
                )
        );
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

    void setLeftPlayer(Player left) {
        this.left = left;

    }

    void setRightPlayer(Player right) {
        this.right = right;
    }

    void updateCastels() {
        fade.setOpacity(0.0);
        final FadeIn fadeIn = new FadeIn(stage, fade, 500);
        fadeIn.play();
        updateCastelSprite(leftCastelFade, left);
        updateCastelSprite(rightCastelFade, right);
        await(fadeIn);
        updateCastelSprite(leftCastel, left);
        updateCastelSprite(rightCastel, right);
    }

    private void updateCastelSprite(Sprite sprite, Player player) {
        sprite.updateIndex((int) (sprite.size() * ((double) player.getCastle().getHeight() / (double) maxCastel)));
    }

}
