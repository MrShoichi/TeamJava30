package managers;

import sorting.ISortingStrategy;

import java.util.Comparator;
import java.util.List;

/**
 * Для паттерна "Стратегия".
 * Позволяет задать стратегию сортировки и выполнить её на переданном списке.
 */
public class SortingManager<T> {
    private ISortingStrategy<T> sortingStrategy;

    public void setStrategy(ISortingStrategy<T> sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void sort(List<T> array) {
        if (sortingStrategy != null) {
            sortingStrategy.sort(array);
        } else {
            throw new IllegalStateException("Стратегия сортировки не установлена");
        }
    }
}
