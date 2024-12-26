package utils;

import factories.AnimalFactory;
import factories.BarrelFactory;
import factories.IObjectFactory;
import factories.PersonFactory;
import randomDataGenerators.AnimalGenerator;
import randomDataGenerators.BarrelGenerator;
import randomDataGenerators.IGenerator;
import randomDataGenerators.PersonGenerator;

import java.util.List;

public class UtilFunctions {
    public static String getArrayString(List<?> array) {
        return String.join("\n",
                array
                .stream()
                .map(Object::toString)
                .toList()
        );
    }

    public static Entities getObjectClassFromChoice(int choice) {
        return switch (choice) {
            case 1 -> Entities.BARREL;
            case 2 -> Entities.PERSON;
            case 3 -> Entities.ANIMAL;
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        };
    }

    @SuppressWarnings("unchecked")
    public static <T> IObjectFactory<T> getObjectFactory(Entities entity) {
        var factory = switch (entity) {
            case Entities.BARREL -> new BarrelFactory();
            case Entities.ANIMAL -> new AnimalFactory();
            case Entities.PERSON -> new PersonFactory();
        };

        return (IObjectFactory<T>) factory; // Явное приведение типа
    }

    @SuppressWarnings("unchecked")
    public static <T> IGenerator<T> getObjectGenerator(Entities entity) {
        var factory = switch (entity) {
            case Entities.BARREL -> new BarrelGenerator();
            case Entities.ANIMAL -> new AnimalGenerator();
            case Entities.PERSON -> new PersonGenerator();
        };

        return (IGenerator<T>) factory; // Явное приведение типа
    }
}
