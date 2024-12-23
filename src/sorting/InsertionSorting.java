package sorting;

import java.util.Comparator;
import java.util.List;

/**
 * Реализация сортировки вставками.
 */
public class InsertionSorting<T> implements ISortingStrategy<T>{

    @Override
    public void sort(List<T> instances, Comparator<T> comparator) {
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
