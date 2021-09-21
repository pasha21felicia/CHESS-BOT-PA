import java.util.Vector;

public class King extends Piece {
    private boolean isMoved = false;

    public King() {
    }

    public boolean isMoved() {
        return isMoved;
    }

    public void setMoved(boolean moved) {
        isMoved = moved;
    }

    public King(boolean color, Pair<Integer, Integer> position) {
        super(color, position);
    }

    public King(boolean color, Pair<Integer, Integer> position, String type) {
        super(color, position, type);
    }

    public Vector<String> possibleMoves( Board board, boolean mode) {
        Vector<String> moves = new Vector<>();

        if (board.board[this.getPosition().getX()][this.getPosition().getY()] == null
                || board.board[this.getPosition().getX()][this.getPosition().getY()].getColor() != mode) {
            return moves;
        }

        if (board.board[this.getPosition().getX()][this.getPosition().getY()] instanceof King) {
            int x = this.getPosition().getX();
            int y = this.getPosition().getY();

            if (inINterval(x - 1, y) &&
                    (board.board[x - 1][y] == null || board.board[x - 1][y].getColor() != mode)) {
                String oldPos = ConvertMoves.convertInString(this.getPosition());
                String newPos = ConvertMoves.convertInString(new Pair<>(x - 1, y));
                oldPos = oldPos + newPos;
                moves.add(oldPos);
            }

            if (inINterval(x + 1, y) &&
                    (board.board[x + 1][y] == null || board.board[x + 1][y].getColor() != mode)) {
                String oldPos = ConvertMoves.convertInString(this.getPosition());
                String newPos = ConvertMoves.convertInString(new Pair<>(x + 1, y));
                oldPos = oldPos + newPos;
                moves.add(oldPos);
            }

            if (inINterval(x, y + 1) &&
                    (board.board[x][y + 1] == null || board.board[x][y + 1].getColor() != mode)) {
                String oldPos = ConvertMoves.convertInString(this.getPosition());
                String newPos = ConvertMoves.convertInString(new Pair<>(x, y + 1));
                oldPos = oldPos + newPos;
                moves.add(oldPos);
            }

            if (inINterval(x, y - 1) &&
                    (board.board[x][y - 1] == null || board.board[x][y - 1].getColor() != mode)) {
                String oldPos = ConvertMoves.convertInString(this.getPosition());
                String newPos = ConvertMoves.convertInString(new Pair<>(x, y - 1));
                oldPos = oldPos + newPos;
                moves.add(oldPos);
            }

            if (inINterval(x + 1, y + 1) &&
                    (board.board[x + 1][y + 1] == null || board.board[x + 1][y + 1].getColor() != mode)) {
                String oldPos = ConvertMoves.convertInString(this.getPosition());
                String newPos = ConvertMoves.convertInString(new Pair<>(x + 1, y + 1));
                oldPos = oldPos + newPos;
                moves.add(oldPos);
            }

            if (inINterval(x + 1, y - 1) &&
                    (board.board[x + 1][y - 1] == null || board.board[x + 1][y - 1].getColor() != mode)) {
                String oldPos = ConvertMoves.convertInString(this.getPosition());
                String newPos = ConvertMoves.convertInString(new Pair<>(x + 1, y - 1));
                oldPos = oldPos + newPos;
                moves.add(oldPos);
            }

            if (inINterval(x - 1, y + 1) &&
                    (board.board[x - 1][y + 1] == null || board.board[x - 1][y + 1].getColor() != mode)) {
                String oldPos = ConvertMoves.convertInString(this.getPosition());
                String newPos = ConvertMoves.convertInString(new Pair<>(x - 1, y + 1));
                oldPos = oldPos + newPos;
                moves.add(oldPos);
            }

            if (inINterval(x - 1, y - 1) &&
                    (board.board[x - 1][y - 1] == null || board.board[x - 1][y - 1].getColor() != mode)) {
                String oldPos = ConvertMoves.convertInString(this.getPosition());
                String newPos = ConvertMoves.convertInString(new Pair<>(x - 1, y - 1));
                oldPos = oldPos + newPos;
                moves.add(oldPos);
            }
        }

        return moves;
    }

    public boolean isSmallCastlingPossible(Board board, boolean mode) {
        Vector<String> opponentMoves = board.getAllPossibleMoves(!mode);

        if (this.isMoved())
            return false;

        if (board.inDanger(opponentMoves, mode))
            return false;

        if (!mode) {
            if(this.getPosition().getX() != 1 || this.getPosition().getY() != 5)
                return false;

            for (int i = 6; i < 8; i++) {
                if (board.board[1][i] != null)
                    return false;

                if (board.canBeCaptured(opponentMoves, new Pair<>(1, i)))
                    return false;
            }
            return (board.board[1][8] instanceof Rook && !((Rook) board.board[1][8]).isMoved());

        } else {
            if(this.getPosition().getX() != 8  || this.getPosition().getY() != 5)
                return false;

            for (int i = 6; i < 8; i++) {
                if (board.board[8][i] != null)
                    return false;

                if (board.canBeCaptured(opponentMoves, new Pair<>(8, i)))
                    return false;
            }

            return (board.board[8][8] instanceof Rook && !((Rook) board.board[8][8]).isMoved());
        }
    }

    public boolean isBigCastlingPossible(Board board, boolean mode) {
        Vector<String> opponentMoves = board.getAllPossibleMoves(!mode);

        if (this.isMoved())
            return false;

        if (board.inDanger(opponentMoves, mode))
            return false;

        if (!mode) {
            if(this.getPosition().getX() != 1  || this.getPosition().getY() != 5)
                return false;

            for (int i = 4; i > 1; i--) {
                if (board.board[1][i] != null)
                    return false;

                if (i > 2 && board.canBeCaptured(opponentMoves, new Pair<>(1, i)))
                    return false;
            }

            return (board.board[1][1] instanceof Rook && !((Rook) board.board[1][1]).isMoved());

        } else {
            if(this.getPosition().getX() != 8  || this.getPosition().getY() != 5)
                return false;

            for (int i = 4; i > 1; i--) {
                if (board.board[8][i] != null)
                    return false;

                if (i > 2 && board.canBeCaptured(opponentMoves, new Pair<>(8, i)))
                    return false;
            }

            return (board.board[8][1] instanceof Rook && !((Rook) board.board[8][1]).isMoved());
        }
    }

}