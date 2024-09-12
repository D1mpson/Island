import java.util.ArrayList;
import java.util.List;

public class Goat extends Herbivore {

    public Goat() {
        super(60.0, 140, 3, 10.0, 10.0);
    }

    public static List<Goat> createGoat(int quantity) {
        List<Goat> goats = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            goats.add(new Goat());
        }
        return goats;
    }

    protected double getEatingChance(Herbivore herbivore) {
        return 0;
    }

    @Override
    protected double getReproductionChance() {
        return 0.25;
    }
}
