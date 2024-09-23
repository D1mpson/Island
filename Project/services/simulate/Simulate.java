package Project.services.simulate;
import Project.entity.animals.Emoji;
import Project.optional.Island;
import Project.entity.plant.Plant;
import Project.services.Animal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Simulate extends Island {
    private ExecutorService simulate;

    public void simulateDay() {

        resetAllMovements();
        simulate = Executors.newFixedThreadPool(15);
        List<Animal> animalsToSimulate = new ArrayList<>(allAnimals);

        for (Animal animal : animalsToSimulate) {
            simulate.submit(() -> {
                synchronized (this) {
                    if (animal.isAlive) {
                        if (animal.getWeight() > animal.getWeight() * 0.5) {
                            animal.eat(this);
                            animal.move(this);
                            animal.decreaseSaturation();
                            reproduce(animal.positionNowX, animal.positionNowY, animal);
                        } else {
                            removeAnimalCompletely(animal);
                            System.out.println(animal.getClass().getSimpleName() + " помер від голоду.");
                        }
                    }
                }
            });
        }

        simulate.shutdown();
        try {
            simulate.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void reproduce (int x, int y, Animal animal){
        List<Animal> animals = getAnimals(x, y);
        Emoji emoji = new Emoji();
        int sameSpeciesCount = (int) animals.stream()
                .filter(animal1 -> animal1.getClass() == animal.getClass())
                .count();

        if (sameSpeciesCount > 0) {
            Animal offspring = animal.reproduce();
            if (offspring != null) {
                System.out.println(emoji.getEmoji(animal) + " " + offspring.getClass().getSimpleName() + " народився!");
                animals.add(offspring);
                allAnimals.add(offspring);
            }
        }
    }

    public void removeAnimalCompletely(Animal animal) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                getAnimals(x, y).remove(animal);
            }
        }
        allAnimals.remove(animal);
    }

    public void removePlant(Plant plant) {
        Island island = new Island();
        synchronized (island) {
            List<Plant> plants = island.getPlants(plant.getPositionPlantX(), plant.getPositionPlantY());
            plants.remove(plant);
            island.allPlants.remove(plant);
        }
    }

    public void resetAllMovements() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                List<Animal> animals = getAnimals(x, y);
                for (Animal animal : animals) {
                    animal.resetMovement();
                }
            }
        }
    }
}
