package utils;

import java.util.List;

public final class Constants {
    public static class BarrelAttributes {
        public static final List<String> MATERIALS = List.of("Дерево", "Алюминий", "Железо", "Сталь");
        public static final List<String> IN_MATERIALS = List.of("Вода", "Вино", "Пиво", "Ром");
    }
    public static class AnimalAttributes {
        public static final List<String> EYE_COLORS = List.of("Зеленый", "Голубой", "Карий", "Красный");
        public static final List<String> SPECIES = List.of("Хищник", "Травоядное", "Водное");
    }
    public static class PersonAttributes {
        public static final List<String> NAMES = List.of("Джон", "Алексей", "Юрий", "Влад");
        public static final List<String> GENDER = List.of("Мужской", "Женский");
    }

}
