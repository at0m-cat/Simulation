import Entity.*;
import MapConsoleRenderer.MapConsoleRenderer;
import MapSetting.Coordinates;
import MapSetting.GameMap;

import java.util.ArrayList;
import java.util.List;

import static Entity.Types.Herbivore;

public class Main {
    public static void main(String[] args) {

        GameMap gameMap = new GameMap();
//        gameMap.setupDefaultEntityPositions();

        Herbivore herbivore = new Herbivore(new Coordinates(1, 1), 1, 2);
        Predator predator = new Predator(new Coordinates(10, 10), 1, 2, 3);
        Grass grass = new Grass(new Coordinates(5, 5));
        Rock rock = new Rock(new Coordinates(9, 9));
        Rock rock2 = new Rock(new Coordinates(8, 9));
        Rock rock1 = new Rock(new Coordinates(7, 9));

        gameMap.setEntities(new Coordinates(1, 1), herbivore);
        gameMap.setEntities(new Coordinates(10, 10), predator);
        gameMap.setEntities(new Coordinates(5, 5), grass);
        gameMap.setEntities(new Coordinates(9, 9), rock);
        gameMap.setEntities(new Coordinates(8, 9), rock2);
        gameMap.setEntities(new Coordinates(7, 9), rock1);

        MapConsoleRenderer renderer1 = new MapConsoleRenderer();
        renderer1.renderer(gameMap);
        System.out.println();
        List<Creature> allCreatures = gameMap.getAllCreatures();

        predator.makeMove(gameMap, allCreatures);
        renderer1.renderer(gameMap);
        System.out.println();
        predator.makeMove(gameMap, allCreatures);
        renderer1.renderer(gameMap);
        System.out.println();
        predator.makeMove(gameMap, allCreatures);
        renderer1.renderer(gameMap);


        int a = 123;




    }
}
