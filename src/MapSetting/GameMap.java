package MapSetting;

import Entity.*;

import java.util.HashMap;
import java.util.Random;

public class GameMap {
    // Карта - содержит в себе коллекцию для хранения существ и их расположение

    HashMap<Coordinates, Entity> entities = new HashMap<>();

    public final int HORIZONTAL_MAX = 15;
    public final int VERTICAL_MAX = 20;

    public void setEntities(Coordinates coordinates, Entity entity) {
        entities.put(coordinates, entity);
        entity.coordinates = coordinates;
    }

    public int getRandomPosition() {
        Random rand = new Random();
        return rand.nextInt(HORIZONTAL_MAX) + VERTICAL_MAX;
    }

    public void setupDefaultEntityPositions() {

        for (int i = 0; i < 9; i++) {
            setEntities(new Coordinates(1, i), new Grass(new Coordinates(1, i)));
            setEntities(new Coordinates(8, i), new Three(new Coordinates(8, i)));
            setEntities(new Coordinates(7, i), new Three(new Coordinates(7, i)));
            setEntities(new Coordinates(3, i), new Rock(new Coordinates(3, i)));
            setEntities(new Coordinates(5, i), new Herbivore(new Coordinates(5, i),
                                                            3.3, 100));
            setEntities(new Coordinates(6, i), new Predator(new Coordinates(6, i),
                                                            3.3, 100, 44));
        }
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }

    public Entity getEntityCoordinate(Coordinates coordinates) {
        return entities.get(coordinates);
    }
}
