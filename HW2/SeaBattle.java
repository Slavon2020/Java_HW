import java.util.Random;
import java.util.Scanner;

public class SeaBattle {
    public static void main(String[] args) {
        playSeaBattle(5);
    }

    private static void playSeaBattle(int fieldSize) {
        int[][] desk = prepareDesk(fieldSize);
        boolean isGameOver = false;
        while (!isGameOver) {
            drawField(desk);
            isGameOver = shoot(desk);
        }
        System.out.println("You have won !!!");
        drawField(desk);
    }

    private static int[][] prepareDesk(int fieldSize) {
        Random random = new Random();
        int[][] desk = new int[fieldSize + 1][fieldSize + 1];
        int targetRow = random.nextInt(fieldSize) + 1;
        int targetColumn = random.nextInt(fieldSize) + 1;
        desk[targetRow][targetColumn] = 2;
        return desk;
    }

    private static void drawField(int[][] desk) {
        for (int i = 0; i < desk.length; i++) {
            for (int j = 0; j < desk[i].length ; j++) {
                if(i == 0) {
                    System.out.print(j + " | ");
                } else if (j == 0) {
                    System.out.print(i + " | ");
                } else if(desk[i][j] == 1) {
                    System.out.print("* | ");
                } else if (desk[i][j] == 3) {
                    System.out.print("x | ");
                } else {
                    System.out.print("- | ");
                }
            }
            System.out.println(" ");
        }
    }

    private static boolean shoot(int[][] desk) {
        boolean isDestroyedTarget = false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter row");
        int row = scan.nextInt();
        row = row > 0 && row < desk.length ? row : 0;
        System.out.println("Enter column");
        int column = scan.nextInt();
        column = column > 0 && column < desk.length ? column : 0;
            if (desk[row][column] == 2) {
                desk[row][column] = 3;
                isDestroyedTarget = true;
            } else {
                desk[row][column] = 1;
            }
        return isDestroyedTarget;
    }
}
