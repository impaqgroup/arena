package com.impaq.arena.client.view.swing;

import com.impaq.arena.GameBoardView;
import com.impaq.arena.event.AttackCastle;
import com.impaq.arena.event.RecruitBuilders;
import com.impaq.arena.event.RecruitWarriors;
import com.impaq.arena.event.RecruitWizards;
import com.impaq.arena.event.BuildCastle;
import com.impaq.arena.event.GameEnd;
import com.impaq.arena.event.GameStarted;
import com.impaq.arena.event.AttackBuilders;
import com.impaq.arena.event.AttackWarriors;
import com.impaq.arena.event.AttackWizards;
import com.impaq.arena.event.PlayerTurnStart;
import com.impaq.arena.event.RoundStart;
import com.impaq.arena.event.SpyBuilders;
import com.impaq.arena.event.SpyCastle;
import com.impaq.arena.event.SpyWarriors;
import com.impaq.arena.event.SpyWizards;

/**
 *
 * @author jaro
 */
public class SwingViewPresenter implements GameBoardView {

    private SwingView view = new SwingView();

    @Override
    public void onGameStart(GameStarted event) {
        view.displayIntro();
        view.initialize(event.getPlayerOne(), event.getPlayerTwo());
    }

    @Override
    public void onGameEnd(GameEnd gameEnd) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ex) {
        }
        view.dispose();
    }

    @Override
    public void onSpyWizards(SpyWizards event) {
        view.spyWizard(event.getPlayer());
    }

    @Override
    public void onSpyWarriors(SpyWarriors event) {
        view.spyWarriors(event.getPlayer());
    }

    @Override
    public void onSpyCastle(SpyCastle event) {
        view.spyCastel(event.getPlayer());
    }

    @Override
    public void onSpyBuilders(SpyBuilders event) {
        view.spyBuilders(event.getPlayer());
    }

    @Override
    public void onBuildCastle(BuildCastle event) {
        view.buildCastle(event.getPlayer());
        view.updateCastels();
    }

    @Override
    public void onAttackCastle(AttackCastle event) {
        view.destroyCastle(event.getPlayer());
        view.updateCastels();
    }

    @Override
    public void onAttackBuilders(AttackBuilders event) {
        view.killBuilders(event.getPlayer());
    }

    @Override
    public void onAttackWizards(AttackWizards event) {
        view.killWizards(event.getPlayer());
    }

    @Override
    public void onAttackWarriors(AttackWarriors event) {
        view.killWarriors(event.getPlayer());
    }

    @Override
    public void onRecruitBuilders(RecruitBuilders event) {
        view.addBuilders(event.getPlayer());
    }

    @Override
    public void onRecruitWizards(RecruitWizards event) {
        view.addWizards(event.getPlayer());
    }

    @Override
    public void onRecruitWarriors(RecruitWarriors event) {
        view.addWarriors(event.getPlayer());
    }

    @Override
    public void onRoundStart(RoundStart event) {
        view.updateRoundNumber(event.getNumber());
    }

    @Override
    public void onPlayerTurnStart(PlayerTurnStart event) {

    }

}
