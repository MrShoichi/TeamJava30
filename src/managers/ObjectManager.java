package managers;

import randomDataGenerators.IGenerator;
import utils.InputHandler;
import utils.Messages;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ObjectManager {
    private final InputHandler inputValidator;
    private List<Object> array;
    private Class<?> objectType;

    public ObjectManager(InputHandler inputValidator) {
        this.inputValidator = inputValidator;
        this.array = new ArrayList<>();
    }

    public void fillArray() throws IllegalArgumentException {
        int size = inputValidator.safeIntInput(Messages.PROMPT_ARRAY_SIZE);
        if (size <= 0) {
            throw new IllegalArgumentException(Messages.ERROR_INVALID_ARRAY_SIZE);
        }
        IGenerator<?> generator = selectGenerator();
        if (generator == null) {
            throw new IllegalArgumentException(Messages.ERROR_INVALID_CHOICE);
        }

        array = Stream.generate(generator::generateInstanceWithRandomData)
                .limit(size)
                .collect(Collectors.toList());
        System.out.println("Массив заполнен: " + array);
    }

    public void addCustomObject() throws IllegalArgumentException {
        int choice = inputValidator.safeMenuChoice(Messages.CLASS_SELECTION_MENU, 1, 3);
        if (!isValidClassChoice(choice)) {
            throw new IllegalArgumentException("Ошибка: в массив можно добавлять только объекты типа " + objectType.getSimpleName());
        }

        switch (choice) {
            case 1 -> addBarrel();
            case 2 -> addPerson();
            case 3 -> addAnimal();
            default -> throw new IllegalArgumentException(Messages.ERROR_INVALID_CHOICE);
        }
    }

    private boolean isValidClassChoice(int choice) {
        Class<?> newObjectType = getObjectClassFromChoice(choice);
        if (newObjectType == null) {
            throw new IllegalArgumentException(Messages.ERROR_INVALID_CLASS);
        }
        if (objectType == null || objectType.equals(newObjectType)) {
            objectType = newObjectType;
            return true;
        }
        return false;
    }

    private void addBarrel() {
        addObject(Messages.PROMPT_BARREL, _ -> {
            double volume = inputValidator.safeDoubleInput(Messages.PROMPT_VOLUME);
            String content = inputValidator.safeStringInput(Messages.PROMPT_CONTENT);
            String material = inputValidator.safeStringInput(Messages.PROMPT_MATERIAL);

            Barrel barrel = new Barrel.Builder()
                    .setVolume(volume)
                    .setContent(content)
                    .setMaterial(material)
                    .build();
            array.add(barrel);
            System.out.println("Бочка добавлена: " + barrel);
        });
    }

    private void addObject(String prompt, Runnable builderAction) {
        try {
            System.out.println(prompt);
            builderAction.run();
        } catch (Exception e) {
            System.out.println("Ошибка при добавлении объекта: " + e.getMessage());
        }
    }

    private void addPerson() {
        addObject(Messages.PROMPT_PERSON, _ -> {
            String gender = inputValidator.safeStringInput(Messages.PROMPT_GENDER);
            int age = inputValidator.safeIntInput(Messages.PROMPT_AGE);
            String lastName = inputValidator.safeStringInput(Messages.PROMPT_LAST_NAME);

            Person person = new Person.Builder()
                    .setGender(gender)
                    .setAge(age)
                    .setLastName(lastName)
                    .build();
            array.add(person);
            System.out.println("Человек добавлен: " + person);
        });
    }

    private void addAnimal() {
        addObject(Messages.PROMPT_PERSON, _ -> {
            String species = inputValidator.safeStringInput(Messages.PROMPT_SPECIES);
            String eyeColor = inputValidator.safeStringInput(Messages.PROMPT_EYE_COLOR);
            boolean hasFur = inputValidator.safeBooleanInput(Messages.PROMPT_HAS_FUR);

            Animal animal = new Animal.Builder()
                    .setSpecies(species)
                    .setEyeColor(eyeColor)
                    .setHasFur(hasFur)
                    .build();
            array.add(animal);
            System.out.println("Животное добавлено: " + animal);
        });
    }

    private Class<?> getObjectClassFromChoice(int choice) {
        return switch (choice) {
            case 1 -> Barrel.class;
            case 2 -> Person.class;
            case 3 -> Animal.class;
            default -> null;
        };
    }

    private IGenerator<?> selectGenerator() {
        int choice = inputValidator.safeMenuChoice(Messages.CLASS_SELECTION_MENU, 1, 3);
        return switch (choice) {
            case 1 -> new BarrelGenerator();
            case 2 -> new PersonGenerator();
            case 3 -> new AnimalGenerator();
            default -> null;
        };
    }
}
