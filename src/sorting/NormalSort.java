package sorting;

import models.SortableByNumber;

import java.util.Comparator;
import java.util.List;

/**
 * Реализация Normal РЕЖИМА сортировки.
 * Поддерживается только для классов, реализующих {@link Comparable}
 * Алгоритм сортировки {@link InsertionSort}.
 */
public class NormalSort<T extends Comparable<T>> implements ISortingStrategy<T>{
    private final Comparator<T> comparator = new ComparableComparator<>();

    @Override
    public void sort(List<T> instances) {
        InsertionSort.sort(instances, comparator);
    }
}
