package Actions;

import Entity.EntityFactorial;
import GameMap.MapConsoleRenderer.MapConsoleRenderer;
import GameMap.MapSetting.Coordinates;
import GameMap.MapSetting.GameMap;

import java.util.Random;

public class CreationWorld implements GameActions {

    MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();
    GameMap gameMap;
    EntityFactorial entityFactorial = new EntityFactorial();

    @Override
    public void execute(GameMap gameMap) {
        this.gameMap = gameMap;
        setupEntity();
        mapConsoleRenderer.renderer(gameMap);
    }

    private Coordinates getCoordinatesMap() {
        return gameMap.getSizeMap();
    }

    private int getSquareMap() {
        return gameMap.getSizeMap().vertical * gameMap.getSizeMap().horizontal;
    }

    public void create (){

    }


    public void setupEntity() {



        for (int i = 0; i < getSquareMap(); i++) {

            int horizontal = new Random().nextInt(getCoordinatesMap().horizontal) + 1;
            int vertical = new Random().nextInt(getCoordinatesMap().vertical) + 1;
            Coordinates spawnCoordinates = new Coordinates(horizontal, vertical);

            if (gameMap.getAllPredators().size() <= getSquareMap() * 0.1){
                if (gameMap.getEntityCoordinate(spawnCoordinates) == null){
                    entityFactorial.setPredator(gameMap, horizontal, vertical, 2);
                }
            }

            if (gameMap.getAllHerbivore().size() <= getSquareMap() * 0.1){
                if (gameMap.getEntityCoordinate(spawnCoordinates) == null){
                    entityFactorial.setHerbivore(gameMap, horizontal, vertical, 2);
                }
            }

            if (gameMap.getAllGrass().size() <= getSquareMap() * 0.2){
                if (gameMap.getEntityCoordinate(spawnCoordinates) == null){
                    entityFactorial.setGrass(gameMap, horizontal, vertical);
                }
            }

            if (gameMap.getAllThree().size() <= getSquareMap() * 0.2){
                if (gameMap.getEntityCoordinate(spawnCoordinates) == null){
                    entityFactorial.setThree(gameMap, horizontal, vertical);
                }
            }

            if (gameMap.getAllRock().size() <= getSquareMap() * 0.4){
                if (gameMap.getEntityCoordinate(spawnCoordinates) == null){
                    entityFactorial.setRock(gameMap, horizontal, vertical);
                }
            }

        }



    }


//    initActions - действия, совершаемые перед стартом симуляции.
//    Пример - расставить объекты и существ на карте

}
