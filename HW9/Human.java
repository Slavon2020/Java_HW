import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class Human {
    private String name;
    private String surName;
    protected long birthDate;
    private int iq;
    private Map<String, String> schedule;
    private Human mother;
    private Human father;
    private Family family;

    Human(String name, String surName, long birthDate) {
        this.name = name;
        this.surName = surName;
        this.birthDate = birthDate;
    }

    Human(String name, String surName, long birthDate, int iq) {
        this.name = name;
        this.surName = surName;
        this.birthDate = birthDate;
        this.iq = iq;
    }

    Human(String name, String surName, long birthDate, int iq, Human mother, Human father, Map<String, String> schedule) {
        this.name = name;
        this.surName = surName;
        this.birthDate = birthDate;
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
    public long getBirthDate() {
        return this.birthDate;
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

    public void setBirthDate(long birthDate) {
        this.birthDate = birthDate;
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

    public String describeAge() {
        LocalDate birthDate =
                LocalDate.ofInstant(Instant.ofEpochMilli(this.birthDate), ZoneId.systemDefault());
        Period period = Period.between(birthDate, LocalDate.now());
        return "Человек прожил " + period.getYears() + " лет, " + period.getMonths() + " месяцев , " + period.getDays() + " дней";
    }

    @Override
    public String toString() {
        StringBuilder scheduleToPrint = new StringBuilder("[");
        if (this.schedule != null) {
            for (Map.Entry<String, String> day : this.schedule.entrySet()) {
                scheduleToPrint.append("[" + day.getKey() + ", " + day.getValue() + "] ");
            }
        }

        LocalDate birthdayDate = Instant.ofEpochMilli(this.birthDate).atZone(ZoneId.systemDefault()).toLocalDate();
        String birthdayString = birthdayDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        scheduleToPrint.append("]");
        return "Human{name=" + this.name + ", surname='" + this.surName + "', birthdayString=" + birthdayString + ", iq=" + this.iq + ", schedule=" + scheduleToPrint +"}";
    }

    @Override
    public boolean equals(Object objToCompare) {
        if (this == objToCompare) return true;
        if(this.getClass() != objToCompare.getClass()) return false;
        Human humanToCompare = (Human)objToCompare;
        if(this.name.equals(humanToCompare.name)) return false;
        if(this.surName.equals(humanToCompare.surName)) return false;
        if(this.birthDate != humanToCompare.birthDate) return false;
        return true;
    }

    @Override
    public int hashCode(){
        return (int)this.birthDate * 31 + this.name.hashCode() * 31 + this. surName.hashCode() * 31;
    }

    @Override
    public void finalize(){
        System.out.println("Object will be deleted ---- " + this);
    }
}
