package core;

import io.IFileHandler;
import randomDataGenerators.IGenerator;
import search.BinarySearch;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MenuHandler {
    private final Scanner scanner;
    private List<Object> array;
    private Class<?> objectType;
    private final IFileHandler<Object> fileHandler; // интерфейс для работы с файлами

    public MenuHandler(IFileHandler<Object> fileHandler) {
        this.scanner = new Scanner(System.in);
        this.array = new ArrayList<>();
        this.fileHandler = fileHandler; // Инициализируем интерфейс для работы с файлами
    }

    public void runMenu() {
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            try {
                switch (choice) {
                    case 1:
                        fillArray();
                        break;
                    case 2:
                        addCustomObject();
                        break;
                    case 3:
                        sortArray();
                        break;
                    case 4:
                        searchInArray();
                        break;
                    case 5:
                        saveArrayToFile();
                        break;
                    case 6:
                        loadArrayFromFile();
                        break;
                    case 7:
                        System.out.println("Выход из программы.");
                        break;
                    default:
                        throw new IllegalArgumentException("Некорректный выбор. Попробуйте снова.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Неизвестная ошибка: " + e.getMessage());
            }

        } while (choice != 7);
    }

    private static void showMenu() {
        System.out.println("\n=== Меню ===");
        System.out.println("1. Заполнить массив случайными объектами");
        System.out.println("2. Добавить кастомный объект в массив");
        System.out.println("3. Сортировать массив");
        System.out.println("4. Поиск элемента в массиве");
        System.out.println("5. Записать массив в файл");
        System.out.println("6. Загрузить массив из файла");
        System.out.println("7. Выйти");
        System.out.print("Выберите действие: ");
    }

    private void fillArray() throws IllegalArgumentException {
        System.out.print("Введите размер массива: ");
        int size = scanner.nextInt();

        IGenerator<?> generator = selectGenerator();
        if (generator == null) {
            throw new IllegalArgumentException("Некорректный выбор генератора.");
        }

        array = Stream.generate(generator::generateInstanceWithRandomData)
                .limit(size)
                .collect(Collectors.toList());
        System.out.println("Массив заполнен: " + array);
    }

    private IGenerator<?> selectGenerator() {
        showClassesMenu();
        int choice = scanner.nextInt();
        return switch (choice) {
            case 1 -> new BarrelGenerator();
            case 2 -> new PersonGenerator();
            case 3 -> new AnimalGenerator();
            default -> {
                System.out.println("Некорректный выбор.");
                selectGenerator();
                // yield null;
            }
        };
    }

    private void addCustomObject() throws IllegalArgumentException {
        showClassesMenu();
        int choice = scanner.nextInt();

        if (!isValidClassChoice(choice)) {
            throw new IllegalArgumentException("Ошибка: в массив можно добавлять только объекты типа " + objectType.getSimpleName());
        }

        switch (choice) {
            case 1 -> addBarrel();
            case 2 -> addPerson();
            case 3 -> addAnimal();
            default -> throw new IllegalArgumentException("Некорректный выбор.");
        }
    }

    private boolean isValidClassChoice(int choice) throws IllegalArgumentException {
        Class<?> newObjectType = getObjectClassFromChoice(choice);

        if (newObjectType == null) {
            throw new IllegalArgumentException("Некорректный выбор типа объекта.");
        }

        if (objectType == null || objectType.equals(newObjectType)) {
            objectType = newObjectType;
            return true;
        }

        return false;
    }

    private Class<?> getObjectClassFromChoice(int choice) {
        return switch (choice) {
            case 1 -> Barrel.class;
            case 2 -> Person.class;
            case 3 -> Animal.class;
            default -> null;
        };
    }

    private static void showClassesMenu() {
        System.out.println("Выберите тип объекта:");
        System.out.println("1. Бочка");
        System.out.println("2. Человек");
        System.out.println("3. Животное");
        System.out.print("Ваш выбор: ");
    }

    private void addBarrel() {
        try {
            System.out.print("Введите объем: ");
            double volume = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Введите хранимый материал: ");
            String content = scanner.nextLine();
            System.out.print("Введите материал изготовления: ");
            String material = scanner.nextLine();

            Barrel barrel = new Barrel.Builder()
                    .setVolume(volume)
                    .setContent(content)
                    .setMaterial(material)
                    .build();

            array.add(barrel);
            System.out.println("Бочка добавлена: " + barrel);
        } catch (Exception e) {
            System.out.println("Ошибка при добавлении бочки: " + e.getMessage());
        }
    }

    private void addPerson() {
        try {
            System.out.print("Введите пол: ");
            String gender = scanner.next();
            System.out.print("Введите возраст: ");
            int age = scanner.nextInt();
            System.out.print("Введите фамилию: ");
            String lastName = scanner.next();

            Person person = new Person.Builder()
                    .setGender(gender)
                    .setAge(age)
                    .setLastName(lastName)
                    .build();

            array.add(person);
            System.out.println("Человек добавлен: " + person);
        } catch (Exception e) {
            System.out.println("Ошибка при добавлении человека: " + e.getMessage());
        }
    }

    private void addAnimal() {
        try {
            System.out.print("Введите вид: ");
            String species = scanner.next();
            System.out.print("Введите цвет глаз: ");
            String eyeColor = scanner.next();
            System.out.print("Есть ли шерсть (true/false): ");
            boolean hasFur = scanner.nextBoolean();

            Animal animal = new Animal.Builder()
                    .setSpecies(species)
                    .setEyeColor(eyeColor)
                    .setHasFur(hasFur)
                    .build();

            array.add(animal);
            System.out.println("Животное добавлено: " + animal);
        } catch (Exception e) {
            System.out.println("Ошибка при добавлении животного: " + e.getMessage());
        }
    }

    private void sortArray() throws IllegalArgumentException {
        if (array.isEmpty()) {
            throw new IllegalArgumentException("Массив пуст. Заполните его сначала.");
        }

        System.out.println("Выберите метод сортировки:");
        System.out.println("1. Сортировка вставками");
        System.out.println("2. Сортировка четных/нечетных элементов");
        System.out.print("Ваш выбор: ");
        int sortChoice = scanner.nextInt();

        SortingManager sortingManager = new SortingManager();
        switch (sortChoice) {
            case 1:
                sortingManager.setStrategy(new sorting.GenericInsertionSort<>());
                break;
            case 2:
                sortingManager.setStrategy(new sorting.EvenOddSort<>());
                break;
            default:
                throw new IllegalArgumentException("Некорректный выбор сортировки.");
        }

        System.out.println("Введите атрибут объектов для сравнения: ");
        // TODO сделать выбор компоратора(атрибута для сортировки)
        Comparator<Object> comparator = Comparator.comparing(Object::toString);

        sortingManager.sort(array, comparator);
        System.out.println("Отсортированный массив: " + array);
    }

    private void searchInArray() throws IllegalArgumentException {
        if (array.isEmpty()) {
            throw new IllegalArgumentException("Массив пуст. Заполните его сначала.");
        }

        System.out.print("Введите элемент для поиска: ");
        scanner.nextLine();
        String target = scanner.nextLine();

        BinarySearch<Object> binarySearch = new BinarySearch<>();
        Comparator<Object> comparator = Comparator.comparing(Object::toString);

        int index = binarySearch.search(array, target, comparator);

        if (index != -1) {
            System.out.println("Элемент найден на позиции: " + index);
        } else {
            System.out.println("Элемент не найден.");
        }
    }

    private void saveArrayToFile() throws IOException {
        if (array.isEmpty()) {
            throw new IllegalArgumentException("Массив пуст. Заполните его сначала.");
        }

        fileHandler.appendFile(array);
        System.out.println("Массив успешно сохранен в файл.");
    }

    private void loadArrayFromFile() throws IOException {
        array = fileHandler.readFile();
        System.out.println("Массив успешно загружен из файла.");
    }
}
