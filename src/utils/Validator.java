package utils;

import java.util.List;

public class Validator implements utils.IValidator {

    @Override
    public boolean validateRow(String row) {
        if (row == null || row.isEmpty() || row.split(";").length != 3) {
            return false;
        }

        String[] parts = row.split(";");
        String name = parts[0].trim();
        String gender = parts[1].trim();
        String ageStr = parts[2].trim();

        if (name.isEmpty()) {
            return false;
        }

        if (!gender.equalsIgnoreCase("Мужской") && !gender.equalsIgnoreCase("Женский")) {
            return false;
        }


        try {
            int age = Integer.parseInt(ageStr);
            if (age <= 0) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }


    @Override
    public boolean validateFileFormat(List<String> rows) {
        if (rows == null || rows.isEmpty()) {
            return false;
        }

        for (String row : rows) {
            if (!validateRow(row)) {
                return false;
            }
        }
        return true;
    }
}


