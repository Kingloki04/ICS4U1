package recursion.assignment_7;

import recursion.assignment_7.objects.Coordinate;
import recursion.assignment_7.objects.Map;
import utils.MathUtil;
import utils.WritingUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Boggle {

    public static void main(String[] args) throws IOException {

        BufferedReader file = new BufferedReader(new FileReader("src/main/java/recursion/assignment_7/files/dictionary.txt"));
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> words = new ArrayList<>();
        Map board = generateMap();
        board.showMap();
        int score = 0;

        String line;
        while ((line = file.readLine()) != null) {
            words.add(line);
        }
        file.close();
        quickSort(words, 0, words.size() - 1);

        String ans = "";
        while(true) {

            System.out.print("Enter a word: ");
            ans = input.readLine().toLowerCase();

            if (ans.equals("666")) {
                System.out.println(WritingUtil.repeatString("#", 75));
                System.out.println("Reset the score and board");
                System.out.println();
                board = generateMap();
                board.showMap();
                score = 0;
            } else if (ans.equals("999")) break;

            int pos = binarySearch(words, ans);
            if (pos != -1) {
                ArrayList<Coordinate> starts = board.getAllByChar(ans.toUpperCase().charAt(0));

                if (starts.size() != 0) {
                    boolean found = false;
                    for (Coordinate start : starts) {
                        if (containsWord(board, ans.toUpperCase(), start, board, 0)) {
                            int len = ans.length();
                            if (len == 5) {
                                System.out.println("+2 points!");
                                score += 2;
                            }
                            if (len == 6) {
                                System.out.println("+3 points!");
                                score += 3;
                            }
                            if (len == 7) {
                                System.out.println("+5 points!");
                                score += 5;
                            }
                            if (len > 7) {
                                System.out.println("+11 points!");
                                score += 11;
                            } else System.out.println("No points gained. " + ans.toUpperCase() + " is to small");
                            found = true;
                            break;
                        }
                    }
                    if (!found) System.out.println(ans.toUpperCase() + " could not be found on this board");
                }
            } else System.out.println(ans.toUpperCase() + " could not be found in the dictionary");
        }
        System.out.println("Your final score is: " + score);
    }

    private static boolean containsWord(Map board, String word, Coordinate cur, Map temp, int count) {

        if (cur.getX() == -1 || cur.getX() == 5 || cur.getY() == -1 || cur.getY() == 5) return false;

        if (count == word.length() - 1 && temp.getByCoordinates(cur) == word.charAt(word.length() - 1)) return true;
        else if (temp.getByCoordinates(cur) == word.charAt(count)) {
            temp.setByCoordinate(cur, '+');
        } else return false;

        count += 1;
        if (containsWord(board, word, cur.modifyX(1), temp, count)) return true;
        if (containsWord(board, word, cur.modifyX(1).modifyY(1), temp, count)) return true;
        if (containsWord(board, word, cur.modifyY(1), temp, count)) return true;
        if (containsWord(board, word, cur.modifyY(1).modifyX(-1), temp, count)) return true;
        if (containsWord(board, word, cur.modifyX(-1), temp, count)) return true;
        if (containsWord(board, word, cur.modifyX(-1).modifyY(-1), temp, count)) return true;
        if (containsWord(board, word, cur.modifyY(-1), temp, count)) return true;
        if (containsWord(board, word, cur.modifyY(-1).modifyX(1), temp, count)) return true;
        else {
            temp.setByCoordinate(cur, board.getByCoordinates(cur));
            return false;
        }
    }

    private static Map generateMap() {
        Map board = new Map(new ArrayList<ArrayList<Character>>());

        for (int i = 0; i < 5; i++) {

            ArrayList<Character> results = new ArrayList<>();
            for (int j = 0; j < 5; j++) {

                int num = MathUtil.random(65, 90);
                results.add((char)num);
            }
            board.addLine(results);
        }

        return board;
    }

    private static void quickSort(ArrayList<String> a, int start, int end) {
        int i = start;
        int j = end;
        if (j - i >= 1) {
            String pivot = a.get(i);
            while (j > i) {
                while (a.get(i).compareTo(pivot) <= 0 && i <= end && j > i) {
                    i++;
                }
                while (a.get(j).compareTo(pivot) >= 0 && j >= start && j >= i) {
                    j--;
                }
                if (j > i) Collections.swap(a, i, j);
            }

            Collections.swap(a, start, j);
            quickSort(a, start, j - 1);
            quickSort(a, j + 1, end);
        }
    }

    private static int binarySearch(ArrayList<String> words, String find) {
       int low = 0, high = words.size() - 1, mid = (low + high) / 2;

       while (low <= high && !words.get(mid).equalsIgnoreCase(find)) {

           if (words.get(mid).compareTo(find) < 0) low = mid + 1;
           else high = mid - 1;

           mid = (low + high) / 2;

           if (low > high) mid = -1;
       }
       return mid;
    }
}
