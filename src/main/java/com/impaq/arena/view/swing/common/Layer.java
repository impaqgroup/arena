package com.impaq.arena.view.swing.common;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Collection;
import java.util.Iterator;

/**
 *
 * @author jaro
 */
public class Layer<T extends Node> extends BaseNode implements Node, Collection<T> {

    private final Collection<T> nodes;

    public Layer(Collection<T> nodes) {
        super(new Point());
        this.nodes = nodes;
    }

    @Override
    public void draw(Graphics2D graphics) {
        for (T node : nodes) {
            node.draw(graphics);
        }
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
    public Iterator<T> iterator() {
        return nodes.iterator();
    }

    @Override
    public Object[] toArray() {
        return nodes.toArray();
    }

    @Override
    public <T> T[] toArray(T[] ts) {
        return nodes.toArray(ts);
    }

    @Override
    public boolean add(T e) {
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
    public boolean addAll(Collection<? extends T> clctn) {
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
