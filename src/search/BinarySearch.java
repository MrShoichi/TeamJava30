package search;

import java.util.Comparator;
import java.util.List;

public class BinarySearch<T extends Comparable<T>> implements ISearchStrategy<T> {
    @Override
    public int search(List<T> instances, T target) {
        int low = 0;
        int high = instances.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            int comparisonResult = instances.get(mid).compareTo(target);

            if (comparisonResult == 0) {
                return mid;
            } else if (comparisonResult < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
