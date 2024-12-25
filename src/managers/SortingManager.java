package managers;

import sorting.ISortingStrategy;

import java.util.Comparator;
import java.util.List;

public class SortingManager<T> {
    private ISortingStrategy<T> sortingStrategy;
    public void setStrategy(ISortingStrategy<T> sortingStrategy) {
        this.sortingStrategy = sortingStrategy;
    }

    public void sort(List<T> array, Comparator<T> comparator) {
        sortingStrategy.sort(array, comparator);
    }
}
