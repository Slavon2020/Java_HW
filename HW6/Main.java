import animals.Dog;
import animals.Pet;

public class Main {
    public static void main(String[] args) {
       Pet dog = new Dog();
        System.out.println(dog.getAnimalType());
    }
}