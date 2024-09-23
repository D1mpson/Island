package Project;

import Project.optional.Island;
import Project.util.simulate.Simulate;
import static Project.util.simulate.InitializeIsland.initializeIsland;
import static Project.util.simulate.InitializeIsland.printFinalAnimals;

public class Main {
    public static void main(String[] args) {
        Simulate simulate = new Simulate();
        Island island = new Island();

        initializeIsland(island, simulate);

        for (int day = 1; day <= 10; day++) {
            System.out.println("День " + day + " на острові:");
            simulate.simulateDay();
            System.out.println("----------------------------");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        printFinalAnimals();
    }
}
