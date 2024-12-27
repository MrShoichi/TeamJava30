package io;

import utils.Validator; // Импортируем валидатор
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileHandler<T> implements IFileHandler<T> {
    private final String filePath;
    private final Validator validator; // Поле для валидатора

    // Измененный конструктор
    public FileHandler(String filePath, Validator validator) {
        this.filePath = filePath;
        this.validator = validator;
    }

    @Override
    public List<T> readFile() throws IOException {
        List<T> instances = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            while (true) {
                try {
                    T instance = (T) ois.readObject();
                    instances.add(instance);
                } catch (IOException e) {
                    break; // Конец файла достигнут
                } catch (ClassNotFoundException e) {
                    throw new IOException("Класс не найден", e);
                }
            }
        }

        // Преобразуем список объектов в массив строк для валидации
        String[] data = instances.stream()
                .map(Object::toString) // Преобразуем объекты в строки
                .toArray(String[]::new);

        // Проверяем валидность данных
        if (!validator.validateArray(data)) {
            throw new IOException("Данные в файле некорректны");
        }

        return instances;
    }

    @Override
    public void appendFile(List<T> instances) throws IOException {
        try (ObjectOutputStream oos = new AppendableObjectOutputStream(new FileOutputStream(filePath, true))) {
            for (T instance : instances) {
                oos.writeObject(instance);
            }
        }
    }

    // Вспомогательный класс для добавления в файл
    private static class AppendableObjectOutputStream extends ObjectOutputStream {
        public AppendableObjectOutputStream(OutputStream out) throws IOException {
            super(out);
        }

        @Override
        protected void writeStreamHeader() throws IOException {
            reset(); // Можно сбрасывать заголовок, чтобы не записывать его каждый раз
        }
    }
}