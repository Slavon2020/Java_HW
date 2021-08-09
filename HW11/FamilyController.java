import animals.Pet;
import exceptions.FamilyOverflowException;

import java.util.List;
import java.util.Optional;
import java.util.Set;


public class FamilyController {

    private FamilyService familyService;

    FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    List<Family> getAllFamilies() {
        return familyService.getAllFamilies();
    }

    void displayAllFamilies() {
        familyService.displayAllFamilies();
    }

    List<Family> getFamiliesBiggerThan(int number) {
        return familyService.getFamiliesBiggerThan(number);
    };

    List<Family> getFamiliesLessThan(int number) {
        return familyService.getFamiliesLessThan(number);
    }

    int countFamiliesWithMemberNumber(int number) {
        return familyService.countFamiliesWithMemberNumber(number);
    }

    <T extends Human> Family createNewFamily(T human1, T human2) {
        return familyService.createNewFamily(human1, human2);
    }

    void deleteFamilyByIndex(int index) {
        familyService.deleteFamilyByIndex(index);
    }

    Family bornChild(Family family, String maleName, String femaleName) {
        Family familyToReturn = null;
        try {
            familyToReturn = familyService.bornChild(family, maleName, femaleName);
        } catch (FamilyOverflowException e) {
            System.out.println("Вы не можете создавать семью больше 5-ти человек");
            return familyToReturn;
        }
        return familyToReturn;
    }

    <T extends Human> Family adoptChild(Family family, T human) {
        return familyService.adoptChild(family, human);
    }

    void deleteAllChildrenOlderThen(int age) {
        familyService.deleteAllChildrenOlderThen(age);
    }

    int countAllFamilies() {
        return familyService.countAllFamilies();
    }

    Family getFamilyById(int id) {
        return familyService.getFamilyById(id);
    }

    Set<Pet> getPets(int familyId) {
        return familyService.getPets(familyId);
    }

    <T extends Pet> void addPet(int familyIndex, T pet) {
        familyService.addPet(familyIndex, pet);
    }

}
