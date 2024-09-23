package Project.animals.predator;

import Project.animals.herbivore.*;
import Project.util.Herbivore;
import Project.util.Predator;

import java.util.ArrayList;
import java.util.List;

public class Bear extends Predator {

    public Bear() {
        super(500.0, 5, 2, 80.0, 80.0);
    }

    public static List<Bear> createBear(int quantity) {
        List<Bear> bears = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            bears.add(new Bear());
        }
        return bears;
    }

    @Override
    protected double getReproductionChance() {
        return 0.5;
    }

    @Override
    protected double getEatingChanceHerbivore(Herbivore herbivore) {
        if (herbivore instanceof Horse){
            return 0.4;
        }
        if (herbivore instanceof Deer){
            return 0.8;
        }
        if (herbivore instanceof Rabbit){
            return 0.8;
        }
        if (herbivore instanceof Mouse){
            return 0.9;
        }
        if (herbivore instanceof Goat){
            return 0.7;
        }
        if (herbivore instanceof Sheep){
            return 0.7;
        }
        if (herbivore instanceof Boar){
            return 0.5;
        }
        if (herbivore instanceof Buffalo){
            return 0.2;
        }
        if (herbivore instanceof Duck){
            return 0.1;
        }
        return 0;
    }
    @Override
    protected double getEatingChancePredator(Predator predator) {
        if (predator instanceof Boa){
            return 0.8;
        }
        return 0;
    }

}
