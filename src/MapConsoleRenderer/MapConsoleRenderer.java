package MapConsoleRenderer;

import Entity.*;
import MapSetting.*;

public class MapConsoleRenderer {

    public void rendere(Map map) {
        for (int horizontal = 8; horizontal >= 1; horizontal--) {
            for (int vertical = 8; vertical >= 1; vertical--) {
                System.out.printf("Vertical: " + vertical + ", Horizontal: " + horizontal + "\n");
            }
        }
    }

    private String getSpriteForEmptyMap(Coordinates coordinates) {
        return " ";
    }
}
