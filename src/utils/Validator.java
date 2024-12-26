package TeamJava30.src.utils;

import java.util.Arrays;

public class Validator {
    public static boolean validateArray(String[] data) {
        return Arrays.stream(data).allMatch(utils.Validator::isNumeric);
    }

    private static boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
