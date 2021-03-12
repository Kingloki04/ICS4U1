package review.assignment_1;

import java.util.Scanner;

public class Assign12 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter the votes: ");
        String votes = input.nextLine();

        int countA = 0, countB = 0;
        for (int i = 0; i < votes.length(); i++) {
            if (votes.charAt(i) == 'A' || votes.charAt(i) == 'a') countA++;
            if (votes.charAt(i) == 'B' || votes.charAt(i) == 'b') countB++;
        }

        if (countA == countB) {
            System.out.println("A and B Tied");
            return;
        }
        if (countA > countB) {
            System.out.println("The Winner is A");
            return;
        }
        System.out.println("The Winner is B");

    }
}
