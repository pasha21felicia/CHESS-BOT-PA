import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class Pawn extends Piece {
    public Pawn() {
    }
    public Pawn(boolean color, Pair<Integer, Integer> position) {
        super(color, position);
    }

    public Pawn(boolean color, Pair<Integer, Integer> position, String type) {
        super(color, position, type);
    }

    public static String changePawn(int x1, int y1, int x2, int y2) {
        String oldPos = ConvertMoves.convertInString(new Pair<>(x1, y1));
        String newPos = ConvertMoves.convertInString(new Pair<>(x2, y2));
        List<Character> pieces_to_choose = new ArrayList<Character>();
        pieces_to_choose.add('q');
        pieces_to_choose.add('b');
        pieces_to_choose.add('r');
        pieces_to_choose.add('n');
        Random rand = new Random();
        char randomElement = pieces_to_choose.get(rand.nextInt(pieces_to_choose.size()));
        oldPos = oldPos + newPos;
        oldPos = oldPos + randomElement;
        return oldPos;
    }

    public Vector<String> possibleMoves( Board board, boolean mode) {
        Vector<String> moves = new Vector<>();
        if (board.board[this.getPosition().getX()][this.getPosition().getY()] == null
                || board.board[this.getPosition().getX()][this.getPosition().getY()].getColor() != mode) {
            return moves;
        }

        if(!mode) {
            if (board.board[this.getPosition().getX()][this.getPosition().getY()] instanceof Pawn) {
                int x = this.getPosition().getX();
                int y = this.getPosition().getY();

                if (inINterval(x + 1, y) && board.board[x + 1][y] == null) {
                    String oldPos = ConvertMoves.convertInString(this.getPosition());
                    String newPos = ConvertMoves.convertInString(new Pair<>(x + 1, y));
                    oldPos = oldPos + newPos;
                    moves.add(oldPos);
                }

                if (x == 2 && board.board[x + 1][y] == null
                        && board.board[x + 2][y] == null) {
                    String oldPos = ConvertMoves.convertInString(this.getPosition());
                    String newPos = ConvertMoves.convertInString(new Pair<>(x + 2, y));
                    oldPos = oldPos + newPos;
                    moves.add(oldPos);
                }

                if (inINterval(x + 1, y + 1) && board.board[x + 1][y + 1] != null &&
                        board.board[x + 1][y + 1].getColor() !=  board.board[x][y].getColor()) {
                    String oldPos = ConvertMoves.convertInString(this.getPosition());
                    String newPos = ConvertMoves.convertInString(new Pair<>(x + 1, y + 1));
                    oldPos = oldPos + newPos;
                    moves.add(oldPos);
                }

                if (inINterval(x + 1, y - 1) && board.board[x + 1][y - 1] != null &&
                        board.board[x + 1][y - 1].getColor() !=  board.board[x][y].getColor()) {
                    String oldPos = ConvertMoves.convertInString(this.getPosition());
                    String newPos = ConvertMoves.convertInString(new Pair<>(x + 1, y - 1));
                    oldPos = oldPos + newPos;
                    moves.add(oldPos);
                }

                if (x + 1 == 8 && inINterval(x + 1, y - 1)  && board.board[x + 1][y - 1] != null &&
                        board.board[x + 1][y - 1].getColor() != board.board[x][y].getColor()) {
                    String pos = changePawn(x, y, x + 1, y - 1);
                    moves.add(pos);

                } else if (x + 1 == 8 && inINterval(x + 1, y + 1)  && board.board[x + 1][y + 1] != null &&
                        board.board[x + 1][y + 1].getColor() != board.board[x][y].getColor()) {
                    String pos = changePawn(x, y, x + 1, y + 1);
                    moves.add(pos);


                } else if (x + 1 == 8 && inINterval(x + 1, y)  && board.board[x + 1][y] == null) {
                    String pos = changePawn(x, y, x + 1, y);
                    moves.add(pos);
                }
            }
        }

        if(mode) {

            if (board.board[this.getPosition().getX()][this.getPosition().getY()] instanceof Pawn) {
                int x = this.getPosition().getX();
                int y = this.getPosition().getY();

                if (inINterval(x - 1, y) && board.board[x - 1][y] == null) {
                    String oldPos = ConvertMoves.convertInString(this.getPosition());
                    String newPos = ConvertMoves.convertInString(new Pair<>(x - 1, y));
                    oldPos = oldPos + newPos;
                    moves.add(oldPos);
                }

                if (x == 7 && board.board[x - 1][y] == null
                        && board.board[x - 2][y] == null) {
                    String oldPos = ConvertMoves.convertInString(this.getPosition());
                    String newPos = ConvertMoves.convertInString(new Pair<>(x - 2, y));
                    oldPos = oldPos + newPos;
                    moves.add(oldPos);
                }

                if (inINterval(x - 1, y + 1) && board.board[x - 1][y + 1] != null &&
                        board.board[x - 1][y + 1].getColor() !=  board.board[x][y].getColor()) {
                    String oldPos = ConvertMoves.convertInString(this.getPosition());
                    String newPos = ConvertMoves.convertInString(new Pair<>(x - 1, y + 1));
                    oldPos = oldPos + newPos;
                    moves.add(oldPos);
                }

                if (inINterval(x - 1, y - 1) && board.board[x - 1][y - 1] != null &&
                        board.board[x - 1][y - 1].getColor() !=  board.board[x][y].getColor()) {
                    String oldPos = ConvertMoves.convertInString(this.getPosition());
                    String newPos = ConvertMoves.convertInString(new Pair<>(x - 1, y - 1));
                    oldPos = oldPos + newPos;
                    moves.add(oldPos);
                }

                if (x - 1 == 1 && inINterval(x - 1, y - 1)  && board.board[x - 1][y - 1] != null &&
                        board.board[x - 1][y - 1].getColor() != board.board[x][y].getColor()) {
                    String pos = changePawn(x, y, x - 1, y - 1);
                    moves.add(pos);

                }
                else if (x - 1 == 1  && inINterval(x - 1, y + 1) && board.board[x - 1][y + 1] != null
                        && board.board[x - 1][y + 1].getColor() != board.board[x][y].getColor()) {
                    String pos = changePawn(x, y, x - 1, y + 1);
                    moves.add(pos);

                }
                else if (x - 1 == 1 && board.board[x - 1][y] == null) {
                    String pos = changePawn(x, y, x - 1, y);
                    moves.add(pos);
                }
            }
        }

//        System.out.println("MOVES OF THE PAWN");
//        for (String move: moves)
//            System.out.println(move);

        return moves;
    }
}
