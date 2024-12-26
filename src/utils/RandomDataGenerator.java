package TeamJava30.src.utils;

import java.util.Random;

public class RandomDataGenerator {
    public static int[] generateRandomArray(int size, int minValue, int maxValue) {
        if (size <= 0 || minValue > maxValue) {
            throw new IllegalArgumentException("Некорректные параметры для генерации массива.");
        }

        int[] randomArray = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            randomArray[i] = random.nextInt(maxValue - minValue + 1) + minValue;
        }
        return randomArray;
    }
}
