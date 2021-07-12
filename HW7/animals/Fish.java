package animals;

import java.util.Set;

public class Fish extends Pet {

    public Fish(Animal animalType, String nickname) {
        super(nickname);
    }

    public Fish(Animal animalType, String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    public Fish() {
    }

    @Override
    void respond() {
        System.out.println("Привет хозяин, я рыбка и меня зовут " + this.getNickname() + "!");
    }

}
