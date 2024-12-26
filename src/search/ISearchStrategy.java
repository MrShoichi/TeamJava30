package search;

import java.util.Comparator;
import java.util.List;

public interface ISearchStrategy<T extends Comparable<T>> {
    int search(List<T> instances, T target, Comparator<T> comparator);
}
