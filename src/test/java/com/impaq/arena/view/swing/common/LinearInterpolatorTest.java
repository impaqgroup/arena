/*
 * Copyright (C) 2014 Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.impaq.arena.view.swing.common;

import org.fest.assertions.Assertions;
import org.junit.Test;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class LinearInterpolatorTest {

    public static final double MAX = 15.0;
    public static final double MIN = 5.0;

    private Interpolator interpolator = new LinearInterpolator();

    public LinearInterpolatorTest() {
    }

    @Test
    public void shouldInterpolateValueContainedByRange() {
        Assertions.assertThat(interpolator.interpolate(MIN, MAX, 0.5)).isEqualTo(10.0);
    }

    @Test
    public void shouldInterpolateValueHigherThenRange() {
        Assertions.assertThat(interpolator.interpolate(MIN, MAX, 1.5)).isEqualTo(15.0);
    }

    @Test
    public void shouldInterpolateValueLowerThenRande() {
        Assertions.assertThat(interpolator.interpolate(MIN, MAX, -0.1)).isEqualTo(5.0);
    }

}
