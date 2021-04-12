package files.assignment_3;

import utils.WritingUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WordSearch {

    public static void main(String[] args) throws IOException {

        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> found = new ArrayList<>();
        char[][] grid = new char[0][0];
        BufferedReader gridFile = new BufferedReader(new FileReader("src/main/java/files/assignment_3/files/WordSearch.txt"));

        String line;
        int size = 0, count = 0;
        while ((line = gridFile.readLine()) != null) {

           if (size == 0) {
               size = Integer.parseInt(line);
               grid = new char[size][size];
           }
           else {

               char[] letters = line.toCharArray();
               for (int i = 0; i < size; i++) {
                   grid[count][i] = letters[i];
               }
               count++;
           }
        }
        gridFile.close();

        BufferedReader wordsFile = new BufferedReader(new FileReader("src/main/java/files/assignment_3/files/WordList.txt"));

        while ((line = wordsFile.readLine()) != null) {

            words.add(line);
        }
        wordsFile.close();

        for (String word : words) {

            String outcome = "", reverse = "";

            // Vertical & Horizontal check
            for (int i = 0; i < size; i++) {

                for (int j = 0; j < (size - (word.length() - 1)); j++) {

                    outcome = "";
                    for (int k = j; k < (j + word.length()); k++) {

                        outcome = outcome.concat(Character.toString(grid[k][i]));
                    }
                    reverse = WritingUtil.reverse(outcome);
                    if (outcome.equalsIgnoreCase(word) || reverse.equalsIgnoreCase(word)) {
                        found.add(word);
                        break;
                    }

                    outcome = "";
                    for (int k = j; k < (j + word.length()); k++) {

                        outcome = outcome.concat(Character.toString(grid[i][k]));
                    }
                    reverse = WritingUtil.reverse(outcome);
                    if (outcome.equalsIgnoreCase(word) || reverse.equalsIgnoreCase(word)) {
                        found.add(word);
                        break;
                    }
                }
            }

            // Diagonal check 1(Top left to bottom right)
            for (int i = 0; i < (size - (word.length() - 1)); i++) {

                for (int j = 0; j < (size - (word.length() - 1)); j++) {

                    outcome = "";
                    int dif = 0;
                    for (int k = j; k < (j + word.length()); k++) {

                        outcome = outcome.concat(Character.toString(grid[k][i + dif]));
                        dif++;
                    }
                    if (outcome.equalsIgnoreCase(word) || reverse.equalsIgnoreCase(word)) {
                        found.add(word);
                        break;
                    }
                }
            }

            // Diagonal check 2(Bottom left to top right)
            for (int i = 0; i < (size - (word.length() - 1)); i++) {

                for (int j = (size - 1); j > (word.length() - 2); j--) {

                    outcome = "";
                    int dif = 0;
                    for (int k = j; k > (j - word.length()); k--) {

                        System.out.println("k = " + k);
                        outcome = outcome.concat(Character.toString(grid[k][i + dif]));
                        dif++;
                    }
                    reverse = WritingUtil.reverse(outcome);
                    if (outcome.equalsIgnoreCase(word) || reverse.equalsIgnoreCase(word)) {
                        found.add(word);
                        break;
                    }
                }
            }
        }

        for (String word : words) {

            if (found.contains(word)) System.out.println(word + " was found in the board");
            else System.out.println(word + " was not found in the board");
        }
    }
}
