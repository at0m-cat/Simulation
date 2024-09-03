package MapConsoleRenderer;

import Entity.*;
import MapSetting.*;

public class MapConsoleRenderer {

    //    public static final String ANSI_LAVENDER = "\u001b[33;47m";
    public static final String ANSI_LAVENDER = "\u001b[37;46m";
    public static final String ANSI_RESET_COLOR = "\u001B[0m";

    public void renderer(Map map) {
        for (int horizontal = 8; horizontal >= 1; horizontal--) {
            String line = "";
            for (int vertical = 8; vertical >= 1; vertical--) {
                Coordinates coordinates = new Coordinates(horizontal, vertical);

                if (map.isSquareEmpty(coordinates)) {
                    line += getSpriteForEmptyMap(coordinates, map);
                } else {
                    Entity entity = map.getEntityCoordinate(coordinates);
                    line += getEntitySprite(entity, map);
                }
            }
            line += ANSI_RESET_COLOR;
            System.out.println(line);
        }
    }

    private String colorizeSprite(String sprite, Entity entity) {
        String result = sprite;
        if (entity == null){
            return  result = "-" + result;
        }
        switch (entity.type) {
            case Rock -> result = "R" + result;
            case Three -> result = "T" + result;
            case Grass -> result = "G" + result;
            case Herbivore -> result = "H" + result;
            case Predator -> result = "P" + result;
        }
        return result;
    }

    private String getSpriteForEmptyMap(Coordinates coordinates, Map map) {
        return colorizeSprite("   ", null);
    }

    private String getEntitySprite(Entity entity, Map map) {
        return colorizeSprite("   ", entity);
    }
}
