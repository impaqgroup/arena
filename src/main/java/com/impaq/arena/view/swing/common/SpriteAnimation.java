package com.impaq.arena.view.swing.common;

/**
 *
 * @author jaro
 */
public class SpriteAnimation extends Animation {

    private final Sprite sprite;

    private final Interpolator interpolator;

    public SpriteAnimation(Stage stage, Sprite sprite, long duration) {
        this(stage, sprite, duration, new LinearInterpolator());
    }

    public SpriteAnimation(Stage stage, Sprite sprite, long duration, Interpolator interpolator) {
        super(stage, duration);
        this.sprite = sprite;
        this.interpolator = interpolator;
    }

    @Override
    protected void updateValue(double l) {
        sprite.updateIndex((int) interpolator.interpolate(0, sprite.size(), l));
    }

}
