package Project.services;
import Project.entity.animals.Emoji;
import Project.services.simulate.Simulate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal {

    public Predator(double weight, int maxOnLocation, int maxSpeed, double foodNeeded, double maxSaturation) {
        super(weight, maxOnLocation, maxSpeed, foodNeeded, maxSaturation);
    }

    @Override
    public void eat(Simulate simulate) {
        int x = getPositionNowX();
        int y = getPositionNowY();

        List<Animal> animals = new ArrayList<>(simulate.getAnimals(x, y));

        Emoji emoji = new Emoji();

        for (Animal animal : animals) {
            if (animal instanceof Herbivore) {
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

        for (Animal animal : animals) {
            if (animal instanceof Predator && animal.getClass() != this.getClass()) {
                double chanceToEat = ThreadLocalRandom.current().nextDouble();
                if (chanceToEat < getEatingChancePredator((Predator) animal)) {
                    simulate.removeAnimalCompletely(animal);
                    eatFood(animal.getWeight());
                    System.out.println(emoji.getEmoji(this) + " " + this.getClass().getSimpleName()
                            + " з'їв " + emoji.getEmoji(animal) + " " +  animal.getClass().getSimpleName());
                    return;
                }
            }
        }
    }

    protected abstract double getEatingChanceHerbivore(Herbivore herbivore);
    protected abstract double getEatingChancePredator(Predator predator);

}