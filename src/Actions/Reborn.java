package Actions;

import Entity.Objects.DeadSouls;
import Entity.Objects.Grass;
import GameMap.MapSetting.Coordinates;
import GameMap.MapSetting.GameMap;

import java.util.ArrayList;
import java.util.Random;

public class Reborn implements GameActions{

    GameMap gameMap;

    public Reborn(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public void rebornHerbivore(){

    }

    public void rebornGrass (){
        if (gameMap.getAllDeadSouls().isEmpty()){
            return;
        }
        int rangeDeads =  gameMap.getAllDeadSouls().size();

        for (int i = 0; i < rangeDeads/4; i++) {

            Coordinates toGrass = gameMap.getAllDeadSouls().get(i).getCoordinates();
            gameMap.removeEntity(toGrass);
            gameMap.setEntities(toGrass, new Grass(toGrass));
        }
    }

    @Override
    public void execute(GameMap gameMap) {

    }
}
