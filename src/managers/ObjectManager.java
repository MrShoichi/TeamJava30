package managers;

import core.MenuHandler;
import factories.AnimalFactory;
import factories.BarrelFactory;
import factories.PersonFactory;
import models.Barrel;
import randomDataGenerators.AnimalGenerator;
import randomDataGenerators.BarrelGenerator;
import randomDataGenerators.IGenerator;
import randomDataGenerators.PersonGenerator;
import utils.Entities;
import utils.InputHandler;
import utils.Messages;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ObjectManager<T> {
    private final InputHandler inputHandler;
    IGenerator<T> generator;
    public ObjectManager(InputHandler inputValidator, Entities entity) {
        this.inputHandler = inputValidator;
        generator = (IGenerator<T>) switch (entity) {
            case Entities.BARREL -> new BarrelGenerator();
            case Entities.ANIMAL -> new AnimalGenerator();
            case Entities.PERSON -> new PersonGenerator();
        };
    }

    public List<T> generateArrayObjects() {
        int size = inputHandler.safeIntInput(Messages.PROMPT_ARRAY_SIZE);
        if (size <= 0) {
            throw new IllegalArgumentException(Messages.ERROR_INVALID_ARRAY_SIZE);
        }
        if (generator == null) {
            throw new IllegalArgumentException(Messages.ERROR_INVALID_CHOICE);
        }

        return Stream.generate(generator::generateInstanceWithRandomData)
                .limit(size)
                .collect(Collectors.toList());
    }

}
