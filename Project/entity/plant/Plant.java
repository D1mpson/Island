package Project.entity.plant;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Plant {
    private double weight;
    public int positionPlantX;
    public int positionPlantY;

    public Plant() {
        this.weight = ThreadLocalRandom.current().nextDouble(0.5, 5.0);
    }

    @org.jetbrains.annotations.NotNull
    public static List<Plant> createPlant(int quantity) {
        List<Plant> plants = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            plants.add(new Plant());
        }
        return plants;
    }

    public double getWeight() {
        return weight;
    }

    public void decreaseWeight(double amount) {
        this.weight = Math.max(0, this.weight - amount);
    }

    public int getPositionPlantX() {
        return positionPlantX;
    }

    public int getPositionPlantY() {
        return positionPlantY;
    }
}