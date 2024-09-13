package Actions;

import Entity.Factory.EntityFactory;
import Entity.Objects.Herbivore;
import Entity.Objects.Predator;
import Entity.Quantity.EntityQuantity;
import GameMap.MapConsoleRenderer.MapConsoleRenderer;
import GameMap.MapSetting.Coordinates;
import GameMap.MapSetting.GameMap;

import java.util.ArrayList;
import java.util.Random;

public class UpdateEveryTurn implements GameActions {

    GameMap gameMap;
    MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();
    EntityQuantity entityQuantity;


    @Override
    public void execute(GameMap gameMap) {
        this.gameMap = gameMap;
        this.entityQuantity = new EntityQuantity(gameMap);
        makeMoveAll();
        mapConsoleRenderer.renderer(gameMap);

    }

    private void makeMoveAll() {
        ArrayList<Herbivore> herbivores = gameMap.getAllHerbivore();
        ArrayList<Predator> predators = gameMap.getAllPredators();

        for (Predator predator : predators) {
            predator.makeMove(gameMap);
        }
        for (Herbivore herbivore : herbivores) {
            herbivore.makeMove(gameMap);
        }
        System.out.println();
    }

    
}

//    turnActions - действия, совершаемые каждый ход
//    Примеры - передвижение существ, добавить травы или травоядных, если их осталось слишком мало


