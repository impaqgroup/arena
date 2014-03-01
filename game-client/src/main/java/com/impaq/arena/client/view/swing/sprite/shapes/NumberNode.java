package com.impaq.arena.client.view.swing.sprite.shapes;

import com.impaq.arena.client.view.swing.common.Component;
import com.impaq.arena.client.view.swing.common.ImageNode;
import com.impaq.arena.client.view.swing.common.BaseNode;
import com.impaq.arena.client.view.swing.common.Images;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class NumberNode extends BaseNode {

    private int value;
    private final Component numbers = new Component();

    public NumberNode(Point point, int value) {
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
        updateNumbers(Math.max(value, 0));
        this.value = value;
    }

    private synchronized void updateNumbers(int value) {
        String number = String.valueOf(value);
        numbers.clear();
        Point location = new Point(getPosition());
        for (int i = 0; i < number.length(); ++i) {
            final char c = number.charAt(i);
            final ImageNode numberImage = number(Integer.valueOf(String.valueOf(c)));
            numberImage.getPosition().setLocation(location);
            location.translate(numberImage.getDimension().width, 0);
            numbers.add(numberImage);

        }
    }

}
