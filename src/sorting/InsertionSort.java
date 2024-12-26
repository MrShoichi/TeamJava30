package sorting;

import java.util.Comparator;
import java.util.List;

/**
 * Реализация алгоритма сортировки вставками.
 * Используется в классах-режимах сортировки.
 */
public class InsertionSort<T>{

    public static<T> void sort(List<T> instances, Comparator<T> comparator) {
        if (instances == null || instances.isEmpty()) {
            return;
        }

        for (int i = 1; i < instances.size(); i++) {
            T currentElement = instances.get(i);
            int j = i - 1;

            while (j >= 0 && comparator.compare(instances.get(j), currentElement) > 0) {
                instances.set(j + 1, instances.get(j));
                j--;
            }

            instances.set(j + 1, currentElement);
        }
    }
}
