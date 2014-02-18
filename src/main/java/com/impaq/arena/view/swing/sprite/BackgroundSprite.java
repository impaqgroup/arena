package com.impaq.arena.view.swing.sprite;

import com.impaq.arena.view.swing.common.Images;
import com.impaq.arena.view.swing.common.Sprite;
import java.awt.Dimension;
import java.awt.Point;

/**
 *
 * @author jaro
 */
public class BackgroundSprite extends Sprite {

    public BackgroundSprite() {
        super(Images.valueOf("sprites/background-sprite.jpg"), 11, new Dimension(1024, 638), new Point());
    }

}
