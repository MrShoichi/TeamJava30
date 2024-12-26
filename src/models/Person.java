package models;

public class Person implements Comparable<Person>, SortableByNumber {
    private final String gender;
    private final int age;
    private final String fullName;

    private Person(Person.Builder builder) {
        this.gender = builder.gender;
        this.age = builder.age;
        this.fullName = builder.fullName;
    }

    @Override
    public int compareTo(Person other) {
        int result = this.gender.compareTo(other.gender);
        if (result != 0) return result;

        result = Integer.compare(this.age, other.age);
        if (result != 0) return result;

        return this.fullName.compareTo(other.fullName);
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public int getNumericValue() {
        return age;
    }

    public static class Builder {
        private String gender;
        private int age;
        private String fullName;

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setFullName(String fullName) {
            this.fullName = fullName;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

    @Override
    public String toString() {
        return "Person{" +
                "gender='" + gender + '\'' +
                ", age=" + age +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
