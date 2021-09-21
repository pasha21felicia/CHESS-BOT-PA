import java.util.Vector;

public class Knight extends Piece {
    public Knight() {
    }

    public Knight(boolean color, Pair<Integer, Integer> position) {
        super(color, position);
    }

    public Knight(boolean color, Pair<Integer, Integer> position, String type) {
        super(color, position, type);
    }

    public Vector<String> possibleMoves( Board board, boolean mode) {
        Vector<String> moves = new Vector<>();
        int X = this.getPosition().getX();
        int Y = this.getPosition().getY();

        // 1
        if (board.board[this.getPosition().getX()][this.getPosition().getY()] instanceof Knight) {

            if (this.inINterval(X - 2, Y - 1) &&
                    (board.board[X - 2][Y - 1] == null || board.board[X - 2][Y - 1].getColor() == !mode)) {
                String oldPos = ConvertMoves.convertInString(this.getPosition());
                String newPos = ConvertMoves.convertInString(new Pair<>(X - 2, Y - 1));
                oldPos = oldPos + newPos;
                moves.add(oldPos);
            }

            // 2
            if (this.inINterval(X - 1, Y - 2) &&
                    (board.board[X - 1][Y - 2] == null || board.board[X - 1][Y - 2].getColor() == !mode)) {
                String oldPos = ConvertMoves.convertInString(this.getPosition());
                String newPos = ConvertMoves.convertInString(new Pair<>(X - 1, Y - 2));
                oldPos = oldPos + newPos;
                moves.add(oldPos);
            }

            // 3
            if (this.inINterval(X + 1, Y - 2) &&
                    (board.board[X + 1][Y - 2] == null || board.board[X + 1][Y - 2].getColor() == !mode)) {
                String oldPos = ConvertMoves.convertInString(this.getPosition());
                String newPos = ConvertMoves.convertInString(new Pair<>(X + 1, Y - 2));
                oldPos = oldPos + newPos;
                moves.add(oldPos);
            }

            // 4
            if (this.inINterval(X + 2, Y - 1) &&
                    (board.board[X + 2][Y - 1] == null || board.board[X + 2][Y - 1].getColor() == !mode)) {
                String oldPos = ConvertMoves.convertInString(this.getPosition());
                String newPos = ConvertMoves.convertInString(new Pair<>(X + 2, Y - 1));
                oldPos = oldPos + newPos;
                moves.add(oldPos);
            }

            // 5
            if (this.inINterval(X + 2, Y + 1) &&
                    (board.board[X + 2][Y + 1] == null || board.board[X + 2][Y + 1].getColor() == !mode)) {
                String oldPos = ConvertMoves.convertInString(this.getPosition());
                String newPos = ConvertMoves.convertInString(new Pair<>(X + 2, Y + 1));
                oldPos = oldPos + newPos;
                moves.add(oldPos);
            }

            // 6
            if (this.inINterval(X + 1, Y + 2) &&
                    (board.board[X + 1][Y + 2] == null || board.board[X + 1][Y + 2].getColor() == !mode)) {
                String oldPos = ConvertMoves.convertInString(this.getPosition());
                String newPos = ConvertMoves.convertInString(new Pair<>(X + 1, Y + 2));
                oldPos = oldPos + newPos;
                moves.add(oldPos);
            }

            // 7
            if (this.inINterval(X - 1, Y + 2) &&
                    (board.board[X - 1][Y + 2] == null || board.board[X - 1][Y + 2].getColor() == !mode)) {
                String oldPos = ConvertMoves.convertInString(this.getPosition());
                String newPos = ConvertMoves.convertInString(new Pair<>(X - 1, Y + 2));
                oldPos = oldPos + newPos;
                moves.add(oldPos);
            }

            // 8
            if (this.inINterval(X - 2, Y + 1) &&
                    (board.board[X - 2][Y + 1] == null || board.board[X - 2][Y + 1].getColor() == !mode)) {
                String oldPos = ConvertMoves.convertInString(this.getPosition());
                String newPos = ConvertMoves.convertInString(new Pair<>(X - 2, Y + 1));

                oldPos = oldPos + newPos;
                moves.add(oldPos);
            }
        }

//        System.out.println("MOVES OF THE KNIGHT");
//        for (String move: moves)
//            System.out.println(move);

        return moves;
    }
}
