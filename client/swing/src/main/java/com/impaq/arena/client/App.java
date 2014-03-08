package com.impaq.arena.client;

import java.io.IOException;

import org.springframework.core.env.StandardEnvironment;
import org.springframework.core.io.support.ResourcePropertySource;

import com.impaq.arena.EnvironmentBasedGameConfig;
import com.impaq.arena.EventDrivenGameBoard;
import com.impaq.arena.engine.GameConfig;
import com.impaq.arena.client.view.ConsoleView;
import com.impaq.arena.client.view.ViewProvider;

public class App {

    public static void main(String[] args) throws IOException {
        StandardEnvironment environment = new StandardEnvironment();
        environment.getPropertySources().addFirst(new ResourcePropertySource("classpath:arena.properties"));
        GameConfig config = new EnvironmentBasedGameConfig(environment);
        EventDrivenGameBoard gameBoard = new EventDrivenGameBoard(
                config, "blue", new TeamBlueStrategy(), "red", new TeamRedStrategy());
        gameBoard.registerView(new ViewProvider(environment).get(config));
        gameBoard.registerView(new ConsoleView());
        gameBoard.playGame();
    }
}
