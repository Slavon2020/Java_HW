import animals.Dog;

public class Main {
    public static void main(String[] args) {

        FamilyController familyController = new FamilyController(new FamilyService(new CollectionFamilyDao()) {
        });

        Man father1 = new Man("John", "Abrams", 1970);
        Woman mother1 = new Woman("Mary", "Abrams", 1975);
        Family family1 = familyController.createNewFamily(father1, mother1);
        System.out.println("family1 ---- " + family1);

        familyController.bornChild(family1, "Nick", "Ann");
        System.out.println("family1 after borning child ---- " + family1);

        Man family1child1 = new Man("Tom", "Abrams", 2000);
        familyController.adoptChild(family1, family1child1);
        System.out.println("family1 after adopting child ---- " + family1);

        Dog dog1 = new Dog("Rex");
        familyController.addPet(0, dog1);
        System.out.println("family1 after adding dog1 ---- " + family1);

        System.out.println("family1 pets ---- " + familyController.getPets(0));

        System.out.println("family with id 0 ---- " + familyController.getFamilyById(0));

        Man father2 = new Man("Mark", "Duglas", 1980);
        Woman mother2 = new Woman("Ann", "Duglas", 1982);
        Family family2 = familyController.createNewFamily(father2, mother2);
        System.out.println("family2 ---- " + family2);

        System.out.println("display all families ---- ");
        familyController.displayAllFamilies();

        System.out.println("families bigger than 1 ---- " + familyController.getFamiliesBiggerThan(1));
        System.out.println("families bigger than 3 ---- " + familyController.getFamiliesBiggerThan(3));

        System.out.println("number of families less than 3 ---- " + familyController.getFamiliesLessThan(3));

        System.out.println("number of families with 4 members --- " + familyController.countFamiliesWithMemberNumber(4));

        System.out.println("all families ---- " + familyController.getAllFamilies());

        System.out.println("count all families ---- " + familyController.countAllFamilies());

        Man family2child2 = new Man("Eric", "Duglas", 2011);
        familyController.adoptChild(family2, family2child2);

        System.out.println("all families before deleting children older than 5 years --- " + familyController.getAllFamilies());
        familyController.deleteAllChildrenOlderThen(5);
        System.out.println("all families after deleting children older than 5 years --- " + familyController.getAllFamilies());

        familyController.deleteFamilyByIndex(0);
        System.out.println("all families after deleting family with index 0 --- " + familyController.getAllFamilies());

//        + familyController.adoptChild()
//        + familyController.displayAllFamilies();
//        + familyController.getFamilyById()
//        + familyController.getFamiliesBiggerThan()
//        + familyController.getFamiliesLessThan();
//        + familyController.countFamiliesWithMemberNumber()
//        + familyController.bornChild()
//        + familyController.addPet();
//        + familyController.createNewFamily();
//        + familyController.getPets();
//        + familyController.deleteAllChildrenOlderThen();
//        + familyController.getAllFamilies()
//        + familyController.deleteFamilyByIndex();
//        + familyController.countAllFamilies();
    }

}