package com.impaq.arena;

import com.impaq.arena.player.Player;

public abstract class RoundStrategy {

    private static int COUNT = 5;
    private Player current;
    private Player oponent;
    private int actionCount = 0;
    private int spyActionCount = 0;

    protected abstract void body();

    void execute(Player current, Player oponent) {
        this.current = current;
        this.oponent = oponent;
        actionCount = 0;
        spyActionCount = 0;
        body();
    }

    protected void zabijMagow() {
        if (!isActionExecutable()) {
            return;
        }

        oponent.getWizards().kill(getWizardsStrength());
        actionCount++;
    }

    protected void zabijWojownikow() {
        if (!isActionExecutable()) {
            return;
        }

        oponent.getWarriors().kill(getWizardsStrength());
        actionCount++;
    }

    protected void zabijBudowniczych() {
        if (!isActionExecutable()) {
            return;
        }

        oponent.getBuilders().kill(getWizardsStrength());
        actionCount++;
    }

    protected void zniszczZamekWroga() {
        if (!isActionExecutable()) {
            return;
        }

        oponent.getCastle().destroy(getWarriorsStrength());
        actionCount++;
    }

    protected void budujZamek() {
        if (!isActionExecutable()) {
            return;
        }

        current.getCastle().expand(getBuildersProductivity());
        actionCount++;
    }

    protected void dodajBudowniczych() {
        if (!isActionExecutable()) {
            return;
        }

        current.getBuilders().add(COUNT);
        actionCount++;
    }

    protected void dodajMagow() {
        if (!isActionExecutable()) {
            return;
        }

        current.getWizards().add(COUNT);
        actionCount++;
    }

    protected void dodajWojownikow() {
        if (!isActionExecutable()) {
            return;
        }

        current.getWarriors().add(COUNT);
        actionCount++;
    }

    private boolean isActionExecutable() {
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

        spyActionCount++;
        return oponent.getCastle().spy();
    }

    protected long iloscWojownikowWroga() {
        // TODO może exception
        if (!isSpyActionAvailable()) {
            return -1;
        }

        spyActionCount++;
        return oponent.getWarriors().spy();
    }

    protected long iloscMagowWroga() {
        if (!isSpyActionAvailable()) {
            return -1;
        }

        spyActionCount++;
        return oponent.getWizards().spy();
    }

    protected long iloscBudowniczychWroga() {

        if (!isSpyActionAvailable()) {
            return -1;
        }

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
