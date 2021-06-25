import java.util.Scanner;

public class Sceduler {
    static private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        sceduler();
    }

    private static void sceduler() {

        String tasksPhrase = "Your tasks for";
        String[][] scedule = new String[7][2];
        scedule[0][0] = "Sunday";
        scedule[0][1] = "Do Sunday tasks";
        scedule[1][0] = "Monday";
        scedule[1][1] = "Do Monday tasks";
        scedule[2][0] = "Tuesday";
        scedule[2][1] = "Do Tuesday tasks";
        scedule[3][0] = "Wednesday";
        scedule[3][1] = "Do Wednesday tasks";
        scedule[4][0] = "Thursday";
        scedule[4][1] = "Do Thursday tasks";
        scedule[5][0] = "Friday";
        scedule[5][1] = "Do Friday tasks";
        scedule[6][0] = "Saturday";
        scedule[6][1] = "Do Saturday tasks";

        while (true) {
            System.out.println("Please, input the day of the week");
            String enteredValue = scanner.next().trim().toLowerCase();
            switch (enteredValue) {
                case "exit":
                    return;
                case "sunday":
                    System.out.println(tasksPhrase + " " + scedule[0][0] + ":" + " " + scedule[0][1]);
                    break;
                case "monday":
                    System.out.println(tasksPhrase + " " + scedule[1][0] + ":" + " " + scedule[1][1]);
                    break;
                case "tuesday":
                    System.out.println(tasksPhrase + " " + scedule[2][0] + ":" + " " + scedule[2][1]);
                    break;
                case "wednesday":
                    System.out.println(tasksPhrase + " " + scedule[3][0] + ":" + " " + scedule[3][1]);
                    break;
                case "thursday":
                    System.out.println(tasksPhrase + " " + scedule[4][0] + ":" + " " + scedule[4][1]);
                    break;
                case "friday":
                    System.out.println(tasksPhrase + " " + scedule[5][0] + ":" + " " + scedule[5][1]);
                    break;
                case "saturday":
                    System.out.println(tasksPhrase + " " + scedule[6][0] + ":" + " " + scedule[6][1]);
                    break;
                default:
                    System.out.println("Sorry, I don't understand you, please try again.");
                    continue;
            }
        }
    }
}
