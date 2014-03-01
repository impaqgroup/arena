package com.impaq.arena.client;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;

import com.impaq.arena.event.AddAction;
import com.impaq.arena.event.AddBuilders;
import com.impaq.arena.event.AddWarriors;
import com.impaq.arena.event.AddWizards;
import com.impaq.arena.event.BuildCastle;
import com.impaq.arena.event.DestroyCastle;
import com.impaq.arena.event.Event;
import com.impaq.arena.event.KillBuilders;
import com.impaq.arena.event.KillWarriors;
import com.impaq.arena.event.KillWizards;
import com.impaq.arena.event.OffensiveAction;
import com.impaq.arena.event.SpyAction;
import com.impaq.arena.event.SpyBuilders;
import com.impaq.arena.event.SpyCastle;
import com.impaq.arena.event.SpyWarriors;
import com.impaq.arena.event.SpyWizards;
/**
 * Rules:<br>
 * Offensive (1 per round):
 * <ul>
 * <li>warrior destroy 1 level.</li>
 * <li>wizard kills 2 people.</li>
 * <li>builder builds 3 castle level.</li>
 * </ul>
 * <br>
 * Populate (2 per round)
 * in single add action you can add:
 * <ul>
 * <li>1 builder.</li>
 * <li>1 wizard.</li>
 * <li>2 warriors.</li>
 * </ul>
 * <br>
 * Spy (2 per round)
 */
public abstract class BaseStrategyTest {

//    protected TestGameBoard gameBoard;
//
//    @Before
//    public void initialize() {
//        gameBoard = new TestGameBoard( getStrategy() );
//    }
//
//    abstract public Strategy getStrategy();
//
//    protected void assertExpectedActions(Class... eventsClasses){
//    	List<Event> eventList = gameBoard.getEventBus().getEventList();
//    	for ( int inc = 0; inc < eventsClasses.length; inc++ ){
//    		if ( eventsClasses[inc].isInterface() )
//    			Assert.assertTrue(eventsClasses[inc].isAssignableFrom(eventList.get(inc).getClass()));
//    		else
//    			Assert.assertEquals(eventsClasses[inc], eventList.get(inc).getClass());
//    	}
//    }
//
//    protected Class killWizards(){
//    	return KillWizards.class;
//    }
//
//    protected Class killWarriors(){
//    	return KillWarriors.class;
//    }
//
//    protected Class killBuilders(){
//    	return KillBuilders.class;
//    }
//
//    protected Class destroyCastle(){
//    	return DestroyCastle.class;
//    }
//
//    protected Class buildCastle(){
//    	return BuildCastle.class;
//    }
//
//    protected Class addBuilders(){
//    	return AddBuilders.class;
//    }
//    protected Class addWizards(){
//    	return AddWizards.class;
//    }
//
//    protected Class addWarriors(){
//    	return AddWarriors.class;
//    }
//
//    protected Class spyCastle(){
//    	return SpyCastle.class;
//    }
//
//    protected Class spyWarriors(){
//    	return SpyWarriors.class;
//    }
//
//    protected Class spyWizards(){
//    	return SpyWizards.class;
//    }
//
//    protected Class spyBuilders(){
//    	return SpyBuilders.class;
//    }
//
//    protected Class anySpyAction(){
//    	return SpyAction.class;
//    }
//
//    protected Class anyOffensiveAction(){
//    	return OffensiveAction.class;
//    }
//
//    protected Class anyAddAction(){
//    	return AddAction.class;
//    }
//
//    protected Class anyAction(){
//    	return Event.class;
//    }
}
