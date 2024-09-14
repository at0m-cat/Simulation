import Actions.CreationWorld;
import Actions.UpdateEveryTurn;
import GameMap.MapConsoleRenderer.MapConsoleRenderer;
import GameMap.MapSetting.GameMap;

import java.util.Scanner;

public class Game {

    GameMap gameMap;
    CreationWorld creationWorld;
    UpdateEveryTurn updateEveryTurn;

    public static void main(String[] args) {
        Game simulation = new Game();
        simulation.gameLoop();
    }

    public Game() {
        this.gameMap = new GameMap();
        this.creationWorld = new CreationWorld();
        this.updateEveryTurn = new UpdateEveryTurn();
    }

    public void gameLoop(){
        creationWorld.execute(gameMap);

        while (true){
            try {
                Thread.sleep(2500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            updateEveryTurn.execute(gameMap);



        }

    }
}
