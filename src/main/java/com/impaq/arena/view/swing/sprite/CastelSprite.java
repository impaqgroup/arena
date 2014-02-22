package com.impaq.arena.view.swing.sprite;

import com.google.common.base.CaseFormat;
import com.impaq.arena.view.swing.common.Images;
import com.impaq.arena.view.swing.common.Sprite;
import java.awt.Dimension;
import java.awt.Point;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class CastelSprite extends Sprite {

    public enum Side {

        LEFT, RIGHT
    }

    public CastelSprite(Side side) {
        super(Images.valueOf("sprites/castel-" + CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_HYPHEN, side.name()) + "-sprite.jpg"), 19, new Dimension(477, 576), side == Side.RIGHT ? new Point(477, 0) : new Point());
    }

}
