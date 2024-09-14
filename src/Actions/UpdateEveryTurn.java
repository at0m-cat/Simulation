package Actions;
import Entity.Objects.Herbivore;
import Entity.Objects.Predator;
import Entity.EntityQuantity;
import GameMap.MapConsoleRenderer.MapConsoleRenderer;
import GameMap.MapSetting.GameMap;
import java.util.ArrayList;

public class UpdateEveryTurn implements GameActions {

    GameMap gameMap;
    MapConsoleRenderer mapConsoleRenderer = new MapConsoleRenderer();
    EntityQuantity entityQuantity;

    @Override
    public void execute(GameMap gameMap) {
        this.gameMap = gameMap;
        this.entityQuantity = new EntityQuantity(gameMap);
        makeMoveAll();
        System.out.println();
        mapConsoleRenderer.renderer(gameMap);

        if (gameMap.getAllHerbivore().size() < 30){
            Agronome agronome = new Agronome(gameMap);
            agronome.cutTree(gameMap);
            System.out.println();
            mapConsoleRenderer.renderer(gameMap);
        }

        if (gameMap.getAllDeadSouls().size() > 15){
            Reborn reborn = new Reborn(gameMap);
            reborn.rebornGrass();
            System.out.println();
            mapConsoleRenderer.renderer(gameMap);
        }

        if (gameMap.getAllPredators().size() < 8){
            Reborn reborn = new Reborn(gameMap);
            reborn.rebornPredatorsFromThree();
            System.out.println();
            mapConsoleRenderer.renderer(gameMap);
        }

        if (gameMap.getAllPredators().size() < 4){
            Agronome agronome = new Agronome(gameMap);
            agronome.cutRock(gameMap);
            System.out.println();
            mapConsoleRenderer.renderer(gameMap);
        }
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
    }

}


