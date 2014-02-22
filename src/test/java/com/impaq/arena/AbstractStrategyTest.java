package com.impaq.arena;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;

import com.impaq.arena.engine.event.Event;

public abstract class AbstractStrategyTest {

    protected TestGameBoard gameBoard;

    @Before
    public void initialize() {
        gameBoard = new TestGameBoard( getStrategy() );
    }
	
    abstract public Strategy getStrategy();
    
    protected void AssertionTest(Class... eventsClasses){
    	List<Event> eventList = gameBoard.getEventBus().getEventList();
    	for ( int inc = 0; inc < eventsClasses.length; inc++ ){
    		Assert.assertEquals(eventsClasses[inc], eventList.get(inc).getClass());
    	}
    	
    }
    
}
