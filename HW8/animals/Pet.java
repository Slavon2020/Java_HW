package animals;

import java.util.Arrays;
import java.util.Set;

public abstract class Pet {

    protected Animal animalType = Animal.UNKNOWN;
    private String nickname;
    private int age;
    private int trickLevel;
    private Set<String> habits;

    Pet(String nickname) {
        this.nickname = nickname;
    }

    Pet(String nickname, int age, int trickLevel, Set<String> habits) {
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

    Pet() {}

    public Animal getAnimalType() {
        return this.animalType;
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

    public void setHabits(Set<String> habits) {
        this.habits = habits;
    }
    public void setAnimalType(Animal animalType) {
        this.animalType = animalType;
    }

    void eat() {
        System.out.println("Я кушаю!");
    }

    abstract void respond();

    public Set<String> getHabits() {
        return habits;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "animalType=" + animalType +
                ", nickname='" + nickname + '\'' +
                '}';
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

    @Override
    public void finalize(){
        System.out.println("Object will be deleted ---- " + this);
    }
}
