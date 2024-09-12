import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Herbivore extends Animal {

    public Herbivore(double weight, int maxOnLocation, int maxSpeed, double foodNeeded, double maxSaturation) {
        super(weight, maxOnLocation, maxSpeed, foodNeeded, maxSaturation);
    }

    @Override
    public void eat(Island island) {
        int x = getCurrentX();
        int y = getCurrentY();

        List<Plant> plants = island.getPlants(x, y);
        List<Animal> animals = island.getAnimals(x, y);

        if (!plants.isEmpty()) {
            Plant plant = plants.get(0);
            double foodToEat = getFoodNeeded();
            eatFood(foodToEat);
            System.out.println(this.getClass().getSimpleName() + " пасеться на рослині!");
            plants.remove(plant);
            return;
        } else {
            System.out.println("Немає рослин для " + this.getClass().getSimpleName() + " на цій локації.");
        }

        for (Animal animal : animals) {
            if (animal instanceof Herbivore) {
                Herbivore herbivore = (Herbivore) animal;
                if (herbivore.getClass() == this.getClass()){
                    continue;
                }
                double chanceToEat = ThreadLocalRandom.current().nextDouble();
                if (chanceToEat < getEatingChance((Herbivore) animal)) {
                    island.removeAnimalCompletely(animal);
                    eatFood(animal.getWeight());
                    System.out.println(this.getClass().getSimpleName() + " з'їв " + animal.getClass().getSimpleName());
                    return;
                }
            }
        }
    }

    protected abstract double getEatingChance(Herbivore herbivore);
}
