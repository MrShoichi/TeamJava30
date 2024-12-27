package factories;

import core.InputHandler;
import models.Barrel;
import utils.Messages;

public class BarrelFactory implements IObjectFactory<Barrel> {
    @Override
    public Barrel create(InputHandler inputHandler) {
        int volume = inputHandler.safeIntInput(Messages.PROMPT_VOLUME);
        String inMaterial = inputHandler.safeStringInput(Messages.PROMPT_CONTENT);
        String material = inputHandler.safeStringInput(Messages.PROMPT_MATERIAL);

        return new Barrel.Builder()
                .setVolume(volume)
                .setInMaterial(inMaterial)
                .setMaterial(material)
                .build();
    }

    @Override
    public Barrel createFromRowParts(String[] parts) {
        String storedMaterial = parts[1].trim();
        String material = parts[2].trim();
        int volume = Integer.parseInt(parts[3].trim());

        return new Barrel.Builder().setVolume(volume)
                .setInMaterial(storedMaterial).setMaterial(material).build();
    }
}
