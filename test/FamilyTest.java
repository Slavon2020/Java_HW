import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FamilyTest {

    @Test
    void shouldAddChild() {
        Human child = new Human();
        Family family = new Family(new Human(), new Human());
        int childsQuantityBeforeAdding = family.getChilds().length;
        family.addChild(child);
        int childsQuantityAfterAdding = family.getChilds().length;
        assertEquals(child, family.getChilds()[0]);
        assertEquals(childsQuantityBeforeAdding + 1, childsQuantityAfterAdding);
    }

    @Test
    void shouldDeleteChild() {
        Human child1 = new Human();
        Human child2 = new Human();
        Human[] childs = new Human[] {child1, child2};
        Family family = new Family(new Human(), new Human());
        family.setChilds(childs);
        int childLengthBeforeDeleting = family.getChilds().length;
        family.deleteChild(0);
        int childLengthAfterDeleting = family.getChilds().length;
        Human[] expected = new Human[] {child2};
        assertEquals(childLengthBeforeDeleting - 1, childLengthAfterDeleting);
        assertArrayEquals(expected, family.getChilds());
    }

    @Test
    void shouldThrowIllegalArgExWhenIncorrectArgPassed() {
        Human child1 = new Human();
        Human child2 = new Human();
        Human[] childs = new Human[] {child1, child2};
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
        Human[] childs = new Human[] {child1};
        Family family = new Family(new Human(), new Human());
        family.setChilds(childs);
        assertEquals(3, family.countFamily());
    }

    @Test
    void shouldReturnFourWhenTwoChildren() {
        Human child1 = new Human();
        Human child2 = new Human();
        Human[] childs = new Human[] {child1, child2};
        Family family = new Family(new Human(), new Human());
        family.setChilds(childs);
        assertEquals(4, family.countFamily());
    }

    @Test
    void shouldReturnFamilyDescriptionString() {
        String[][] father1Scedule = new String[3][];
        father1Scedule[0] = new String[] {WeekDays.MONDAY.toString(), "read book"};
        father1Scedule[1] = new String[] {WeekDays.TUESDAY.toString(), "go to gym"};
        father1Scedule[2] = new String[] {WeekDays.WEDNESDAY.toString(), "meet with friends"};
        String[][] mother1Scedule = new String[3][];
        mother1Scedule[0] = new String[] {"Monday", "prepare supper"};
        mother1Scedule[1] = new String[] {"Tuesday", "visit cosmetologist"};
        mother1Scedule[2] = new String[] {"Wednesday", "read book"};
        Human mother1 = new Human("Jenifer", "Henks", 1975, 90,  null, null, mother1Scedule);
        Human father1 = new Human("Bob", "Henks", 1973, 90, null, null, father1Scedule);
        Family family1 = new Family(father1, mother1);
        String expected = "Human{name=Bob, surname='Henks', year=1973, iq=90, schedule=[[MONDAY, read book] [TUESDAY, go to gym] [WEDNESDAY, meet with friends] ]} Human{name=Jenifer, surname='Henks', year=1975, iq=90, schedule=[[Monday, prepare supper] [Tuesday, visit cosmetologist] [Wednesday, read book] ]} null []";
        assertEquals(expected, family1.toString());

    }
}