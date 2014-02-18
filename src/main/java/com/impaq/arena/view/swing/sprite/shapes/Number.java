package com.impaq.arena.view.swing.sprite.shapes;

import com.impaq.arena.view.swing.common.BaseNode;
import com.impaq.arena.view.swing.common.ImageNode;
import com.impaq.arena.view.swing.common.Images;
import com.impaq.arena.view.swing.common.Layer;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class Number extends BaseNode {

    private int value;
    private final Layer<ImageNode> numbers = new Layer<>();

    public Number(Point point, int value) {
        super(point);
        setValue(value);
    }

    ImageNode number(int number) {
        return new ImageNode(Images.valueOf(String.format("numbers/%d.JPG", number)), new Point());
    }

    @Override
    public synchronized void draw(Graphics2D graphics) {

        numbers.draw(graphics);
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        updateNumbers(value);
        this.value = value;
    }

    private synchronized void updateNumbers(int value) {
        String number = String.valueOf(value);
        numbers.clear();
        Point location = new Point(getPosition());
        for (int i = 0; i < number.length(); ++i) {
            final char c = number.charAt(i);
            final ImageNode numberImage = number(Integer.valueOf(String.valueOf(c)));
            location.translate(-numberImage.getDimension().width, 0);
            numberImage.getPosition().setLocation(location);
            numbers.add(numberImage);

        }
    }

}
