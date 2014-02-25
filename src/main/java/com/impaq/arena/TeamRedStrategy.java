package com.impaq.arena;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class TeamRedStrategy extends RoundRobinStrategy {

    {
        add(new RoundStrategy() {

            @Override
            public void body() {
                if (spyBuilders()> 10) {
                    addWizzards();
                    addWizzards();
                    killBuilders();
                } else {
                    addWarriors();
                    addWarriors();
                    destroyCastle();
                }
            }
        });
    }
}
