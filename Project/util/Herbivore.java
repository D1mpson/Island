package Project.util;
import Project.animals.Emoji;
import Project.plant.Plant;
import Project.util.simulate.Simulate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Herbivore extends Animal {

    public Herbivore(double weight, int maxOnLocation, int maxSpeed, double foodNeeded, double maxSaturation) {
        super(weight, maxOnLocation, maxSpeed, foodNeeded, maxSaturation);
    }
    @Override
    public void eat(Simulate simulate) {

        int x = getPositionNowX();
        int y = getPositionNowY();

        List<Plant> plants = new ArrayList<>(simulate.getPlants(x, y));
        List<Animal> animals = new ArrayList<>(simulate.getAnimals(x, y));
        Emoji emoji = new Emoji();

        synchronized (simulate) {
            if (!plants.isEmpty()) {
                Plant plant = plants.getFirst();
                double foodToEat = Math.min(getFoodNeeded(), plant.getWeight());

                eatFood(foodToEat);
                System.out.println(emoji.getEmoji(this) + " " + this.getClass().getSimpleName() + " їсть рослину.");

                if (plant.getWeight() <= foodToEat) {
                    simulate.removePlant(plant); //Рослина повністю зʼїдена
                } else {
                    plant.decreaseWeight(foodToEat); //Рослина НЕ повністю зʼїдена, але її вага стала меншою.
                }
            } else {
                System.out.println("Немає рослин для " + emoji.getEmoji(this) + " "
                        +  this.getClass().getSimpleName() + " на цій локації (" + x + ", " + y + ").");
            }
        }

        for (Animal animal : animals) {
            if (animal instanceof Herbivore && animal.getClass() != this.getClass()) {
                double chanceToEat = ThreadLocalRandom.current().nextDouble();
                if (chanceToEat < getEatingChanceHerbivore((Herbivore) animal)) {
                    simulate.removeAnimalCompletely(animal);
                    eatFood(animal.getWeight());
                    System.out.println(emoji.getEmoji(this) + " " + this.getClass().getSimpleName()
                            + " з'їв " + emoji.getEmoji(animal) + " " + animal.getClass().getSimpleName());
                    return;
                }
            }
        }
    }

    protected abstract double getEatingChanceHerbivore(Herbivore herbivore);
}