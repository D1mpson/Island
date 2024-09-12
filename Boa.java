import java.util.ArrayList;
import java.util.List;

public class Boa extends Predator {

    public Boa() {
        super(15.0, 30, 1, 3.0, 3.0);
    }

    public static List<Boa> createBoa(int quantity) {
        List<Boa> boas = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            boas.add(new Boa());
        }
        return boas;
    }

    @Override
    protected double getReproductionChance() {
        return 0.5;
    }

    @Override
    protected double getEatingChanceHerbivore(Herbivore herbivore) {
        if (herbivore instanceof Rabbit) {
            return 0.2;
        }
        if (herbivore instanceof Mouse) {
            return 0.4;
        }
        if (herbivore instanceof Duck) {
            return 0.1;
        }
        return 0;
    }

    @Override
    protected double getEatingChancePredator(Predator predator) {
        if (predator instanceof Fox) {
            return 0.15;
        }
        return 0.25;
    }
}
