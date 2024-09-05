package MapSetting;

import Entity.*;
import EntityMotion.*;

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

        setEntities(new Coordinates(1, 1),
                new Predator(
                new Coordinates(1,1),
                2,
                100,
                77
        ));

        setEntities(new Coordinates(10, 12), new Herbivore(
                new Coordinates(10, 12),
                1, 50)
        );

        setEntities(new Coordinates(9, 12), new Rock(new Coordinates(9, 12)));
        setEntities(new Coordinates(9, 11), new Rock(new Coordinates(9, 11)));
        setEntities(new Coordinates(10, 11), new Rock(new Coordinates(10, 11)));
        setEntities(new Coordinates(9, 13), new Rock(new Coordinates(9, 13)));


        setEntities(new Coordinates(3, 2), new Rock(new Coordinates(3, 2)));
        setEntities(new Coordinates(4, 1), new Rock(new Coordinates(4, 1)));
        setEntities(new Coordinates(1, 3), new Rock(new Coordinates(1, 3)));
        setEntities(new Coordinates(10, 11), new Rock(new Coordinates(10, 11)));
        setEntities(new Coordinates(10, 13), new Rock(new Coordinates(10, 13)));
        setEntities(new Coordinates(11, 11), new Rock(new Coordinates(11, 11)));


//        for (int i = 0; i < 9; i++) {
//            setEntities(new Coordinates(1, i), new Grass(new Coordinates(1, i)));
//            setEntities(new Coordinates(8, i), new Three(new Coordinates(8, i)));
//            setEntities(new Coordinates(7, i), new Three(new Coordinates(7, i)));
//            setEntities(new Coordinates(3, i), new Rock(new Coordinates(3, i)));
//            setEntities(new Coordinates(5, i), new Herbivore(new Coordinates(5, i),
//                    3.3, 100));
//            setEntities(new Coordinates(6, i), new Predator(new Coordinates(6, i),
//                    3.3, 100, 44));
//        }
    }

    public boolean isSquareEmpty(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }

    public Entity getEntityCoordinate(Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public Coordinates getCoordinates(Entity entity) {
        return entity.coordinates;
    }

    public boolean isValidCoordinate(Coordinates coordinates) {
        boolean a = coordinates.horizontal < 0;
        boolean b = coordinates.vertical < 0;
        boolean c = coordinates.vertical > VERTICAL_MAX;
        boolean d = coordinates.horizontal > HORIZONTAL_MAX;

        if (a || b || c || d) {
            return false;
        }
        if (isObstacle(coordinates)) {
            return false;
        }
        return true;
    }

    public boolean isObstacle(Coordinates coordinates) {
        Entity entity = getEntityCoordinate(coordinates);

        switch (entity.type) {
            case Grass, Herbivore, Predator, Three, Rock:
                return false;
            case null:
                return true;
        }
    }
}
