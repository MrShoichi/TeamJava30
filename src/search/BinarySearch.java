package search;

import java.util.Comparator;
import java.util.List;

public class BinarySearch<T extends Comparable<T>> implements ISearchStrategy<T> {
    @Override
    public int search(List<T> instances, T target, Comparator<T> comparator) {
        return -1;
    }
}
