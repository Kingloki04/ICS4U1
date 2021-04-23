package recursion.assignment_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex3 {

    public static int getFibonacci(int finPos, int curPos, int fibPos1, int fibPos2) {

        if (finPos == curPos) return fibPos2;
        else return getFibonacci(finPos, curPos + 1, fibPos2, (fibPos1 + fibPos2));
    }

    public static void main(String[] args) throws IOException {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter what position in the Fibonacci sequence: ");
        int pos = Integer.parseInt(input.readLine());

        System.out.println(getFibonacci(pos, 1, 0, 1));
    }
}
