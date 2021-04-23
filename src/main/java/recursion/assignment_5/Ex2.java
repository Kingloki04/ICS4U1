package recursion.assignment_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex2 {

    public static int findCommonDivisor(int num1, int num2, int divisor) {

        if (num1 % divisor == 0 && num2 % divisor == 0) return divisor;
        else return findCommonDivisor(num1, num2, divisor - 1);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter a number: ");
        int num1 = Integer.parseInt(input.readLine());
        System.out.print("Enter another number: ");
        int num2 = Integer.parseInt(input.readLine());

        if (num1 > num2) System.out.println("The largest common divisor is " + findCommonDivisor(num1, num2, num1));
        else System.out.println("The largest common divisor is " + findCommonDivisor(num1, num2, num2));
    }
}
