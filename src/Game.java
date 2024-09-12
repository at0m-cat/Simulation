import GameMap.MapConsoleRenderer.MapConsoleRenderer;
import GameMap.MapSetting.GameMap;

public class Game {
    private final GameMap gameMap;
    private MapConsoleRenderer renderer = new MapConsoleRenderer();

    public Game(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public void gameLoop(){
        while (true){
            renderer.renderer(gameMap);



        }

    }
}
