package managers;

import models.Animal;
import models.Barrel;
import models.Person;
import utils.Messages;

import java.util.Comparator;

public class ComparatorSelector {
    public static <T> Comparator<T> selectComparator(int attributeChoice) {
        return switch (attributeChoice) {
            case 1 -> Comparator.comparing(Object::toString);
            case 2 -> Comparator.comparing(obj -> {
                if (obj instanceof Barrel barrel) {
                    return barrel.getVolume();
                } else if (obj instanceof Person person) {
                    return person.getAge();
                } else if (obj instanceof Animal animal) {
                    return animal.isHasFur() ? 1: 0;
                }
                throw new IllegalArgumentException("Неизвестный объект для сравнения.");
            });
            case 3 -> Comparator.comparing(obj -> {
                if (obj instanceof Barrel barrel) {
                    return barrel.getMaterial();
                } else if (obj instanceof Person person) {
                    return person.getFullName();
                } else if (obj instanceof Animal animal) {
                    return animal.getEyeColor();
                }
                throw new IllegalArgumentException("Неизвестный объект для сравнения.");
            });
            default -> throw new IllegalArgumentException("Некорректный выбор атрибута.");
        };
    }

}
