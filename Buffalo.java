import java.util.ArrayList;
import java.util.List;

public class Buffalo extends Herbivore {

    public Buffalo() {
        super(700.0, 10, 3, 100.0, 100.0);
    }

    public static List<Buffalo> createBuffalo(int quantity) {
        List<Buffalo> buffalo = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            buffalo.add(new Buffalo());
        }
        return buffalo;
    }

    protected double getEatingChance(Herbivore herbivore) {
        return 0;
    }
    @Override
    protected double getReproductionChance() {
        return 0.2;
    }
}
