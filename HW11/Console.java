import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

public class Console {
    private FamilyController familyController;
    HashMap<String, Runnable> options;

    Console() {
        familyController = new FamilyController(new FamilyService(new CollectionFamilyDao() {
        }));
        options = new HashMap<>();
        options.put("1", this::createRandomData);
        options.put("2", this::displayAllFamilies);
        options.put("3", this::showFamiliesBiggerThan);
        options.put("4", this::showFamiliesLessThan);
        options.put("5", this::countFamiliesWithMembersNumber);
        options.put("6", this::createNewFamily);
        options.put("7", this::deleteFamilyByIndex);
        options.put("8", this::updateFamilyByIndex);
        options.put("9", this::deleteChildrenOlderThan);
        options.put("exit", this::exit);
    }

    private long getMillisFromDateString(String dateString) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime() / 1000;
    };

    private void createNewFamily() {
        System.out.println("Введите имя матери:");
        String motherName = readOption();
        System.out.println("Введите фамилию матери:");
        String motherSurname = readOption();
        System.out.println("Введите год рождения матери:");
        String motherBirthYear = readOption();
        System.out.println("Введите месяц рождения матери:");
        String motherBirthMonth = readOption();
        System.out.println("Введите день рождения матери:");
        String motherBirthDay = readOption();
        System.out.println("Введите Iq матери:");
        int motherIq = Integer.parseInt(readOption());

        StringBuilder motherBirthDate = new StringBuilder();
        motherBirthDate.append(motherBirthYear);
        motherBirthDate.append("/");
        motherBirthDate.append(motherBirthMonth);
        motherBirthDate.append("/");
        motherBirthDate.append(motherBirthDay);

        System.out.println("Введите имя отца:");
        String fatherName = readOption();
        System.out.println("Введите фамилию отца:");
        String fatherSurname = readOption();
        System.out.println("Введите год рождения отца:");
        String fatherBirthYear = readOption();
        System.out.println("Введите месяц рождения отца:");
        String fatherBirthMonth = readOption();
        System.out.println("Введите день рождения отца:");
        String fatherBirthDay = readOption();
        System.out.println("Введите Iq отца:");
        int fatherIq = Integer.parseInt(readOption());

        StringBuilder fatherBirthDate = new StringBuilder();
        fatherBirthDate.append(fatherBirthYear);
        fatherBirthDate.append("/");
        fatherBirthDate.append(fatherBirthMonth);
        fatherBirthDate.append("/");
        fatherBirthDate.append(fatherBirthDay);

        Woman mother = new Woman(motherName, motherSurname, getMillisFromDateString(motherBirthDate.toString()), motherIq, null, null, null);
        Man father = new Man(fatherName, fatherSurname, getMillisFromDateString(fatherBirthDate.toString()), fatherIq, null, null, null);

        familyController.createNewFamily(mother, father);
    }

    private void deleteFamilyByIndex() {
        System.out.println("Введите порядковый номер семьи:");
        familyController.deleteFamilyByIndex(Integer.parseInt(readOption()) - 1);
    }

    private void updateFamilyByIndex() {

        System.out.println("Введите порядковый номер семьи:");
        int familyIndex = Integer.parseInt(readOption());
        System.out.println("1. Родить ребенка\n" +
                "2. Усыновить ребенка");
        String choosedOption = readOption();
        System.out.println("Имя мальчика");
        String boyName = readOption();
        System.out.println("Имя девочки");
        String girlName = readOption();
        Family family = familyController.getAllFamilies().get(familyIndex - 1);

        if (choosedOption == "1") {

            familyController.bornChild(family, boyName, girlName);
        } else {
            familyController.adoptChild(family, new Man(boyName, girlName, new Date().getTime()));
        }
    }

    private void exit() {
        System.exit(1);
    }

    public void run() {
        while (true) {
            showMainMenu();
            handleMainMenuOption();
        }
    }

    private void handleMainMenuOption() {
        Scanner scan = new Scanner(System.in);
        String choosedOption = scan.nextLine();
        try {
            options.get(choosedOption).run();
        } catch (NullPointerException e) {
            System.out.println("Нет такого пункта меню...");
         }
    }

    private void displayAllFamilies() {
        familyController.displayAllFamilies();
    }

    private void createRandomData() {
        Man father1 = new Man("John", "Conor", 112312312312l);
        Woman mother1 = new Woman("Ann", "Conor", 999192391239l);

        Man father2 = new Man("Bob", "Martin", 122312312312l);
        Woman mother2 = new Woman("Jenifer", "Martin", 999192391239l);

        Man father3 = new Man("David", "Owen", 122312312312l);
        Woman mother3 = new Woman("Maria", "Owen", 889192391239l);

        familyController.createNewFamily(father1, mother1);
        familyController.createNewFamily(father2, mother2);
        familyController.createNewFamily(father3, mother3);
    }

    private void deleteChildrenOlderThan() {
        System.out.println("Введите число:");
        int age = Integer.parseInt(readOption());
        familyController.deleteAllChildrenOlderThen(age);
    }

    private void countFamiliesWithMembersNumber() {
        System.out.println("Введите число:");
        int number = Integer.parseInt(readOption());
        System.out.println("Количество подходящих семей: " + familyController.countFamiliesWithMemberNumber(number));
    }

    private void showFamiliesLessThan() {
        System.out.println("Введите число:");
        int number = Integer.parseInt(readOption());
        if (number != -1) {
            familyController.getFamiliesLessThan(number);
        }
    }

    private void showFamiliesBiggerThan() {
        System.out.println("Введите число:");
        int number = Integer.parseInt(readOption());
        if (number != -1) {
            familyController.getFamiliesBiggerThan(number);
        }
    }

    public void showMainMenu() {
        System.out.println("Выберите пункт меню: \n" +
                "1. Заполнить тестовыми данными\n" +
                "2. Отобразить весь список семей\n" +
                "3. Отобразить список семей, где количество людей больше заданного\n" +
                "4. Отобразить список семей, где количество людей меньше заданного\n" +
                "5. Подсчитать количество семей, где количество членов равно\n" +
                "6. Создать новую семью\n" +
                "7. Удалить семью по индексу семьи в общем списке\n" +
                "8. Редактировать семью по индексу семьи в общем списке \n" +
                "9. Удалить всех детей старше возраста\n");
    }

    private String readOption() {
        Scanner scanner = new Scanner(System.in);
        String option;
        try {
            option = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Вы ввели некорректные данные");
            return "";
        }
        return option;
    }
}
