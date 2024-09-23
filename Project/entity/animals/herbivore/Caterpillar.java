package Project.entity.animals.herbivore;

import Project.services.Herbivore;

import java.util.ArrayList;
import java.util.List;

public class Caterpillar extends Herbivore {

    public Caterpillar() {
        super(0.01, 1000, 0, 0.0, 0.001);
    }

    public static List<Caterpillar> createCaterpillar(int quantity) {
        List<Caterpillar> caterpillars = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            caterpillars.add(new Caterpillar());
        }
        return caterpillars;
    }

    @Override
    protected double getEatingChanceHerbivore(Herbivore herbivore) {
        return 0;
    }

    @Override
    protected double getReproductionChance() {
        return 0.15;
    }
}