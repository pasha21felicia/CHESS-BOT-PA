import java.util.Vector;

public class Rook extends Piece {
    public Rook() {
    }

    private boolean isMoved = false;

    public void setMoved(boolean moved) {
        this.isMoved = moved;
    }

    public boolean isMoved() {
        return isMoved;
    }

    public Rook(boolean color, Pair<Integer, Integer> position) {
        super(color, position);
    }

    public Rook(boolean color, Pair<Integer, Integer> position, String type) {
        super(color, position, type);
    }

    public Vector<String> possibleMoves( Board board, boolean mode) {
        Vector<String> moves = new Vector<>();

        if (board.board[this.getPosition().getX()][this.getPosition().getY()] instanceof Rook) {

            //check upwards
            for (int i = this.getPosition().getX(); i < 8; i++) {
                int posUp = i + 1;

                if (board.board[posUp][this.getPosition().getY()] == null) {
                    String oldPos = ConvertMoves.convertInString(this.getPosition());
                    String newPos = ConvertMoves.convertInString(new Pair<>(posUp, this.getPosition().getY()));
                    oldPos = oldPos + newPos;
                    moves.add(oldPos);

                } else if (board.board[posUp][this.getPosition().getY()].getColor() != mode) {
                    String oldPos = ConvertMoves.convertInString(this.getPosition());
                    String newPos = ConvertMoves.convertInString(new Pair<>(posUp, this.getPosition().getY()));
                    oldPos = oldPos + newPos;
                    moves.add(oldPos);
                    break;

                } else
                    break;
            }

            //check downwards
            for (int i = this.getPosition().getX(); i > 1; i--) {
                int posDown = i - 1;

                if (board.board[posDown][this.getPosition().getY()] == null) {
                    String oldPos = ConvertMoves.convertInString(this.getPosition());
                    String newPos = ConvertMoves.convertInString(new Pair<>(posDown, this.getPosition().getY()));
                    oldPos = oldPos + newPos;
                    moves.add(oldPos);

                } else if (board.board[posDown][this.getPosition().getY()].getColor() != mode) {
                    String oldPos = ConvertMoves.convertInString(this.getPosition());
                    String newPos = ConvertMoves.convertInString(new Pair<>(posDown, this.getPosition().getY()));
                    oldPos = oldPos + newPos;
                    moves.add(oldPos);
                    break;

                } else
                    break;
            }

            //check left
            for (int i = this.getPosition().getY(); i > 1; i--) {
                int posLeft = i - 1;

                if (board.board[this.getPosition().getX()][posLeft] == null) {
                    String oldPos = ConvertMoves.convertInString(this.getPosition());
                    String newPos = ConvertMoves.convertInString(new Pair<>(this.getPosition().getX(), posLeft));
                    oldPos = oldPos + newPos;
                    moves.add(oldPos);

                } else if (board.board[this.getPosition().getX()][posLeft].getColor() != mode) {
                    String oldPos = ConvertMoves.convertInString(this.getPosition());
                    String newPos = ConvertMoves.convertInString(new Pair<>(this.getPosition().getX(), posLeft));
                    oldPos = oldPos + newPos;
                    moves.add(oldPos);
                    break;

                } else
                    break;
            }

            //check right
            for (int i = this.getPosition().getY(); i < 8; i++) {
                int posRight = i + 1;

                if (board.board[this.getPosition().getX()][posRight] == null) {
                    String oldPos = ConvertMoves.convertInString(this.getPosition());
                    String newPos = ConvertMoves.convertInString(new Pair<>(this.getPosition().getX(), posRight));
                    oldPos = oldPos + newPos;
                    moves.add(oldPos);

                } else if (board.board[this.getPosition().getX()][posRight].getColor() != mode) {
                    String oldPos = ConvertMoves.convertInString(this.getPosition());
                    String newPos = ConvertMoves.convertInString(new Pair<>(this.getPosition().getX(), posRight));
                    oldPos = oldPos + newPos;
                    moves.add(oldPos);
                    break;

                } else
                    break;
            }
        }

        return moves;
    }
}
