package com.impaq.arena.view.swing.common;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author jaro
 */
public interface Node {

    void draw(Graphics2D graphics);

    Point getPosition();

}
