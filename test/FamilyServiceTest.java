import animals.Animal;
import animals.Dog;
import animals.Pet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class FamilyServiceTest {
    FamilyService familyService;
    Family family1;
    Family family2;


    @BeforeEach
    void initializeData() {
        familyService = new FamilyService(new CollectionFamilyDao());
        family1 = familyService.createNewFamily(new Man("Nicolas", "Cage", 1970), new Woman("Ann", "Cage", 1975));
        family2 = familyService.createNewFamily(new Man("Tom", "Hanks", 1965), new Woman("Mary", "Hanks", 1970));
        familyService.bornChild(family2, "Eric", "Maria");
    }

    @Test
    void shouldReturnListOfAllFamilies() {
        List<Family> expected = new ArrayList<>();
        expected.add(family1);
        expected.add(family2);
        List<Family> actual = familyService.getAllFamilies();
         assertEquals(expected, actual);
    }

    @Test
    void displayAllFamilies() {
    }

    @Test
    void shouldReturnFamilyBiggerThanTwoMembers() {
        familyService.bornChild(family2, "Eric", "Maria");
        List<Family> expected = new ArrayList<>();
        expected.add(family2);
        List<Family> actual = familyService.getFamiliesBiggerThan(2);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnFamilyLessThanThreeMembers() {
        List<Family> expected = new ArrayList<>();
        expected.add(family1);
        List<Family> actual = familyService.getFamiliesLessThan(3);
    }

    @Test
    void shouldReturnTwoWhenCountingFamilies() {
        int actual = familyService.countAllFamilies();
        assertEquals(2, actual);
    }

    @Test
    void createNewFamily() {
        Family actual = familyService.createNewFamily(new Human("Jack", "Martin", 1975), new Human("Ann", "Martin", 1980));
        Family expected = new Family(new Human("Jack", "Martin", 1975), new Human("Ann", "Martin", 1980));
        assertEquals(actual, expected);
    }

    @Test
    void shouldRemoveFamilyByIndex() {
        familyService.deleteFamilyByIndex(0);
        int actual = familyService.getAllFamilies().indexOf(family1);
        assertEquals(-1, actual);
    }

    @Test
    void shouldReturnFamilyWithNewChild() {
        familyService.bornChild(family2, "Bob", "Tina");
        List<Family> actual = familyService.getFamiliesBiggerThan(3);
        List<Family> expected = new ArrayList<>();
        expected.add(family2);
        assertEquals(expected, actual);
    }

    @Test
    void shouldReturnFamilyWithAdoptedChild() {
        familyService.adoptChild(family2, new Human("Alex", "Fox", 2010));
        List<Family> actual = familyService.getFamiliesBiggerThan(3);
        List<Family> expected = new ArrayList<>();
        expected.add(family2);
        assertEquals(expected, actual);
    }

    @Test
    void shouldDeleteAllChildrenOlderThanFive() {
        familyService.deleteAllChildrenOlderThen(5);
        assertEquals(1, familyService.countFamiliesWithMemberNumber(2));
        assertEquals(1, familyService.countFamiliesWithMemberNumber(3));
    }

    @Test
    void shouldReturnFamily1() {
        Family actual = familyService.getFamilyById(0);
        assertEquals(family1, actual);
    }

    @Test
    void shouldReturnEmptySetOfPets() {
        familyService.getPets(1);
        assertEquals(new HashSet<>(), familyService.getPets(1));
    }

    @Test
    void shouldAddPetToFamily() {
        familyService.addPet(0, new Dog("Rex"));
        HashSet<Dog> expected = new HashSet<>();
        expected.add(new Dog("Rex"));
        HashSet<Pet> actual = (HashSet<Pet>)familyService.getPets(0);
        assertArrayEquals(expected.toArray(), actual.toArray());
    }
}