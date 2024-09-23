package Project.optional;

import Project.plant.Plant;
import Project.util.Animal;

import java.util.ArrayList;
import java.util.List;

public class Island {
    public final int width = 100;
    public final int height = 20;
    private List<Animal>[][] animalLocations;
    private List<Plant>[][] plantLocations;
    public static List<Animal> allAnimals = new ArrayList<>();
    public static List<Plant> allPlants = new ArrayList<>();
    private final Object lock = new Object();


    public Island() {
        this.animalLocations = new ArrayList[width][height];
        this.plantLocations = new ArrayList[width][height];

        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                animalLocations[i][j] = new ArrayList<>();
                plantLocations[i][j] = new ArrayList<>();
            }
        }
    }

    public void addAnimalToLocation(int x, int y, Animal animal) {
        synchronized (lock) {
            List<Animal> animals = getAnimals(x, y);
            int sameSpeciesCount = (int) animals.stream()
                    .filter(animal1 -> animal1.getClass() == animal.getClass())
                    .count();

            if (sameSpeciesCount < animal.maxOnLocation) {
                animals.add(animal);
                animal.positionNowX = x;
                animal.positionNowY = y;
                allAnimals.add(animal);
            }
        }
    }

    public void addPlantToLocation(int x, int y, Plant plant) {
        List<Plant> plants = getPlants(x, y);
        plants.add(plant);
        plant.positionPlantX = x;
        plant.positionPlantY = y;
        allPlants.add(plant);
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
}