package sorting;

import models.SortableByNumber;
import java.util.Comparator;

/**
 * Компаратор, который сортирует объекты, реализующие {@link SortableByNumber},
 * на основе их числовых значений.
 *
 * Правила сортировки:
 * - Чётные числа сортируются в порядке возрастания.
 * - Нечётные числа и объекты, которые не реализуют {@link SortableByNumber},
 * остаются на своих местах.
*/
public class EvenOddComparator<T> implements Comparator<T> {
    @Override
    public int compare(T o1, T o2) {

        if (o1 instanceof SortableByNumber && o2 instanceof SortableByNumber) {
            int value1 = ((SortableByNumber) o1).getNumericValue();
            int value2 = ((SortableByNumber) o2).getNumericValue();

            // Чётные числа сортируются в порядке возрастания
            if (value1 % 2 == 0 && value2 % 2 == 0) {
                return Integer.compare(value1, value2);
            }

            // Если одно из чисел нечётное — оставляем их на местах
            return 0;
        }

        // Если объекты не реализуют SortableByNumber, оставляем их на местах
        return 0;
    }
}