package GameMap.MapSetting;

import Entity.*;
import Entity.EnumType.FamilyType;
import Entity.EnumType.TargetType;
import Entity.Objects.*;
//import Entity.EntityMotion.*;

import java.util.*;

public class GameMap {
    HashMap<Coordinates, Entity> entities = new HashMap<>();

    public static final int HORIZONTAL_MAX = 35;
    public static final int VERTICAL_MAX = 20;

    public Coordinates getSizeMap() {
        return new Coordinates(HORIZONTAL_MAX, VERTICAL_MAX);
    }


    public void setEntities(Entity entity) {
        entities.put(entity.getCoordintes(), entity);
    }

    public void setEntities(Coordinates coordinates, Entity entity) {
        entities.put(coordinates, entity);
        entity.setCoordinates(coordinates);
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

    public ArrayList<Three> getAllThree() {
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
        for (Entity entity : entities.values()) {
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

    public boolean isSquareEmptyForMove(Coordinates targetCoordinate, Entity activeCreature) {

        if (!isValidCoordinates(targetCoordinate)) {
            return false;
        }

        if (isNotEntity(targetCoordinate)) {
            return true;
        }

        Entity e = entities.get(targetCoordinate);

        if (((Creature) activeCreature).isValidTarget(e.target)) {
            return true;
        }

        return !entities.containsKey(targetCoordinate);
    }

    public boolean isNotEntity(Coordinates coordinates) {
        Entity e = entities.get(coordinates);
        return e == null;
    }

    public ArrayList<DeadSouls> getAllDeadSouls() {
        ArrayList<DeadSouls> deadSouls = new ArrayList<>();
        for (Entity entity : entities.values()) {
            if (entity instanceof DeadSouls) {
                deadSouls.add((DeadSouls) entity);
            }
        }
        return deadSouls;
    }

    public <T extends Entity> ArrayList<T> getTargets(GameMap map, Entity from) {
        ArrayList<T> targets = new ArrayList<>();

        // проверить

        if (from.type.equals(FamilyType.Predator)) {
            targets = (ArrayList<T>) map.getAllHerbivore();
        }
        if (from.type.equals(FamilyType.Herbivore)) {
            targets = (ArrayList<T>) map.getAllGrass();
        }
        targets.sort(Comparator.comparingDouble(t -> from.getCoordinates().distanceTo(t)));

        return targets;
    }


    public boolean isSquareEmptyForPrintMap(Coordinates coordinates) {
        return !entities.containsKey(coordinates);
    }

    public Entity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }


    public void removeEntity(Coordinates coordinates) {
        entities.remove(coordinates);
    }

    public void moveCreature(Coordinates from, Coordinates to) {
        Entity entity = getEntity(from);
        if (entity == null) {
            return;
        }

        removeEntity(from);
        setEntities(to, entity);
    }
}
