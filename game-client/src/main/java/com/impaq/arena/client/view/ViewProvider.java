package com.impaq.arena.client.view;

import com.impaq.arena.GameBoardView;
import com.impaq.arena.PropertySource;

public class ViewProvider {

    public static final String VIEW_TYPE = "view.type";

    public GameBoardView get() {
        PropertySource property = new PropertySource();
        property.load();
        return ViewType.from(property.getString(VIEW_TYPE)).create();

    }

}
