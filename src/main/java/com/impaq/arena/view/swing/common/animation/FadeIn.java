package com.impaq.arena.view.swing.common.animation;

import com.impaq.arena.view.swing.common.BaseAnimation;
import com.impaq.arena.view.swing.common.Stage;
import com.impaq.arena.view.swing.common.Transparency;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class FadeIn extends BaseAnimation {
    
    private final Transparency transparency;
    
    public FadeIn(Stage stage, Transparency transparency, long duration) {
        super(stage, duration);
        this.transparency = transparency;
    }
    
    @Override
    protected void updateValue(double l) {
        transparency.setOpacity(l);
    }
    
}
