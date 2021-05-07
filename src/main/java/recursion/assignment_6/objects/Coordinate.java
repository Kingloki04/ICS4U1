package recursion.assignment_6.objects;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Coordinate {

    private int x;
    private int y;

    public Coordinate(int x, int y) {

        this.x = x;
        this.y = y;
    }

    public Coordinate xAdd(int value) {
        return new Coordinate(x + value, y);
    }

    public Coordinate yAdd(int value) {
        return new Coordinate(x, y + value);
    }

}
