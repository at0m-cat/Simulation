package Actions;

import GameMap.MapSetting.GameMap;

public interface GameActions {

     void execute(GameMap gameMap);

     class UpdateEveryTurn {}
}
