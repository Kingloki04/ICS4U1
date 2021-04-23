package recursion.assignment_5;

import utils.WritingUtil;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex5 {

    public static boolean checkPalindrome(String word, int pos) {

        if (pos == (word.length() - 1)) return true;
        if (word.toLowerCase().replaceAll(" ", "").charAt(pos) == WritingUtil.reverse(word.toLowerCase().replaceAll(" ", "")).charAt(pos)) return checkPalindrome(word, pos + 1);
        else return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter some text: ");
        String text = input.readLine();

        boolean result = checkPalindrome(text, 0);

        if (result) System.out.println("The given text is a palindrome");
        else System.out.println("The given text is a palindrome");
    }
}
