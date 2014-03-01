package com.impaq.arena.client.view;

import com.impaq.arena.PropertySource;
import com.impaq.arena.GameBoardView;

public class ViewProvider {

    public static final String VIEW_TYPE = "visualisationType";

    public GameBoardView get() {
        PropertySource property = new PropertySource();
        property.load();
        return ViewType.from(property.getString(VIEW_TYPE)).create();

    }

}
