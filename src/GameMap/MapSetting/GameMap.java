package GameMap.MapSetting;

import Entity.*;
import Entity.EnumType.FamilyType;
import Entity.EnumType.TargetType;
import Entity.Objects.*;
//import GameMap.EntityMotion.*;

import java.util.*;

public class GameMap {
    HashMap<Coordinates, Entity> entities = new HashMap<>();

    public static final int HORIZONTAL_MAX = 35;
    public static final int VERTICAL_MAX = 20;

    public Coordinates getSizeMap(){
        return new Coordinates(HORIZONTAL_MAX, VERTICAL_MAX);
    }


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

    public ArrayList<Predator> getAllPredators() {
        ArrayList<Predator> predators = new ArrayList<>();
        for (Entity entity : entities.values()) {
            if (entity instanceof Predator) {
                predators.add((Predator) entity);
            }
        }
        return predators;
    }

    public ArrayList<Three> getAllThree(){
        ArrayList<Three> threes = new ArrayList<>();
        for (Entity entity : entities.values()) {
            if (entity instanceof Three) {
                threes.add((Three) entity);

            }
        }
        return threes;
    }

    public ArrayList<Entity> getAllEntities() {
        ArrayList<Entity> ent = new ArrayList<>();
        for (Entity entity : entities.values()){
            ent.add(entity);
        }
        return ent;
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

    public ArrayList<Rock> getAllRock() {
        ArrayList<Rock> rocks = new ArrayList<>();
        for (Entity entity : entities.values()) {
            if (entity instanceof Rock) {
                rocks.add((Rock) entity);
            }
        }
        return rocks;
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

        if (isNotEntity(coordinates)) {
            return true;
        }

        Entity e = entities.get(coordinates);

        switch (type){
            case Predator -> {
                if (e.target.equals(TargetType.TargetForPredator)){
                    return true;
                }
            }
            case Herbivore -> {
                if (e.target.equals(TargetType.TargetForHerbivore)){
                    return true;
                }
            }
        }

        return !entities.containsKey(coordinates);
    }

    public boolean isNotEntity(Coordinates coordinates) {
        Entity e = entities.get(coordinates);
        if (e == null) {
            return true;
        }
        return false;
    }


    public boolean isSquareEmptyForPrintMap(Coordinates coordinates) {
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
