package Entity.EntityMotion;

public class ShiftsCreature {

    private final int[][] SHIFTS;

    public ShiftsCreature() {
        this.SHIFTS = setShifts();
    }

    private int[][] setShifts(){
        return new int[][]{
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
