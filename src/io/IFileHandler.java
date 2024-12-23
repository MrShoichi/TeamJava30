package io;

import java.io.IOException;
import java.util.List;

public interface IFileHandler<T> {
    List<T> readFile() throws IOException;
    void appendFile(List<T> instances) throws IOException;
}
