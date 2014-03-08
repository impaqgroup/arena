package com.impaq.arena.client.view.swing.common.animation;

import com.impaq.arena.client.view.swing.common.BaseAnimation;
import com.impaq.arena.client.view.swing.common.Interpolator;
import com.impaq.arena.client.view.swing.common.LinearInterpolator;
import com.impaq.arena.client.view.swing.common.Sprite;

/**
 *
 * @author jaro
 */
public class SpriteAnimation extends BaseAnimation {

    private final Sprite sprite;

    private final Interpolator interpolator;

    public SpriteAnimation(Sprite sprite, long duration) {
        this(sprite, duration, new LinearInterpolator());
    }

    public SpriteAnimation(Sprite sprite, long duration, Interpolator interpolator) {
        super(duration);
        this.sprite = sprite;
        this.interpolator = interpolator;
    }

    @Override
    protected void updateValue(double l) {
        sprite.updateIndex((int) interpolator.interpolate(0, sprite.size(), l));
    }

}
