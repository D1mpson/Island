package Project.animals.herbivore;

import Project.util.Herbivore;

import java.util.ArrayList;
import java.util.List;

public class Deer extends Herbivore {

    public Deer() {
        super(300.0, 20, 4, 50.0, 50.0);
    }

    public static List<Deer> createDeer(int quantity) {
        List<Deer> deer = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            deer.add(new Deer());
        }
        return deer;
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