package com.impaq.arena.client.view.swing.common.animation;

import com.impaq.arena.client.view.swing.common.BaseAnimation;
import com.impaq.arena.client.view.swing.common.Component;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class Hide extends BaseAnimation {

    private final Component component;

    public Hide(Component component) {
        super(1);
        this.component = component;
    }

    @Override
    protected void updateValue(double l) {
        component.setOpacity(0.0);
    }

}
