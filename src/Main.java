//import GameMap.EntityMotion.aStar;
import Actions.CreationWorld;
import Entity.*;
import Entity.Name.*;
import GameMap.MapConsoleRenderer.MapConsoleRenderer;
import GameMap.MapSetting.Coordinates;
import GameMap.MapSetting.*;

public class Main {
    public static void main(String[] args) {

        GameMap gameMap = new GameMap();

        CreationWorld creationWorld = new CreationWorld();

        creationWorld.execute(gameMap);




//
//
//        GameMap gameMap = new GameMap();
//
////
////        for (int i = 0; i < 40; i++){
////            gameMap.setupDefaultEntityPositions();
////        }
//        MapConsoleRenderer renderer1 = new MapConsoleRenderer();
////        renderer1.renderer(gameMap);
//
//
//        Herbivore herbivore = new Herbivore(new Coordinates(8, 20), 1, 2);
//        Herbivore herbivore1 = new Herbivore(new Coordinates(9, 5), 1, 2);
//        Herbivore herbivore3 = new Herbivore(new Coordinates(1, 9), 1, 2);
//        Predator predator = new Predator(new Coordinates(9, 11), 3, 2, 3);
//        Grass grass = new Grass(new Coordinates(5, 5));
//        Grass grass12 = new Grass(new Coordinates(5, 5));
//        Grass grass13 = new Grass(new Coordinates(5, 6));
//        Grass grass14 = new Grass(new Coordinates(5, 7));
//        Grass grass15 = new Grass(new Coordinates(5, 8));
//        Grass grass1 = new Grass(new Coordinates(5, 9));
//        Grass grass2= new Grass(new Coordinates(6, 9));
//        Grass grass3 = new Grass(new Coordinates(1, 1));
//        Rock rock = new Rock(new Coordinates(9, 9));
//        Rock rock2 = new Rock(new Coordinates(8, 9));
//        Rock rock1 = new Rock(new Coordinates(9, 10));
//        Rock rock3 = new Rock(new Coordinates(8, 11));
//        Rock rock4 = new Rock(new Coordinates(10, 9));
//
//        gameMap.setEntities(herbivore);
//        gameMap.setEntities(herbivore3);
//        gameMap.setEntities(herbivore1);
//        gameMap.setEntities(predator);
//        gameMap.setEntities(grass);
//        gameMap.setEntities(grass1);
//        gameMap.setEntities(grass12);
//        gameMap.setEntities(grass13);
//        gameMap.setEntities(grass14);
//        gameMap.setEntities(grass15);
//        gameMap.setEntities(grass2);
//        gameMap.setEntities(grass3);
//        gameMap.setEntities(rock);
//        gameMap.setEntities(rock2);
//        gameMap.setEntities(rock1);
//        gameMap.setEntities(rock3);
//        gameMap.setEntities(rock4);
//
//        renderer1.renderer(gameMap);
//        System.out.println();
////        System.out.println();
//
////
////
////        System.out.println(gameMap.getAllCreatures());
////
////        int b =11;
//        while (!gameMap.getAllHerbivore().isEmpty()){
//            predator.makeMove(gameMap);
//            herbivore.makeMove(gameMap);
//            herbivore1.makeMove(gameMap);
//            herbivore3.makeMove(gameMap);
//            renderer1.renderer(gameMap);
//            System.out.println();
//            System.out.println(gameMap.getAllCreatures());
//        }
//
//
//
////        for (int i = 0; i < 50; i++){
////            predator.makeMove(gameMap);
////            renderer1.renderer(gameMap);
////            System.out.println();
////            System.out.println(gameMap.getAllCreatures());
////        }
//
//        int a = 123;


    }
}
