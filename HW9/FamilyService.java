import animals.Pet;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FamilyService {
    private FamilyDao familyDao;

    FamilyService(FamilyDao familyDao) {
        this.familyDao = familyDao;
    }

    List<Family> getAllFamilies() {
        return familyDao.getAllFamilies();
    }

    void displayAllFamilies() {
        familyDao.getAllFamilies().stream()
            .forEach(System.out::println);
    }

    List<Family> getFamiliesBiggerThan(int number) {
        List<Family> toReturn = familyDao.getAllFamilies().stream()
                .filter(family -> family.countFamily() > number)
                .collect(Collectors.toList());
        System.out.println(toReturn);
        return toReturn;
    }

    List<Family> getFamiliesLessThan(int number) {
        List<Family> toReturn = familyDao.getAllFamilies().stream()
                .filter(family -> family.countFamily() < number)
                .collect(Collectors.toList());
        System.out.println(toReturn);
        return toReturn;
    }

    int countFamiliesWithMemberNumber(int number) {
        return (int)familyDao.getAllFamilies().stream()
                .filter(family -> family.countFamily() == number)
                .count();
    }

    <T extends Human> Family createNewFamily(T human1, T human2) {
        Family newFamily = new Family(human1, human2);
        familyDao.saveFamily(newFamily);
        return newFamily;
    }

    void deleteFamilyByIndex(int index) {
        familyDao.deleteFamily(index);
    }

    Family bornChild(Family family, String maleName, String femaleName) {
        Man newChild = new Man(maleName, family.getFather().getSurName(), Calendar.getInstance().get(Calendar.YEAR));
        family.addChild(newChild);
        familyDao.saveFamily(family);
        return family;
    }

    <T extends Human> Family adoptChild(Family family, T human) {
        family.addChild(human);
        familyDao.saveFamily(family);
        return family;
    }

    void deleteAllChildrenOlderThen(int age) {
        List<Family> families = familyDao.getAllFamilies();
        families.forEach(family -> {
        List<Human> filteredChilds = family.getChilds().stream()
                .filter(child -> Period.between(LocalDate.ofInstant(Instant.ofEpochMilli(child.getBirthDate()), ZoneId.systemDefault()), LocalDate.now()).getYears()  <= age)
                .collect(Collectors.toList());
        family.setChilds(filteredChilds);
        familyDao.saveFamily(family);
    });
}

    int countAllFamilies() {
        return familyDao.getAllFamilies().size();
    }

    Family getFamilyById(int id) {
        return familyDao.getFamilyByIndex(id);
    }

    Set<Pet> getPets(int familyId) {
        return familyDao.getFamilyByIndex(familyId).getPets();
    }

    <T extends Pet> void addPet(int familyIndex, T pet) {
        Family family = familyDao.getFamilyByIndex(familyIndex);
        family.addPet(pet);
        familyDao.saveFamily(family);
    }

}
