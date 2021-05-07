package recursion.assignment_7.objects;

import recursion.assignment_6.objects.Coordinate;

import java.util.ArrayList;

public class Map {

    private ArrayList<ArrayList<Character>> map;

    public Map(ArrayList<ArrayList<Character>> map) {
        this.map = map;
    }

    public void addLine(ArrayList<Character> line) {
        map.add(line);
    }

    public char getByCoordinates(Coordinate pos) {
        return map.get(pos.getY()).get(pos.getX());
    }

    public void showMap() {
        for (ArrayList<Character> chars : map) {
            for(char c : chars) System.out.print(c);
            System.out.println();
        }
    }
}
