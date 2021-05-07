package recursion.assignment_7.objects;

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

    public Coordinate modifyX(int value) {
        return new Coordinate(x + value, y);
    }

    public Coordinate modifyY(int value) {
        return new Coordinate(x, y + value);
    }
}
