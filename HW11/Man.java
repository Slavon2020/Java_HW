import java.util.Map;

public final class Man extends Human {

    public Man(String name, String surName, long birthDate) {
        super(name, surName, birthDate);
    }

    public Man(String name, String surName, long birthDate, int iq, Human mother, Human father, Map<String, String> schedule) {
        super(name, surName, birthDate, iq, mother, father, schedule);
    }

    public Man() {
    }

    public void repairCar() {
        System.out.println("Я ремонтирую машину...");
    }

    @Override
    void describePet() {
        System.out.println("Описание животного у мужчины...");
    }
}
