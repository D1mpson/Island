package Project.animals.herbivore;

import Project.util.Herbivore;

import java.util.ArrayList;
import java.util.List;

public class Mouse extends Herbivore {

    public Mouse() {
        super(0.05, 500, 1, 0.01, 0.01);
    }

    public static List<Mouse> createMouse(int quantity) {
        List<Mouse> mice = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            mice.add(new Mouse());
        }
        return mice;
    }

    @Override
    protected double getEatingChanceHerbivore(Herbivore herbivore) {
        if (herbivore instanceof Caterpillar){
            return 0.9;
        }
        return 0;
    }

    @Override
    protected double getReproductionChance() {
        return 0.6;
    }
}