package managers;

import factories.IObjectFactory;
import randomDataGenerators.IGenerator;
import utils.Constants;
import utils.InputHandler;
import utils.Messages;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ObjectManager<T> {
    private final InputHandler inputHandler;
    public ObjectManager(InputHandler inputValidator) {
        this.inputHandler = inputValidator;
    }

    public List<T> generateArrayObjects() {
        int size = inputHandler.safeIntInput(Messages.PROMPT_ARRAY_SIZE);
        if (size <= 0) {
            throw new IllegalArgumentException(Messages.ERROR_INVALID_ARRAY_SIZE);
        }
        IGenerator<T> generator = selectGenerator();
        if (generator == null) {
            throw new IllegalArgumentException(Messages.ERROR_INVALID_CHOICE);
        }

        return Stream.generate(generator::generateInstanceWithRandomData)
                .limit(size)
                .collect(Collectors.toList());
    }

    private IGenerator<T> selectGenerator() {
        int choice = inputHandler.safeMenuChoice(Messages.CLASS_SELECTION_MENU, 1, 3);
        return switch (choice) {
            case 1 -> new BarrelGenerator();
            case 2 -> new PersonGenerator();
            case 3 -> new AnimalGenerator();
            default -> null;
        };
    }
}
