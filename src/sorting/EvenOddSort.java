package sorting;

import models.SortableByNumber;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Реализация EvenOdd РЕЖИМА сортировки.
 * Поддерживается только для массива класса, реализующего {@link SortableByNumber},
 * иначе массив не сортируется.
 * Алгоритм сортировки {@link InsertionSort}.
 */
public class EvenOddSort<T> implements ISortingStrategy<T> {
    private final Comparator<T> comparator = new EvenOddComparator<>();

    @Override
    public void sort(List<T> instances) {
        if (instances == null || instances.isEmpty()) {
            return;
        }

        if (!(instances.get(0) instanceof SortableByNumber)) {
            return;
        }

        List<Integer> evenIndexes = new ArrayList<>();
        List<T> evenElements = new ArrayList<>();
        for (int i = 0; i < instances.size(); i++) {
            T element = instances.get(i);
            if (element instanceof SortableByNumber) {
                int number = ((SortableByNumber) element).getNumericValue();
                if (number % 2 == 0) {
                    evenIndexes.add(i);
                    evenElements.add(element);
                }
            }
        }

        InsertionSort.sort(evenElements, comparator);

        for (int i = 0; i < evenIndexes.size(); i++) {
            instances.set(evenIndexes.get(i), evenElements.get(i));
        }
    }
}