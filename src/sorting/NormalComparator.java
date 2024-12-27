package sorting;

import java.util.Comparator;

/**
 * Компаратор для Normal режима сортировки Comparable объектов
 */
public class NormalComparator<T extends Comparable<T>> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }
}