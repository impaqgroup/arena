package com.impaq.arena.visualisation.impl;

import com.impaq.arena.engine.Property;
import com.impaq.arena.visualisation.IVisualisation;
import com.impaq.arena.visualisation.impl.swing.SwingVisualisation;

public class VisualisationFactory {

    public static IVisualisation getVisualisation() {
        Property property = new Property();
        String visualisationType = property.getProperty("visualisationType");

        if (visualisationType.equalsIgnoreCase("Console"))
            return new ConsoleVisualisation();
        if (visualisationType.equalsIgnoreCase("Swing"))
            return new SwingVisualisation();
        return new EmptyVisualisation();
    }

}
