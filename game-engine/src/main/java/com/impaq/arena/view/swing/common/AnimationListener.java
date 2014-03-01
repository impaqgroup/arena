package com.impaq.arena.view.swing.common;

import com.google.common.eventbus.Subscribe;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public interface AnimationListener {

    @Subscribe
    void onAnimationFinish(AnimationFinish event);
}
