public final class Man extends Human {

    public Man(String name, String surName, int year) {
        super(name, surName, year);
    }

    public Man(String name, String surName, int year, int iq, Human mother, Human father, String[][] schedule) {
        super(name, surName, year, iq, mother, father, schedule);
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
