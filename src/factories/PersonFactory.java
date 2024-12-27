package factories;

import core.InputHandler;
import models.Animal;
import models.Person;
import utils.Messages;

public class PersonFactory implements IObjectFactory<Person> {
    @Override
    public Person create(InputHandler inputHandler) {
        String gender = inputHandler.safeStringInput(Messages.PROMPT_GENDER);
        int age = inputHandler.safeIntInput(Messages.PROMPT_AGE);
        String fullName = inputHandler.safeStringInput(Messages.PROMPT_FULL_NAME);

        return new Person.Builder()
                .setGender(gender)
                .setAge(age)
                .setFullName(fullName)
                .build();
    }

    @Override
    public Person createFromRowParts(String[] parts) {
        String gender = parts[1].trim();
        int age = Integer.parseInt(parts[2].trim());
        String fullName = parts[3].trim();
        return new Person.Builder().setAge(age).setGender(gender).setFullName(fullName).build();
    }
}
