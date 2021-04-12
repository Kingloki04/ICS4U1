package files.assignment_3;

import utils.WritingUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HTMLViewer {


    public static void main(String[] args) throws IOException {

        BufferedReader file = new BufferedReader(new FileReader("src/main/java/files/assignment_3/files/HTMLViewer.txt"));

        String line, text = "";
        int width = 35;
        while ((line = file.readLine()) != null) {

            text = text.concat(line);
        }
        file.close();

        text = text.replace("<br>", "\n");
        text = text.replace("<p>", "\n\n");
        text = text.replace("<hr>", WritingUtil.repeatString("_", width));

        System.out.println(text);
    }
}
