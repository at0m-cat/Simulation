package MapConsoleRenderer;

import Entity.*;
import MapSetting.*;
import static MapConsoleRenderer.AnsiSprite.*;

public class MapConsoleRenderer {

    public void renderer(Map map) {
        for (int horizontal = 15; horizontal >= 1; horizontal--) {
            String line = "";
            for (int vertical = 20; vertical >= 1; vertical--) {
                Coordinates coordinates = new Coordinates(horizontal, vertical);

                if (map.isSquareEmpty(coordinates)) {
                    line = "%s%s".formatted(line, getSprite(null));
                } else {
                    Entity entity = map.getEntityCoordinate(coordinates);
                    line = "%s%s".formatted(line, getSprite(entity));
                }
            }
            line += ANSI_RESET_COLOR;
            System.out.println(line);
        }
    }

    private String colorizeSprite(String sprite, Entity entity) {
        String result = sprite;
        if (entity == null) {
            return result = ANSI_BACKGROUND_NULL + result + ANSI_SMILE_NULL + result;
        }
        switch (entity.type) {
            case Rock -> result = ANSI_BACKGROUND_ROCK + result + ANSI_SMILE_ROCK + result;
            case Three -> result = ANSI_BACKGROUND_THREE + result + ANSI_SMILE_THREE + result;
            case Grass -> result = ANSI_BACKGROUND_GRASS + result + ANSI_SMILE_GRASS + result;
            case Herbivore -> result = ANSI_BACKGROUND_HERBIVORE + result + ANSI_SMILE_HERBIVORE + result;
            case Predator -> result = ANSI_BACKGROUND_PREDATOR + result + ANSI_SMILE_PREDATOR + result;
        }
        return result;
    }


    private String getSprite(Entity entity) {
        return colorizeSprite(" ", entity);
    }
}
