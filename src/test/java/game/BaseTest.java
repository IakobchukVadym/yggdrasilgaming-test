package game;

import game.client.GameClient;
import game.service.GameService;

public interface BaseTest {
    GameClient gameClient = new GameClient();
    GameService gameService = new GameService(gameClient);
}
