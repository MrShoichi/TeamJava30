package factories;

import models.Barrel;
import utils.InputHandler;
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
}
