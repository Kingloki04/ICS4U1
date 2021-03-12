package review.assignment_1;

import java.util.Scanner;

public class Assign11 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the weight: ");
        double weight = input.nextDouble();
        System.out.print("Enter the height: ");
        double height = input.nextDouble();

        double bmi = weight / (height * height);

        if (bmi < 18.5) System.out.println("\nUnderweight");
        if (bmi >= 18.5 && bmi <= 25) System.out.println("\nNormal Weight");
        if (bmi > 25) System.out.println("\nOverweight");
    }
}
