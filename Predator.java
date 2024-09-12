import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal {

    public Predator(double weight, int maxOnLocation, int maxSpeed, double foodNeeded, double maxSaturation) {
        super(weight, maxOnLocation, maxSpeed, foodNeeded, maxSaturation);
    }

    @Override
    public void eat(Island island) {
        int x = getCurrentX();
        int y = getCurrentY();

        List<Animal> animals = new ArrayList<>(island.getAnimals(x, y));

        for (Animal animal : animals) {
            if (animal instanceof Herbivore) {
                Herbivore herbivore = (Herbivore) animal;
                double chanceToEat = ThreadLocalRandom.current().nextDouble();
                if (chanceToEat < getEatingChanceHerbivore(herbivore)) {
                    island.removeAnimalCompletely(animal);
                    eatFood(animal.getWeight());
                    System.out.println(this.getClass().getSimpleName() + " з'їв " + animal.getClass().getSimpleName());
                    return;
                } else {
                    System.out.println(this.getClass().getSimpleName() + " не зміг зловити " + animal.getClass().getSimpleName());
                }
            }
        }

        for (Animal animal : animals) {
            if (animal instanceof Predator) {
                Predator predator = (Predator) animal;
                if (predator.getClass() == this.getClass()) {
                    continue;
                }
                double chanceToEat = ThreadLocalRandom.current().nextDouble();
                if (chanceToEat < getEatingChancePredator(predator)) {
                    island.removeAnimalCompletely(animal);
                    eatFood(animal.getWeight());
                    System.out.println(this.getClass().getSimpleName() + " з'їв " + animal.getClass().getSimpleName());
                    return;
                } else {
                    System.out.println(this.getClass().getSimpleName() + " не зміг зловити " + animal.getClass().getSimpleName());
                }
            }
        }
    }

    protected abstract double getEatingChanceHerbivore(Herbivore herbivore);
    protected abstract double getEatingChancePredator(Predator predator);

}
