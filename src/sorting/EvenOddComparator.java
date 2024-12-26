package sorting;

import models.SortableByNumber;
import java.util.Comparator;

/**
 * Компаратор для сортировки элементов классов, реализующих
 * {@link SortableByNumber}.
 * Если объекты не реализуют SortingByNumber, считаем их равными
*/
public class EvenOddComparator<T> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {
        if (o1 instanceof SortableByNumber && o2 instanceof SortableByNumber) {
            int num1 = ((SortableByNumber) o1).getNumericValue();
            int num2 = ((SortableByNumber) o2).getNumericValue();
            return Integer.compare(num1, num2);
        }
        return 0;
    }
}