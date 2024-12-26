package factories;

import utils.InputHandler;
import utils.Messages;

public class PersonFactory implements IObjectFactory<Person> {
    @Override
    public Person create(InputHandler inputHandler) {
        String gender = inputHandler.safeStringInput(Messages.PROMPT_GENDER);
        int age = inputHandler.safeIntInput(Messages.PROMPT_AGE);
        String lastName = inputHandler.safeStringInput(Messages.PROMPT_LAST_NAME);

        return new Person.Builder()
                .setGender(gender)
                .setAge(age)
                .setLastName(lastName)
                .build();
    }
}
