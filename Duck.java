import java.util.ArrayList;
import java.util.List;

public class Duck extends Herbivore {

    public Duck() {
        super(1.0, 200, 4, 0.15, 0.15);
    }

    public static List<Duck> createDuck(int quantity) {
        List<Duck> ducks = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            ducks.add(new Duck());
        }
        return ducks;
    }

    @Override
    protected double getEatingChance(Herbivore herbivore) {
        if (herbivore instanceof Caterpillar){
            return 0.9;
        }
        return 0;
    }

    @Override
    protected double getReproductionChance() {
        return 0.45;
    }
}
