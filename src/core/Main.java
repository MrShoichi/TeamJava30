package core;

import factories.AnimalFactory;
import factories.BarrelFactory;
import factories.PersonFactory;
import models.Animal;
import models.Barrel;
import utils.Entities;
import utils.InputHandler;
import utils.Messages;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        int choice = inputHandler.safeMenuChoice(Messages.CLASS_SELECTION_MENU, 1, 3);
        var entity = getObjectClassFromChoice(choice);
        new MenuHandler<>(entity).runMenu();
    }

    private static Entities getObjectClassFromChoice(int choice) {
        return switch (choice) {
            case 1 -> Entities.BARREL;
            case 2 -> Entities.PERSON;
            case 3 -> Entities.ANIMAL;
            default -> throw new IllegalStateException("Unexpected value: " + choice);
        };
    }

}