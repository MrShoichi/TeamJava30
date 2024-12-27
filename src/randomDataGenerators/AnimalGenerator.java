package randomDataGenerators;

import models.Animal;
import utils.Constants.AnimalAttributes;

import java.util.Random;

public class AnimalGenerator implements IGenerator<Animal> {
    @Override
    public void fillWithRandomData(Animal instance) {

    }

    @Override
    public Animal generateInstanceWithRandomData() {
        Random random = new Random();
        String eyeColor = AnimalAttributes.EYE_COLORS.get(random.nextInt(AnimalAttributes.EYE_COLORS.size()));
        String species = AnimalAttributes.SPECIES.get(random.nextInt(AnimalAttributes.SPECIES.size()));
        boolean hasFur = random.nextBoolean();
        return new Animal.Builder().setEyeColor(eyeColor).setSpecies(species).setHasFur(hasFur).build();
    }
}

