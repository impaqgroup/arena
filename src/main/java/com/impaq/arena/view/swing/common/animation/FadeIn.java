package com.impaq.arena.view.swing.common.animation;

import com.impaq.arena.view.swing.common.BaseAnimation;
import com.impaq.arena.view.swing.common.Component;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class FadeIn extends BaseAnimation {

    private final Component transparency;

    public FadeIn(Component transparency, long duration) {
        super(duration);
        this.transparency = transparency;
    }

    @Override
    protected void updateValue(double l) {
        transparency.setOpacity(l);
    }

}
