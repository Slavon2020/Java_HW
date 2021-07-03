import java.util.Arrays;

public class Pet {
    private Animal animalType;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    Pet(Animal animalType, String nickname) {
        this.animalType = animalType;
        this.nickname = nickname;
    }

    Pet(Animal animalType, String nickname, int age, int trickLevel, String[] habits) {
        this.animalType = animalType;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    Pet() {}

    public Animal getAnimalType() {
        return animalType;
    }
    public String getNickname() {
        return nickname;
    }
    public int getAge() {
        return age;
    }
    public int getTrickLevel() {
        return trickLevel;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }
    private void eat() {
        System.out.println("Я кушаю!");
    }
    private void respond() {
        System.out.println("Привет, хозяин. Я - " + nickname + ". Я соскучился!");
    }
    private void foul() {
        System.out.println("Нужно хорошо замести следы...");
    }

    public String[] getHabits() {
        return habits;
    }

    @Override
    public String toString() {
        return this.animalType.getType() + "{nickname='" + this.nickname + "' age=" + this.age + " trickLevel=" + this.trickLevel + " habits=" + Arrays.toString(this.habits) + "}";
    }

    @Override
    public boolean equals(Object objToCompare){
        if (this == objToCompare) return true;
        if(this.getClass() != objToCompare.getClass()) return false;
        Pet petToCompare = (Pet)objToCompare;
        if(!this.nickname.equals(petToCompare.nickname)) return false;
        if(this.age != petToCompare.age) return false;
        return true;
    }


}
