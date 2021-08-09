import java.time.LocalDate;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class AdoptedChild extends Human {

    AdoptedChild(String name, String surname, String birthDateString, int iq) {
        super(name, surname, LocalDate.parse(birthDateString, DateTimeFormatter.ofPattern("dd/MM/yyyy")).atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli(), iq);
    }



}
