package utils;

import models.Animal;
import models.Barrel;
import models.Person;

import java.util.List;

public class Validator implements IValidator{
    public boolean validateRow(String line) {
        String[] parts = line.split(";");
        if (parts.length < 2) return false;

        String type = parts[0].trim();

        return switch (type) {
            case "Animal" -> parts.length == 4 && validateAnimal(parts);
            case "Barrel" -> parts.length == 4 && validateBarrel(parts);
            case "Person" -> parts.length == 4 && validatePerson(parts);
            default -> false;
        };
    }

    private static boolean validateAnimal(String[] parts) {
        String species = parts[1].trim();
        String eyeColor = parts[2].trim();
        String hasFur = parts[3].trim();

        return !species.isEmpty() && !eyeColor.isEmpty() && (hasFur.equals("true") ||  hasFur.equals("false"));
    }

    private static boolean validateBarrel(String[] parts) {
        String storedMaterial = parts[1].trim();
        String material = parts[3].trim();
        String volume = parts[3].trim();

        return !storedMaterial.isEmpty() && !material.isEmpty() && isInteger(volume);
    }

    private static boolean validatePerson(String[] parts) {
        String gender = parts[1].trim();
        String age = parts[2].trim();
        String fullName = parts[3].trim();

        return (gender.equals("Male") || gender.equals("Female")) && isInteger(age) && !fullName.isEmpty();
    }

    private static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

