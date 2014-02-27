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
                if (spyWizzards() > 8) {
                    if (wizzards() < 4) {
                        addWizzards();
                        addWizzards();
                    } else {
                        addBuilders();
                        addBuilders();
                    }
                    killWizzards();
                } else if (spyCastle() > 30) {

                    addWarriors();
                    addWarriors();
                    destroyCastle();
                } else {
                    addBuilders();
                    addBuilders();
                    buildCastle();
                }
            }
        });

        add(new RoundStrategy() {
            @Override
            public void body() {
                if (spyWarriors() > 8) {
                    if (wizzards() < 4) {
                        addWizzards();
                        addWizzards();
                    } else {
                        addBuilders();
                        addBuilders();
                    }
                    killWarriors();
                } else if (spyCastle() > 30) {
                    addWarriors();
                    addWarriors();
                    destroyCastle();
                } else {
                    addBuilders();
                    addBuilders();
                    buildCastle();
                }
            }
        });

        add(new RoundStrategy() {
            @Override
            public void body() {
                if (spyBuilders() > 8) {
                    if (wizzards() < 4) {
                        addWizzards();
                        addWizzards();
                    } else {
                        addBuilders();
                        addBuilders();
                    }
                    killBuilders();
                } else if (spyCastle() > 30) {
                    addWarriors();
                    addWarriors();
                    destroyCastle();
                } else {
                    addBuilders();
                    addBuilders();
                    buildCastle();
                }
            }
        });

    }
}
