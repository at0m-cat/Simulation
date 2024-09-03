import MapConsoleRenderer.MapConsoleRenderer;
import MapSetting.Map;

public class Main {
    public static void main(String[] args) {

        Map map = new Map();
        map.setupDefaultEntityPositions();

        MapConsoleRenderer renderer1 = new MapConsoleRenderer();
        renderer1.rendere(map);

        int a = 123;

    }
}
