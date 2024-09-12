import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Island {
    private final int width = 100;
    private final int height = 20;
    private List<Animal>[][] animalLocations;
    private List<Plant>[][] plantLocations;

    private List<Animal> allAnimals = new ArrayList<>();
    private List<Plant> allPlants = new ArrayList<>();
    private ExecutorService executorService;

    public Island() {
        this.animalLocations = new ArrayList[width][height];
        this.plantLocations = new ArrayList[width][height];

        // Ініціалізація кожної локації на острові для тварин та рослин
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                animalLocations[i][j] = new ArrayList<>();
                plantLocations[i][j] = new ArrayList<>();
            }
        }
        this.executorService = Executors.newFixedThreadPool(15);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<Animal> getAnimals(int x, int y) {
        return animalLocations[x][y];
    }

    public List<Plant> getPlants(int x, int y) {
        return plantLocations[x][y];
    }

    public void addAnimalToLocation(int x, int y, Animal animal) {
        List<Animal> animals = getAnimals(x, y);
        int sameSpeciesCount = 0;

        for (Animal a : animals) {
            if (a.getClass() == animal.getClass()) {
                sameSpeciesCount++;
            }
        }

        if (sameSpeciesCount < animal.maxOnLocation) {
            animals.add(animal);
            animal.currentX = x;
            animal.currentY = y;
            allAnimals.add(animal);

            if (sameSpeciesCount > 0) {
                Animal offspring = animal.reproduce();
                if (offspring != null) {
                    System.out.println(offspring.getClass().getSimpleName() + " народився");
                    animals.add(offspring);
                } else {
                    System.out.println("Не вдала спроба розмноження");
                }
            }
        } else {
            System.out.println("Неможливо додати більше " + animal.getClass().getSimpleName() + " до цієї локації.");
        }
    }

    public void addPlantToLocation(int x, int y, Plant plant) {
        List<Plant> plants = getPlants(x, y);
        plants.add(plant);
        plant.currentX = x;
        plant.currentY = y;
        allPlants.add(plant);
    }

    public void removeAnimalCompletely(Animal animal) {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                getAnimals(x, y).remove(animal);
            }
        }
        allAnimals.remove(animal);
    }

    public void simulateDay() {
        resetAllMovements();
        List<Animal> animalsToSimulate = new ArrayList<>(allAnimals);

        for (Animal animal : animalsToSimulate) {
            executorService.submit(() -> {
                synchronized (this) {
                    if (allAnimals.contains(animal)) {
                        if (animal.getCurrentSaturation() > 0) {
                            animal.eat(this);
                            animal.move(this);
                            animal.decreaseSaturation();
                        } else {
                            removeAnimalCompletely(animal);
                            System.out.println(animal.getClass().getSimpleName() + " помер від голоду.");
                        }
                    }
                }
            });
        }

        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService = Executors.newFixedThreadPool(15);
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

    public void printFinalAnimals() {
        System.out.println("Стан острова після завершення симуляції:");
        for (Animal animal : allAnimals) {
            System.out.println("Локація (" + animal.getCurrentX() + ", " + animal.getCurrentY() + "):");
            System.out.println(" - " + animal.getClass().getSimpleName() + " (насичення: " + animal.getCurrentSaturation() + ")");
        }
        System.out.println("----------------------------");
    }
}
