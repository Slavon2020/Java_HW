package animals;

public class DomesticCat extends Pet implements Foulable {

    public DomesticCat(Animal animalType, String nickname) {
        super(nickname);
    }

    public DomesticCat(Animal animalType, String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }

    public DomesticCat() {
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
