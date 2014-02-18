package com.impaq.arena.view.swing.sprite;

import com.impaq.arena.view.swing.common.Images;
import com.impaq.arena.view.swing.common.Sprite;
import java.awt.Dimension;
import java.awt.Point;

/**
 *
 * @author jaro
 */
public class IntroSprite extends Sprite {

    public IntroSprite() {
        super(Images.valueOf("sprites/open-sprite.jpg"), 57, new Dimension(1024, 638), new Point());
    }

}
