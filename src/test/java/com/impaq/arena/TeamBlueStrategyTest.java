package com.impaq.arena;

import org.junit.Test;

public class TeamBlueStrategyTest extends BaseStrategyTest {

    @Override
    public Strategy getStrategy() {
        return new TeamBlueStrategy();
    }

    @Test
    public void inSecondRoundShoudSpyWarriorsAndIfGreaterThenTenShouldAddWizardsTwiceAndKillWarriors() {
        //given
        gameBoard.setOponentWarriors(11).setWizzards(2);

        //when
        gameBoard.executeRound(2);

        //than
        assertExpectedActions(spyWarriors(), addWizards(), addWizards(), killWarriors());
    }

}
