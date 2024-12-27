package managers;

import core.InputHandler;
import models.Animal;
import models.Barrel;
import models.Person;
import sorting.EvenOddSort;
import sorting.NormalSort;
import utils.Messages;
import utils.UtilFunctions;

import java.util.ArrayList;
import java.util.List;

public class ArrayManager<T extends Comparable<T>> {
    private List<T> array;
    private final InputHandler inputValidator;

    public ArrayManager(InputHandler inputValidator) {
        this.array = new ArrayList<>();
        this.inputValidator = inputValidator;
    }

    public void sortArray() throws IllegalArgumentException {
        if (array.isEmpty()) {
            throw new IllegalArgumentException(Messages.ERROR_EMPTY_ARRAY);
        }
        int sortChoice = inputValidator.safeMenuChoice(Messages.SORTING_MENU, 1, 2);

        SortingManager<T> sortingManager = new SortingManager<>();
        switch (sortChoice) {
            // TODO: Enum для режимов, чтобы не путаться (но не обязательно)
            case 1:
                sortingManager.setStrategy(new NormalSort<T>());
                break;
            case 2:
                sortingManager.setStrategy(new EvenOddSort<T>());
                break;
            default:
                throw new IllegalArgumentException("Некорректный выбор сортировки.");
        }

        //int attributeChoice = inputValidator.safeMenuChoice(Messages.SORTING_ATTRIBUTE_MENU, 1, 3);
        //Comparator<T> comparator = ComparatorSelector.selectComparator(attributeChoice);

        sortingManager.sort(array);
        System.out.println("Отсортированный массив: " + UtilFunctions.getArrayString(array));
    }



    public void searchInArray() throws IllegalArgumentException {
//        if (array.isEmpty()) {
//            throw new IllegalArgumentException(Messages.ERROR_EMPTY_ARRAY);
//        }
//        int attributeChoice = inputValidator.safeMenuChoice(Messages.SORTING_ATTRIBUTE_MENU, 1, 3);

        //Comparator<T> comparator = ComparatorSelector.selectComparator(attributeChoice);
//        T target = getKeyForSearch();
//        BinarySearch<T> binarySearch = new BinarySearch<>();
//
//        int index = binarySearch.search(array, target, comparator);
//
//        if (index != -1) {
//            System.out.println("Элемент найден на позиции: " + index);
//        } else {
//            System.out.println("Элемент не найден.");
//        }
    }

    private Comparable<?> getKeyForSearch() {
        if (array.isEmpty()) {
            throw new IllegalArgumentException(Messages.ERROR_EMPTY_ARRAY);
        }
        System.out.println(Messages.PROMPT_ELEMENT_SEARCH);
        T example = array.getFirst();

        if (example instanceof Barrel) {
            int volume = inputValidator.safeIntInput(Messages.PROMPT_VOLUME);
            return new Barrel.Builder().setVolume(volume).build();
        } else if (example instanceof Person) {
            int age = inputValidator.safeIntInput(Messages.PROMPT_AGE);
            return new Person.Builder().setAge(age).build();
        } else
        if (example instanceof Animal) {
            String species = inputValidator.safeStringInput(Messages.PROMPT_SPECIES);
            return new Animal.Builder().setSpecies(species).build();
        } else {
            throw new IllegalArgumentException("Неизвестный тип объектов для поиска.");
        }
    }



    public void addInstance(T newObject) {
        array.add(newObject);
    }

    public void setArray(List<T> objects) {
        this.array = objects;
    }

    public List<T> getArray() {
        return array;
    }
}
