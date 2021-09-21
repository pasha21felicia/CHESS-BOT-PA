import java.util.Vector;

public abstract class Piece {
    private boolean color;
    private  String  type;
    private Pair<Integer, Integer> position;

    Piece() {

    }

    Piece(boolean color, Pair<Integer, Integer> position) {
        this.color = color;
        this.position = position;
    }

    public Piece(boolean color, Pair<Integer, Integer> position, String type) {
        this.color = color;
        this.type = type;
        this.position = position;
    }

    public boolean getColor() {
        return color;
    }

    public void setColor(boolean color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Pair<Integer, Integer> getPosition() {
        return position;
    }

    public void setPosition(Pair<Integer, Integer> position) {
        this.position = position;
    }

    public abstract Vector<String> possibleMoves( Board board, boolean mode);

    public boolean inINterval(int x, int y) {
        if(x > 0 && x < 9 && y > 0 && y < 9)
            return true;
        return false;
    }
}
