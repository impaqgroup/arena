package com.impaq.arena.engine;

import com.impaq.arena.visualisation.impl.Visualisation;

public class Actions {

    private static int COUNT = 5;
    
    public static void ZabijMagow() {
	// TODO może exception
	if (!IsActionAvailable())
	    return;

	Visualisation.getInstance().KillWizards(getWizardsStrength(),
		Engine.isFirstPlayerAction());

	Engine.getUnactivePlayer().getWizards().kill(getWizardsStrength());
	Engine.incrementAction();
    }

    public static void ZabijWojownikow() {
	// TODO może exception
	if (!IsActionAvailable())
	    return;

	Visualisation.getInstance().KillWarriors(getWizardsStrength(),
		Engine.isFirstPlayerAction());

	Engine.getUnactivePlayer().getWarriors().kill(getWizardsStrength());
	Engine.incrementAction();
    }

    public static void ZabijBudowniczych() {
	// TODO może exception
	if (!IsActionAvailable())
	    return;

	Visualisation.getInstance().KillBuilders(getWizardsStrength(),
		Engine.isFirstPlayerAction());

	Engine.getUnactivePlayer().getBuilders().kill(getWizardsStrength());
	Engine.incrementAction();
    }

    public static void ZniszczZamekWroga() {
	// TODO może exception
	if (!IsActionAvailable())
	    return;
	
	Visualisation.getInstance().DestroyCastle(getWarriorsStrength(),
		Engine.isFirstPlayerAction());


	Engine.getUnactivePlayer().getCastle().destroy(getWarriorsStrength());
	Engine.incrementAction();
    }

    public static void BudujZamek() {
	// TODO może exception
	if (!IsActionAvailable())
	    return;
	
	Visualisation.getInstance().BuildCastle(getBuildersProductivity(),
		Engine.isFirstPlayerAction());

	Engine.getActivePlayer().getCastle().expand(getBuildersProductivity());
	Engine.incrementAction();
    }

    public static void DodajBudowniczych() {
	// TODO może exception
	if (!IsActionAvailable())
	    return;
	
	Visualisation.getInstance().AddBuilders( COUNT,
		Engine.isFirstPlayerAction());
	
	Engine.getActivePlayer().getBuilders().add(COUNT);
	Engine.incrementAction();
    }

    public static void DodajMagow() {
	// TODO może exception
	if (!IsActionAvailable())
	    return;
	
	Visualisation.getInstance().AddWizards( COUNT,
		Engine.isFirstPlayerAction());
	
	Engine.getActivePlayer().getWizards().add(COUNT);
	Engine.incrementAction();
    }

    public static void DodajWojownikow() {
	// TODO może exception
	if (!IsActionAvailable())
	    return;
	
	Visualisation.getInstance().AddWarriors( COUNT,
		Engine.isFirstPlayerAction());
	
	Engine.getActivePlayer().getWarriors().add(COUNT);
	Engine.incrementAction();
    }

    private static boolean IsActionAvailable() {
	return Engine.getActionCount() < 3;
    }

    private static int getWizardsStrength() {
	return Engine.getActivePlayer().getWizards().getStrength();
    }

    private static int getWarriorsStrength() {
	return Engine.getActivePlayer().getWarriors().getStrength();
    }

    private static int getBuildersProductivity() {
	return Engine.getActivePlayer().getBuilders().getProductivity();
    }

    public static int WysokoscZamkuWroga() {
	// TODO może exception
	if (!IsSpyActionAvailable())
	    return -1;
	
	Visualisation.getInstance().CheckCastleHeight( Engine.isFirstPlayerAction());
	
	Engine.incrementSpyAction();
	return Engine.getUnactivePlayer().getCastle().getHeight();
    }
    
    public static int IloscWojownikowWroga() {
	// TODO może exception
	if (!IsSpyActionAvailable())
	    return -1;
	
	Visualisation.getInstance().CheckWarriorCount(Engine.isFirstPlayerAction());
	
	Engine.incrementSpyAction();
	return Engine.getUnactivePlayer().getWarriors().getCount();
    }

    public static int IloscMagowWroga() {
	// TODO może exception
	if (!IsSpyActionAvailable())
	    return -1;
	
	Visualisation.getInstance().CheckWizardCount(Engine.isFirstPlayerAction());
	
	Engine.incrementSpyAction();
	return Engine.getUnactivePlayer().getWizards().getCount();
    }

    public static int IloscBudowniczychWroga() {
	// TODO może exception
	
	if (!IsSpyActionAvailable())
	    return -1;
	
	Visualisation.getInstance().CheckBuildersCount(Engine.isFirstPlayerAction());
	
	Engine.incrementSpyAction();
	return Engine.getUnactivePlayer().getBuilders().getCount();
    }

    private static boolean IsSpyActionAvailable() {
	return Engine.getSpyActionCount() < 2;
    }

    public static int WysokoscPosiadanegoZamku() {
	return Engine.getActivePlayer().getCastle().getHeight();
    }

    public static int IloscPosiadanychWojowniko() {
	return Engine.getActivePlayer().getWarriors().getCount();
    }

    public static int IloscPosiadanychMagow() {
	return Engine.getActivePlayer().getWizards().getCount();
    }

    public static int IloscPosiadanychBudowniczyc() {
	return Engine.getActivePlayer().getBuilders().getCount();
    }
}
