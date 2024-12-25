package core;

import factories.AnimalFactory;
import factories.BarrelFactory;
import factories.PersonFactory;
import utils.InputHandler;
import utils.Messages;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        int choice = inputHandler.safeMenuChoice(Messages.CLASS_SELECTION_MENU, 1, 3);
        Class<?> selectedClass = getObjectClassFromChoice(choice);
        var menuHandler= switch (selectedClass) {
            case Barrel.class -> new MenuHandler<Barrel>(new BarrelFactory());
            case Person.class -> new MenuHandler<Person>(new PersonFactory());
            case Animal.class -> new MenuHandler<Animal>(new AnimalFactory());
        };
        menuHandler.runMenu();
    }

    private static Class<?> getObjectClassFromChoice(int choice) {
        return switch (choice) {
            case 1 -> Barrel.class;
            case 2 -> Person.class;
            case 3 -> Animal.class;
        };
    }

}