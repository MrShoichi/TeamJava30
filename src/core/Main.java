package core;

import utils.Messages;
import utils.UtilFunctions;


public class Main {
    public static void main(String[] args) {
        InputHandler inputHandler = new InputHandler();
        int choice = inputHandler.safeMenuChoice(Messages.CLASS_SELECTION_MENU, 1, 3);
        System.out.println((char) choice);
        var entity = UtilFunctions.getObjectClassFromChoice(choice);
        new MenuHandler<>(entity).runMenu();
    }
}