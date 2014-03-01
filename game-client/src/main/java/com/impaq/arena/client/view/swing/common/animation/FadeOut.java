package com.impaq.arena.client.view.swing.common.animation;

import com.impaq.arena.client.view.swing.common.BaseAnimation;
import com.impaq.arena.client.view.swing.common.Component;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class FadeOut extends BaseAnimation {

    private final Component transparency;

    public FadeOut(Component transparency, long duration) {
        super(duration);
        this.transparency = transparency;
    }

    @Override
    protected void updateValue(double l) {
        transparency.setOpacity(1.0 - l);
    }

}
