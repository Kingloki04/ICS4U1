package recursion.assignment_7.map;

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

    public void setByCoordinate(Coordinate pos, char c) {
        map.get(pos.getY()).set(pos.getX(), c);
    }

    public ArrayList<Coordinate> getAllByChar(char c) {
        ArrayList<Coordinate> cords = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (map.get(j).get(i).compareTo(c) == 0) cords.add(new Coordinate(i, j));
            }
        }
        return cords;
    }

    public void showMap() {
        for (ArrayList<Character> chars : map) {
            for(char c : chars) System.out.print(c);
            System.out.println();
        }
    }
}
