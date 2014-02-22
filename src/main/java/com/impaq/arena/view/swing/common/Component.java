package com.impaq.arena.view.swing.common;

import com.google.common.base.Preconditions;
import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author jaro
 */
public class Component extends BaseNode implements Node, Collection<Node> {

    private final Collection<Node> nodes;
    private double opacity = 1.0f;

    public Component() {
        this(new LinkedList<Node>());
    }

    public Component(Point position) {
        this(new LinkedList<Node>(), position);
    }

    public Component(Collection<Node> nodes) {
        this(nodes, new Point());
    }

    public Component(Collection<Node> nodes, Point position) {
        super(position);
        this.nodes = nodes;
    }

    private AlphaComposite makeComposite(double alpha) {
        int type = AlphaComposite.SRC_OVER;
        return (AlphaComposite.getInstance(type, (float) alpha));
    }

    public double getOpacity() {
        return opacity;
    }

    public void setOpacity(double opacity) {
        Preconditions.checkArgument(opacity <= 1 && opacity >= 0);
        this.opacity = opacity;
    }

    @Override
    public void draw(Graphics2D graphics) {
        Composite orginal = graphics.getComposite();
        graphics.setComposite(makeComposite(opacity));
        graphics.translate(getPosition().x, getPosition().y);
        for (Node node : nodes) {
            node.draw(graphics);
        }
        graphics.translate(-getPosition().x, -getPosition().y);
        graphics.setComposite(orginal);
    }

    @Override
    public int size() {
        return nodes.size();
    }

    @Override
    public boolean isEmpty() {
        return nodes.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return nodes.contains(o);
    }

    @Override
    public Iterator<Node> iterator() {
        return nodes.iterator();
    }

    @Override
    public Object[] toArray() {
        return nodes.toArray();
    }

    @Override
    public <Node> Node[] toArray(Node[] ts) {
        return nodes.toArray(ts);
    }

    @Override
    public boolean add(Node e) {
        return nodes.add(e);
    }

    @Override
    public boolean remove(Object o) {
        return nodes.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> clctn) {
        return nodes.containsAll(clctn);
    }

    @Override
    public boolean addAll(Collection<? extends Node> clctn) {
        return nodes.addAll(clctn);
    }

    @Override
    public boolean removeAll(Collection<?> clctn) {
        return nodes.removeAll(clctn);
    }

    @Override
    public boolean retainAll(Collection<?> clctn) {
        return nodes.retainAll(clctn);
    }

    @Override
    public void clear() {
        nodes.clear();
    }

}
