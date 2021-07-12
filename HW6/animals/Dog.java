package animals;

public class Dog extends Pet implements Foulable {

    public Dog(Animal animalType, String nickname) {
        super(nickname);
    }

    public Dog(Animal animalType, String nickname, int age, int trickLevel, String[] habits) {
        super(nickname, age, trickLevel, habits);
    }

    public Dog() {
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
