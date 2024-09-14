package Actions;

import Entity.Factory.EntityFactory;
import Entity.Quantity.EntityQuantity;
import GameMap.MapConsoleRenderer.MapConsoleRenderer;
import GameMap.MapSetting.Coordinates;
import GameMap.MapSetting.GameMap;

import java.util.Random;

public class CreationWorld implements GameActions {

    EntityQuantity quantity;
    MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();
    GameMap gameMap;
    EntityFactory entityFactory = new EntityFactory();

    @Override
    public void execute(GameMap gameMap) {
        this.gameMap = gameMap;
        quantity = new EntityQuantity(gameMap);
        setupAllEntity();
        mapConsoleRenderer.renderer(gameMap);
    }

    private void setupAllEntity() {

        while (!(gameMap.getAllEntities().size() == getSquareMap() * 0.8)) {

            int horizontal = new Random().nextInt(getCoordinatesMap().horizontal) + 1;
            int vertical = new Random().nextInt(getCoordinatesMap().vertical) + 1;
            Coordinates spawnCoordinates = new Coordinates(horizontal, vertical);

            if (gameMap.getAllPredators().size() <= quantity.getConstValues()[0]) {
                if (gameMap.getEntity(spawnCoordinates) == null) {
                    entityFactory.setPredator(gameMap, horizontal, vertical, 1);
                }
            }
            if (gameMap.getAllHerbivore().size() <= quantity.getConstValues()[1]) {
                if (gameMap.getEntity(spawnCoordinates) == null) {
                    entityFactory.setHerbivore(gameMap, horizontal, vertical, 1);
                }
            }
            if (gameMap.getAllGrass().size() <= quantity.getConstValues()[2]) {
                if (gameMap.getEntity(spawnCoordinates) == null) {
                    entityFactory.setGrass(gameMap, horizontal, vertical);
                }
            }
            if (gameMap.getAllThree().size() <= quantity.getConstValues()[3]) {
                if (gameMap.getEntity(spawnCoordinates) == null) {
                    entityFactory.setThree(gameMap, horizontal, vertical);
                }
            }
            if (gameMap.getAllRock().size() <= quantity.getConstValues()[4]) {
                if (gameMap.getEntity(spawnCoordinates) == null) {
                    entityFactory.setRock(gameMap, horizontal, vertical);
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
}
