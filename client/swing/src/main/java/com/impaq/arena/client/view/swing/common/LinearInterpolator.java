package com.impaq.arena.client.view.swing.common;

/**
 *
 * @author jaro
 */
public final class LinearInterpolator implements Interpolator {

    public LinearInterpolator() {
    }

    @Override
    public double interpolate(double start, double end, double fraction) {
        double result = start + ((end - start) * fraction);
        result = Math.max(start, result);
        result = Math.min(end, result);
        return result;
    }

    @Override
    public String toString() {
        return LinearInterpolator.class.getSimpleName();
    }
}
