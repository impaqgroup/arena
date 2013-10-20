package com.impaq.arena.visualisation.impl;

import com.impaq.arena.engine.Property;
import com.impaq.arena.visualisation.IVisualisation;

public class VisualisationFactory {

    public static IVisualisation getVisualisation(){
	Property property = new Property();
	String visualisationType = property.getProperty( "visualisationType" );
	
	if (visualisationType.equalsIgnoreCase( "Console") )
	    return new ConsoleVisualisation();
	
	return new EmptyVisualisation();
    }
    
}
