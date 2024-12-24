package managers;

import search.BinarySearch;
import utils.InputHandler;
import utils.Messages;

import java.util.Comparator;
import java.util.List;

public class ArrayManager {
    private final List<Object> array;
    private final InputHandler inputValidator;

    public ArrayManager(List<Object> array, InputHandler inputValidator) {
        this.array = array;
        this.inputValidator = inputValidator;
    }

    public void sortArray() throws IllegalArgumentException {
        if (array.isEmpty()) {
            throw new IllegalArgumentException(Messages.ERROR_EMPTY_ARRAY);
        }

        int sortChoice = inputValidator.safeMenuChoice(Messages.SORTING_MENU, 1, 2);

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

        System.out.println(Messages.PROMPT_SORT_ATTRIBUTE);
        // TODO сделать выбор компоратора(атрибута для сортировки)
        Comparator<Object> comparator = Comparator.comparing(Object::toString);

        sortingManager.sort(array, comparator);
        System.out.println("Отсортированный массив: " + array);
    }

    public void searchInArray() throws IllegalArgumentException {
        if (array.isEmpty()) {
            throw new IllegalArgumentException(Messages.ERROR_EMPTY_ARRAY);
        }

        String target = inputValidator.safeStringInput(Messages.PROMPT_ELEMENT_SEARCH);
        // TODO сделать выбор компаратора
        BinarySearch<Object> binarySearch = new BinarySearch<>();
        Comparator<Object> comparator = Comparator.comparing(Object::toString);

        int index = binarySearch.search(array, target, comparator);

        if (index != -1) {
            System.out.println("Элемент найден на позиции: " + index);
        } else {
            System.out.println("Элемент не найден.");
        }
    }
}
