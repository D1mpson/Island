package Project.animals.herbivore;
import Project.util.Herbivore;

import java.util.ArrayList;
import java.util.List;

public class Horse extends Herbivore {

    public Horse() {
        super(400.0, 20, 4, 60.0, 60.0);
    }

    public static List<Horse> createHorse(int quantity) {
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            horses.add(new Horse());
        }
        return horses;
    }

    @Override
    protected double getEatingChanceHerbivore(Herbivore herbivore) {
        return 0;
    }

    @Override
    protected double getReproductionChance() {
        return 0.2;
    }
}