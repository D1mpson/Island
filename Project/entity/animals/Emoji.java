package Project.entity.animals;

import Project.services.Animal;
import Project.entity.animals.herbivore.*;
import Project.entity.animals.predator.*;

public class Emoji {
    public String getEmoji(Animal animal) {
        if (animal instanceof Wolf) return "🐺";
        if (animal instanceof Bear) return "🐻";
        if (animal instanceof Horse) return "🐎";
        if (animal instanceof Deer) return "🦌";
        if (animal instanceof Boar) return "🐗";
        if (animal instanceof Sheep) return "🐑";
        if (animal instanceof Goat) return "🐐";
        if (animal instanceof Boa) return "🐍";
        if (animal instanceof Fox) return "🦊";
        if (animal instanceof Eagle) return "🦅";
        if (animal instanceof Rabbit) return "🐇";
        if (animal instanceof Duck) return "🦆";
        if (animal instanceof Mouse) return "🐁";
        if (animal instanceof Caterpillar) return "🐛";
        if (animal instanceof Buffalo) return "🐃";
        return "🦓";
    }
}
