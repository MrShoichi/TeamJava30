package factories;

import utils.InputHandler;
import utils.Messages;

public class BarrelFactory implements IObjectFactory<Barrel> {
    @Override
    public Barrel create(InputHandler inputHandler) {
        double volume = inputHandler.safeDoubleInput(Messages.PROMPT_VOLUME);
        String content = inputHandler.safeStringInput(Messages.PROMPT_CONTENT);
        String material = inputHandler.safeStringInput(Messages.PROMPT_MATERIAL);

        return new Barrel.Builder()
                .setVolume(volume)
                .setContent(content)
                .setMaterial(material)
                .build();
    }
}
