package com.impaq.arena.view.swing.common;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class ImageNode extends BaseNode {

    private final BufferedImage image;

    public ImageNode(BufferedImage image, Point point) {
        super(point);
        this.image = image;
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.drawImage(image, getPosition().x, getPosition().y, null);
    }

    public Dimension getDimension() {
        return new Dimension(image.getWidth(), image.getHeight());
    }

}
