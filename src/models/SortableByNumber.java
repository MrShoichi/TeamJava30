package models;

/**
 * Интерфейс для классов, которые могут предоставлять числовое значение.
 * Реализация интерфейса требуется для сортировки с EvenOddComparator.
 */
public interface SortableByNumber {
    int getNumericValue();
}
