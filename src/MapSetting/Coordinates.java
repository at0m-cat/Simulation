package MapSetting;

import Entity.Entity;
//import EntityMotion.Node;

import java.util.*;

public class Coordinates {

    public final Integer horizontal;
    public final Integer vertical;

    public Coordinates(Integer horizontal, Integer vertical) {
        this.horizontal = horizontal;
        this.vertical = vertical;
    }


    public double distanceTo (Entity entity, GameMap map) {
        Coordinates goal = entity.getCoordinates();
        return Math.abs((this.horizontal - goal.horizontal) + (this.vertical - goal.vertical));
    }


    public Coordinates shift(CoordinatesShift shift) {
        return new Coordinates(this.horizontal + shift.horizontalShift,
                this.vertical + shift.verticalShift);
    }

    public boolean canShift(CoordinatesShift shift) {
        int v = this.vertical + shift.verticalShift;
        int h = this.horizontal + shift.horizontalShift;

        if ((h <= 0) || (h > GameMap.HORIZONTAL_MAX)) return false;
        if ((v <= 0) || (v > GameMap.VERTICAL_MAX)) return false;
        return true;
    }

    public Set<Coordinates> getAvailableCoordinates() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates that = (Coordinates) o;
        return Objects.equals(horizontal, that.horizontal) && Objects.equals(vertical, that.vertical);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horizontal, vertical);
    }
    @Override
    public String toString() {
        return "vertical: " + vertical + ", horizontal: " + horizontal;
    }
}
