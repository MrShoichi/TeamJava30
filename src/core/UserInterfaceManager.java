package core;

import managers.ArrayManager;
import managers.FileManager;
import managers.ObjectManager;
import utils.InputHandler;
import utils.Messages;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInterfaceManager {
    private final Scanner scanner;
    private final InputHandler inputValidator;
    private final ObjectManager objectManager;
    private final FileManager fileManager;
    private final ArrayManager arrayManager;
    private final List<Object> array;

    public UserInterfaceManager() {
        this.scanner = new Scanner(System.in);
        this.inputValidator = new InputHandler(scanner);
        this.objectManager = new ObjectManager(inputValidator);
        this.array = new ArrayList<>();
        this.arrayManager = new ArrayManager(this.array, inputValidator);
        this.fileManager = new FileManager(new FileHandler());
    }

    public void runMenu() {
        int choice;
        do {
            choice = inputValidator.safeMenuChoice(Messages.MAIN_MENU, 1, 7);
            try {
                switch (choice) {
                    case 1:
                        objectManager.fillArray();
                        break;
                    case 2:
                        objectManager.addCustomObject();
                        break;
                    case 3:
                        arrayManager.sortArray();
                        break;
                    case 4:
                        arrayManager.searchInArray();
                        break;
                    case 5:
                        fileManager.saveArrayToFile();
                        break;
                    case 6:
                        fileManager.loadArrayFromFile();
                        break;
                    case 7:
                        System.out.println(Messages.EXIT_PROGRAM);
                        break;
                    default:
                        throw new IllegalArgumentException("Некорректный выбор. Попробуйте снова.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Неизвестная ошибка: " + e.getMessage());
            }

        } while (choice != 7);
    }



}
