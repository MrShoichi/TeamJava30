package sorting;

import java.util.Comparator;
import java.util.List;

public interface ISortingStrategy<T> {
    void sort(List<T> instances, Comparator<T> comparator);
}
