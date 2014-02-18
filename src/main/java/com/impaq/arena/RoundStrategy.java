package com.impaq.arena;

import com.impaq.arena.engine.event.BuildCastle;
import com.impaq.arena.engine.event.DestroyCastle;
import com.impaq.arena.engine.event.PopulateBuilders;
import com.impaq.arena.engine.event.KillBuilders;
import com.impaq.arena.engine.event.KillWarriors;
import com.impaq.arena.engine.event.PopulateWizards;
import com.impaq.arena.engine.event.KillWizards;
import com.impaq.arena.engine.event.PopulateWarriors;
import com.impaq.arena.engine.event.SpyWarriors;
import com.impaq.arena.engine.event.SpyBuilders;
import com.impaq.arena.engine.event.SpyWizards;
import com.impaq.arena.engine.event.SpyCastle;
import com.google.common.eventbus.EventBus;
import com.impaq.arena.player.Player;

public abstract class RoundStrategy {

    private static int POPULATE_NUMBER = 5;
    private Player current;
    private Player oponent;
    private int actionCount = 0;
    private int spyActionCount = 0;
    private EventBus eventBus;

    protected abstract void body();

    void execute(EventBus eventBus, Player current, Player oponent) {
        this.current = current;
        this.oponent = oponent;
        this.eventBus = eventBus;
        actionCount = 0;
        spyActionCount = 0;
        body();
    }

    private void dispatchEvent(Object object) {
        eventBus.post(object);
    }

    protected void zabijMagow() {
        if (!isActionAvailable()) {
            return;
        }

        dispatchEvent(new KillWizards(oponent, getWizardsStrength()));
        oponent.getWizards().kill(getWizardsStrength());
        actionCount++;
    }

    protected void zabijWojownikow() {
        if (!isActionAvailable()) {
            return;
        }
        dispatchEvent(new KillWarriors(oponent, getWizardsStrength()));
        oponent.getWarriors().kill(getWizardsStrength());
        actionCount++;
    }

    protected void zabijBudowniczych() {
        if (!isActionAvailable()) {
            return;
        }
        dispatchEvent(new KillBuilders(oponent, getWizardsStrength()));
        oponent.getBuilders().kill(getWizardsStrength());
        actionCount++;
    }

    protected void zniszczZamekWroga() {
        if (!isActionAvailable()) {
            return;
        }
        dispatchEvent(new DestroyCastle(oponent, getWarriorsStrength()));
        oponent.getCastle().destroy(getWarriorsStrength());
        actionCount++;
    }

    protected void budujZamek() {
        if (!isActionAvailable()) {
            return;
        }
        dispatchEvent(new BuildCastle(oponent, getBuildersProductivity()));
        current.getCastle().expand(getBuildersProductivity());
        actionCount++;
    }

    protected void dodajBudowniczych() {
        if (!isActionAvailable()) {
            return;
        }
        dispatchEvent(new PopulateBuilders(oponent, POPULATE_NUMBER));
        current.getBuilders().add(POPULATE_NUMBER);
        actionCount++;
    }

    protected void dodajMagow() {
        if (!isActionAvailable()) {
            return;
        }
        dispatchEvent(new PopulateWizards(oponent, POPULATE_NUMBER));
        current.getWizards().add(POPULATE_NUMBER);
        actionCount++;
    }

    protected void dodajWojownikow() {
        if (!isActionAvailable()) {
            return;
        }
        dispatchEvent(new PopulateWarriors(oponent, POPULATE_NUMBER));
        current.getWarriors().add(POPULATE_NUMBER);
        actionCount++;
    }

    private boolean isActionAvailable() {
        return actionCount < 3;
    }

    private int getWizardsStrength() {
        return current.getWizards().getStrength();
    }

    private int getWarriorsStrength() {
        return current.getWarriors().getStrength();
    }

    private int getBuildersProductivity() {
        return current.getBuilders().getProductivity();
    }

    protected long wysokoscZamkuWroga() {
        if (!isSpyActionAvailable()) {
            return -1;
        }
        dispatchEvent(new SpyCastle(oponent));
        spyActionCount++;
        return oponent.getCastle().spy();
    }

    protected long iloscWojownikowWroga() {
        if (!isSpyActionAvailable()) {
            return -1;
        }
        dispatchEvent(new SpyWarriors(oponent));
        spyActionCount++;
        return oponent.getWarriors().spy();
    }

    protected long iloscMagowWroga() {
        if (!isSpyActionAvailable()) {
            return -1;
        }
        dispatchEvent(new SpyWizards(oponent));

        spyActionCount++;
        return oponent.getWizards().spy();
    }

    protected long iloscBudowniczychWroga() {

        if (!isSpyActionAvailable()) {
            return -1;
        }
        dispatchEvent(new SpyBuilders(oponent));
        spyActionCount++;
        return oponent.getBuilders().spy();
    }

    private boolean isSpyActionAvailable() {
        return spyActionCount < 2;
    }

    protected long wysokoscZamku() {
        return current.getCastle().getHeight();
    }

    protected long iloscPosiadanychWojowniko() {
        return current.getWarriors().getCount();
    }

    protected long iloscPosiadanychMagow() {
        return current.getWizards().getCount();
    }

    protected long iloscPosiadanychBudowniczyc() {
        return current.getBuilders().getCount();
    }
}
