import java.util.Map;

public class Human {
    private String name;
    private String surName;
    private int year;
    private int iq;
    private Map<String, String> schedule;
    private Human mother;
    private Human father;
    private Family family;

    Human(String name, String surName, int year) {
        this.name = name;
        this.surName = surName;
        this.year = year;
    }

    Human(String name, String surName, int year, int iq, Human mother, Human father, Map<String, String> schedule) {
        this.name = name;
        this.surName = surName;
        this.year = year;
        this.iq = iq;
        this.schedule = schedule;
        this.mother = mother;
        this.father = father;
    }

    Human(){};

    void greetPet() {
        System.out.println("Привет, " + this.family.getPets());
    }
    void describePet() {
        System.out.println("У меня есть " + this.family.getPets() );
    }

    public String getName() {
        return name;
    }
    public String getSurName() {
        return surName;
    }
    public int getYear() {
        return year;
    }
    public int getIq() {
        return iq;
    }
    public Map<String, String> getSchedule() {
        return schedule;
    }
    public Human getMother() { return mother; }
    public Human getFather() { return father; }
    public Family getFamily() {
        return family;
    }

    public void setYear(int year) {
        this.year = year;
    }
    public void setIq(int iq) {
        this.iq = iq;
    }
    public void setSchedule(Map<String, String> schedule) {
        this.schedule = schedule;
    }
    public void setFamily(Family family) {
        this.family = family;
    }

    @Override
    public String toString() {
        StringBuilder scheduleToPrint = new StringBuilder("[");
        if (this.schedule != null) {
            for (Map.Entry<String, String> day : this.schedule.entrySet()) {
                scheduleToPrint.append("[" + day.getKey() + ", " + day.getValue() + "] ");
            }
        }
        scheduleToPrint.append("]");
        return "Human{name=" + this.name + ", surname='" + this.surName + "', year=" + this.year + ", iq=" + this.iq + ", schedule=" + scheduleToPrint +"}";
    }

    @Override
    public boolean equals(Object objToCompare) {
        if (this == objToCompare) return true;
        if(this.getClass() != objToCompare.getClass()) return false;
        Human humanToCompare = (Human)objToCompare;
        if(this.name.equals(humanToCompare.name)) return false;
        if(this.surName.equals(humanToCompare.surName)) return false;
        if(this.year != humanToCompare.year) return false;
        return true;
    }

    @Override
    public int hashCode(){
        return this.year * 31 + this.name.hashCode() * 31 + this. surName.hashCode() * 31;
    }

    @Override
    public void finalize(){
        System.out.println("Object will be deleted ---- " + this);
    }
}
