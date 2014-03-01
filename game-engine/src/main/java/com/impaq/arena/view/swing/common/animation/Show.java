package com.impaq.arena.view.swing.common.animation;

import com.impaq.arena.view.swing.common.BaseAnimation;
import com.impaq.arena.view.swing.common.Component;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class Show extends BaseAnimation {
    
    private final Component component;
    
    public Show(Component component) {
        super(1);
        this.component = component;
    }
    
    @Override
    protected void updateValue(double l) {
        component.setOpacity(1.0);
    }
    
}
