package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public interface IFileHandler<T> {
    List<T> readFile() throws IOException;
    void appendFile(List<T> instances) throws IOException;
}