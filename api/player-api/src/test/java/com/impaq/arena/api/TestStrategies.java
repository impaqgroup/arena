package com.impaq.arena.api;

public enum TestStrategies implements PlayerStrategy {

    idleStrategy() {
        @Override
        public void playRound(Game game) { }
    },

    builderStrategy() {
        @Override
        public void playRound(Game game) {
            game.recruitBuilders();
            game.recruitBuilders();
            game.buildMyCastle();
        }
    },

    warriorStrategy() {
        @Override
        public void playRound(Game game) {
            game.recruitWarriors();
            game.recruitWarriors();
            game.attackEnemyCastle();
        }
    },

    rougeStrategy() {
        @Override
        public void playRound(Game game) {
            if (game.spyEnemyBuildersCount() > game.myWizardsStrength() / 2) {
                game.recruitWizards();
                game.recruitWizards();
                game.attackEnemyBuilders();
            } else if (game.spyEnemyWarriorsCount() > game.myWizardsStrength() / 2) {
                game.recruitWizards();
                game.recruitWizards();
                game.attackEnemyWarriors();
            } else {
                game.recruitBuilders();
                game.recruitBuilders();
                game.buildMyCastle();
            }
        }
    }

}
