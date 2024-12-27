package models;

/**
 * Класс Animal с характеристиками: вид, цвет глаз и наличие шерсти.
 * Поддерживает сортировку по естественному порядку:
 * - Сначала по виду (species).
 * - Затем по цвету глаз (eyeColor).
 * - Потом по наличию шерсти (hasFur).
 *
 * Объекты класса создаются с использованием паттерна Builder.
 */
public class Animal implements Comparable<Animal>{
    private final String species;
    private final String eyeColor;
    private final boolean hasFur;

    private Animal(Builder builder) {
        this.species = builder.species;
        this.eyeColor = builder.eyeColor;
        this.hasFur = builder.hasFur;
    }

    public String getSpecies() {
        return species;
    }

    public String getEyeColor() {
        return eyeColor;
    }

    public boolean isHasFur() {
        return hasFur;
    }

    @Override
    public int compareTo(Animal other) {
        int result = this.species.compareTo(other.species);
        if (result != 0) return result;

        result = this.eyeColor.compareTo(other.eyeColor);
        if (result != 0) return result;

        return Boolean.compare(this.hasFur, other.hasFur);
    }

    public static class Builder {
        private String species;
        private String eyeColor;
        private boolean hasFur;

        public Builder setSpecies(String species) {
            this.species = species;
            return this;
        }

        public Builder setEyeColor(String eyeColor) {
            this.eyeColor = eyeColor;
            return this;
        }

        public Builder setHasFur(boolean hasFur) {
            this.hasFur = hasFur;
            return this;
        }

        public Animal build() {
            return new Animal(this);
        }
    }

    @Override
    public String toString() {
        return "Animal{" +
                "species='" + species + '\'' +
                ", eyeColor='" + eyeColor + '\'' +
                ", hasFur=" + hasFur +
                '}';
    }
}