package GameMap.PathToTarget;

import Entity.Entity;
import Entity.EnumType.FamilyType;
import GameMap.MapSetting.Coordinates;
import GameMap.MapSetting.GameMap;

import java.util.ArrayList;

public class PathToTarget {

    private ArrayList<Coordinates> pathToTarget;

    public PathToTarget(GameMap gameMap, Coordinates from) {
        pathToTarget = new ArrayList<>();
        execute(gameMap, from);
    }

    private void execute(GameMap gameMap, Coordinates from) {
        Entity targetsFor = gameMap.getEntity(from);
        if (gameMap.getTargets(gameMap, targetsFor).isEmpty()) {
            pathToTarget = new ArrayList<>();
        } else {
            Coordinates coordinatesTo = gameMap.getTargets(gameMap, targetsFor).get(0).getCoordinates();
            Entity creatureFrom = gameMap.getEntity(from);
            aStar star = new aStar(creatureFrom);
            pathToTarget = star.shortestPath(from, coordinatesTo, gameMap);
        }
    }

    public ArrayList<Coordinates> getPath() {
        return pathToTarget;
    }
}
