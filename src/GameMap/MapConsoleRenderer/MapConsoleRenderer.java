package GameMap.MapConsoleRenderer;

import Entity.*;
import Entity.Objects.Herbivore;
import Entity.Objects.Predator;
import GameMap.MapSetting.Coordinates;
import GameMap.MapSetting.GameMap;

import static GameMap.MapConsoleRenderer.AnsiSprite.*;

public class MapConsoleRenderer {

    public void renderer(GameMap gameMap) {
        for (int vertical = gameMap.VERTICAL_MAX; vertical >= 1; vertical--) {
            String line = "";
            for (int horizontal = gameMap.HORIZONTAL_MAX; horizontal >= 1; horizontal--) {
                Coordinates coordinates = new Coordinates(horizontal, vertical);

                if (gameMap.isSquareEmptyForPrintMap(coordinates)) {
                    line = "%s%s".formatted(line, getSprite(null));
                } else {
                    Entity entity = gameMap.getEntity(coordinates);
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
        switch (entity.TYPE) {
            case Rock -> result = ANSI_BACKGROUND_ROCK + result + ANSI_SMILE_ROCK + result;
            case Three -> result = ANSI_BACKGROUND_THREE + result + ANSI_SMILE_THREE + result;
            case Grass -> result = ANSI_BACKGROUND_GRASS + result + ANSI_SMILE_GRASS + result;
            case Herbivore -> {

                   double hp = ((Herbivore) entity).getHp();
                   if (hp < 25){
                       result = ANSI_BACKGROUND_LOW_HP + result + ANSI_SMILE_HERBIVORE + result;
                   } else {
                       result = ANSI_BACKGROUND_HERBIVORE + result + ANSI_SMILE_HERBIVORE + result;
                   }
            }
            case Predator -> {
                if (entity instanceof Predator) {

                    int satiety = ((Predator) entity).getSatiety();
                    if (satiety < 70) {
                        result = ANSI_BACKGROUND_PREDATOR + result + ANSI_SMILE_PREDATOR + result;
                    } else {
                        result = ANSI_BACKGROUND_SATIETY_FULL + result + ANSI_SMILE_PREDATOR + result;
                    }
                }

            }
            case DeadSouls -> result = ANSI_BACKGROUND_DEADSOULS + result +  ANSI_SMILE_DEADSOULS + result;
        }

        return result;
    }


    private String getSprite(Entity entity) {
        return colorizeSprite(" ", entity);
    }
}
