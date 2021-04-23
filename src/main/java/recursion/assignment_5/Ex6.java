package recursion.assignment_5;

import utils.WritingUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex6 {

    public static String findPalindrome(String text, int count, int start) {

        if (count == 2) return "";
        if (start == (text.length() - count) + 1) return  findPalindrome(text, count - 1, 0);
        else {
            if (checkPalindrome(text.substring(start, (count + start)))) return text.substring(start, (count + start));
            else return  findPalindrome(text, count, start + 1);
        }
    }

    private static boolean checkPalindrome(String text) {

        text = text.toLowerCase().replaceAll(" ", "");
        return text.equals(WritingUtil.reverse(text));
    }

    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the text you would like to check: ");
        String text = input.readLine();

        String outcome = findPalindrome(text, text.length(), 0);
        if (outcome.equals("")) System.out.println("This text does not contain a palindrome");
        else System.out.println("This text contains the palindrome " + outcome);
    }
}
