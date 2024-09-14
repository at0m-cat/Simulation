package Actions;

import Entity.Objects.Grass;
import Entity.Objects.Predator;
import GameMap.MapSetting.Coordinates;
import GameMap.MapSetting.GameMap;

public class Reborn implements GameActions{

    GameMap gameMap;

    public Reborn(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public void rebornGrass (){
        if (gameMap.getAllDeadSouls().isEmpty()){
            return;
        }
        int rangeDeads =  gameMap.getAllDeadSouls().size();

        for (int i = 0; i < rangeDeads/5; i++) {

            Coordinates toGrass = gameMap.getAllDeadSouls().get(i).getCoordinates();
            gameMap.removeEntity(toGrass);
            gameMap.setEntities(toGrass, new Grass(toGrass));
        }
    }

    public void rebornPredatorsFromThree(){
        if (gameMap.getAllThree().isEmpty()){
            return;
        }
        int rangeThree = gameMap.getAllThree().size();

        for (int i = 0; i < rangeThree / 3; i++) {
            Coordinates toPredators = gameMap.getAllThree().get(i).getCoordinates();
            gameMap.removeEntity(toPredators);
            gameMap.setEntities(toPredators, new Predator(toPredators));
        }
    }

    @Override
    public void execute(GameMap gameMap) {

    }
}
