package animals;

import java.util.Set;

public class RoboCat extends Pet {
    private Animal animalType = Animal.ROBOCAT;

    public RoboCat(String nickname) {
        super(nickname);
    }

    public RoboCat(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    public RoboCat() {
    }

    @Override
    public String toString() {
        return "RoboCat{" +
                "animalType=" + animalType +
                '}';
    }

    @Override
    void respond() {
        System.out.println("Привет хозяин, я кот-робот и меня зовут " + this.getNickname() + "!");
    }

}
