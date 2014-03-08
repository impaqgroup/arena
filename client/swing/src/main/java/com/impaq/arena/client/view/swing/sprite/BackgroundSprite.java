package com.impaq.arena.client.view.swing.sprite;

import com.impaq.arena.client.view.swing.common.Images;
import com.impaq.arena.client.view.swing.common.Sprite;
import java.awt.Dimension;
import java.awt.Point;

/**
 *
 * @author jaro
 */
public class BackgroundSprite extends Sprite {

    public BackgroundSprite(Point position) {
        super(Images.valueOf("sprites/background-sprite.jpg"), 10, new Dimension(988, 576), position);
    }

}
