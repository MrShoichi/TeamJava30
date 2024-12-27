package factories;

import core.InputHandler;
import models.Animal;
import utils.Messages;

public class AnimalFactory implements IObjectFactory<Animal>{
    @Override
    public Animal create(InputHandler inputHandler) {
        String species = inputHandler.safeStringInput(Messages.PROMPT_SPECIES);
        String eyeColor = inputHandler.safeStringInput(Messages.PROMPT_EYE_COLOR);
        boolean hasFur = inputHandler.safeBooleanInput(Messages.PROMPT_HAS_FUR);

        return new Animal.Builder()
                .setSpecies(species)
                .setEyeColor(eyeColor)
                .setHasFur(hasFur)
                .build();
    }

    @Override
    public Animal createFromRowParts(String[] parts) {
        String species = parts[1].trim();
        String eyeColor = parts[2].trim();
        boolean hasFur = Boolean.parseBoolean(parts[3].trim());
        return new Animal.Builder().setSpecies(species).setEyeColor(eyeColor).setHasFur(hasFur).build();
    }
}
