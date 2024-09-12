package EntityMotion;

class ShiftsCreature {

    final int[][] SHIFTS;

    ShiftsCreature() {

        this.SHIFTS = new int[][]{
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0},
        };
    }

    int[][] getShifts() {
        return SHIFTS;
    }

}
