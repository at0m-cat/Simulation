//import GameMap.PathToTarget.aStar;
import Actions.CreationWorld;
import Actions.UpdateEveryTurn;
import GameMap.MapSetting.*;

public class Main {
    public static void main(String[] args) {

        GameMap gameMap = new GameMap();
        CreationWorld creationWorld = new CreationWorld();
        UpdateEveryTurn updateEveryTurn = new UpdateEveryTurn();

        creationWorld.execute(gameMap);
        updateEveryTurn.execute(gameMap);
        int count = 0;

        while (!(gameMap.getAllHerbivore().size() <= 3 )){
            updateEveryTurn.execute(gameMap);
            count++;
        }
        System.out.println(count + " === " + " iterations");

    }
}
