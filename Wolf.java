import java.util.ArrayList;
import java.util.List;

public class Wolf extends Predator {

    public Wolf() {
        super(50.0, 30, 3, 8.0, 8.0);
    }
    public static List<Wolf> createWolves(int quantity) {
        List<Wolf> wolves = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            wolves.add(new Wolf());
        }
        return wolves;
    }

    @Override
    protected double getReproductionChance() {
        return 0.5;
    }

    @Override
    protected double getEatingChanceHerbivore(Herbivore herbivore) {
        if (herbivore instanceof Horse){
            return 0.1;
        }
        if (herbivore instanceof Deer){
            return 0.15;
        }
        if (herbivore instanceof Rabbit){
            return 0.6;
        }
        if (herbivore instanceof Mouse){
            return 0.8;
        }
        if (herbivore instanceof Goat){
            return 0.6;
        }
        if (herbivore instanceof Sheep){
            return 0.7;
        }
        if (herbivore instanceof Boar){
            return 0.15;
        }
        if (herbivore instanceof Buffalo){
            return 0.1;
        }
        if (herbivore instanceof Duck){
            return 0.4;
        }
        return 0;
    }
    @Override
    protected double getEatingChancePredator(Predator predator) {
        return 0;
    }

}
