package utils;

import models.Animal;
import models.Barrel;
import models.Person;

import java.util.List;

public interface IValidator {
    boolean validateRow(String row);
}