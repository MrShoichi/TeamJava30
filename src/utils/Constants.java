package utils;

import factories.AnimalFactory;
import factories.BarrelFactory;
import factories.IObjectFactory;
import factories.PersonFactory;

import java.util.List;
import java.util.Map;

public final class Constants {
    public static class BarrelAttributes {
        public static final List<String> materials = List.of("Дерево", "Алюминий", "Железо", "Сталь");
        public static final List<String> storedMaterials = List.of("Вода", "Вино", "Пиво", "Ром");
    }
    public enum Sex {
        Male,
        Female;
    }

}
