package com.impaq.arena.view;

import com.impaq.arena.PropertySource;
import com.impaq.arena.GameBoardView;
import static com.impaq.arena.view.ViewType.from;

public class ViewProvider {

    public static final String VIEW_TYPE = "visualisationType";

    public GameBoardView get() {
        PropertySource property = new PropertySource();
        property.load();

        return from(property.getString(VIEW_TYPE)).create();

    }

}
