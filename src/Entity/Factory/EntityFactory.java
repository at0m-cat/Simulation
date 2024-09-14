package Entity.Factory;

import Entity.Objects.*;
import GameMap.MapSetting.Coordinates;
import GameMap.MapSetting.GameMap;
import org.w3c.dom.Entity;

public class EntityFactory {

    public void setPredator(GameMap gameMap, int horizontal, int vertical, int speed) {
        gameMap.setEntities(new Predator(new Coordinates(horizontal, vertical), speed, 100, 20) {
        });
    }

    public void setHerbivore(GameMap gameMap, int horizontal, int vertical, int speed) {
        gameMap.setEntities(new Herbivore(new Coordinates(horizontal, vertical), speed, 100) {
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
