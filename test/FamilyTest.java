import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {

    @Test
    void shouldAddChild() {
        Human child = new Human();
        Family family = new Family(new Human(), new Human());
        int childsQuantityBeforeAdding = family.getChilds().size();
        family.addChild(child);
        int childsQuantityAfterAdding = family.getChilds().size();
        assertEquals(child, family.getChilds().get(0));
        assertEquals(childsQuantityBeforeAdding + 1, childsQuantityAfterAdding);
    }

    @Test
    void shouldDeleteChild() {
        Human child1 = new Human();
        Human child2 = new Human();
        List<Human> childs = new ArrayList<Human>();
        childs.add(child1);
        childs.add(child2);
        Family family = new Family(new Human(), new Human());
        family.setChilds(childs);
        int childLengthBeforeDeleting = family.getChilds().size();
        family.deleteChild(0);
        int childLengthAfterDeleting = family.getChilds().size();
        List<Human> expected = new ArrayList<>();
        expected.add(child2);
        assertEquals(childLengthBeforeDeleting - 1, childLengthAfterDeleting);
        assertEquals(expected, family.getChilds());
    }

    @Test
    void shouldThrowIllegalArgExWhenIncorrectArgPassed() {
        Human child1 = new Human();
        Human child2 = new Human();
        List<Human> childs = new ArrayList<>();
        childs.add(child1);
        childs.add(child2);
        Family family = new Family(new Human(), new Human());
        family.setChilds(childs);
        assertThrows(IllegalArgumentException.class, () -> {family.deleteChild(3);});
    }

    @Test
    void shouldReturnTwoWhenNoChildren() {
        Family family = new Family(new Human(), new Human());
        assertEquals(2, family.countFamily());
    }

    @Test
    void shouldReturnThreeWhenOneChild() {
        Human child1 = new Human();
        List<Human> childs = new ArrayList<>();
        childs.add(child1);
        Family family = new Family(new Human(), new Human());
        family.setChilds(childs);
        assertEquals(3, family.countFamily());
    }

    @Test
    void shouldReturnFourWhenTwoChildren() {
        Human child1 = new Human();
        Human child2 = new Human();
        List<Human> childs = new ArrayList<>();
        childs.add(child1);
        childs.add(child2);
        Family family = new Family(new Human(), new Human());
        family.setChilds(childs);
        assertEquals(4, family.countFamily());
    }

    @Test
    void shouldReturnFamilyDescriptionString() {

        Map fathersScedule = new HashMap<String, String>();
        fathersScedule.put(WeekDays.MONDAY.toString(), "read book");
        fathersScedule.put(WeekDays.TUESDAY.toString(), "go to gym");
        fathersScedule.put(WeekDays.WEDNESDAY.toString(), "meet with friends");

        Map mothersScedule = new HashMap<String, String>();
        mothersScedule.put("Monday", "prepare supper");
        mothersScedule.put("Tuesday", "visit cosmetologist");
        mothersScedule.put("Wednesday", "read book");

        Human mother1 = new Human("Jenifer", "Henks", 1975, 90,  null, null, mothersScedule);
        Human father1 = new Human("Bob", "Henks", 1973, 90, null, null, fathersScedule);
        Family family1 = new Family(father1, mother1);
        String expected = "Human{name=Bob, surname='Henks', year=1973, iq=90, schedule=[[WEDNESDAY, meet with friends] [MONDAY, read book] [TUESDAY, go to gym] ]} Human{name=Jenifer, surname='Henks', year=1975, iq=90, schedule=[[Monday, prepare supper] [Wednesday, read book] [Tuesday, visit cosmetologist] ]} null []";
        assertEquals(expected, family1.toString());
    }
}