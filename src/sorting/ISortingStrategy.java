package sorting;

import java.util.List;

public interface ISortingStrategy<T> {
    void sort(List<T> instances);
}
