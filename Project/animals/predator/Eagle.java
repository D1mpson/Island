package Project.animals.predator;

import Project.animals.herbivore.Duck;
import Project.animals.herbivore.Mouse;
import Project.animals.herbivore.Rabbit;
import Project.util.Herbivore;
import Project.util.Predator;

import java.util.ArrayList;
import java.util.List;

public class Eagle extends Predator {

    public Eagle() {
        super(6.0, 20, 3, 1.0, 1.0);
    }

    public static List<Eagle> createEagle(int quantity) {
        List<Eagle> eagles = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            eagles.add(new Eagle());
        }
        return eagles;
    }

    @Override
    protected double getReproductionChance() {
        return 0.5;
    }

    @Override
    protected double getEatingChanceHerbivore(Herbivore herbivore) {
        if (herbivore instanceof Rabbit){
            return 0.9;
        }
        if (herbivore instanceof Mouse){
            return 0.9;
        }
        if (herbivore instanceof Duck){
            return 0.8;
        }
        return 0;
    }

    @Override
    protected double getEatingChancePredator(Predator predator) {
        if (predator instanceof Fox){
            return 0.1;
        }
        return 0;
    }
}
