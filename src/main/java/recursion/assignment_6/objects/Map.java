package recursion.assignment_6.objects;

import java.util.ArrayList;
import java.util.List;

public class Map {

    private ArrayList<char[]> map;

    public Map(ArrayList<char[]> map) {
        this.map = map;
    }

    public void addLine(char[] line) {
        map.add(line);
    }

    public char getByCoordinates(Coordinate pos) {
        return map.get(pos.getY())[pos.getX()];
    }

    public Coordinate getEntrance() {

        List<Coordinate> cords = new ArrayList<>();
        Coordinate e = new Coordinate(0 , 0);
        for (int i = 0; i < map.size(); i++) {

            for (int j = 0; j < map.get(0).length; j++) {

                if (map.get(i)[j] == 'e') e = new Coordinate(j, i);
            }
        }
        cords.add(new Coordinate(e.getX() + 1, e.getY()));
        cords.add(new Coordinate(e.getX() - 1, e.getY()));
        cords.add(new Coordinate(e.getX(), e.getY() + 1));
        cords.add(new Coordinate(e.getX(), e.getY() - 1));
        for (int i = 0; i < map.size(); i++) {

            for (int j = 0; j < map.get(0).length; j++) {

                if (map.get(i)[j] == '.') {

                    for (Coordinate c : cords) {

                        if (c.getX() == j && c.getY() == i) return new Coordinate(j, i);
                    }
                }
            }
        }

        return null;
    }

    public void showMap() {
        for (char[] chars : map) {
            System.out.println(String.valueOf(chars));
        }
    }

    public void setByCoordinate(Coordinate pos, char c) {
        map.get(pos.getY())[pos.getX()] = c;
    }
}
