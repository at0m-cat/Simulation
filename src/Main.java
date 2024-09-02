import Nature.Herbivore;
import Nature.Predator;

public class Main {
    public static void main(String[] args) {
//        Predator predator = new Predator(3, 3, 10.4, 100.0, 65.2);
//        System.out.println(predator);
//
//        Predator predator1 = new Predator(3, 3, 10.4, 100.0, 65.2);
//        System.out.println(predator1);
//
//        Herbivore herbivore = new Herbivore(1, 2, 2.2, 55.5);
//        System.out.println(herbivore);
        ////
        // test

        StringBuilder line = new StringBuilder();
        int size = 20;

        for (int i = 0; i < size; i++) {
            line.append("*").append("\n");
        }
        System.out.println(line);
    }
}
