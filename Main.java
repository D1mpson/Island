import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    public static void main(String[] args) {
        Island island = new Island();
        initializeIsland(island);

        for (int day = 1; day <= 10; day++) {
            System.out.println("День " + day + " на острові:");
            island.simulateDay();
            System.out.println("----------------------------");
        }

        island.printFinalAnimals();
    }
    private static void initializeIsland(Island island) {
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


        for (Wolf wolf : wolves) {
            island.addAnimalToLocation(ThreadLocalRandom.current().nextInt(0, 100),
                    ThreadLocalRandom.current().nextInt(0, 20),
                    wolf);
        }

        for (Boa boa : boas) {
            island.addAnimalToLocation(ThreadLocalRandom.current().nextInt(0, 100),
                    ThreadLocalRandom.current().nextInt(0, 20),
                    boa);
        }

        for (Fox fox : foxes) {
            island.addAnimalToLocation(ThreadLocalRandom.current().nextInt(0, 100),
                    ThreadLocalRandom.current().nextInt(0, 20),
                    fox);
        }

        for (Bear bear : bears) {
            island.addAnimalToLocation(ThreadLocalRandom.current().nextInt(0, 100),
                    ThreadLocalRandom.current().nextInt(0, 20),
                    bear);
        }

        for (Eagle eagle : eagles) {
            island.addAnimalToLocation(ThreadLocalRandom.current().nextInt(0, 100),
                    ThreadLocalRandom.current().nextInt(0, 20),
                    eagle);
        }

        for (Horse horse  : horses) {
            island.addAnimalToLocation(ThreadLocalRandom.current().nextInt(0, 100),
                    ThreadLocalRandom.current().nextInt(0, 20),
                    horse);
        }

        for (Deer deer1 : deer) {
            island.addAnimalToLocation(ThreadLocalRandom.current().nextInt(0, 100),
                    ThreadLocalRandom.current().nextInt(0, 20),
                    deer1);
        }

        for (Rabbit rabbit : rabbits) {
            island.addAnimalToLocation(ThreadLocalRandom.current().nextInt(0, 100),
                    ThreadLocalRandom.current().nextInt(0, 20),
                    rabbit);
        }

        for (Mouse mouse : mice) {
            island.addAnimalToLocation(ThreadLocalRandom.current().nextInt(0, 100),
                    ThreadLocalRandom.current().nextInt(0, 20),
                    mouse);
        }

        for (Goat goat : goats) {
            island.addAnimalToLocation(ThreadLocalRandom.current().nextInt(0, 100),
                    ThreadLocalRandom.current().nextInt(0, 20),
                    goat);
        }

        for (Sheep sheep1 : sheep) {
            island.addAnimalToLocation(ThreadLocalRandom.current().nextInt(0, 100),
                    ThreadLocalRandom.current().nextInt(0, 20),
                    sheep1);
        }

        for (Boar boar : boars) {
            island.addAnimalToLocation(ThreadLocalRandom.current().nextInt(0, 100),
                    ThreadLocalRandom.current().nextInt(0, 20),
                    boar);
        }

        for (Buffalo buffalo1 : buffalo) {
            island.addAnimalToLocation(ThreadLocalRandom.current().nextInt(0, 100),
                    ThreadLocalRandom.current().nextInt(0, 20),
                    buffalo1);
        }

        for (Duck duck : ducks) {
            island.addAnimalToLocation(ThreadLocalRandom.current().nextInt(0, 100),
                    ThreadLocalRandom.current().nextInt(0, 20),
                    duck);
        }

        for (Caterpillar caterpillar : caterpillars) {
            island.addAnimalToLocation(ThreadLocalRandom.current().nextInt(0, 100),
                    ThreadLocalRandom.current().nextInt(0, 20),
                    caterpillar);
        }

        List<Plant> plant = Plant.createPlant(100);

        for (Plant plant1 : plant) {
            for (int i = 0; i < 2000; i++){
                island.addPlantToLocation(ThreadLocalRandom.current().nextInt(0, 100),
                        ThreadLocalRandom.current().nextInt(0, 20),
                        plant1);
            }
        }
    }
}