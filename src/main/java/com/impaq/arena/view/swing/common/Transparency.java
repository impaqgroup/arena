package com.impaq.arena.view.swing.common;

import com.google.common.base.Preconditions;
import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.util.Collection;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class Transparency extends Layer<Node> {

    private double opacity = 0.0f;

    public Transparency(Collection<Node> nodes) {
        super(nodes);
    }

    @Override
    public void draw(Graphics2D graphics) {
        if (opacity != 0.0f) {
            Composite orginal = graphics.getComposite();
            graphics.setComposite(makeComposite(1.0 - opacity));
            super.draw(graphics);
            graphics.setComposite(orginal);
        } else {
            super.draw(graphics);
        }
    }

    private AlphaComposite makeComposite(double alpha) {
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type, (float) alpha));
    }

    public double getOpacity() {
        return opacity;
    }

    public void setOpacity(double opacity) {
        Preconditions.checkArgument(opacity < 1 && opacity > 0);
        this.opacity = opacity;
    }

}
