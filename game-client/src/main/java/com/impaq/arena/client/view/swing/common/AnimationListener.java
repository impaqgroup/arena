package com.impaq.arena.client.view.swing.common;

import com.google.common.eventbus.Subscribe;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public interface AnimationListener {

    @Subscribe
    void onAnimationFinish(AnimationFinish event);
}
