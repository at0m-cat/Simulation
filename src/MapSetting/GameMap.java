package MapSetting;

import Entity.*;
//import EntityMotion.*;

import java.util.*;

public class GameMap {
    HashMap<Coordinates, Entity> entities = new HashMap<>();

    public static final int HORIZONTAL_MAX = 20;
    public static final int VERTICAL_MAX = 20;

    public void setEntities(Entity entity) {
        entities.put(entity.coordinates, entity);
    }

    public void setEntities(Coordinates coordinates, Entity entity) {
        entities.put(coordinates, entity);
        entity.coordinates = coordinates;
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

        setEntities(new Predator(
                new Coordinates(new Random().nextInt(1, HORIZONTAL_MAX+1),
                        new Random().nextInt(1, VERTICAL_MAX+1)), new Random().nextInt(3), 100,1));

        setEntities(new Herbivore(
                new Coordinates(new Random().nextInt(1,HORIZONTAL_MAX+1),
                        new Random().nextInt(1,VERTICAL_MAX+1)), new Random().nextInt(3), 100));

        setEntities(new Grass(
                new Coordinates(new Random().nextInt(1,HORIZONTAL_MAX+1),
                        new Random().nextInt(1,VERTICAL_MAX+1))));

        setEntities(new Rock(new Coordinates(
                new Random().nextInt(1,HORIZONTAL_MAX+1),
                new Random().nextInt(1,VERTICAL_MAX+1)
        )));

        setEntities(new Three(new Coordinates(
                new Random().nextInt(HORIZONTAL_MAX-1),
                new Random().nextInt(VERTICAL_MAX-1)
        )));


    }

    public boolean isValidCoordinates(Coordinates coordinates) {
        if (coordinates.horizontal <= 0 || coordinates.horizontal > HORIZONTAL_MAX ||
                coordinates.vertical <= 0 || coordinates.vertical > VERTICAL_MAX) {
            return false;
        }
        return true;
    }

    public boolean isSquareEmptyForMove(Coordinates coordinates, FamilyType type) {

        if (!isValidCoordinates(coordinates)) {
            return false;
        }
        Entity e = entities.get(coordinates);
        if (e == null) {
            return true;
        }


        switch (type){
            case Predator -> {
                if (e.target.equals(Target.TargetForPredator)){
                    return true;
                }
            }
            case Herbivore -> {
                if (e.target.equals(Target.TargetForHerbivore)){
                    return true;
                }
            }
        }

        return !entities.containsKey(coordinates);
    }


    public boolean isSquareEmptyForPrintMap(Coordinates coordinates) {

        if (!isValidCoordinates(coordinates)) {
            return false;
        }

        Entity entity = entities.get(coordinates);
        if (entity == null) {
            return true;
        }
        if (entity.staticEntity.equals(Static.YES)) {
            return false;
        }


        return !entities.containsKey(coordinates);
    }

    public Entity getEntityCoordinate(Coordinates coordinates) {
        return entities.get(coordinates);
    }


    public void removeEntity(Coordinates coordinates) {
        entities.remove(coordinates);
    }

    public void moveCreature(Coordinates from, Coordinates to) {
        Entity entity = getEntityCoordinate(from);
        if (entity == null) {
            return;
        }

        removeEntity(from);
        setEntities(to, entity);
    }
}
