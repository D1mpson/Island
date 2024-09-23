package Project.animals.herbivore;

import Project.util.Herbivore;

import java.util.ArrayList;
import java.util.List;

public class Boar extends Herbivore {

    public Boar() {
        super(400.0, 50, 3, 50.0, 50.0);
    }

    public static List<Boar> createBoar(int quantity) {
        List<Boar> boars = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            boars.add(new Boar());
        }
        return boars;
    }

    @Override
    protected double getEatingChanceHerbivore(Herbivore herbivore) {
        if (herbivore instanceof Mouse){
            return 0.5;
        }
        if (herbivore instanceof Caterpillar){
            return 0.9;
        }
        return 0;
    }

    @Override
    protected double getReproductionChance() {
        return 0.2;
    }
}