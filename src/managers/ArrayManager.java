package managers;

import core.InputHandler;
import models.Animal;
import models.Barrel;
import models.Person;
import search.BinarySearch;
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
            case 1:
                sortingManager.setStrategy(new NormalSort<T>());
                break;
            case 2:
                sortingManager.setStrategy(new EvenOddSort<T>());
                break;
            default:
                throw new IllegalArgumentException("Некорректный выбор сортировки.");
        }

        sortingManager.sort(array);
        System.out.println("Отсортированный массив: " + UtilFunctions.getArrayString(array));
    }



    public void searchInArray(T target) throws IllegalArgumentException {
        if (array.isEmpty()) {
            throw new IllegalArgumentException(Messages.ERROR_EMPTY_ARRAY);
        }

        BinarySearch<T> binarySearch = new BinarySearch<>();

        int index = binarySearch.search(array, target);

        if (index != -1) {
            System.out.println("Элемент найден на позиции: " + index);
        } else {
            System.out.println("Элемент не найден.");
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
