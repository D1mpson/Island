package Project;

import Project.optional.Island;
import Project.services.simulate.Simulate;

import static Project.services.simulate.InitializeIsland.*;

public class Main {
    public static void main(String[] args) {
        Simulate simulate = new Simulate();
        Island island = new Island();

        initializeIsland(island, simulate);
        printInitialAnimals();

        for (int day = 1; day <= 1; day++) {
            System.out.println("================= День " + day + " =================");
            simulate.simulateDay();
            System.out.println("===================================================");

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        printFinalAnimals();
    }
}
