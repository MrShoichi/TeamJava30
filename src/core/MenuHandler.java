package core;

import factories.IObjectFactory;
import managers.ArrayManager;
import managers.FileManager;
import managers.ObjectManager;
import utils.InputHandler;
import utils.Messages;

public class MenuHandler<T> {
    private final InputHandler inputValidator;
    private final ObjectManager<T> objectManager;
    private final FileManager<T> fileManager;
    private final ArrayManager<T> arrayManager;
    private final IObjectFactory<T> objectFactory;

    public MenuHandler(IObjectFactory<T> objectFactory) {
        this.inputValidator = new InputHandler();
        this.objectManager = new ObjectManager<>(inputValidator);
        this.arrayManager = new ArrayManager<>(inputValidator);
        this.fileManager = new FileManager<>(new FileHandler());
        this.objectFactory = objectFactory;
    }

    public void runMenu() {
        int choice;
        do {
            choice = inputValidator.safeMenuChoice(Messages.MAIN_MENU, 1, 7);
            try {
                switch (choice) {
                    case 1:
                        fillArray();
                        break;
                    case 2:
                        addCustomObject();
                        break;
                    case 3:
                        arrayManager.sortArray();
                        break;
                    case 4:
                        arrayManager.searchInArray();
                        break;
                    case 5:
                        fileManager.saveArrayToFile(arrayManager.getArray());
                        break;
                    case 6:
                        arrayManager.setArray(fileManager.loadArrayFromFile());
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

    private void fillArray() {
        arrayManager.setArray(objectManager.generateArrayObjects());
        System.out.println("Массив заполнен: " + arrayManager.getArray());
    }


    private void addCustomObject() {
        T newObject = objectFactory.create(inputValidator);
        arrayManager.addInstance(newObject);
        System.out.println("Объект добавлен: " + newObject);
    }



}
