package managers;

import core.InputHandler;
import randomDataGenerators.IGenerator;
import utils.Entities;
import utils.Messages;
import utils.UtilFunctions;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ObjectManager<T extends Comparable<T>> {
    private final InputHandler inputHandler;
    private final IGenerator<T> generator;
    public ObjectManager(InputHandler inputValidator, Entities entity) {
        this.inputHandler = inputValidator;
        generator = UtilFunctions.getObjectGenerator(entity);
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
