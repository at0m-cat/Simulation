package MapSetting;

import Entity.*;

import java.util.HashMap;

public class Map {
    // Карта - содержит в себе коллекцию для хранения существ и их расположение

    HashMap<Coordinates, Entity> entities = new HashMap<>();

    public void setEntities(Coordinates coordinates, Entity entity) {
        entities.put(coordinates, entity);
        entity.coordinates = coordinates;
    }

    public void setupDefaultEntityPositions() {
        for (int i = 0; i < 9; i++) {
            setEntities(new Coordinates(1, i), new Grass(new Coordinates(1, i)));
            setEntities(new Coordinates(2, i), new Three(new Coordinates(2, i)));
            setEntities(new Coordinates(3, i), new Rock(new Coordinates(3, i)));
            setEntities(new Coordinates(5, i), new Herbivore(new Coordinates(5, i), 3.3, 100));
        }
    }

    public static boolean isSquareGreen(Coordinates coordinates) {
        return (coordinates.horizontal + coordinates.vertical) % 2 == 0;
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }

    public Types getEntityTypeCoordinate(Coordinates coordinates) {
        Entity entity = entities.get(coordinates);
        if (entity == null) {
            return null;
        }
        return entity.type;
    }

    public Coordinates getCoordinates(Entity entity) {
        return entities.containsKey(entity.coordinates) ? entity.coordinates : null;
    }

    public Entity getEntityCoordinate(Coordinates coordinates) {
        return entities.get(coordinates);
    }
}
