package randomDataGenerators;

import models.Person;
import utils.Constants.PersonAttributes;

import java.util.Random;

public class PersonGenerator implements IGenerator<Person>{
    @Override
    public void fillWithRandomData(Person instance) {

    }

    @Override
    public Person generateInstanceWithRandomData() {
        Random random = new Random();
        String name = PersonAttributes.NAMES.get(random.nextInt(PersonAttributes.NAMES.size()));
        String gender = PersonAttributes.GENDER.get(random.nextInt(PersonAttributes.GENDER.size()));
        int age = random.nextInt(100);

        return new Person.Builder().setFullName(name).setAge(age).setGender(gender).build();
    }
}
