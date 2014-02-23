package com.impaq.arena.view.swing;

import com.google.common.base.CaseFormat;
import com.google.common.collect.ImmutableList;
import com.impaq.arena.player.Player;
import com.impaq.arena.view.swing.common.Animation;
import com.impaq.arena.view.swing.common.AnimationFinish;
import com.impaq.arena.view.swing.common.AnimationListener;
import com.impaq.arena.view.swing.common.Component;
import com.impaq.arena.view.swing.common.ImageNode;
import com.impaq.arena.view.swing.common.Node;
import com.impaq.arena.view.swing.common.animation.Chain;
import com.impaq.arena.view.swing.common.animation.FadeIn;
import com.impaq.arena.view.swing.common.animation.FadeOut;
import com.impaq.arena.view.swing.sprite.shapes.NumberNode;
import java.awt.Point;
import static java.lang.String.format;
import java.util.Collections;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class PlayerInfo extends Component {

    enum Color {

        RED, BLUE;

        public String getName() {
            return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, name());
        }

    }

    enum Side {

        LEFT(Color.BLUE), RIGHT(Color.RED) {

                    @Override
                    public void process(Component component) {
                        Collections.reverse(component);
                        for (Node node : component) {
                            node.getPosition().move(400 - node.getPosition().x, node.getPosition().y);
                        }
                    }

                };

        private final Color color;

        private Side(Color color) {
            this.color = color;
        }

        public Color getColor() {
            return color;
        }

        public void process(Component component) {

        }
    }

    class Figure extends Component {

        private final ImageNode icon;

        private final ImageNode addIcon;

        private final ImageNode removeIcon;

        private final ImageNode spyIcon;

        private final NumberNode value;

        private final Component action = new Component();

        public Figure(Point position, String icon, String addIcon, String removeIcon, String spyIcon) {
            super(position);
            this.icon = new ImageNode(icon);
            this.addIcon = new ImageNode(addIcon, new Point(0, 150));
            this.removeIcon = new ImageNode(removeIcon, new Point(0, 150));
            this.spyIcon = new ImageNode(spyIcon, new Point(0, 150));
            this.value = new NumberNode(new Point(20, 70), 0);
            action.setOpacity(0.0);
            add(this.icon);
            add(this.value);
            add(action);
        }

        public int getValue() {
            return value.getValue();
        }

        public void setValue(int value) {
            if (value > 100) {
                this.value.getPosition().move(0, 70);
            } else {
                this.value.getPosition().move(20, 70);
            }
            this.value.setValue(value);
        }

        public Animation add() {
            return animate(addIcon);

        }

        public Animation remove() {
            return animate(removeIcon);

        }

        public Animation spy() {
            return animate(spyIcon);

        }

        private Animation animate(final Node icon) {
            action.add(icon);
            final Animation chain = Chain.of(new FadeIn(action, 500), new FadeOut(action, 500));
            chain.registerListener(new AnimationListener() {

                @Override
                public void onAnimationFinish(AnimationFinish event) {
                    action.remove(icon);
                }
            });
            return chain;
        }

    }

    private final Figure builder;

    private final Figure wizzard;

    private final Figure warrior;

    private final Figure castle;

    public PlayerInfo(Side side, Point position) {
        super(position);
        builder = new Figure(new Point(0, 30), format("icons/builder%s.JPG", side.getColor().getName()), "icons/actionAdd.JPG", "icons/actionKill.JPG", "icons/actionSpy.JPG");

        wizzard = new Figure(new Point(100, 30), format("icons/wizzard%s.JPG", side.getColor().getName()), "icons/actionAdd.JPG", "icons/actionKill.JPG", "icons/actionSpy.JPG");

        warrior = new Figure(new Point(200, 30), format("icons/warrior%s.JPG", side.getColor().getName()), "icons/actionAdd.JPG", "icons/actionKill.JPG", "icons/actionSpy.JPG");

        castle = new Figure(new Point(300, 30), format("icons/castle%s.JPG", side.getColor().getName()), "icons/actionAdd.JPG", "icons/actionKill.JPG", "icons/actionSpy.JPG");

        addAll(ImmutableList.of(builder, wizzard, warrior, castle));
        side.process(this);
    }

    public void setBuildersNumber(int value) {
        builder.setValue(value);
    }

    public void setWizzardsNumber(int value) {
        wizzard.setValue(value);
    }

    public void setWarriorsNumer(int value) {
        warrior.setValue(value);
    }

    public void setCastleNumer(int value) {
        castle.setValue(value);
    }

    public void update(Player player) {
        setBuildersNumber(player.getBuilders().getCount());
        setWarriorsNumer(player.getWarriors().getCount());
        setWizzardsNumber(player.getWizards().getCount());
        setCastleNumer(player.getCastle().getHeight());
    }

    Animation spyWarriors() {
        return warrior.spy();
    }

    Animation spyBuilders() {
        return builder.spy();
    }

    Animation spyWizzards() {
        return wizzard.spy();
    }

    Animation spyCastle() {
        return castle.spy();
    }

}
