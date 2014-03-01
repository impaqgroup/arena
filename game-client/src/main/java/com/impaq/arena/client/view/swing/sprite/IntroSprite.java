package com.impaq.arena.client.view.swing.sprite;

import com.impaq.arena.client.view.swing.common.Images;
import com.impaq.arena.client.view.swing.common.Sprite;
import java.awt.Dimension;
import java.awt.Point;

/**
 *
 * @author jaro
 */
public class IntroSprite extends Sprite {

    public IntroSprite(Point position) {
        super(Images.valueOf("sprites/open-sprite.jpg"), 57, new Dimension(988, 576), position);
    }

}
