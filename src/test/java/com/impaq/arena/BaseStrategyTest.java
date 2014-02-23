package com.impaq.arena;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;

import com.impaq.arena.engine.event.AddBuilders;
import com.impaq.arena.engine.event.AddWarriors;
import com.impaq.arena.engine.event.AddWizards;
import com.impaq.arena.engine.event.BuildCastle;
import com.impaq.arena.engine.event.DestroyCastle;
import com.impaq.arena.engine.event.Event;
import com.impaq.arena.engine.event.KillBuilders;
import com.impaq.arena.engine.event.KillWarriors;
import com.impaq.arena.engine.event.KillWizards;
import com.impaq.arena.engine.event.SpyBuilders;
import com.impaq.arena.engine.event.SpyCastle;
import com.impaq.arena.engine.event.SpyWarriors;
import com.impaq.arena.engine.event.SpyWizards;

public abstract class BaseStrategyTest {

    protected TestGameBoard gameBoard;

    @Before
    public void initialize() {
        gameBoard = new TestGameBoard( getStrategy() );
    }
	
    abstract public Strategy getStrategy();
    
    protected void assertExpectedActions(Class... eventsClasses){
    	List<Event> eventList = gameBoard.getEventBus().getEventList();
    	for ( int inc = 0; inc < eventsClasses.length; inc++ ){
    		Assert.assertEquals(eventsClasses[inc], eventList.get(inc).getClass());
    	}
    }
    
    protected Class KillWizards(){
    	return KillWizards.class;
    }
    
    protected Class KillWarriors(){
    	return KillWarriors.class;
    }
    
    protected Class KillBuilders(){
    	return KillBuilders.class;
    }
    
    protected Class DestroyCastle(){
    	return DestroyCastle.class;
    }
    
    protected Class BuildCastle(){
    	return BuildCastle.class;
    }
    
    protected Class AddBuilders(){
    	return AddBuilders.class;
    }
    protected Class AddWizards(){
    	return AddWizards.class;
    }
    
    protected Class AddWarriors(){
    	return AddWarriors.class;
    }
    
    protected Class SpyCastle(){
    	return SpyCastle.class;
    }
    
    protected Class SpyWarriors(){
    	return SpyWarriors.class;
    }
    
    protected Class SpyWizards(){
    	return SpyWizards.class;
    }
    
    protected Class SpyBuilders(){
    	return SpyBuilders.class;
    }
    
}
