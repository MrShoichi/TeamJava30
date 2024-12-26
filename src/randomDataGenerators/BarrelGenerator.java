package randomDataGenerators;

import models.Barrel;
import utils.Constants.BarrelAttributes;

import java.util.Random;

public class BarrelGenerator implements IGenerator<Barrel> {
    @Override
    public void fillWithRandomData(Barrel instance) {

    }

    @Override
    public Barrel generateInstanceWithRandomData() {
        Random random = new Random();
        String material = BarrelAttributes.MATERIALS.get(random.nextInt(BarrelAttributes.MATERIALS.size()));
        String inMaterial = BarrelAttributes.IN_MATERIALS.get(random.nextInt(BarrelAttributes.IN_MATERIALS.size()));
        int volume = random.nextInt(10000);
        return new Barrel.Builder().setInMaterial(inMaterial).setMaterial(material).setVolume(volume).build();
    }
}
