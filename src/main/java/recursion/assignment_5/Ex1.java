package recursion.assignment_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex1 {

    public static int[] divide(int num, int divisor, int divisons) {
        int division = (num - divisor);

        if ((division - divisor) == 0) return new int[]{divisons + 2, 0};
        if (division > divisor) return divide(division, divisor, divisons + 1);
        return new int[]{divisons + 1, (division)};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Please enter a number: ");
        int num = Integer.parseInt(input.readLine());
        System.out.print("Please enter a number to divide by: ");
        int divisor = Integer.parseInt(input.readLine());

        int[] outcome = divide(num, divisor, 0);
        System.out.println();
        System.out.println("Quotient: " + outcome[0]);
        System.out.println("Remainder: " + outcome[1]);
    }
}
