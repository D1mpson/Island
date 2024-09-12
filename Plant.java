import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Plant {
    private double weight;
    protected int currentX;
    protected int currentY;

    public Plant() {
        this.weight = ThreadLocalRandom.current().nextDouble(0.5, 5.0);;
    }

    public static List<Plant> createPlant(int quantity) {
        List<Plant> plants = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            plants.add(new Plant());
        }
        return plants;
    }

}
