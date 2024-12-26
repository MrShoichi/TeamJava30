package models;

public class Barrel implements Comparable<Barrel>, SortableByNumber {
    private final String inMaterial;
    private final String material;
    private final int volume;

    private Barrel(Barrel.Builder builder) {
        this.inMaterial = builder.inMaterial;
        this.material = builder.material;
        this.volume = builder.volume;
    }



    @Override
    public int compareTo(Barrel other) {
        int result = this.inMaterial.compareTo(other.inMaterial);
        if (result != 0) return result;

        result = this.material.compareTo(other.material);
        if (result != 0) return result;

        return Integer.compare(this.volume, other.volume);
    }

    public String getInMaterial() {
        return inMaterial;
    }

    public String getMaterial() {
        return material;
    }

    public int getVolume() {
        return volume;
    }

    @Override
    public int getNumericValue() {
        return volume;
    }

    public static class Builder {
        private String inMaterial;
        private String material;
        private int volume;

        public Barrel.Builder setInMaterial(String inMaterial) {
            this.inMaterial = inMaterial;
            return this;
        }

        public Barrel.Builder setMaterial(String material) {
            this.material = material;
            return this;
        }

        public Barrel.Builder setVolume(int volume) {
            this.volume = volume;
            return this;
        }

        public Barrel build() {
            return new Barrel(this);
        }
    }

    @Override
    public String toString() {
        return "Barrel{" +
                "inMaterial='" + inMaterial + '\'' +
                ", material='" + material + '\'' +
                ", volume=" + volume +
                '}';
    }
}
