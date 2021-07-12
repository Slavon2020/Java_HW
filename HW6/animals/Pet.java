package animals;

import java.util.Arrays;

public abstract class Pet {
    private Animal animalType;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

    {
        switch (getClass().getName()) {
            case "animals.Dog":
                animalType = Animal.DOG;
                break;
            case "animals.Fish":
                animalType = Animal.FISH;
                break;
            case "animals.DomesticCat":
                animalType = Animal.DOMESTICCAT;
                break;
            case "animals.RoboCat":
                animalType = Animal.ROBOCAT;
                break;
            default:
                animalType = Animal.UNKNOWN;
        }
        System.out.println(getClass().getName());
    }

    Pet(String nickname) {
        this.nickname = nickname;
    }

    Pet(String nickname, int age, int trickLevel, String[] habits) {
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

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    void eat() {
        System.out.println("Я кушаю!");
    }

    abstract void respond();

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

    @Override
    public void finalize(){
        System.out.println("Object will be deleted ---- " + this);
    }
}
