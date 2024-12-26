package utils;

import java.util.List;

public class UtilFunctions {
    public static String getArrayString(List<?> array) {
        return String.join("\n",
                array
                .stream()
                .map(Object::toString)
                .toList()
        );
    }
}
