import java.util.Vector;

public class Board_Copy {
    public Piece[][] copie;

    public Board_Copy() {
        copie = new Piece[9][9];
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                copie[i][j] = null;
            }
        }
    }

    public void duplicate(Board board, Board_Copy bc) {
        for (int i = 1; i < 9; i ++) {
            for(int j = 1; j < 9; j++) {

                if(board.board[i][j] instanceof Pawn) {
                    bc.copie[i][j] = new Pawn(board.board[i][j].getColor(), new Pair<>(i, j), board.board[i][j].getType());

                } else if(board.board[i][j] instanceof Rook) {
                    bc.copie[i][j] = new Rook(board.board[i][j].getColor(), new Pair<>(i, j), board.board[i][j].getType());

                } else if(board.board[i][j] instanceof Knight) {
                    bc.copie[i][j] = new Knight(board.board[i][j].getColor(), new Pair<>(i, j), board.board[i][j].getType());

                } else if(board.board[i][j] instanceof Bishop) {
                    bc.copie[i][j] = new Bishop(board.board[i][j].getColor(), new Pair<>(i, j), board.board[i][j].getType());

                } else if(board.board[i][j] instanceof Queen) {
                    bc.copie[i][j] = new Queen(board.board[i][j].getColor(), new Pair<>(i, j), board.board[i][j].getType());

                } else if(board.board[i][j] instanceof King) {
                    bc.copie[i][j] = new King(board.board[i][j].getColor(), new Pair<>(i, j), board.board[i][j].getType());

                } else {
                    bc.copie[i][j] = null;
                }
            }
        }
    }

    public String toString() {
        String res = "";
        for(int i = 1; i <= 8 ; i++) {
            res += (9 - i) + "| ";
            for(int j = 1; j <= 8; j++) {
                if(copie[i][j] == null) {
                    res += "- ";
                }
                else {
                    res += copie[i][j].getType() + " ";

                }
            }
            res += "\n";
        }
        res += "   ---------------\n   a b c d e f g h\n";
        return res;

    }
}
