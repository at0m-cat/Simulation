package Entity.Objects;

import Entity.Creature;
import Entity.EnumType.FamilyType;
import Entity.EnumType.TargetType;
import GameMap.MapSetting.Coordinates;
import GameMap.MapSetting.GameMap;


public class Herbivore extends Creature implements Comparable<Herbivore> {


    public Herbivore(Coordinates coordinates, int speed, double hp) {
        super(coordinates, FamilyType.Herbivore, TargetType.TargetForPredator, speed, hp);
    }


    @Override
    public void makeMove(GameMap map) {
        super.makeMove(map);
    }


    @Override
    public int compareTo(Herbivore o) {
        return Math.abs((coordinates.horizontal - o.coordinates.horizontal)
                + (coordinates.vertical - o.coordinates.vertical));
    }


}
