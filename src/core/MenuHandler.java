package core;

import factories.AnimalFactory;
import factories.BarrelFactory;
import factories.IObjectFactory;
import managers.ArrayManager;
import managers.FileManager;
import managers.ObjectManager;
import randomDataGenerators.AnimalGenerator;
import randomDataGenerators.BarrelGenerator;
import randomDataGenerators.PersonGenerator;
import utils.Entities;
import utils.InputHandler;
import utils.Messages;
import utils.UtilFunctions;

public class MenuHandler<T extends Comparable<T>> {
    private final InputHandler inputValidator;
    private final ObjectManager<T> objectManager;
    private final FileManager<T> fileManager = null;
    private final ArrayManager<T> arrayManager;
    private final IObjectFactory<T> objectFactory;

    public MenuHandler(Entities entity) {
        this.inputValidator = new InputHandler();
        this.objectManager = new ObjectManager<>(inputValidator, entity);
        this.arrayManager = new ArrayManager<>(inputValidator);
        //this.fileManager = new FileManager<>(new FileHandler());
        this.objectFactory = (IObjectFactory<T>) switch (entity) {
            case Entities.BARREL ->  new BarrelFactory();
            case Entities.ANIMAL -> new AnimalFactory();
            case Entities.PERSON -> new PersonGenerator();
        };;
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
        System.out.println("Массив заполнен: " + UtilFunctions.getArrayString(arrayManager.getArray()));
    }


    private void addCustomObject() {
        T newObject = objectFactory.create(inputValidator);
        arrayManager.addInstance(newObject);
        System.out.println("Объект добавлен: " + newObject);
    }

}
