package search;

import java.util.Comparator;
import java.util.List;

public interface ISearchStrategy<T> {
    T search(List<T> instances, Comparator<T> comparator);
}
