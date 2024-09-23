package Project.util;
import Project.animals.Emoji;
import Project.util.simulate.Simulate;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal {
    protected double weight;
    public int maxOnLocation;
    protected int maxSpeed;
    protected double foodNeeded;
    protected double maxSaturation;
    protected double currentSaturation;
    public int positionNowX;
    public int positionNowY;
    private boolean hasMovedToday = false;
    public boolean isAlive = true;


    public Animal(double weight, int maxOnLocation, int maxSpeed, double foodNeeded, double maxSaturation) {
        this.weight = weight;
        this.maxOnLocation = maxOnLocation;
        this.maxSpeed = maxSpeed;
        this.foodNeeded = foodNeeded;
        this.maxSaturation = maxSaturation;
        this.currentSaturation = maxSaturation;
    }

    public abstract void eat(Simulate simulate);

    public void move(Simulate simulate) {
        Emoji emoji = new Emoji();


        synchronized (simulate) {
            if (hasMovedToday) {
                System.out.println(this.getClass().getSimpleName() + " вже переміщався сьогодні.");
                return;
            }

            int oldX = positionNowX;
            int oldY = positionNowY;

            int xOffset = ThreadLocalRandom.current().nextInt(-maxSpeed, maxSpeed + 1);
            int yOffset = ThreadLocalRandom.current().nextInt(-maxSpeed, maxSpeed + 1);

            int newX = Math.max(0, Math.min(positionNowX + xOffset, simulate.getWidth() - 1));
            int newY = Math.max(0, Math.min(positionNowY + yOffset, simulate.getHeight() - 1));

            List<Animal> currentLocationAnimals = simulate.getAnimals(oldX, oldY);
            List<Animal> newLocationAnimals = simulate.getAnimals(newX, newY);

            currentLocationAnimals.remove(this);
            newLocationAnimals.add(this);

            this.positionNowX = newX;
            this.positionNowY = newY;
            hasMovedToday = true;

            if (oldX == newX && oldY == newY) {
                System.out.println(emoji.getEmoji(this) + " "
                        + this.getClass().getSimpleName() + " не переміщався сьогодні.");
            } else {
                System.out.println(emoji.getEmoji(this) + " " + this.getClass().getSimpleName()
                        + " перемістився з (" + oldX + ", " + oldY + ") на (" + newX + ", " + newY + ")");
            }
        }
    }

    public void resetMovement() {
        hasMovedToday = false;
    }

    protected abstract double getReproductionChance();

    public Animal reproduce() {
        if (!isAlive) {
            System.out.println(this.getClass().getSimpleName() + " не може розмножуватися, оскільки мертва.");
            return null;
        }

        if (ThreadLocalRandom.current().nextDouble() < getReproductionChance()) {
            try {
                return this.getClass().getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    public void decreaseSaturation() {
        currentSaturation -= weight * 0.01;
        if (currentSaturation < 0 || weight < weight * 0.5) {
            isAlive = false;
        }
    }
    protected void eatFood(double foodAmount) {
        currentSaturation += foodAmount;
        if (currentSaturation > maxSaturation) {
            currentSaturation = maxSaturation;
        }
    }

    public double getWeight() {
        return weight;
    }

    public double getFoodNeeded() {
        return foodNeeded;
    }

    public int getPositionNowX() {
        return positionNowX;
    }

    public int getPositionNowY() {
        return positionNowY;
    }
}