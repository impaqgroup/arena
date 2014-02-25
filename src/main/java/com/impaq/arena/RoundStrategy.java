package com.impaq.arena;

import com.google.common.eventbus.EventBus;
import com.impaq.arena.event.BuildCastle;
import com.impaq.arena.event.DestroyCastle;
import com.impaq.arena.event.KillBuilders;
import com.impaq.arena.event.KillWarriors;
import com.impaq.arena.event.AddBuilders;
import com.impaq.arena.event.AddWarriors;
import com.impaq.arena.event.AddWizards;
import com.impaq.arena.event.KillWizards;
import com.impaq.arena.event.SpyBuilders;
import com.impaq.arena.event.SpyCastle;
import com.impaq.arena.event.SpyWarriors;
import com.impaq.arena.event.SpyWizards;
import com.impaq.arena.player.Player;

public abstract class RoundStrategy {

    private Player current;
    private Player oponent;
    private int actionCount = 0;
    private int spyActionCount = 0;
    private EventBus eventBus;
    private int addActionCount = 0;

    protected abstract void body();

    final void execute(EventBus eventBus, Player current, Player oponent) {
        this.current = current;
        this.oponent = oponent;
        this.eventBus = eventBus;
        actionCount = 0;
        spyActionCount = 0;
        addActionCount = 0;
        body();
    }

    private void dispatchEvent(Object object) {
        eventBus.post(object);
    }

    protected final void killWizzards() {
        if (!isActionAvailable()) {
            return;
        }

        dispatchEvent(new KillWizards(current, getWizardsStrength()));
        oponent.getWizards().kill(getWizardsStrength());
        actionCount++;
    }

    protected final void killWarriors() {
        if (!isActionAvailable()) {
            return;
        }
        oponent.getWarriors().kill(getWizardsStrength());
        dispatchEvent(new KillWarriors(current, getWizardsStrength()));
        actionCount++;
    }

    protected final void killBuilders() {
        if (!isActionAvailable()) {
            return;
        }

        oponent.getBuilders().kill(getWizardsStrength());
        dispatchEvent(new KillBuilders(current, getWizardsStrength()));
        actionCount++;
    }

    protected final void destroyCastle() {
        if (!isActionAvailable()) {
            return;
        }
        oponent.getCastle().destroy(getWarriorsStrength());
        dispatchEvent(new DestroyCastle(current, getWarriorsStrength()));
        actionCount++;
    }

    protected final void buildCastle() {
        if (!isActionAvailable()) {
            return;
        }
        current.getCastle().expand(getBuildersProductivity());
        dispatchEvent(new BuildCastle(current, getBuildersProductivity()));
        actionCount++;
    }

    protected final void addBuilders() {
        if (!isAddAvailable()) {
            return;
        }
        current.getBuilders().add(1);
        dispatchEvent(new AddBuilders(current, 1));
        addActionCount++;
    }

    protected final void addWizzards() {
        if (!isAddAvailable()) {
            return;
        }
        current.getWizards().add(1);
        dispatchEvent(new AddWizards(current, 1));
        addActionCount++;
    }

    protected final void addWarriors() {
        if (!isAddAvailable()) {
            return;
        }
        current.getWarriors().add(2);
        dispatchEvent(new AddWarriors(current, 2));
        addActionCount++;
    }

    private boolean isActionAvailable() {
        return actionCount < 1;
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

    protected final long spyCastle() {
        if (!isSpyActionAvailable()) {
            return -1;
        }
        dispatchEvent(new SpyCastle(current));
        spyActionCount++;
        return oponent.getCastle().spy();
    }

    protected final long spyWarriors() {
        if (!isSpyActionAvailable()) {
            return -1;
        }
        dispatchEvent(new SpyWarriors(current));
        spyActionCount++;
        return oponent.getWarriors().spy();
    }

    protected final long spyWizzards() {
        if (!isSpyActionAvailable()) {
            return -1;
        }
        dispatchEvent(new SpyWizards(current));

        spyActionCount++;
        return oponent.getWizards().spy();
    }

    protected final long spyBuilders() {

        if (!isSpyActionAvailable()) {
            return -1;
        }
        dispatchEvent(new SpyBuilders(current));
        spyActionCount++;
        return oponent.getBuilders().spy();
    }

    private boolean isSpyActionAvailable() {
        return spyActionCount < 2;
    }

    protected final long castle() {
        return current.getCastle().getHeight();
    }

    protected final long warriors() {
        return current.getWarriors().getCount();
    }

    protected final long wizzards() {
        return current.getWizards().getCount();
    }

    protected final long builders() {
        return current.getBuilders().getCount();
    }

    private boolean isAddAvailable() {
        return addActionCount < 2;
    }
}
