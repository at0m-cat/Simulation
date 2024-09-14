package Actions;

import Entity.Objects.Grass;
import Entity.Objects.Rock;
import Entity.Objects.Three;
import GameMap.MapSetting.Coordinates;
import GameMap.MapSetting.GameMap;

import java.util.ArrayList;
import java.util.Collections;

public class Agronome implements GameActions {

    GameMap gameMap;

    public Agronome(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    @Override
    public void execute(GameMap gameMap) {

    }


    public void cutTree(GameMap gameMap) {

       int rangeThree =  gameMap.getAllThree().size();
        ArrayList<Three> threes = gameMap.getAllThree();
        Collections.shuffle(threes);


       for (int i = 0; i < rangeThree / 5; i++) {
           Coordinates threeCoord = threes.get(i).getCoordinates();
           gameMap.removeEntity(threeCoord);
           gameMap.setEntities(threeCoord, new Grass(threeCoord));
       }
    }

    public void cutRock(GameMap gameMap) {
        int rangeRock =  gameMap.getAllRock().size();
        ArrayList<Rock> rocks = gameMap.getAllRock();
        Collections.shuffle(rocks);
        for (int i = 0; i < rangeRock / 2; i++) {
            Coordinates rockCoord = rocks.get(i).getCoordinates();
            gameMap.removeEntity(rockCoord);
            gameMap.setEntities(rockCoord, new Three(rockCoord));
        }
    }
}
