package review.assignment_1;

import utils.MathUtil;

import java.util.Scanner;

public class Assign13 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        char[][] icon = createIcon();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(icon[i][j]);
            }
            System.out.println();
        }

        System.out.print("Enter the scaling factor: ");
        int factor = input.nextInt();

        if (factor > 99) {
            System.out.println("Please provide a scaling factor between 1-99\n");
            main(null);
            return;
        }

        System.out.println();

        char[][] newIcon = scale(icon, factor);
        for (int i = 0; i < 3 * factor; i++) {
            for (int j = 0; j < 3 * factor; j++) {
                System.out.print(newIcon[i][j]);
            }
            System.out.println();
        }
    }

    private static char[][] scale(char[][] icon, int factor) {

        char[][] newIcon = new char[3 * factor][3 * factor];
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                char character = icon[i][j];
                for (int a = i * factor; a < factor + (i * factor); a++) {

                    for (int b = j * factor; b < factor + (j * factor); b++) {
                        newIcon[a][b] = character;
                    }
                }
            }
        }

        return newIcon;
    }

    private static char[][] createIcon() {

        char[][] icon = new char[3][3];
        for (int i = 0; i < 3; i++) {

            for (int j = 0; j < 3; j++) {

                if (MathUtil.random(0, 1) == 0) icon[i][j] = 'X';
                else icon[i][j] = '*';
            }
        }

        return icon;
    }
}
