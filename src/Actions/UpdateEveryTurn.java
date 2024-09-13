package Actions;

import Entity.Creature;
import Entity.Name.Herbivore;
import Entity.Name.Predator;
import GameMap.MapConsoleRenderer.MapConsoleRenderer;
import GameMap.MapSetting.GameMap;

import java.util.ArrayList;

public class UpdateEveryTurn implements GameActions {

    GameMap gameMap;
    MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();


    @Override
    public void execute(GameMap gameMap) {
        this.gameMap = gameMap;
        makeMoveAll();
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
        mapConsoleRenderer.renderer(gameMap);
    }
}

//    turnActions - действия, совершаемые каждый ход
//    Примеры - передвижение существ, добавить травы или травоядных, если их осталось слишком мало


