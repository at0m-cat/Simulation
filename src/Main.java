import MapConsoleRenderer.MapConsoleRenderer;
import MapSetting.GameMap;

public class Main {
    public static void main(String[] args) {

        GameMap gameMap = new GameMap();
        gameMap.setupDefaultEntityPositions();

        MapConsoleRenderer renderer1 = new MapConsoleRenderer();
        renderer1.renderer(gameMap);

        int a = 123;

    }
}
