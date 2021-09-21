public class Move {

    private Pair from;
    private Pair dest;
    private int type;
    boolean isEnPassant = false;

    public Move(Pair from, Pair dest) {
        this.from = from;
        this.dest = dest;
    }

    public Move(Pair from, Pair dest, int type) {
        this.from = from;
        this.dest = dest;
        this.type = type;
    }

    public Pair getDest() {
        return dest;
    }

    public Pair getFrom() {
        return from;
    }

    public int getType() {
        return type;
    }

    public void setFrom(Pair from) {
        this.from = from;
    }

    public void setDest(Pair dest) {
        this.dest = dest;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isDoublePawnMove() {
        if (this.getFrom().getX() == 7 && this.getDest().getX() == 5)
            return true;
        return false;
    }

    public boolean isEquals(Move a) {
        if(this.dest.getX() == a.dest.getX() && this.dest.getY() == a.dest.getY() &&
                this.from.getX() == a.from.getX() && this.from.getY() == a.from.getY())
            return true;
        return false;
    }

    @Override
    public String toString() {
        return "from=" + from + " dest=" + dest +"\n";
    }
}
