package recursion.assignment_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex4 {

    public static int sumDigit(String num, int pos, int sum) {
        int difference = Integer.parseInt(String.valueOf(num.charAt(pos)));

        if (pos == (num.length() - 1)) return sum + difference;
        else return sumDigit(num, pos + 1, sum + difference);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter a number: ");
        String num = input.readLine();

        System.out.println("The sum of this numbers individual parts is " + sumDigit(num, 0, 0));
    }
}
