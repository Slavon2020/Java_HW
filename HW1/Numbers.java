import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        playNumbers();
    }

    private static void playNumbers() {
        Random random = new Random();
        int numberToGuess = random.nextInt(100) + 1;
        System.out.println("Enter your name...");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        int[] enteredNumbers = new int[0];
        while (true) {
            System.out.println("Enter your number...");
            int enteredNumber;
            try {
                String enteredValue = scanner.next();
                enteredNumber = Integer.parseInt(enteredValue);
            } catch (Exception e) {
                continue;
            }
            int[] temp = new int[enteredNumbers.length + 1];
            System.arraycopy(enteredNumbers, 0, temp, 0, enteredNumbers.length);
            temp[enteredNumbers.length] = enteredNumber;
            enteredNumbers = temp;
            if (enteredNumber == numberToGuess) {
                bubbleSortReverse(enteredNumbers);
                System.out.println("Congratulations " + name + " Your numbers: " + Arrays.toString(enteredNumbers));
                break;
            } else if(enteredNumber < numberToGuess) {
                System.out.println("Your number is too small. Please, try again.");
            } else {
                System.out.println("Your number is too big. Please, try again.");
            }
        }
    }

    private static void bubbleSortReverse(int[] arr) {
        if (arr.length > 1) {
            boolean isSorted = false;
            while (!isSorted) {
                isSorted = true;
                for (int i = 0; i < arr.length - 1; i++) {
                    if(arr[i] < arr[i + 1]) {
                        isSorted = false;
                        int temp = arr[i];
                        arr[i] = arr[i + 1];
                        arr[i + 1] = temp;
                    }
                }
            }
        }
    }
}
