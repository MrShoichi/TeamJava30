package utils;


public final class Messages {
    public static final String EXIT_PROGRAM = "Выход из программы.";
    public static final String ERROR_INVALID_CHOICE = "Некорректный выбор. Попробуйте снова.";
    public static final String ERROR_EMPTY_ARRAY = "Массив пуст. Выполните заполнение перед этой операцией.";
    public static final String ERROR_INVALID_ARRAY_SIZE = "Размер массива должен быть больше нуля.";

    public static final String PROMPT_ARRAY_SIZE = "Введите размер массива: ";
    public static final String SUCCESS_ARRAY_SAVED = "Массив успешно сохранен в файл.";
    public static final String SUCCESS_ARRAY_LOADED = "Массив успешно загружен из файла.";

    public static final String PROMPT_VOLUME = "Введите объем: ";
    public static final String PROMPT_CONTENT = "Введите хранимый материал: ";
    public static final String PROMPT_MATERIAL = "Введите материал изготовления: ";

    public static final String PROMPT_GENDER = "Введите пол (мужской/женский): ";
    public static final String PROMPT_AGE = "Введите возраст: ";
    public static final String PROMPT_FULL_NAME = "Введите Полное имя: ";

    public static final String PROMPT_SPECIES = "Введите вид: ";
    public static final String PROMPT_EYE_COLOR = "Введите цвет глаз: ";
    public static final String PROMPT_HAS_FUR = "Есть ли шерсть (да/нет)? ";

    public static final String MAIN_MENU = """
            \n=== Меню ===
            1. Заполнить массив случайными объектами
            2. Добавить кастомный объект в массив
            3. Сортировать массив
            4. Поиск элемента в массиве
            5. Записать массив в файл
            6. Загрузить массив из файла
            7. Вывести массив на экран
            8. Выйти
            Выберите действие:\s""";

    public static final String CLASS_SELECTION_MENU = """
            Выберите тип объекта:
            1. Бочка
            2. Человек
            3. Животное
            Ваш выбор:\s""";

    public static final String SORTING_MENU = """
            Выберите метод сортировки:
            1. Сортировка вставками
            2. Сортировка четных/нечетных элементов
            Ваш выбор:\s""";

    public static final String SORTING_ATTRIBUTE_MENU =
            """
                    Выберите атрибут для сортировки:
                    1. По строковому представлению
                    2. По числовому значению (например, объем или возраст)
                    3. По строковому атрибуту (например, материал или фамилия)""";


    public static final String PROMPT_ELEMENT_SEARCH = "Введите элемент для поиска: ";
}
