package animals;

import java.util.Set;

public class Fish extends Pet {
    private Animal animalType = Animal.FISH;

    public Fish(String nickname) {
        super(nickname);
    }

    public Fish(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    public Fish() {
    }

    @Override
    public String toString() {
        return "Fish{" +
                "animalType=" + animalType +
                '}';
    }

    @Override
    void respond() {
        System.out.println("Привет хозяин, я рыбка и меня зовут " + this.getNickname() + "!");
    }

}
