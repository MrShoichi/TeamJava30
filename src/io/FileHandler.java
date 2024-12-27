package io;

import factories.IObjectFactory;
import utils.IValidator; // Импортируем валидатор

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class FileHandler<T extends Comparable<T>> implements IFileHandler<T> {
    private final String filePath;
    private final IValidator validator;
    private final IObjectFactory<T> factory;

    public FileHandler(String filePath, IValidator validator, IObjectFactory<T> factory) {
        this.filePath = filePath;
        this.validator = validator;
        this.factory = factory;
    }


    @Override
    public List<T> readFile() throws IOException {
        List<T> instances = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!validator.validateRow(line)) {
                    throw new IOException("Данные в файле некорректны");
                }
                T instance = createInstanceFromCSV(line);
                instances.add(instance);
            }
        }
        catch (InvalidClassException exception) {
            throw new InvalidClassException("Неверный формат объектов");
        }

        return instances;
    }

    @Override
    public void appendFile(List<T> instances) throws IOException {
        File file = new File(filePath);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
            for (T instance : instances) {
                String csvLine = convertInstanceToCSV(instance);
                writer.write(csvLine);
                writer.newLine();
            }
        }
    }

    private String convertInstanceToCSV(T instance) {
        return instance.toString();
    }

    private T createInstanceFromCSV(String row) throws InvalidClassException {
        try {
            String[] rowParts = row.split(";");
            return factory.createFromRowParts(rowParts);
        } catch (Exception e) {
            throw new InvalidClassException("");
        }
    }
}
