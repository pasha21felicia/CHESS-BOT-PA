import java.util.Vector;

public class Queen extends Piece {
    public Queen() {
    }

    public Queen(boolean color, Pair<Integer, Integer> position) {
        super(color, position);
    }

    public Queen(boolean color, Pair<Integer, Integer> position, String type) {
        super(color, position, type);
    }

    public Vector<String> possibleMoves( Board board, boolean mode) {
        Vector<String> moves = new Vector<>();

        //check digonal left-down
        for (int i = this.getPosition().getY(), j = this.getPosition().getX(); i > 1 && j > 1; i--, j--) {
            int posDown = i-1;
            int posLeft = j-1;

            if (board.board[posLeft][posDown] == null) {
                String oldPos = ConvertMoves.convertInString(this.getPosition());
                String newPos = ConvertMoves.convertInString(new Pair<>(posLeft, posDown));
                oldPos = oldPos + newPos;
                moves.add(oldPos);

            } else if (board.board[posLeft][posDown].getColor() != mode) {
                String oldPos = ConvertMoves.convertInString(this.getPosition());
                String newPos = ConvertMoves.convertInString(new Pair<>(posLeft, posDown));
                oldPos = oldPos + newPos;
                moves.add(oldPos);
                break;

            } else
                break;
        }

//        check left-up
        for (int i = this.getPosition().getY(), j = this.getPosition().getX(); i > 1 && j < 8; i--, j++) {
            int posDown = i - 1;
            int posLeft = j + 1;

            if (board.board[posLeft][posDown] == null) {
                String oldPos = ConvertMoves.convertInString(this.getPosition());
                String newPos = ConvertMoves.convertInString(new Pair<>(posLeft, posDown));
                oldPos = oldPos + newPos;
                moves.add(oldPos);

            } else if (inINterval(posLeft, posDown) && board.board[posLeft][posDown].getColor() != mode) {
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

            } else if (inINterval(posRight, posUp) && board.board[posRight][posUp].getColor() != mode) {
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
            int posDown = i+1;
            int posRight = j-1;

            if (board.board[posRight][posDown] == null) {
                String oldPos = ConvertMoves.convertInString(this.getPosition());
                String newPos = ConvertMoves.convertInString(new Pair<>(posRight, posDown));
                oldPos = oldPos + newPos;
                moves.add(oldPos);

            } else if (inINterval(posRight, posDown) && board.board[posRight][posDown].getColor() != mode) {
                String oldPos = ConvertMoves.convertInString(this.getPosition());
                String newPos = ConvertMoves.convertInString(new Pair<>(posRight, posDown));
                oldPos = oldPos + newPos;
                moves.add(oldPos);
                break;

            } else
                break;
        }

        //check upwards
        for (int i = this.getPosition().getX(); i < 8; i++) {
            int posUp = i + 1;

            if (board.board[posUp][this.getPosition().getY()] == null) {
                String oldPos = ConvertMoves.convertInString(this.getPosition());
                String newPos = ConvertMoves.convertInString(new Pair<>(posUp, this.getPosition().getY()));
                oldPos = oldPos + newPos;
                moves.add(oldPos);

            } else if (inINterval(posUp, this.getPosition().getY()) &&
                    board.board[posUp][this.getPosition().getY()].getColor() != mode) {
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
            int posDown = i-1;

            if (board.board[posDown][this.getPosition().getY()] == null) {
                String oldPos = ConvertMoves.convertInString(this.getPosition());
                String newPos = ConvertMoves.convertInString(new Pair<>(posDown, this.getPosition().getY()));
                oldPos = oldPos + newPos;
                moves.add(oldPos);

            } else if (inINterval(posDown, this.getPosition().getY()) &&
                    board.board[posDown][this.getPosition().getY()].getColor() != mode) {
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
            int posLeft = i-1;

            if (board.board[this.getPosition().getX()][posLeft] == null) {
                String oldPos = ConvertMoves.convertInString(this.getPosition());
                String newPos = ConvertMoves.convertInString(new Pair<>(this.getPosition().getX(), posLeft));
                oldPos = oldPos + newPos;
                moves.add(oldPos);

            } else if (inINterval(this.getPosition().getX(), posLeft) &&
                    board.board[this.getPosition().getX()][posLeft].getColor() != mode) {
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

            } else if (inINterval(this.getPosition().getX(), posRight) &&
                    board.board[this.getPosition().getX()][posRight].getColor() != mode) {
                String oldPos = ConvertMoves.convertInString(this.getPosition());
                String newPos = ConvertMoves.convertInString(new Pair<>(this.getPosition().getX(), posRight));
                oldPos = oldPos + newPos;
                moves.add(oldPos);
                break;

            } else
                break;
        }

        return moves;
    }
}
