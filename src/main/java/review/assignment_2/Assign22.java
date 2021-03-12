package review.assignment_2;

import utils.MathUtil;
import utils.WritingUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Assign22 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<String> names = new ArrayList<>();
        ArrayList<Integer> marks = new ArrayList<>();

        String name = "";
        int mark = 0;
        while(mark != -1) {
            System.out.print("Enter a name: ");
            name = input.next();

            if (name.equals("-1")) break;

            System.out.print("Enter a mark: ");
            mark = input.nextInt();
            System.out.println();

            if ((mark < 0 || mark > 100) && mark != -1) System.out.println("The mark must be between 0-100");
            else if(mark != -1) {
                names.add(name);
                marks.add(mark);
            }
        }

        System.out.println(WritingUtil.repeatString("*", 50));
        double mean = MathUtil.average(marks);
        System.out.println("Mean: " + MathUtil.round(mean, 1) + "\n");

        int mode = MathUtil.mode(marks);
        if (mode != 0) System.out.println("Mode: " + mode + "\n");
        else System.out.println("There is no mode\n");

        System.out.println("Median: " + MathUtil.median(sortMarks(marks)));
        System.out.println(WritingUtil.repeatString("*", 50));
    }

    private static ArrayList<Integer> sortMarks(ArrayList<Integer> marks) {
        int j;
        for (int i = 0; i < marks.size() -1; i++) {
            j = i;
            while (j >= 0 && marks.get(j) < marks.get(j + 1)) {
                Collections.swap(marks, j, j + 1);
            }
        }

        return marks;
    }
}
