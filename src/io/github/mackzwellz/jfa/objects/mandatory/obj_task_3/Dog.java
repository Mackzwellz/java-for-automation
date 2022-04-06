package io.github.mackzwellz.jfa.objects.mandatory.obj_task_3;

import java.util.Random;

public class Dog implements Comparable<Dog> {

    private static final int DOG_MAX_AGE = 20;
    private String name;
    private Size size;
    private int age;

    public Dog() {
        this(generateRandomDogName(), generateRandomDogSize(), generateRandomDogAge());
    }

    public Dog(String name) {
        this(name, generateRandomDogSize(), generateRandomDogAge());
    }

    public Dog(Size size) {
        this(generateRandomDogName(), size, generateRandomDogAge());
    }

    public Dog(int age) {
        this(generateRandomDogName(), generateRandomDogSize(), age);
    }

    public Dog(String name, Size size) {
        this(name, size, generateRandomDogAge());
    }

    public Dog(String name, int age) {
        this(name, generateRandomDogSize(), age);
    }

    public Dog(Size size, int age) {
        this(generateRandomDogName(), size, age);
    }

    public Dog(String name, Size size, int age) {
        this.name = name;
        this.size = size;
        dogAgeValidator(age);
        this.age = age;
        logCurrentDog();
    }

    /**
     * Credit: https://www.baeldung.com/java-random-string
     *
     * @return
     */
    private static String generateRandomDogName() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    private static int generateRandomDogAge() {
        return new Random().nextInt(DOG_MAX_AGE - 1) + 1;
    }

    private static Size generateRandomDogSize() {
        return Size.values()[new Random().nextInt(3)];
    }

    private static void dogAgeValidator(int age) {
        if (age < 1 || age >= DOG_MAX_AGE) {
            throw new IllegalArgumentException("Dog age is out of expected bounds");
        }
    }

    @Override
    public String toString() {
        return this.name + " " + this.size.toString() + " " + this.age;
    }

    public void logCurrentDog() {
        System.out.println("Dog details: " + this);
    }

    @Override
    public int compareTo(Dog other) {
        int nameCompare = this.name.compareTo(other.name);
        if (nameCompare != 0) return nameCompare;
        int sizeCompare = this.size.compareTo(other.size);
        if (sizeCompare != 0) return sizeCompare;
        return Integer.compare(this.age, other.age);
    }

    public enum Size {
        SMALL,
        MEDIUM,
        BIG
    }
}