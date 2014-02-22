package com.impaq.arena.view.swing;

import com.google.common.collect.ImmutableList;
import com.impaq.arena.view.swing.common.BaseNode;
import com.impaq.arena.view.swing.common.Component;
import com.impaq.arena.view.swing.common.ImageNode;
import com.impaq.arena.view.swing.sprite.shapes.NumberNode;
import java.awt.Graphics2D;
import java.awt.Point;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class PlayerInfo extends BaseNode {

    class Figure extends Component {

        private final ImageNode icon;

        private final NumberNode value;

        public Figure(String icon, Point position) {
            super(position);
            this.icon = new ImageNode(icon);
            this.value = new NumberNode(new Point(20, 70), 0);
            add(this.icon);
            add(this.value);
        }

        public int getValue() {
            return value.getValue();
        }

        public void setValue(int value) {
            this.value.setValue(value);
        }
    }

    private Component icons;

    private Figure builder = new Figure("icons/builderBlue.JPG", new Point(0, 30));

    private Figure wizzard = new Figure("icons/wizzardBlue.JPG", new Point(100, 30));

    private Figure warrior = new Figure("icons/warriorBlue.JPG", new Point(200, 30));

    private Figure castel = new Figure("icons/castleBlue.JPG", new Point(300, 30));

    public PlayerInfo(Point position) {
        super(position);
        icons = new Component(position);
        icons.addAll(ImmutableList.of(builder, wizzard, warrior, castel));
    }

    @Override
    public void draw(Graphics2D graphics) {
        icons.draw(graphics);
    }

    public void setBuildersNumber(int value) {
        builder.setValue(value);
    }
    
    public void setWizzardsNumber(int value) {
        wizzard.setValue(value);
    }

}
