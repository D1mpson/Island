package Project.services.simulate;

import Project.entity.animals.herbivore.*;
import Project.entity.animals.predator.*;
import Project.optional.Island;
import Project.entity.plant.Plant;
import Project.services.Animal;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;

import static Project.optional.Island.allAnimals;

public class InitializeIsland {
    public static void initializeIsland(Island island, Simulate simulate) {

        List<Wolf> wolves = Wolf.createWolves(15);
        List<Boa> boas = Boa.createBoa(15);
        List<Fox> foxes = Fox.createFox(15);
        List<Bear> bears = Bear.createBear(3);
        List<Eagle> eagles = Eagle.createEagle(10);
        List<Horse> horses = Horse.createHorse(10);
        List<Deer> deer = Deer.createDeer(10);
        List<Rabbit> rabbits = Rabbit.createRabbits(75);
        List<Mouse> mice = Mouse.createMouse(200);
        List<Goat> goats = Goat.createGoat(55);
        List<Sheep> sheep = Sheep.createSheep(55);
        List<Boar> boars = Boar.createBoar(20);
        List<Buffalo> buffalo = Buffalo.createBuffalo(5);
        List<Duck> ducks = Duck.createDuck(55);
        List<Caterpillar> caterpillars = Caterpillar.createCaterpillar(100);
        List<Plant> plants = Plant.createPlant(10000);

        addAnimalsToIsland(island, wolves);
        addAnimalsToIsland(island, boas);
        addAnimalsToIsland(island, foxes);
        addAnimalsToIsland(island, bears);
        addAnimalsToIsland(island, eagles);
        addAnimalsToIsland(island, horses);
        addAnimalsToIsland(island, deer);
        addAnimalsToIsland(island, rabbits);
        addAnimalsToIsland(island, mice);
        addAnimalsToIsland(island, goats);
        addAnimalsToIsland(island, sheep);
        addAnimalsToIsland(island, boars);
        addAnimalsToIsland(island, buffalo);
        addAnimalsToIsland(island, ducks);
        addAnimalsToIsland(island, caterpillars);
        addPlantsToIsland(simulate, plants);
    }

    private static void addAnimalsToIsland(Island island, List<? extends Animal> animals) {
        for (Animal animal : animals) {
            int x, y;
            x = ThreadLocalRandom.current().nextInt(0, 100);
            y = ThreadLocalRandom.current().nextInt(0, 20);
            island.addAnimalToLocation(x, y, animal);
        }
    }

    private static void addPlantsToIsland(Simulate simulate, List<? extends Plant> plants) {
        for (Plant plant : plants) {
            int x, y;
            x = ThreadLocalRandom.current().nextInt(0, 100);
            y = ThreadLocalRandom.current().nextInt(0, 20);
            simulate.addPlantToLocation(x, y, plant);
        }
    }

    public static void printInitialAnimals() {
        System.out.println("============Початковий стан острова: ============");

        Map<String, Integer> animalCounts = new HashMap<>();

        for (Animal animal : allAnimals) {
            String species = animal.getClass().getSimpleName();
            animalCounts.put(species, animalCounts.getOrDefault(species, 0) + 1);
        }

        System.out.println("Початкова кількість тварин на острові:");
        for (Map.Entry<String, Integer> entry : animalCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        int totalAnimals = animalCounts.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("\nВсього тварин на острові: " + totalAnimals);
    }

    public static void printFinalAnimals() {
        System.out.println("    Стан острова після завершення симуляції:");

        Map<String, Integer> animalCounts = new HashMap<>();

        for (Animal animal : allAnimals) {
            String species = animal.getClass().getSimpleName();
            animalCounts.put(species, animalCounts.getOrDefault(species, 0) + 1);
        }

        System.out.println("    \nЗагальна кількість тварин на острові:");
        for (Map.Entry<String, Integer> entry : animalCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        int totalAnimals = animalCounts.values().stream().mapToInt(Integer::intValue).sum();
        System.out.println("    \nВсього тварин на острові: " + totalAnimals);

        System.out.println("===================================================");
    }
}
