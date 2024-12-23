package randomDataGenerators;

public interface IGenerator<T> {
    void fillWithRandomData(T instance);
    T generateRandomInstance();
}
