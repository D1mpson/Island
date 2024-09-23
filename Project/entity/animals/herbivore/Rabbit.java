package Project.entity.animals.herbivore;

import Project.services.Herbivore;

import java.util.ArrayList;
import java.util.List;

public class Rabbit extends Herbivore {

    public Rabbit() {
        super(2.0, 150, 2, 0.5, 0.5);
    }

    public static List<Rabbit> createRabbits(int quantity) {
        List<Rabbit> rabbits = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            rabbits.add(new Rabbit());
        }
        return rabbits;
    }

    @Override
    protected double getEatingChanceHerbivore(Herbivore herbivore) {
        return 0;
    }

    @Override
    protected double getReproductionChance() {
        return 0.7;
    }
}