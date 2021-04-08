package review.assignment_2;

import utils.WritingUtil;

import java.util.ArrayList;
import java.util.Scanner;

public class Assign21 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String response = input.nextLine();

        String[] words = response.split(" ");

        for (String word : words) {
            tree(word.toUpperCase());
            System.out.println();
        }
    }

    private static void tree(String word) {

        ArrayList<String> layers = new ArrayList<>();
        char[] letters = word.toCharArray();

        int len = letters.length;
        for (int i = 0; i < len; i++) {
            String space = WritingUtil.repeatString(" ", len - (i + 1)), front = "", end = "";

            for (int j = 0; j < i; j++) {
                front = front.concat(Character.toString(letters[j]));
            }

            end = WritingUtil.reverse(front);

            layers.add(space + front + letters[i] + end);
            System.out.println(space + front + letters[i] + end);
        }

        for (int i = (len - 2); i > 0; i--) {
            System.out.println(layers.get(i));
        }

        for (char letter : letters) System.out.println(WritingUtil.repeatString(" ", len - 1) + letter);
    }
}
