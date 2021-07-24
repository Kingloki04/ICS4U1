package files.assignment_4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HTMLViewer {


    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader file = new BufferedReader(new FileReader("src/main/java/files/assignment_4/files/HTMLViewer.txt"));

        System.out.print("Width: ");
        int width = Integer.parseInt(input.readLine());

        String line, text = "";
        while ((line = file.readLine()) != null) {

            text = text.concat(line);
        }
        file.close();
        input.close();

       text = text.replaceAll("<br>", " <br> ")
               .replaceAll("<p>", " <p> ")
               .replaceAll("<hr>", " <hr> ");
       String[] parts = text.split(" ");





//        int counter = 1;
//        for (int i = 0; i < text.length(); i++) {
//
//            if (text.charAt(i) == ' ') {
//                int count = 1;
//                boolean looking = true;
//                while (looking) {
//                    if (i + count > text.length() - 1) break;
//                    if (text.charAt(i + count) == ' ') looking = false;
//                    else count++;
//                }
//                System.out.println(" " + (counter + count + 1) + " " + text.substring(i + 1, i + count));
//                if (counter + count + 1 > width) {
//                    System.out.print("\n");
//                    counter = 0;
//                } else System.out.print(" ");
//            } else if (counter == width) {
//                System.out.print(text.charAt(i) + "\n");
//                counter++;
//            } else if(text.charAt(i) == '<') {
//                if (text.charAt(i + 1) == 'b') {
//                    text = text.replaceFirst("<br>", "");
//                    System.out.print("\n");
//                    counter = 0;
//                    System.out.print(text.charAt(i));
//                } else if (text.charAt(i + 1) == 'p') {
//                    text = text.replaceFirst("<p>", "");
//                    System.out.print("\n\n");
//                    counter = 0;
//                    System.out.print(text.charAt(i));
//                } else if (text.charAt(i + 1) == 'h') {
//                    text = text.replaceFirst("<hr>", "");
//                    System.out.print(WritingUtil.repeatString("_", width));
//                    counter = 0;
//                }
//            } else {
//                System.out.print(text.charAt(i));
//                counter++;
//            }
//        }
    }
}
