public class Main {
    public static void main(String[] args) {
        String[][] father1Scedule = new String[3][];
        father1Scedule[0] = new String[] {"Monday", "read book"};
        father1Scedule[1] = new String[] {"Tuesday", "go to gym"};
        father1Scedule[2] = new String[] {"Wednesday", "meet with friends"};

        String[][] mother1Scedule = new String[3][];
        mother1Scedule[0] = new String[] {"Monday", "prepare supper"};
        mother1Scedule[1] = new String[] {"Tuesday", "visit cosmetologist"};
        mother1Scedule[2] = new String[] {"Wednesday", "read book"};

        String[][] child1Scedule = new String[3][];
        child1Scedule[0] = new String[] {"Monday", "do homework"};
        child1Scedule[1] = new String[] {"Tuesday", "play football"};
        child1Scedule[2] = new String[] {"Wednesday", "play with friends"};

        Human mother1 = new Human("Jenifer", "Henks", 1975, 90,  null, null, mother1Scedule);
        Human father1 = new Human("Bob", "Henks", 1973, 90, null, null, father1Scedule);
        Human child1 = new Human("Tom", "Henks", 1995, 90, mother1, father1, child1Scedule);
        Pet dog1 = new Pet(Animal.DOG, "Rex", 5, 70, new String[]{"play outside", "jump"});

        Family family1 = new Family(father1, mother1);
        family1.addChild(child1);
        family1.setPet(dog1);

        Human father2 = new Human("Alex", "Pitt", 1970);
        Human mother2 = new Human();
        Human child2 = new Human("child2Name", "child2Surname", 2005);
        Pet cat1 = new Pet(Animal.CAT, "Barsik");
        Family family2 = new Family(father2, mother2);
        family2.addChild(child2);
        family2.setPet(cat1);

        System.out.println("family 2: " + family2);

        child1.setFamily(family1);
        System.out.println("getYear() --- " + child1.getYear());
        System.out.println("getName() --- " + child1.getName());
        System.out.println("getSurname() --- " + child1.getSurName());
        System.out.println("getIq() --- " + child1.getIq());
        System.out.println("getFamily() --- " + child1.getFamily());
        child1.describePet();
        child1.getSchedule();
        child1.greetPet();
        System.out.println(child1.getFamily().getPet());
        System.out.println(child1);
    }
}
