import java.util.Random;
import java.util.Vector;

public class Board {
    public Piece[][] board;

    public Board() {
        board = new Piece[9][9];
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                board[i][j] = null;
            }
        }
    }

    public Piece[][] newBoard() {
        board = new Piece[9][9];
        for (int i = 0; i <= 8; i++) {
            for (int j = 0; j <= 8; j++) {
                board[i][j] = null;
            }
        }

        for (int j = 1; j <= 8; j++) {
            board[2][j] = new Pawn(false, new Pair<>(2, j), "P");
            board[7][j] = new Pawn(true, new Pair<>(7, j),"P");
        }
        board[1][1] = new Rook(false, new Pair<>(1, 1),"R");
        board[1][8] = new Rook(false, new Pair<>(1, 8), "R");
        board[8][1] = new Rook(true, new Pair<>(8, 1), "R");
        board[8][8] = new Rook(true, new Pair<>(8, 8),"R");

        board[1][2] = new Knight(false, new Pair<>(1, 2),"N");
        board[1][7] = new Knight(false, new Pair<>(1, 7),"N");
        board[8][2] = new Knight(true, new Pair<>(8, 2),"N");
        board[8][7] = new Knight(true, new Pair<>(8, 7),"N");

        board[1][3] = new Bishop(false,  new Pair<>(1, 3),"B");
        board[1][6] = new Bishop(false,  new Pair<>(1, 6),"B");
        board[8][3] = new Bishop(true,  new Pair<>(8, 3),"B");
        board[8][6] = new Bishop(true,  new Pair<>(8, 6),"B");

        board[1][4] = new Queen(false,  new Pair<>(1, 4),"Q");
        board[8][4] = new Queen(true,  new Pair<>(8, 4),"Q");

        board[1][5] = new King(false,  new Pair<>(1, 5), "K");
        board[8][5] = new King(true,  new Pair<>(8, 5),"K");

        return board;
    }


    public void update(Move newMove, Board board) {

        if ((9 - newMove.getDest().getY() == 8 && board.board[9 -  newMove.getFrom().getY()][newMove.getFrom().getX()] instanceof Pawn)
                || (9 - newMove.getDest().getY() == 1 && board.board[9 -  newMove.getFrom().getY()][newMove.getFrom().getX()] instanceof Pawn)) {

            if (newMove.getType() == 17 || newMove.getType() == 0) {
                board.board[9 - newMove.getDest().getY()][newMove.getDest().getX()] =
                        new Queen(board.board[9 - newMove.getFrom().getY()][newMove.getFrom().getX()].getColor()
                                , new Pair<>(9 - newMove.getFrom().getY(), newMove.getFrom().getX()), "Q");
                board.board[9 - newMove.getFrom().getY()][newMove.getFrom().getX()] = null;

            } else if (newMove.getType() == 14) {
                board.board[9 - newMove.getDest().getY()][newMove.getDest().getX()] =
                        new Knight(board.board[9 - newMove.getFrom().getY()][newMove.getFrom().getX()].getColor()
                                , new Pair<>(9 - newMove.getFrom().getY(), newMove.getFrom().getX()), "N");
                board.board[9 - newMove.getFrom().getY()][newMove.getFrom().getX()] = null;

            } else if (newMove.getType() == 18) {
                board.board[9 - newMove.getDest().getY()][newMove.getDest().getX()] =
                        new Rook(board.board[9 - newMove.getFrom().getY()][newMove.getFrom().getX()].getColor()
                                , new Pair<>(9 - newMove.getFrom().getY(), newMove.getFrom().getX()), "R");
                board.board[9 - newMove.getFrom().getY()][newMove.getFrom().getX()] = null;

            } else if (newMove.getType() == 2) {
                board.board[9 - newMove.getDest().getY()][newMove.getDest().getX()] =
                        new Bishop(board.board[9 - newMove.getFrom().getY()][newMove.getFrom().getX()].getColor()
                                , new Pair<>(9 - newMove.getFrom().getY(), newMove.getFrom().getX()), "B");
                board.board[9 - newMove.getFrom().getY()][newMove.getFrom().getX()] = null;
            }

        } else if (board.board[9 - newMove.getFrom().getY()][newMove.getFrom().getX()] instanceof Pawn) {
            board.board[9 - newMove.getDest().getY()][newMove.getDest().getX()] =
                    new Pawn(board.board[9 - newMove.getFrom().getY()][newMove.getFrom().getX()].getColor()
                        ,new Pair<>(9 - newMove.getFrom().getY(),newMove.getFrom().getX()), "P");
            board.board[9 - newMove.getFrom().getY()][newMove.getFrom().getX()] = null;

        } else if (board.board[9 - newMove.getFrom().getY()][newMove.getFrom().getX()] instanceof Rook) {
            board.board[9 - newMove.getDest().getY()][newMove.getDest().getX()] =
                    new Rook(board.board[9 - newMove.getFrom().getY()][newMove.getFrom().getX()].getColor()
                        ,new Pair<>(9 - newMove.getFrom().getY(),newMove.getFrom().getX()), "R");
            board.board[9 - newMove.getFrom().getY()][newMove.getFrom().getX()] = null;
            ((Rook)board.board[9 - newMove.getDest().getY()][newMove.getDest().getX()]).setMoved(true);

        } else if (board.board[9 - newMove.getFrom().getY()][newMove.getFrom().getX()] instanceof Bishop) {
            board.board[9 - newMove.getDest().getY()][newMove.getDest().getX()] =
                    new Bishop(board.board[9 - newMove.getFrom().getY()][newMove.getFrom().getX()].getColor()
                        ,new Pair<>(9 - newMove.getFrom().getY(),newMove.getFrom().getX()), "B");
            board.board[9 - newMove.getFrom().getY()][newMove.getFrom().getX()] = null;

        } else if (board.board[9 - newMove.getFrom().getY()][newMove.getFrom().getX()] instanceof King) {
            board.board[9 - newMove.getDest().getY()][newMove.getDest().getX()] =
                    new King(board.board[9 - newMove.getFrom().getY()][newMove.getFrom().getX()].getColor()
                        ,new Pair<>(9 - newMove.getFrom().getY(),newMove.getFrom().getX()), "K");
            board.board[9 - newMove.getFrom().getY()][newMove.getFrom().getX()] = null;
            ((King)board.board[9 - newMove.getDest().getY()][newMove.getDest().getX()]).setMoved(true);

        } else if (board.board[9 - newMove.getFrom().getY()][newMove.getFrom().getX()] instanceof Queen) {
            board.board[9 - newMove.getDest().getY()][newMove.getDest().getX()] =
                    new Queen(board.board[9 - newMove.getFrom().getY()][newMove.getFrom().getX()].getColor()
                        ,new Pair<>(9 - newMove.getFrom().getY(),newMove.getFrom().getX()), "Q");
            board.board[9 - newMove.getFrom().getY()][newMove.getFrom().getX()] = null;

        } else if (board.board[9 - newMove.getFrom().getY()][newMove.getFrom().getX()] instanceof Knight) {
            board.board[9 - newMove.getDest().getY()][newMove.getDest().getX()] =
                    new Knight(board.board[9 - newMove.getFrom().getY()][newMove.getFrom().getX()].getColor()
                        ,new Pair<>(9 - newMove.getFrom().getY(),newMove.getFrom().getX()), "N");
            board.board[9 - newMove.getFrom().getY()][newMove.getFrom().getX()] = null;

        }
    }

    public String toString() {
        String res = "";
        for(int i = 1; i <= 8 ; i++) {
            res += (9 - i) + "| ";
            for(int j = 1; j <= 8; j++) {
                if(board[i][j] == null) {
                    res += "- ";
                }
                else {
                    res += board[i][j].getType() + " ";

                }
            }
            res += "\n";
        }
        res += "   ---------------\n   a b c d e f g h\n";
        return res;

    }

    public String toColor() {
        String res = "";
        for(int i = 1; i <= 8 ; i++) {
            res += (9 - i) + "| ";
            for(int j = 1; j <= 8; j++) {
                if(board[i][j] == null) {
                    res += "- ";
                }
                else {
                    res += (board[i][j].getColor() ? 1 : 2) + " ";
                }
            }
            res += "\n";
        }
        res += "   ---------------\n   a b c d e f g h\n";
        return res;

    }

    public Pair<Integer, Integer> getPawn(boolean mode) {
        for (int j = 1; j <= 8; ++j) {
            for (int i = 8; i >= 1; i--) {
                if (board[i][j] != null && board[i][j].getColor() == mode && (board[i][j] instanceof Pawn)) {
                    return new Pair<>(i, j);
                }
            }
        }
        return null;
    }

    public Pair<Integer, Integer> getRook(boolean mode) {
        for (int j = 1; j <= 8; ++j) {
            for (int i = 8; i >= 1; i--) {
                if (board[i][j] != null && board[i][j].getColor() == mode && (board[i][j] instanceof Rook)) {
                    return new Pair<>(i, j);
                }
            }
        }
        return null;
    }

    public Pair<Integer, Integer> getBishop(boolean mode) {
        for (int j = 1; j <= 8; ++j) {
            for (int i = 8; i >= 1; i--) {
                if (board[i][j] != null && board[i][j].getColor() == mode && (board[i][j] instanceof Bishop)) {
                    return new Pair<>(i, j);
                }
            }
        }
        return null;
    }

    public Pair<Integer, Integer> getKnight(boolean mode) {
        for (int j = 1; j <= 8; ++j) {
            for (int i = 8; i >= 1; i--) {
                if (board[i][j] != null && board[i][j].getColor() == mode && (board[i][j] instanceof Knight)) {
                    return new Pair<>(i, j);
                }
            }
        }
        return null;
    }

    public Pair<Integer, Integer> getKing(boolean mode) {
        for (int j = 1; j <= 8; ++j) {
            for (int i = 8; i >= 1; i--) {
                if (board[i][j] != null && board[i][j].getColor() == mode && (board[i][j] instanceof King)) {
                    return new Pair<>(i, j);
                }
            }
        }
        return null;
    }

    public Vector<String> getAllPossibleMoves(boolean mode) {
        Vector<String> allPossibleMoves = new Vector<>();
        for (int i = 1; i <= 8; ++i) {
            for (int j = 1; j <= 8; j++) {
                if (this.board[i][j] != null && this.board[i][j].getColor() == mode) {
                    this.board[i][j].setPosition(new Pair<>(i, j));
                    allPossibleMoves.addAll(this.board[i][j].possibleMoves(this, mode));
                }
            }
        }
        return allPossibleMoves;
    }

    public boolean inDanger(Vector<String> pMoves, boolean mode) {
        Pair<Integer, Integer> pair = getKing(mode);

        if(pMoves != null) {
            for (String m : pMoves) {
                Vector<Integer> movess = ConvertMoves.convertInInteger(m);
                if (9 - movess.get(3) == pair.getX() && movess.get(2) == pair.getY()) {
                    return true;
                }
            }
        }

        return false;
    }

    public void duplicate(Board board, Board_Copy bc) {
        for (int i = 1; i < 9; i ++) {
            for(int j = 1; j < 9; j++) {

                if(bc.copie[i][j] instanceof Pawn) {
                    board.board[i][j] = new Pawn(bc.copie[i][j].getColor(), new Pair<>(i, j), bc.copie[i][j].getType());

                } else if(bc.copie[i][j] instanceof Rook) {
                    board.board[i][j] = new Rook(bc.copie[i][j].getColor(), new Pair<>(i, j), bc.copie[i][j].getType());

                } else if(bc.copie[i][j] instanceof Knight) {
                    board.board[i][j] = new Knight(bc.copie[i][j].getColor(), new Pair<>(i, j), bc.copie[i][j].getType());

                }else if(bc.copie[i][j] instanceof Bishop) {
                    board.board[i][j] = new Bishop(bc.copie[i][j].getColor(), new Pair<>(i, j), bc.copie[i][j].getType());

                } else  if(bc.copie[i][j] instanceof Queen) {
                    board.board[i][j] = new Queen(bc.copie[i][j].getColor(), new Pair<>(i, j), bc.copie[i][j].getType());

                } else if(bc.copie[i][j] instanceof King) {
                    board.board[i][j] = new King(bc.copie[i][j].getColor(), new Pair<>(i, j), bc.copie[i][j].getType());

                } else {
                    board.board[i][j] = null;
                }
            }
        }
    }

    public boolean canBeCaptured(Vector<String> opponentMoves, Pair<Integer, Integer> captured) {
        for (String m : opponentMoves) {
            Vector<Integer> movess = ConvertMoves.convertInInteger(m);
            if (9 - movess.get(3) == captured.getX() && movess.get(2) == captured.getY()) {
                return true;
            }
        }
        return false;
    }

    public void doSmallCastling(Board board, boolean mode) {
        if (!mode) {
            board.board[1][7] = new King(mode, new Pair<>(1, 7), "K");
            board.board[1][5] = null;
            ((King) board.board[1][7]).setMoved(true);

            board.board[1][6] = new Rook(mode, new Pair<>(1, 6), "R");
            board.board[1][8] = null;
            ((Rook) board.board[1][6]).setMoved(true);

        } else {
            board.board[8][7] = new King(mode, new Pair<>(8,7), "K");
            board.board[8][5] = null;
            ((King) board.board[8][7]).setMoved(true);

            board.board[8][6] = new Rook(mode, new Pair<>(8, 6), "R");
            board.board[8][8] = null;
            ((Rook) board.board[8][6]).setMoved(true);
        }
    }

    public void doBigCastling(Board board, boolean mode) {
        if (!mode) {
            board.board[1][3] = new King(mode, new Pair<>(1, 3), "K");
            board.board[1][5] = null;
            ((King) board.board[1][3]).setMoved(true);

            board.board[1][4] = new Rook(mode, new Pair<>(1, 4), "R");
            board.board[1][1] = null;
            ((Rook) board.board[1][4]).setMoved(true);

        } else {
            board.board[8][3] = new King(mode, new Pair<>(8,3), "K");
            board.board[8][5] = null;
            ((King) board.board[8][3]).setMoved(true);

            board.board[8][4] = new Rook(mode, new Pair<>(8, 4), "R");
            board.board[8][1] = null;
            ((Rook) board.board[8][4]).setMoved(true);
        }
    }

    public String kingAnyCastling(boolean mode, Pair<Integer, Integer> posMyKing, int offset) {
        String kingMove, newKingMove;

        kingMove = ConvertMoves.convertInString(posMyKing);
        newKingMove = ConvertMoves.convertInString(new Pair<>(posMyKing.getX(), posMyKing.getY() + offset));
        kingMove = kingMove + newKingMove;

        return kingMove;
    }

    public String rookSmallCastling(boolean mode) {
        String newRookMove, rookMove = null;
        Pair <Integer, Integer> posMyRook;

        if (!mode) {
            posMyRook = new Pair<>(1, 8);
            rookMove = ConvertMoves.convertInString(posMyRook);
            newRookMove = ConvertMoves.convertInString(new Pair<>(1, 6));
            rookMove = rookMove + newRookMove;
        }

        if (mode) {
            posMyRook = new Pair<>(8, 8);
            rookMove = ConvertMoves.convertInString(posMyRook);
            newRookMove = ConvertMoves.convertInString(new Pair<>(8, 6));
            rookMove  = rookMove + newRookMove;
        }

        return rookMove;
    }

    public String rookBigCastling(boolean mode) {
        String newRookMove, rookMove = null;
        Pair <Integer, Integer> posMyRook;

        if (!mode) {
            posMyRook = new Pair<>(1, 1);
            rookMove = ConvertMoves.convertInString(posMyRook);
            newRookMove = ConvertMoves.convertInString(new Pair<>(1, 4));
            rookMove = rookMove + newRookMove;
        }

        if (mode) {
            posMyRook = new Pair<>(8, 1);
            rookMove = ConvertMoves.convertInString(posMyRook);
            newRookMove = ConvertMoves.convertInString(new Pair<>(8, 4));
            rookMove  = rookMove + newRookMove;
        }

        return rookMove;
    }

    public void updateRocadePlayer(Move newMove) {
        if(newMove.isEquals(new Move(new Pair(5, 1), new Pair(7, 1))) && this.board[8][5] instanceof King
             && !((King) this.board[8][5]).isMoved()) {
            ((King) this.board[8][5]).setMoved(true);
            this.update(new Move(new Pair(8, 1), new Pair(6, 1)), this);
        }

        if(newMove.isEquals(new Move(new Pair(5, 1), new Pair(3, 1))) && this.board[8][5] instanceof King
                && !((King) this.board[8][5]).isMoved()) {
            ((King) this.board[8][5]).setMoved(true);
            this.update(new Move(new Pair(1, 1), new Pair(4, 1)), this);
        }

        if(newMove.isEquals(new Move(new Pair(5, 8), new Pair(3, 8))) && this.board[1][5] instanceof King
                && !((King) this.board[1][5]).isMoved()) {
            ((King) this.board[1][5]).setMoved(true);
            this.update(new Move(new Pair(8, 8), new Pair(6, 8)), this);
        }

        if(newMove.isEquals(new Move(new Pair(5, 8), new Pair(3, 8))) && this.board[1][5] instanceof King
                && !((King) this.board[1][5]).isMoved()) {
            ((King) this.board[1][5]).setMoved(true);
            this.update(new Move(new Pair(1, 8), new Pair(4, 8)), this);
        }
    }

    public void addMoves(Board board, Move newMove, boolean mode, Vector<Move> movesWhite, Vector<Move> movesBlack) {
        if (!mode) {
            if (board.board[9 - newMove.getFrom().getY()][newMove.getFrom().getX()].getColor() != mode) {
                movesWhite.addElement(newMove);

            } else {
                movesBlack.addElement(newMove);
            }
        }

        if (mode) {
            if (board.board[9 - newMove.getFrom().getY()][newMove.getFrom().getX()].getColor() != mode) {
                movesBlack.addElement(newMove);

            } else {
                movesWhite.addElement(newMove);
            }
        }
    }

    public boolean inINterval(int x, int y) {
        if(x > 0 && x < 9 && y > 0 && y < 9)
            return true;
        return false;
    }

    public String EnPassantMove(Board board, boolean mode, Vector<Move> movesWhite, Vector<Move> movesBlack) {
        Move opponentLastMove = null;

        if(movesWhite.size() < 1 || movesBlack.size() < 1)
            return null;

        if (!mode && movesWhite.lastElement() != null) {
            opponentLastMove = movesWhite.lastElement();
            System.out.println(opponentLastMove);
        }

        else if (mode && movesBlack.lastElement() != null) {
            opponentLastMove = movesBlack.lastElement();
            System.out.println(opponentLastMove);
        }

        if (!mode) {
            int x = 9 - opponentLastMove.getDest().getY();
            int y = opponentLastMove.getDest().getX();

            if (Math.abs(opponentLastMove.getDest().getY() - opponentLastMove.getFrom().getY()) == 2) {

                if ((board.board[x][y] instanceof Pawn)) {
                    System.out.println(x);
                    System.out.println(y);
                    System.out.println(board.board[x][y - 1]);
                    System.out.println(board.board[x][y]);

                    if (inINterval(x + 1, y - 1) &&
                            (board.board[x][y - 1] instanceof Pawn) &&
                            (board.board[x][y - 1].getColor() != board.board[x][y].getColor()) &&
                            (board.board[x + 1][y] == null)) {

                        String oldPos = ConvertMoves.convertInString(new Pair<>(x, y - 1));
                        String newPos = ConvertMoves.convertInString(new Pair<>(x + 1, y));
                        oldPos = oldPos + newPos;
                        return oldPos;
                    }

                    if (inINterval(x + 1, y + 1) && inINterval(x, y + 1) && inINterval(x, y) &&
                            (board.board[x][y + 1] instanceof Pawn) &&
                            (board.board[x][y + 1].getColor() != board.board[x][y].getColor()) &&
                            (board.board[x + 1][y] == null)) {

                        String oldPos = ConvertMoves.convertInString(new Pair<>(x, y + 1));
                        String newPos = ConvertMoves.convertInString(new Pair<>(x + 1, y));
                        oldPos = oldPos + newPos;
                        return oldPos;
                    }
                }
            }
        }

        if (mode) {
            int x = 9 - opponentLastMove.getDest().getY();
            int y = opponentLastMove.getDest().getX();

            if (Math.abs(opponentLastMove.getDest().getY() - opponentLastMove.getFrom().getY()) == 2) {
                if (board.board[x][y] instanceof Pawn) {

                    if (inINterval(x - 1, y - 1) &&
                            (board.board[x][y - 1] instanceof Pawn) &&
                            (board.board[x][y - 1].getColor() != board.board[x][y].getColor()) &&
                            (board.board[x - 1][y] == null)) {
                        String oldPos = ConvertMoves.convertInString(new Pair<>(x, y - 1));
                        String newPos = ConvertMoves.convertInString(new Pair<>(x - 1, y));
                        oldPos = oldPos + newPos;
                        return oldPos;
                    }

                    if (inINterval(x - 1, y + 1) &&
                            (board.board[x][y + 1] instanceof Pawn) &&
                            (board.board[x][y + 1].getColor() != board.board[x][y].getColor()) &&
                            (board.board[x - 1][y] == null)) {
                        String oldPos = ConvertMoves.convertInString(new Pair<>(x, y + 1));
                        String newPos = ConvertMoves.convertInString(new Pair<>(x - 1, y));
                        oldPos = oldPos + newPos;
                        return oldPos;
                    }
                }
            }

        }

        return null;
    }

    public void doEnPassant(Board board, boolean mode, Move enPassantMove) {
        board.board[9 - enPassantMove.getDest().getY()][enPassantMove.getDest().getX()] =
                new Pawn(board.board[9 - enPassantMove.getFrom().getY()][enPassantMove.getFrom().getX()].getColor()
                        , new Pair<>(9 - enPassantMove.getFrom().getY(), enPassantMove.getFrom().getX()), "P");
        board.board[9 - enPassantMove.getFrom().getY()][enPassantMove.getFrom().getX()] = null;
        board.board[9 - enPassantMove.getFrom().getY()][enPassantMove.getDest().getX()] = null;
    }
}

