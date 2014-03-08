package com.impaq.arena.client.view.swing.common;

import static com.google.common.base.Preconditions.checkArgument;
import java.awt.AlphaComposite;
import java.awt.Composite;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author jaro
 */
public class Component extends BaseNode implements Node, List<Node> {

    private final List<Node> nodes;
    private double opacity = 1.0f;

    public Component() {
        this(new LinkedList<Node>());
    }

    public Component(Point position) {
        this(new LinkedList<Node>(), position);
    }

    public Component(List<Node> nodes) {
        this(nodes, new Point());
    }

    public Component(List<Node> nodes, Point position) {
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
        checkArgument(opacity <= 1 && opacity >= 0);
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

    @Override
    public boolean addAll(int index, Collection<? extends Node> c) {
        return nodes.addAll(index, c);
    }

    @Override
    public boolean equals(Object o) {
        return nodes.equals(o);
    }

    @Override
    public int hashCode() {
        return nodes.hashCode();
    }

    @Override
    public Node get(int index) {
        return nodes.get(index);
    }

    @Override
    public Node set(int index, Node element) {
        return nodes.set(index, element);
    }

    @Override
    public void add(int index, Node element) {
        nodes.add(index, element);
    }

    @Override
    public Node remove(int index) {
        return nodes.remove(index);
    }

    @Override
    public int indexOf(Object o) {
        return nodes.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o) {
        return nodes.lastIndexOf(o);
    }

    @Override
    public ListIterator<Node> listIterator() {
        return nodes.listIterator();
    }

    @Override
    public ListIterator<Node> listIterator(int index) {
        return nodes.listIterator(index);
    }

    @Override
    public List<Node> subList(int fromIndex, int toIndex) {
        return nodes.subList(fromIndex, toIndex);
    }



}
