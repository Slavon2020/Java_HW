package animals;

import java.util.Set;

public class Dog extends Pet implements Foulable {
    private Animal animalType = Animal.DOG;

    public Dog(String nickname) {
        super(nickname);
    }

    public Dog(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    public Dog() {}

    @Override
    public String toString() {
        return "Dog{" +
                "animalType=" + animalType +
                " nickName=" + this.getNickname() +
                '}';
    }

    @Override
    public void setAnimalType(Animal animalType){
        this.animalType = animalType;
    }

    @Override
    public Animal getAnimalType() {
        return this.animalType;
    }

    @Override
    void respond() {
        System.out.println("Привет хозяин, я собака и меня зовут " + this.getNickname() + "!");
    }

    @Override
    public void foul() {
        System.out.println("Я собака и я нагадила...");
    }

}
