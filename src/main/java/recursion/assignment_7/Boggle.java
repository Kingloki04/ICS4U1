package recursion.assignment_7;

import recursion.assignment_7.objects.Map;
import utils.MathUtil;

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

        String line;
        while ((line = file.readLine()) != null) {
            words.add(line);
        }
        file.close();
        quickSort(words, 0, words.size() - 1);

        String ans = "";
        while(!ans.equals("999")) {

            System.out.print("Enter a word: ");
            ans = input.readLine();

            int pos = binarySearch(words, ans);
            if (pos != -1) {
                boolean result = containsWord();
                if (result) System.out.println("Word found");
                // TODO Create point system
            }
            else System.out.println(ans + " is an invalid word");
        }
    }

    private static boolean containsWord() {
        return true;
    }

    private static Map generateMap() {
        Map board = new Map(new ArrayList<ArrayList<Character>>());

        for (int i = 0; i < 5; i++) {

            ArrayList<Character> results = new ArrayList<>();
            for (int j = 0; j < 5; j++) {

                int num = MathUtil.random(0, 25);
                results.add((char)num);
            }
            board.addLine(results);
        }

        return board;
    }

    private static void quickSort(ArrayList<String> a, int start, int end)
    {
        int i = start;
        int j = end;
        if (j - i >= 1)
        {
            String pivot = a.get(i);
            while (j > i)
            {
                while (a.get(i).compareTo(pivot) <= 0 && i <= end && j > i){
                    i++;
                }
                while (a.get(j).compareTo(pivot) >= 0 && j >= start && j >= i){
                    j--;
                }
                if (j > i)
                    Collections.swap(a, i, j);
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
