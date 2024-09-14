package Entity.Factory;

import Entity.Objects.*;
import GameMap.MapSetting.Coordinates;
import GameMap.MapSetting.GameMap;

public class EntityFactory {

    public void setPredator(GameMap gameMap, int horizontal, int vertical, int speed) {
        gameMap.setEntities(new Predator(new Coordinates(horizontal, vertical)) {
        });
    }

    public void setHerbivore(GameMap gameMap, int horizontal, int vertical, int speed) {
        gameMap.setEntities(new Herbivore(new Coordinates(horizontal, vertical)) {
        });
    }

    public void setGrass(GameMap gameMap, int horizontal, int vertical) {
        gameMap.setEntities(new Grass(new Coordinates(horizontal, vertical)) {
        });
    }

    public void setRock(GameMap gameMap, int horizontal, int vertical) {
        gameMap.setEntities(new Rock(new Coordinates(horizontal, vertical)) {
        });
    }

    public void setThree(GameMap gameMap, int horizontal, int vertical) {
        gameMap.setEntities(new Three(new Coordinates(horizontal, vertical)) {
        });
    }

}
