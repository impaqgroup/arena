package com.impaq.arena.client.view.swing;

import com.google.common.base.CaseFormat;
import com.google.common.collect.ImmutableList;
import com.impaq.arena.client.view.swing.common.Animation;
import com.impaq.arena.client.view.swing.common.AnimationFinish;
import com.impaq.arena.client.view.swing.common.AnimationListener;
import com.impaq.arena.client.view.swing.common.Component;
import com.impaq.arena.client.view.swing.common.ImageNode;
import com.impaq.arena.client.view.swing.common.Node;
import com.impaq.arena.client.view.swing.common.animation.Chain;
import com.impaq.arena.client.view.swing.common.animation.FadeOut;
import com.impaq.arena.client.view.swing.common.animation.Pause;
import com.impaq.arena.player.Player;
import com.impaq.arena.client.view.swing.common.animation.FadeIn;
import com.impaq.arena.client.view.swing.sprite.shapes.NumberNode;
import java.awt.Point;
import static java.lang.String.format;
import java.util.Collections;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class PlayerInfo extends Component {

    public static final String DESTROY_ACTION = "icons/actionDestroy.png";
    public static final String BUILD_ACTION = "icons/actionBuild.png";
    public static final String SPY_ACTION = "icons/actionSpy.png";
    public static final String KILL_ACTION = "icons/actionKill.png";
    public static final String ADD_ACTION = "icons/actionAdd.png";

    public static final int FADE_OUT_DURATION = 500;
    public static final int DISPAY_DURATION = 750;
    public static final int FADE_IN_DURATION = 500;

    private static class Arrow extends Component {

        private final ImageNode icon;

        public Arrow(Point position, String icon) {
            super(position);
            this.icon = new ImageNode(icon);
            add(this.icon);
            setOpacity(0.0);
        }

        private Animation show() {
            return new FadeIn(this, FADE_IN_DURATION);
        }

        private Animation hide() {
            return new FadeOut(this, FADE_OUT_DURATION);
        }
    }

    public enum Color {

        RED, BLUE;

        public String getName() {
            return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, name());
        }

    }

    public enum Side {

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
            if (value >= 100) {
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
            final Animation chain = Chain.of(new FadeIn(action, FADE_IN_DURATION), new Pause(DISPAY_DURATION), new FadeOut(action, FADE_OUT_DURATION));
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

    private final Figure wizard;

    private final Figure warrior;

    private final Figure castle;

    private final Arrow arrow;

    public PlayerInfo(Side side, Point position) {
        super(position);
        builder = new Figure(new Point(0, 30), format("icons/builder%s.JPG", side.getColor().getName()), ADD_ACTION, KILL_ACTION, SPY_ACTION);

        wizard = new Figure(new Point(100, 30), format("icons/wizard%s.JPG", side.getColor().getName()), ADD_ACTION, KILL_ACTION, SPY_ACTION);

        warrior = new Figure(new Point(200, 30), format("icons/warrior%s.JPG", side.getColor().getName()), ADD_ACTION, KILL_ACTION, SPY_ACTION);

        castle = new Figure(new Point(300, 30), format("icons/castle%s.JPG", side.getColor().getName()), BUILD_ACTION, DESTROY_ACTION, SPY_ACTION);

        arrow = new Arrow(new Point(400, 50), format("icons/arrow%s.JPG", side.getColor().getName()));

        addAll(ImmutableList.of(builder, wizard, warrior, castle, arrow));

        side.process(this);
    }

    private void setBuildersNumber(int value) {
        builder.setValue(value);
    }

    private void setWizardsNumber(int value) {
        wizard.setValue(value);
    }

    private void setWarriorsNumer(int value) {
        warrior.setValue(value);
    }

    private void setCastleNumer(int value) {
        castle.setValue(value);
    }

    public void update(Player player) {
        setBuildersNumber(player.getBuilders().getCount());
        setWarriorsNumer(player.getWarriors().getCount());
        setWizardsNumber(player.getWizards().getCount());
        setCastleNumer(player.getCastle().getHeight());
    }

    Animation spyWarriors() {
        return warrior.spy();
    }

    Animation spyBuilders() {
        return builder.spy();
    }

    Animation spyWizards() {
        return wizard.spy();
    }

    Animation spyCastle() {
        return castle.spy();
    }

    Animation killWizards() {
        return wizard.remove();
    }

    Animation killWarriors() {
        return warrior.remove();
    }

    Animation killBuilders() {
        return builder.remove();
    }

    Animation destroyCastle() {
        return castle.remove();
    }

    Animation buildCastle() {
        return castle.add();
    }

    Animation addBuilders() {
        return builder.add();
    }

    Animation addWarriors() {
        return warrior.add();
    }

    Animation addWizards() {
        return wizard.add();
    }

    Animation showArrow() {
        return arrow.show();
    }

     Animation hideArrow() {
        return arrow.hide();
    }

}
