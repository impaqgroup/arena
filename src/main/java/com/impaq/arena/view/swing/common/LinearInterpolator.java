package com.impaq.arena.view.swing.common;

/**
 *
 * @author jaro
 */
public final class LinearInterpolator implements Interpolator {

    public LinearInterpolator() {
    }

    @Override
    public double interpolate(double start, double end, double fraction) {
        return (end - start) * fraction;
    }

    @Override
    public String toString() {
        return LinearInterpolator.class.getSimpleName();
    }
}
