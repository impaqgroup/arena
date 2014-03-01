package com.impaq.arena.client.view.swing.common;

import java.awt.Point;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public abstract class BaseNode implements Node {

    private final Point position;

    public BaseNode(Point position) {
        this.position = position;
    }

    @Override
    public Point getPosition() {
        return position;
    }

}
