import java.util.Map;

public final class Woman extends Human {
    public Woman(String name, String surName, int year) {
        super(name, surName, year);
    }

    public Woman(String name, String surName, int year, int iq, Human mother, Human father, Map<String, String> schedule) {
        super(name, surName, year, iq, mother, father, schedule);
    }

    public Woman() {
    }

    public void makeUp() {
        System.out.println("Я делаю makeUp...");
    }

    @Override
    void greetPet() {
        System.out.println("Описание животного у девушки...");
    }
}
