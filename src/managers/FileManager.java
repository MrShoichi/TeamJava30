package managers;

import io.IFileHandler;
import utils.Messages;

import java.io.IOException;

public class FileManager {
    private final IFileHandler<Object> fileHandler;

    public FileManager(IFileHandler<Object> fileHandler) {
        this.fileHandler = fileHandler;
    }

    public void saveArrayToFile() throws IOException {
        if (fileHandler == null || fileHandler.readFile().isEmpty()) {
            throw new IllegalArgumentException(Messages.ERROR_EMPTY_ARRAY);
        }

        fileHandler.appendFile(fileHandler.readFile());
        System.out.println(Messages.SUCCESS_ARRAY_SAVED);
    }

    public void loadArrayFromFile() throws IOException {
        var array = fileHandler.readFile();
        System.out.println(Messages.SUCCESS_ARRAY_LOADED);
    }
}
