package animals;

import java.util.Set;

public class DomesticCat extends Pet implements Foulable {
    private Animal animalType = Animal.DOMESTICCAT;

    public DomesticCat(String nickname) {
        super(nickname);
    }

    public DomesticCat(String nickname, int age, int trickLevel, Set<String> habits) {
        super(nickname, age, trickLevel, habits);
    }

    public DomesticCat() {
    }

    @Override
    public String toString() {
        return "DomesticCat{" +
                "animalType=" + animalType +
                '}';
    }

    @Override
    void respond() {
        System.out.println("Привет хозяин, я домашний кот и меня зовут " + this.getNickname() + "!");
    }

    @Override
    public void foul() {
        System.out.println("Я домашний кот и я нагадил...");
    }

}
