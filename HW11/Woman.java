import java.util.Map;

public final class Woman extends Human {
    public Woman(String name, String surName, long birthdate) {
        super(name, surName, birthdate);
    }

    public Woman(String name, String surName, long birthdate, int iq, Human mother, Human father, Map<String, String> schedule) {
        super(name, surName, birthdate, iq, mother, father, schedule);
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
