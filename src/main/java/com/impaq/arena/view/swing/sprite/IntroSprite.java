package com.impaq.arena.view.swing.sprite;

import static com.google.common.base.Throwables.propagate;
import static com.google.common.io.Resources.getResource;
import com.impaq.arena.view.swing.common.Sprite;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.IOException;
import static javax.imageio.ImageIO.read;

/**
 *
 * @author jaro
 */
public class IntroSprite extends Sprite {

    public IntroSprite() {
        super(loadSprite(), 47, new Dimension(1280, 798), new Point());
    }

    private static BufferedImage loadSprite() {
        try {
            return read(getResource("sprites/open-sprite.jpg"));
        } catch (IOException ex) {
            throw propagate(ex);
        }
    }
}
