package MapConsoleRenderer;

import Entity.*;
import MapSetting.*;

public class MapConsoleRenderer {

        public static final String ANSI_GREY = "\u001b[33;47m";
    public static final String ANSI_LAVENDER = "\u001b[0;100m";
    public static final String ANSI_RESET_COLOR = "\u001B[0m";

    public void renderer(Map map) {
        for (int horizontal = 8; horizontal >= 1; horizontal--) {
            String line = "";
            for (int vertical = 8; vertical >= 1; vertical--) {
                Coordinates coordinates = new Coordinates(horizontal, vertical);

                if (map.isSquareEmpty(coordinates)) {
                    line = "%s%s".formatted(line, getSpriteForEmptyMap(coordinates, map));
                } else {
                    Entity entity = map.getEntityCoordinate(coordinates);
                    line = "%s%s".formatted(line, getEntitySprite(entity));
                }
            }
            line += ANSI_RESET_COLOR;
            System.out.println(line);
        }
    }

    private String colorizeSprite(String sprite, Entity entity) {
        String result = sprite;
        if (entity == null) {
            return result = ANSI_GREY + result + "\uD83C\uDF42" + result;
        }
        switch (entity.type) {
            case Rock -> result = ANSI_LAVENDER + result + "\uD83D\uDDFF" + result;
            case Three -> result = ANSI_LAVENDER + result + "\uD83C\uDF33" + result;
            case Grass -> result = ANSI_LAVENDER + result + "\uD83C\uDF3F" + result;
            case Herbivore -> result = ANSI_LAVENDER + result + "\uD83D\uDC39" + result;
            case Predator -> result = ANSI_LAVENDER + result + "\uD83E\uDD81" + result;
        }
        return result;
    }

//    private String figureSprite(Entity entity){
//        String result = "";
//        switch (entity.type){
//            case Rock ->  result = "\uD83D\uDDFF";
//            case Three -> result = "\uD83C\uDF33";
//            case Grass -> result = "\uD83C\uDF3F";
//            case Herbivore -> result = "\uD83D\uDC39";
//            case Predator ->  result = "\uD83E\uDD81";
//
//        }
//        return result;
//    }

    private String getSpriteForEmptyMap(Coordinates coordinates, Map map) {
        return colorizeSprite(" ", null);
    }

    private String getEntitySprite(Entity entity) {
        return colorizeSprite(" ", entity);
    }
}
