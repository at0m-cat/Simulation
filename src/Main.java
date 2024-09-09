import Entity.*;
//import EntityMotion.aStar;
import MapConsoleRenderer.MapConsoleRenderer;
import MapSetting.Coordinates;
import MapSetting.GameMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static Entity.Types.Herbivore;

public class Main {
    public static void main(String[] args) {

        GameMap gameMap = new GameMap();
//        gameMap.setupDefaultEntityPositions();

        Herbivore herbivore = new Herbivore(new Coordinates(8, 20), 1, 2);
        Herbivore herbivore1 = new Herbivore(new Coordinates(1, 1), 1, 2);
        Herbivore herbivore3 = new Herbivore(new Coordinates(1, 9), 1, 2);
        Predator predator = new Predator(new Coordinates(8, 10), 1, 2, 3);
        Grass grass = new Grass(new Coordinates(5, 5));
        Rock rock = new Rock(new Coordinates(9, 9));
        Rock rock2 = new Rock(new Coordinates(8, 9));
        Rock rock1 = new Rock(new Coordinates(9, 10));
        Rock rock3 = new Rock(new Coordinates(8, 11));
        Rock rock4 = new Rock(new Coordinates(10, 9));

        gameMap.setEntities(herbivore);
        gameMap.setEntities(herbivore3);
        gameMap.setEntities(herbivore1);
        gameMap.setEntities(predator);
        gameMap.setEntities(grass);
        gameMap.setEntities(rock);
        gameMap.setEntities(rock2);
        gameMap.setEntities(rock1);
        gameMap.setEntities(rock3);
        gameMap.setEntities(rock4);

        MapConsoleRenderer renderer1 = new MapConsoleRenderer();
        renderer1.renderer(gameMap);
        System.out.println();

        predator.makeMove(
                // отправляем свои координаты и карту ->
                // смотрим доступные ходы ->
                // отсеиваем ходы с большим весом ->
                // двигаемся к ближайшей цели на карте

                gameMap);

        List<Creature> allCreatures = gameMap.getAllCreatures();
        System.out.println("Creatures:" + allCreatures);

        renderer1.renderer(gameMap);
        predator.makeMove(gameMap);
        renderer1.renderer(gameMap);




        ArrayList<Coordinates> setList = predator.getAvailableMoves(gameMap);
        for (Coordinates coordinates : setList) {
            System.out.println("rthis coord: " + coordinates.vertical + " " + coordinates.horizontal);
        }

        gameMap.getAllCreatures();


        int a = 123;


    }
}
