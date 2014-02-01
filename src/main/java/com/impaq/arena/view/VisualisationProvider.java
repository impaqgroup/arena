package com.impaq.arena.view;

import com.impaq.arena.PropertySource;
import com.impaq.arena.GameBoardView;
import static com.impaq.arena.view.VisualisationType.from;

public class VisualisationProvider {

    public static final String VISUALISATION_TYPE = "visualisationType";

    public GameBoardView get() {
        PropertySource property = new PropertySource();
        property.load();

        return from(property.getString(VISUALISATION_TYPE)).create();

    }

}
