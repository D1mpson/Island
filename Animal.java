import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal {
    protected double weight;
    protected int maxOnLocation;
    protected int maxSpeed;
    protected double foodNeeded;
    protected double maxSaturation;
    protected double currentSaturation;
    protected int currentX;
    protected int currentY;
    private boolean hasMovedToday = false;

    public Animal(double weight, int maxOnLocation, int maxSpeed, double foodNeeded, double maxSaturation) {
        this.weight = weight;
        this.maxOnLocation = maxOnLocation;
        this.maxSpeed = maxSpeed;
        this.foodNeeded = foodNeeded;
        this.maxSaturation = maxSaturation;
        this.currentSaturation = maxSaturation;
    }

    protected abstract void eat(Island island);

    protected void eatFood(double foodAmount) {
        currentSaturation += foodAmount;
        if (currentSaturation > maxSaturation) {
            currentSaturation = maxSaturation;
        }
    }

    public void decreaseSaturation() {
        currentSaturation -= weight * 0.01;
        if (currentSaturation < 0) {
            currentSaturation = 0;
        }
    }

    public void move(Island island) {
        if (hasMovedToday) return;

        int xOffset = ThreadLocalRandom.current().nextInt(-maxSpeed, maxSpeed + 1);
        int yOffset = ThreadLocalRandom.current().nextInt(-maxSpeed, maxSpeed + 1);

        int newX = Math.max(0, Math.min(currentX + xOffset, island.getWidth() - 1));
        int newY = Math.max(0, Math.min(currentY + yOffset, island.getHeight() - 1));

        List<Animal> currentLocationAnimals = island.getAnimals(currentX, currentY);
        List<Animal> newLocationAnimals = island.getAnimals(newX, newY);

        currentLocationAnimals.remove(this);
        newLocationAnimals.add(this);

        this.currentX = newX;
        this.currentY = newY;
        hasMovedToday = true;

        System.out.println(this.getClass().getSimpleName() + " перемістився з (" + currentX + ", " + currentY + ") до (" + newX + ", " + newY + ").");
    }

    public void resetMovement() {
        hasMovedToday = false;
    }

    protected abstract double getReproductionChance();

    public Animal reproduce() {
        if (ThreadLocalRandom.current().nextDouble() < getReproductionChance()) {
            try {
                return this.getClass().getConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public double getWeight() {
        return weight;
    }

    public double getFoodNeeded() {
        return foodNeeded;
    }

    public double getCurrentSaturation() {
        return currentSaturation;
    }

    public int getCurrentX() {
        return currentX;
    }

    public int getCurrentY() {
        return currentY;
    }
}
