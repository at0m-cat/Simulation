package GameMap.EntityMotion;

class ShiftsCreature {

    final int[][] SHIFTS;

    public ShiftsCreature() {

        this.SHIFTS = new int[][]{
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0},
        };
    }

    public int[][] getShifts() {
        return SHIFTS;
    }

}
