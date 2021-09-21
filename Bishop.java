import java.util.Vector;

public class Bishop extends Piece {
    public Bishop() {
    }

    public Bishop(boolean color, Pair<Integer, Integer> position) {
        super(color, position);
    }

    public Bishop(boolean color, Pair<Integer, Integer> position, String type) {
        super(color, position, type);
    }

    public Vector<String> possibleMoves( Board board, boolean mode) {
        Vector<String> moves = new Vector<>();

        if (board.board[this.getPosition().getX()][this.getPosition().getY()] instanceof Bishop) {

            //check digonal left-down
            for (int i = this.getPosition().getY(), j = this.getPosition().getX(); i > 1 && j > 1; i--, j--) {
                int posDown = i-1;
                int posLeft = j-1;

                if (board.board[posLeft][posDown] == null) {
                    String oldPos = ConvertMoves.convertInString(this.getPosition());
                    String newPos = ConvertMoves.convertInString(new Pair<>(posLeft, posDown));
                    oldPos = oldPos + newPos;
                    moves.add(oldPos);

                } else if  (board.board[posLeft][posDown].getColor() != mode) {
                    String oldPos = ConvertMoves.convertInString(this.getPosition());
                    String newPos = ConvertMoves.convertInString(new Pair<>(posLeft, posDown));
                    oldPos = oldPos + newPos;
                    moves.add(oldPos);
                    break;

                } else
                    break;
            }

            //check left-up
            for (int i = this.getPosition().getY(), j = this.getPosition().getX(); i > 1 && j < 8; i--, j++) {
                int posDown = i-1;
                int posLeft = j+1;

                if (board.board[posLeft][posDown] == null) {
                    String oldPos = ConvertMoves.convertInString(this.getPosition());
                    String newPos = ConvertMoves.convertInString(new Pair<>(posLeft, posDown));
                    oldPos = oldPos + newPos;
                    moves.add(oldPos);

                } else if  (board.board[posLeft][posDown].getColor() != mode) {
                    String oldPos = ConvertMoves.convertInString(this.getPosition());
                    String newPos = ConvertMoves.convertInString(new Pair<>(posLeft, posDown));
                    oldPos = oldPos + newPos;
                    moves.add(oldPos);
                    break;

                } else
                    break;
            }

            //check right-up
            for (int i = this.getPosition().getY(), j = this.getPosition().getX(); i < 8 && j < 8; i++, j++) {
                int posUp = i+1;
                int posRight = j+1;

                if (board.board[posRight][posUp] == null) {
                    String oldPos = ConvertMoves.convertInString(this.getPosition());
                    String newPos = ConvertMoves.convertInString(new Pair<>(posRight, posUp));
                    oldPos = oldPos + newPos;
                    moves.add(oldPos);

                } else if  (board.board[posRight][posUp].getColor() != mode) {
                    String oldPos = ConvertMoves.convertInString(this.getPosition());
                    String newPos = ConvertMoves.convertInString(new Pair<>(posRight, posUp));
                    oldPos = oldPos + newPos;
                    moves.add(oldPos);
                    break;

                } else
                    break;
            }

            //check right-down
            for (int i = this.getPosition().getY(), j = this.getPosition().getX(); i < 8 && j > 1; i++, j--) {
                int posDown = i + 1;
                int posRight = j - 1;

                if (board.board[posRight][posDown] == null) {
                    String oldPos = ConvertMoves.convertInString(this.getPosition());
                    String newPos = ConvertMoves.convertInString(new Pair<>(posRight, posDown));
                    oldPos = oldPos + newPos;
                    moves.add(oldPos);

                } else if  (board.board[posRight][posDown].getColor() != mode) {
                    String oldPos = ConvertMoves.convertInString(this.getPosition());
                    String newPos = ConvertMoves.convertInString(new Pair<>(posRight, posDown));
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
