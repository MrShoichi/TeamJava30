package core;

import factories.IObjectFactory;
import io.FileHandler;
import managers.ArrayManager;
import managers.FileManager;
import managers.ObjectManager;
import utils.Entities;
import utils.Messages;
import utils.UtilFunctions;
import utils.Validator;

public class MenuHandler<T extends Comparable<T>> {
    private final InputHandler inputValidator;
    private final ObjectManager<T> objectManager;
    private final FileManager<T> fileManager;
    private final ArrayManager<T> arrayManager;
    private final IObjectFactory<T> objectFactory;

    public MenuHandler(Entities entity) {
        this.inputValidator = new InputHandler();
        this.objectManager = new ObjectManager<>(inputValidator, entity);
        this.arrayManager = new ArrayManager<>(inputValidator);
        this.objectFactory = UtilFunctions.getObjectFactory(entity);
        this.fileManager = new FileManager<>(new FileHandler<T>("src/resources/barrels.csv",
                new Validator(),
                objectFactory));

    }

    public void runMenu() {
        while (true) {
            var choice = inputValidator.safeMenuChoice(Messages.MAIN_MENU, 1, 8);
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
                        arrayManager.searchInArray(objectFactory.create(inputValidator));
                        break;
                    case 5:
                        fileManager.saveArrayToFile(arrayManager.getArray());
                        break;
                    case 6:
                        arrayManager.setArray(fileManager.loadArrayFromFile());
                        break;
                    case 7:
                        System.out.println(UtilFunctions.getArrayString(arrayManager.getArray()));
                        break;
                    case 8:
                        System.out.println(Messages.EXIT_PROGRAM);
                        return;
                    default:
                        throw new IllegalArgumentException("Некорректный выбор. Попробуйте снова.");
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Неизвестная ошибка: " + e.getMessage());
            }
        }
    }

    private void fillArray() {
        arrayManager.setArray(objectManager.generateArrayObjects());
        System.out.println("Массив заполнен: " + UtilFunctions.getArrayString(arrayManager.getArray()));
    }


    private void addCustomObject() {
        T newObject = objectFactory.create(inputValidator);
        arrayManager.addInstance(newObject);
        System.out.println("Объект добавлен: " + newObject);
    }

}
