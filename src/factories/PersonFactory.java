package factories;

import models.Person;
import utils.InputHandler;
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
}
