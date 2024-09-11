import Entity.*;
//import EntityMotion.aStar;
import EntityMotion.aStar;
import MapConsoleRenderer.MapConsoleRenderer;
import MapSetting.Coordinates;
import MapSetting.GameMap;

public class Main {
    public static void main(String[] args) {

        GameMap gameMap = new GameMap();
//        gameMap.setupDefaultEntityPositions();

        Herbivore herbivore = new Herbivore(new Coordinates(8, 20), 1, 2);
        Herbivore herbivore1 = new Herbivore(new Coordinates(9, 5), 1, 2);
        Herbivore herbivore3 = new Herbivore(new Coordinates(1, 9), 1, 2);
        Predator predator = new Predator(new Coordinates(9, 11), 3, 2, 3);
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


        aStar star = new aStar();
        System.out.println(gameMap.getAllCreatures());

        int b =11;
        while (!gameMap.getAllHerbivore().isEmpty()){
            predator.makeMove(gameMap);
            renderer1.renderer(gameMap);
            System.out.println();
            System.out.println(gameMap.getAllCreatures());
        }

//        for (int i = 0; i < 50; i++){
//            predator.makeMove(gameMap);
//            renderer1.renderer(gameMap);
//            System.out.println();
//            System.out.println(gameMap.getAllCreatures());
//        }

        int a = 123;


    }
}
