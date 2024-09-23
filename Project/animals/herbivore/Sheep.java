package Project.animals.herbivore;

import Project.util.Herbivore;

import java.util.ArrayList;
import java.util.List;

public class Sheep extends Herbivore {

    public Sheep() {
        super(70.0, 140, 3, 15.0, 15.0);
    }

    public static List<Sheep> createSheep(int quantity) {
        List<Sheep> sheep = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            sheep.add(new Sheep());
        }
        return sheep;
    }

    @Override
    protected double getEatingChanceHerbivore(Herbivore herbivore) {
        return 0;
    }

    @Override
    protected double getReproductionChance() {
        return 0.25;
    }
}
