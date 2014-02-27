package com.impaq.arena;

import org.junit.Test;

public class TeamBlueStrategyTest extends BaseStrategyTest {

    @Override
    public Strategy getStrategy() {
        return new TeamBlueStrategy();
    }

    @Test
    public void shouldSpyWarriorsAddWizardsTwiceAndKillWarriorsWhenExecutingSecondRoundAndOponentWarriorsGreaterThen10() {
        //given
        gameBoard.setOponentWarriors(11);

        //when
        gameBoard.executeRound(2);

        //than
        assertExpectedActions(spyWarriors(), addWizards(), addWizards(), killWarriors());
    }

}
