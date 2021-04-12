package files.assignment_3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class WordStats {

    public static void main(String[] args) throws IOException {

        ArrayList<String> words = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        BufferedReader file = new BufferedReader(new FileReader("src/main/java/files/assignment_3/files/WordStats.txt"));
        StringTokenizer st;

        String line;
        while ((line = file.readLine()) != null) {

            st = new StringTokenizer(line);
            while (st.hasMoreTokens()) {
                String word = st.nextToken().toLowerCase();

                if (word.contains(".")) word = word.replace(".", "");

                if (words.contains(word)) {
                    map.put(word, map.get(word) + 1);
                } else {
                    words.add(word);
                    map.put(word, 1);
                }
            }
        }

        Collections.sort(words);

        System.out.println("Word: Occurrence");
        for (int i = 0; i < words.size(); i++) {
            System.out.println(words.get(i) + ": " + map.get(words.get(i)));
        }
    }
}
