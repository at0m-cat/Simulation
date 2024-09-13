package Actions;

import Entity.EntityFactory;
import GameMap.MapConsoleRenderer.MapConsoleRenderer;
import GameMap.MapSetting.Coordinates;
import GameMap.MapSetting.GameMap;

import java.util.Random;

public class CreationWorld implements GameActions {

    MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();
    GameMap gameMap;
    EntityFactory entityFactorial = new EntityFactory();

    @Override
    public void execute(GameMap gameMap) {
        this.gameMap = gameMap;
        setupEntity();
        mapConsoleRenderer.renderer(gameMap);
    }

    private void setupEntity() {

        while (!(gameMap.getAllEntities().size() == getSquareMap() * 0.8)) {

            int horizontal = new Random().nextInt(getCoordinatesMap().horizontal) + 1;
            int vertical = new Random().nextInt(getCoordinatesMap().vertical) + 1;
            Coordinates spawnCoordinates = new Coordinates(horizontal, vertical);

            if (gameMap.getAllPredators().size() <= getConstValues()[0]) {
                if (gameMap.getEntityCoordinate(spawnCoordinates) == null) {
                    entityFactorial.setPredator(gameMap, horizontal, vertical, 1);
                }
            }

            if (gameMap.getAllHerbivore().size() <= getConstValues()[1]) {
                if (gameMap.getEntityCoordinate(spawnCoordinates) == null) {
                    entityFactorial.setHerbivore(gameMap, horizontal, vertical, 1);
                }
            }

            if (gameMap.getAllGrass().size() <= getConstValues()[2]) {
                if (gameMap.getEntityCoordinate(spawnCoordinates) == null) {
                    entityFactorial.setGrass(gameMap, horizontal, vertical);
                }
            }

            if (gameMap.getAllThree().size() <= getConstValues()[3]) {
                if (gameMap.getEntityCoordinate(spawnCoordinates) == null) {
                    entityFactorial.setThree(gameMap, horizontal, vertical);
                }
            }

            if (gameMap.getAllRock().size() <= getConstValues()[4]) {
                if (gameMap.getEntityCoordinate(spawnCoordinates) == null) {
                    entityFactorial.setRock(gameMap, horizontal, vertical);
                }
            }


        }

    }

    private Coordinates getCoordinatesMap() {
        return gameMap.getSizeMap();
    }

    private int getSquareMap() {
        return gameMap.getSizeMap().vertical * gameMap.getSizeMap().horizontal;
    }

    private double[] getConstValues() {
        double PREDATORS = getSquareMap() * 0.15;
        double HERBIVORES = getSquareMap() * 0.25;
        double GRASS = getSquareMap() * 0.2;
        double THREES = getSquareMap() * 0.1;
        double ROCKS = getSquareMap() * 0.1;

        return new double[]{
                PREDATORS,
                HERBIVORES,
                GRASS,
                THREES,
                ROCKS
        };
    }
}
