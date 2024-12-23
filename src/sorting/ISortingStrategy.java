package sorting;

import java.util.Comparator;
import java.util.List;

/**
 * Интерфейс стратегии сортировки.
 * Определяет общий контракт для сортировок.
 *
 * @param <T> тип объектов, которые будут сортироваться.
 */
public interface ISortingStrategy<T> {

    /**
     * Сортирует список объектов с использованием компаратора.
     *
     * @param instances список объектов для сортировки.
     * @param comparator компаратор, определяющий порядок сортировки объектов.
     */
    void sort(List<T> instances, Comparator<T> comparator);
}
