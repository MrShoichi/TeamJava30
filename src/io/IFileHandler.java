package io;

import java.util.List;

public interface IFileHandler<T> {
    List<T> readFile();
    void appendFile(List<T> instances);
}
