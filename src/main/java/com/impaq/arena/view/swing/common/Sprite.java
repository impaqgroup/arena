package com.impaq.arena.view.swing.common;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import static java.lang.Math.max;

/**
 *
 * @author jaro
 */
public class Sprite implements Node {

    private final BufferedImage image;
    private final int size;
    private final Dimension dimension;
    private int index = 0;
    private final Point position;

    public Sprite(BufferedImage image, int size, Dimension dimension, Point point) {
        this.image = image;
        this.size = size;
        this.dimension = dimension;
        this.position = point;
    }

    public void updateIndex(int index) {
        this.index = index;
    }

    public int size() {
        return size;
    }

    public void last() {
        updateIndex(max(size() - 1, 0));
    }

    @Override
    public void draw(Graphics2D graphics) {
        graphics.drawImage(image.getSubimage(computeSubimageWidth(), computeSubimageHeight(), dimension.width, dimension.height), position.x, position.y, null);
    }

    private int computeSubimageWidth() {
        return (dimension.width * index) % image.getWidth();
    }

    private int computeSubimageHeight() {
        return ((index * dimension.width) / image.getWidth()) * dimension.height;
    }

    public Point getPosition() {
        return position;
    }

    public Dimension getDimension() {
        return dimension;
    }

}
