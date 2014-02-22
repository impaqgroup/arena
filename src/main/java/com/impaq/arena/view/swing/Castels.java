package com.impaq.arena.view.swing;

import com.google.common.collect.ImmutableList;
import static com.google.common.collect.ImmutableList.of;
import com.impaq.arena.PropertySource;
import com.impaq.arena.player.PropertyNames;
import com.impaq.arena.view.swing.common.BaseNode;
import com.impaq.arena.view.swing.common.Component;
import com.impaq.arena.view.swing.common.Node;
import com.impaq.arena.view.swing.common.Sprite;
import com.impaq.arena.view.swing.common.animation.FadeIn;
import com.impaq.arena.view.swing.sprite.CastelSprite;
import com.impaq.arena.view.swing.sprite.CastelSprite.Side;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class Castels extends BaseNode {

    private final Sprite leftCastel;
    private final Sprite leftCastelFade;
    private final Sprite rightCastel;
    private final Sprite rightCastelFade;
    private final Component castelFade;
    private final PropertySource properties = new PropertySource() {
        {
            load();
        }
    };
    private final Component layer = new Component();
    private final int maxCastel = properties.getInt(PropertyNames.CASTLE_MAX_HEIGHT);

    public Castels(Point position) {
        super(position);
        leftCastel = new CastelSprite(Side.LEFT);
        leftCastelFade = new CastelSprite(Side.LEFT);
        rightCastel = new CastelSprite(Side.RIGHT);
        rightCastelFade = new CastelSprite(Side.RIGHT);
        castelFade = new Component(ImmutableList.<Node>of(leftCastelFade, rightCastelFade));
        layer.addAll(
                of(
                        new Component(ImmutableList.<Node>of(leftCastel, rightCastel)),
                        castelFade
                )
        );

    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.translate(getPosition().x, getPosition().y);
        layer.draw(graphics);
        graphics.translate(-getPosition().x, -getPosition().y);
    }

    void initialize(int left, int right) {
        updateCastelSprite(leftCastelFade, left);
        updateCastelSprite(rightCastelFade, right);
        updateCastelSprite(leftCastel, left);
        updateCastelSprite(rightCastel, right);
    }

    void updateCastels(int left, int right) {
        castelFade.setOpacity(0.0);
        final FadeIn fadeIn = new FadeIn(castelFade, 500);
        fadeIn.play();
        updateCastelSprite(leftCastelFade, left);
        updateCastelSprite(rightCastelFade, right);
        fadeIn.awaitFinish();
        updateCastelSprite(leftCastel, left);
        updateCastelSprite(rightCastel, right);
    }

    private void updateCastelSprite(Sprite sprite, int castel) {
        castel = Math.max(castel, 0);
        castel = Math.min(castel, maxCastel);
        sprite.updateIndex((int) (sprite.size() * ((double) castel / (double) maxCastel)));
    }

}
