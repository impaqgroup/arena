package com.impaq.arena.view.swing;

import com.google.common.collect.ImmutableList;
import static com.google.common.collect.ImmutableList.of;
import com.impaq.arena.PropertySource;
import com.impaq.arena.player.PropertyNames;
import com.impaq.arena.view.swing.common.AnimationFinish;
import com.impaq.arena.view.swing.common.AnimationListener;
import com.impaq.arena.view.swing.common.Component;
import com.impaq.arena.view.swing.common.Interpolator;
import com.impaq.arena.view.swing.common.LinearInterpolator;
import com.impaq.arena.view.swing.common.Node;
import com.impaq.arena.view.swing.common.Sprite;
import com.impaq.arena.view.swing.common.animation.FadeIn;
import com.impaq.arena.view.swing.sprite.CastleSprite;
import com.impaq.arena.view.swing.sprite.CastleSprite.Side;
import java.awt.Point;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
class Castles extends Component {

    private final Sprite leftCastel;
    private final Sprite leftCastelFade;
    private final Sprite rightCastel;
    private final Sprite rightCastelFade;
    private final Component castelFade;
    private final Interpolator interpolator = new LinearInterpolator();
    private final PropertySource properties = new PropertySource() {
        {
            load();
        }
    };
    private final int maxCastle = properties.getInt(PropertyNames.CASTLE_MAX_HEIGHT);

    public Castles(Point position) {
        super(position);
        leftCastel = new CastleSprite(Side.LEFT);
        leftCastelFade = new CastleSprite(Side.LEFT);
        rightCastel = new CastleSprite(Side.RIGHT);
        rightCastelFade = new CastleSprite(Side.RIGHT);
        castelFade = new Component(ImmutableList.<Node>of(leftCastelFade, rightCastelFade));
        addAll(
                of(
                        new Component(ImmutableList.<Node>of(leftCastel, rightCastel)),
                        castelFade
                )
        );

    }

    void initialize(int left, int right) {
        updateCastleSprite(leftCastelFade, left);
        updateCastleSprite(rightCastelFade, right);
        updateCastleSprite(leftCastel, left);
        updateCastleSprite(rightCastel, right);
    }

    FadeIn updateCastles(final int left, final int right) {
        castelFade.setOpacity(0.0);
        final FadeIn fadeIn = new FadeIn(castelFade, 500);
        fadeIn.play();
        updateCastleSprite(leftCastelFade, left);
        updateCastleSprite(rightCastelFade, right);
        fadeIn.registerListener(new AnimationListener() {

            @Override
            public void onAnimationFinish(AnimationFinish event) {
                updateCastleSprite(leftCastel, left);
                updateCastleSprite(rightCastel, right);
            }
        });

        return fadeIn;
    }

    private void updateCastleSprite(Sprite sprite, int castle) {
        final int index = (int) interpolator.interpolate(0, sprite.size(), (double) castle / maxCastle);
        sprite.updateIndex(handleBounds(index, castle, sprite.size()));
    }

    private int handleBounds(final int index, int castle, int size) {
        return handleUpperBound(handleLowerBound(index, castle, size), castle, size);
    }

    private int handleLowerBound(final int index, int castle, int size) {
        return index == 0 ? (castle > 0 ? 1 : 0) : index;
    }

    private int handleUpperBound(int index, int castle, int size) {
        return index == size ? (castle < maxCastle ? size - 1 : size) : index;
    }

}
