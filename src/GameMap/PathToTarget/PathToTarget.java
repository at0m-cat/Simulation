package GameMap.PathToTarget;

import Entity.Entity;
import Entity.EnumType.FamilyType;
import GameMap.MapSetting.Coordinates;
import GameMap.MapSetting.GameMap;

import java.util.ArrayList;

public class PathToTarget {

    aStar star;
    GameMap gameMap;
    FamilyType familyType;
    Coordinates coordinates;
    ArrayList<Coordinates> pathToTarget;

    Entity entity;


    public PathToTarget(GameMap gameMap, Coordinates from) {
        this.coordinates = from;
        this.entity = gameMap.getEntityCoordinate(coordinates);
        this.pathToTarget = new ArrayList<>();
        this.familyType = gameMap.getEntityCoordinate(from).type;
        this.gameMap = gameMap;
        star = new aStar(familyType);
    }

    public ArrayList<Coordinates> getPath() {

        // пересмотреть структуру
        // перенести в PathToTarget

        if (gameMap.getEntityCoordinate(coordinates) == null) {
            return new ArrayList<>();
        }


        pathToTarget = star.shortestPath(coordinates, gameMap.getTargets(gameMap, entity).getFirst().coordinates, gameMap);

//        FamilyType type = map.getEntityCoordinate(coordinates).type;
//        aStar star = new aStar(type);
//        ArrayList<Coordinates> path = new ArrayList<>();
//
//        if (this instanceof Predator) {
//            ArrayList<Herbivore> targets = getTargets(map);
//            path = star.shortestPath(coordinates, targets.getFirst().coordinates, map);
//        } else if (this instanceof Herbivore) {
//            ArrayList<Grass> targets = getTargets(map);
//            path = star.shortestPath(coordinates, targets.getFirst().coordinates, map);
//        }

        return pathToTarget;
    }
}
