package recursion.assignment_6;

import recursion.assignment_6.objects.Coordinate;
import recursion.assignment_6.objects.Map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SolvingMazes {

    public static boolean solveMaze(Map maze, Coordinate cur) {

        if (maze.getByCoordinates(cur) == 'x') {
            maze.showMap();
            return true;
        }

        if (maze.getByCoordinates(cur) == '%' || maze.getByCoordinates(cur) == '+' || maze.getByCoordinates(cur) == 'e') return false;
        else {
            maze.setByCoordinate(cur, '+');
        }

        if (solveMaze(maze, cur.xAdd(1))) return true;
        if (solveMaze(maze, cur.xAdd(-1))) return true;
        if (solveMaze(maze, cur.yAdd(1))) return true;
        if (solveMaze(maze, cur.yAdd(-1))) return true;
        else {
            maze.setByCoordinate(cur, '.');
            return false;
        }

    }

    public static void main(String[] args) throws IOException {

        Map maze = new Map(new ArrayList<char[]>());

        BufferedReader file = new BufferedReader(new FileReader("src/main/java/recursion/assignment_6/files/Maze.txt"));

        int temp = 0;
        String line;
        while ((line = file.readLine()) != null) {

            if (temp != 0) {

                maze.addLine(line.toCharArray());
            }
            else temp++;
        }
        file.close();

        if (solveMaze(maze, maze.getEntrance())) System.out.println("Maze Solved!");

    }
}