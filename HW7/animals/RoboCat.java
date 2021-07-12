package animals;

import java.util.Set;

public class RoboCat extends Pet {

    public RoboCat(Animal animalType, String nickname) {
        super(nickname);
    }

    public RoboCat(Animal animalType, String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    public RoboCat() {
    }

    @Override
    void respond() {
        System.out.println("Привет хозяин, я кот-робот и меня зовут " + this.getNickname() + "!");
    }

}
