package sorting;

import models.SortableByNumber;

import java.util.Comparator;
import java.util.List;


/**
 * Реализация EvenOdd РЕЖИМА сортировки.
 * Поддерживается только для классов, реализующих {@link SortableByNumber}
 * Подробнее: {@link EvenOddComparator}
 * Алгоритм сортировки {@link InsertionSort}.
 */
public class EvenOddSort<T> implements ISortingStrategy<T>{
    private final Comparator<T> comparator = new EvenOddComparator<>();

    @Override
    public void sort(List<T> instances) {
        InsertionSort.sort(instances, comparator);
    }
}

