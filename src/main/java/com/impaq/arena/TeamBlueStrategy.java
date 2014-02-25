package com.impaq.arena;

/**
 *
 * @author Jaroslaw Herod <jaroslaw.herod@impaqgroup.com>
 */
public class TeamBlueStrategy extends Strategy {

    public TeamBlueStrategy() {
        add(new RoundStrategy() {
            @Override
            public void body() {
                if (spyCastle() > 60) {
                    addWarriors();
                    addWarriors();
                    destroyCastle();
                } else {
                    if (warriors() > 30) {
                        destroyCastle();
                        addWizzards();
                        addWizzards();
                    } else {
                        addBuilders();
                        addBuilders();
                        buildCastle();
                    }
                }
            }
        });

        add(new RoundStrategy() {
            public void body() {
                addBuilders();
                addBuilders();
                if (spyBuilders() > wizzards() * 2) {
                    killBuilders();
                } else {
                    buildCastle();
                }
            }
        });
    }
}
