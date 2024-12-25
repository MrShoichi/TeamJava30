package managers;

import io.IFileHandler;
import utils.Messages;

import java.io.IOException;
import java.util.List;

public class FileManager<T> {
    private final IFileHandler<T> fileHandler;

    public FileManager(IFileHandler<T> fileHandler) {
        this.fileHandler = fileHandler;
    }

    public void saveArrayToFile(List<T> array) throws IOException {
        if (fileHandler == null || fileHandler.readFile().isEmpty()) {
            throw new IllegalArgumentException(Messages.ERROR_EMPTY_ARRAY);
        }

        fileHandler.appendFile(array);
        System.out.println(Messages.SUCCESS_ARRAY_SAVED);
    }

    public List<T> loadArrayFromFile() throws IOException {
        var array = fileHandler.readFile();
        System.out.println(Messages.SUCCESS_ARRAY_LOADED);
        return array;
    }
}
