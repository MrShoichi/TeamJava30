package utils;

import java.util.List;

public interface IValidator {
    boolean validateRow(String row);
    boolean validateFileFormat(List<String> rows);
}