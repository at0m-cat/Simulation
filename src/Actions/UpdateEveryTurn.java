package Actions;

import Entity.Objects.Herbivore;
import Entity.Objects.Predator;
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

    private void updateGrass(){

    }

    
}

//    turnActions - действия, совершаемые каждый ход
//    Примеры - передвижение существ, добавить травы или травоядных, если их осталось слишком мало


