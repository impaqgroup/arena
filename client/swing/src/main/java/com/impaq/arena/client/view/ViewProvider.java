package com.impaq.arena.client.view;

import org.springframework.core.env.Environment;

import com.impaq.arena.server.engine.GameBoardView;
import com.impaq.arena.engine.GameConfig;

public class ViewProvider {

    public static final String VIEW_TYPE = "view.type";

    private final Environment environment;

    public ViewProvider(Environment environment) {
        this.environment = environment;
    }

    public GameBoardView get(GameConfig config) {
        return ViewType.from(environment.getProperty(VIEW_TYPE)).create(config);
    }

}
