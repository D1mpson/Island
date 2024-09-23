package Project.entity.animals.predator;

import Project.entity.animals.herbivore.Caterpillar;
import Project.entity.animals.herbivore.Duck;
import Project.entity.animals.herbivore.Mouse;
import Project.entity.animals.herbivore.Rabbit;
import Project.services.Herbivore;
import Project.services.Predator;

import java.util.ArrayList;
import java.util.List;

public class Fox extends Predator {

    public Fox() {
        super(8.0, 30, 2, 2.0, 2.0);
    }

    public static List<Fox> createFox(int quantity) {
        List<Fox> foxes = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            foxes.add(new Fox());
        }
        return foxes;
    }

    @Override
    protected double getReproductionChance() {
        return 0.5;
    }

    @Override
    protected double getEatingChanceHerbivore(Herbivore herbivore) {
        if (herbivore instanceof Rabbit){
            return 0.8;
        }
        if (herbivore instanceof Rabbit){
            return 0.7;
        }
        if (herbivore instanceof Mouse){
            return 0.9;
        }
        if (herbivore instanceof Duck) {
            return 0.6;
        }
        if (herbivore instanceof Caterpillar){
            return 0.4;
        }
        return 0;
    }

    @Override
    protected double getEatingChancePredator(Predator predator) {
        return 0;
    }
}
