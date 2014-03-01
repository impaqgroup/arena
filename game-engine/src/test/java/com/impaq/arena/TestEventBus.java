package com.impaq.arena;

import com.google.common.eventbus.EventBus;
import com.impaq.arena.event.Event;
import java.util.ArrayList;
import java.util.List;

public class TestEventBus extends EventBus{

	private List<Event> eventList = new ArrayList<Event>();
	
	@Override
	public void post(Object event) {
		super.post(event);
		if (event instanceof Event)
			eventList.add((Event)event);
	}

	public List<Event> getEventList() {
		return eventList;
	}
	
}
