package MapSetting;

import Entity.*;
//import EntityMotion.*;

import java.util.*;

public class GameMap {
    HashMap<Coordinates, Entity> entities = new HashMap<>();

    public static final int HORIZONTAL_MAX = 15;
    public static final int VERTICAL_MAX = 20;

    public void setEntities(Entity entity) {
        entities.put(entity.coordinates, entity);
//        entities.put(coordinates, entity);
//        entity.coordinates = coordinates;
    }

    public void setEntities(Coordinates coordinates, Entity entity) {
        entities.put(coordinates, entity);
    }

    public ArrayList<Creature> getAllCreatures() {
        ArrayList<Creature> creatures = new ArrayList<>();
        for (Entity entity : entities.values()) {
            if (entity instanceof Creature) {
                creatures.add((Creature) entity);
            }
        }
        return creatures;
    }

    public ArrayList<Herbivore> getAllHerbivore() {
        ArrayList<Herbivore> herbivores = new ArrayList<>();
        for (Entity entity : entities.values()) {
            if (entity instanceof Herbivore) {
                herbivores.add((Herbivore) entity);
            }
        }
        return herbivores;
    }

    public ArrayList<Grass> getAllGrass() {
        ArrayList<Grass> grasses = new ArrayList<>();
        for (Entity entity : entities.values()) {
            if (entity instanceof Grass) {
                grasses.add((Grass) entity);
            }
        }
        return grasses;
    }

    public void setupDefaultEntityPositions() {

//        setEntities(new Coordinates(1, 1),
//                new Predator(
//                        new Coordinates(1, 1),
//                        2,
//                        100,
//                        77
//                ));
//
//        setEntities(new Coordinates(10, 12), new Herbivore(
//                new Coordinates(10, 12),
//                1, 50)
//        );
//
//        setEntities(new Coordinates(9, 12), new Rock(new Coordinates(9, 12)));
//        setEntities(new Coordinates(9, 11), new Rock(new Coordinates(9, 11)));
//        setEntities(new Coordinates(10, 11), new Rock(new Coordinates(10, 11)));
//        setEntities(new Coordinates(9, 13), new Rock(new Coordinates(9, 13)));
//
//
//        setEntities(new Coordinates(3, 2), new Rock(new Coordinates(3, 2)));
//        setEntities(new Coordinates(4, 1), new Rock(new Coordinates(4, 1)));
//        setEntities(new Coordinates(1, 3), new Rock(new Coordinates(1, 3)));
//        setEntities(new Coordinates(10, 11), new Rock(new Coordinates(10, 11)));
//        setEntities(new Coordinates(10, 13), new Rock(new Coordinates(10, 13)));
//        setEntities(new Coordinates(11, 11), new Rock(new Coordinates(11, 11)));


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

        Entity entity = entities.get(coordinates);
        if (entity == null) {
            return true;
        }
        if (entity.isStatic) {
            return false;
        }

        return !entities.containsKey(coordinates);
    }

    public Entity getEntityCoordinate(Coordinates coordinates) {
        return entities.get(coordinates);
    }


    public boolean isValidCoordinate(Coordinates coordinates) {
        if (coordinates.horizontal < 0 || coordinates.horizontal >= HORIZONTAL_MAX ||
                coordinates.vertical < 0 || coordinates.vertical >= VERTICAL_MAX) {
            return false;
        }
        return !isObstacle(coordinates);
    }

    public boolean isObstacle(Coordinates coordinates) {

        Entity entity = getEntityCoordinate(coordinates);
        if (entity == null) {
            return false; // Если объект отсутствует, считаем, что препятствия нет
        }
        return !entity.isStatic;
    }

    public void removePiece(Coordinates coordinates) {
        entities.remove(coordinates);
    }

    public void moveCreature(Coordinates from, Coordinates to) {
        Entity entity = getEntityCoordinate(from);
        if (entity == null) {
            return;
        }

        removePiece(from);
        setEntities(to, entity);
    }
}
