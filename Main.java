import java.io.*;
import java.util.Scanner;
import java.util.Vector;
import java.util.Random;
public class Main {
    public static boolean isMove(String buffer) {
        if(Character.isLetter(buffer.charAt(0)) && Character.isDigit(buffer.charAt(1))
                && Character.isLetter(buffer.charAt(2)) && Character.isDigit(buffer.charAt(3))) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        Scanner reader = new Scanner(new InputStreamReader(System.in));
        System.out.println("feature done=1\n");
        String buffer;
        Board board = new Board();
        boolean turn = false;
        boolean mode = false;
        boolean stoped = true;
        boolean danger = false;
        Vector<Move> movesWhite = new Vector<>();
        Vector<Move> movesBlack = new Vector<>();

        while (true) {
            reader.reset();
            buffer = reader.nextLine();


            if(buffer.equals("quit")) {
                break;
            }

            if(buffer.equals("new")) {
                board.newBoard();
                turn = false;
                mode = false;
                stoped = false;
                danger = false;

            }

            if (buffer.equals("resign")) {
                break;
            }

            if(buffer.equals("white")) {
                turn = true;
                mode = true;
                stoped = true;
            }

            if(buffer.equals("black")) {
                mode = false;
                turn = false;
                stoped = true;
            }

            if  ((buffer.length() == 4 || buffer.length() == 5) && isMove(buffer)) {

                Vector<Integer> moves = ConvertMoves.convertInInteger(buffer);
                Move newMove;
                if (buffer.length() == 4) {
                    newMove = new Move(new Pair(moves.get(0), moves.get(1)), new Pair(moves.get(2), moves.get(3)), 0);
                } else {
                    newMove = new Move(new Pair(moves.get(0), moves.get(1)), new Pair(moves.get(2), moves.get(3)), moves.get(4));
                }

                board.addMoves(board, newMove, mode, movesWhite, movesBlack);

                //Rocada Player
                int make = 0;
                if(buffer.equals("e1g1") && board.board[8][5] instanceof King) {
                    make = 1;
                    board.doSmallCastling(board, !mode);
                }

                if(buffer.equals("e8g8") && board.board[1][5] instanceof King) {
                    make = 1;
                    board.doSmallCastling(board, !mode);
                }

                if(buffer.equals("e1c1") && board.board[8][5] instanceof King) {
                    make = 1;
                    board.doBigCastling(board, !mode);
                }

                if(buffer.equals("e8c8") && board.board[1][5] instanceof King) {
                    make = 1;
                    board.doBigCastling(board, !mode);
                }

                if(make == 0) {
                    board.update(newMove, board);
                }

                Vector<String> pMoves;
                pMoves = board.getAllPossibleMoves(!mode);
                danger = board.inDanger(pMoves, mode);

                turn = true;
            }

            if (buffer.equals("go")) {
                turn = true;
                stoped = false;
            }

            if (buffer.equals("force")) {
                turn = false;
                stoped = true;
            }

            if (turn && !stoped) {
                Vector<String> pMoves;
                Random randomMove;

                pMoves = board.getAllPossibleMoves(mode);

                if(pMoves == null || pMoves.size() < 1) {
                    System.out.println("resign\n");

                } else {
                    String s = "move ";
                    randomMove = new Random();
                    if (!danger) {
                        String enPassantMove = board.EnPassantMove(board, mode, movesWhite, movesBlack);
                        Pair<Integer, Integer> posMyKing = board.getKing(mode);
                        King myKing = (King) board.board[posMyKing.getX()][posMyKing.getY()];

                        if (myKing.isSmallCastlingPossible(board, mode)) {
                            String kingMove = board.kingAnyCastling(mode, posMyKing, 2);
                            String rookMove = board.rookSmallCastling(mode);
                            System.out.println(s + kingMove);
                            System.out.println(s + rookMove);
                            board.doSmallCastling(board, mode);

                        } else if (myKing.isBigCastlingPossible(board, mode)) {
                            String kingMove = board.kingAnyCastling(mode, posMyKing, -2);
                            String rookMove = board.rookBigCastling(mode);
                            System.out.println(s + kingMove);
                            System.out.println(s + rookMove);
                            board.doBigCastling(board, mode);
//
//                        } else if (enPassantMove != null) {
//                            Vector<Integer> movess = ConvertMoves.convertInInteger(enPassantMove);
//                            Move newMove = new Move(new Pair(movess.get(0), movess.get(1)), new Pair(movess.get(2), movess.get(3)), 0);
//
//                            System.out.println(s + enPassantMove);
//                            board.doEnPassant(board, mode, newMove);

                        } else {
                            while (pMoves.size() > 0) {
                                int indexMove = randomMove.nextInt(pMoves.size());
                                String s_nou = s + pMoves.get(indexMove);
                                Vector<Integer> movess = ConvertMoves.convertInInteger(pMoves.get(indexMove));

                                Board_Copy board_copy = new Board_Copy();
                                board_copy.duplicate(board, board_copy);

                                Move newMove;
                                if (movess.size() == 4) {
                                    newMove = new Move(new Pair(movess.get(0), movess.get(1)), new Pair(movess.get(2), movess.get(3)), 0);

                                } else {
                                    newMove = new Move(new Pair(movess.get(0), movess.get(1)), new Pair(movess.get(2), movess.get(3)), movess.get(4));
                                }
                                board.addMoves(board, newMove, mode, movesWhite, movesBlack);
                                board.update(newMove, board);

                                Vector<String> oponentMoves;
                                oponentMoves = board.getAllPossibleMoves(!mode);

                                if (board.inDanger(oponentMoves, mode)) {
                                    board.duplicate(board, board_copy);
                                    pMoves.remove(indexMove);

                                } else {
                                    System.out.println(s_nou);
                                    break;
                                }
                            }
                        }

                        if(pMoves.size() == 0)
                            System.out.println("resign\n");

                    } else {
                        String aux = "";
                        for (String st : pMoves) {
                            Vector<Integer> movess = ConvertMoves.convertInInteger(st);

                            Board_Copy board_copy = new Board_Copy();
                            board_copy.duplicate(board, board_copy);

                            Move newMove;
                            if (movess.size() == 4) {
                                newMove = new Move(new Pair(movess.get(0), movess.get(1)), new Pair(movess.get(2), movess.get(3)), 0);

                            } else {
                                newMove = new Move(new Pair(movess.get(0), movess.get(1)), new Pair(movess.get(2), movess.get(3)), movess.get(4));
                            }
                            board.addMoves(board, newMove, mode, movesWhite, movesBlack);
                            board.update(newMove, board);

                            Vector<String> p;
                            p = board.getAllPossibleMoves(!mode);

                            if(!board.inDanger(p, mode)) {
                                danger = false;
                                aux = st;
                                break;

                            } else {
                                board.duplicate(board, board_copy);
                            }
                        }

                        if(danger) {
                            System.out.println("resign");

                        } else {
                            System.out.println(s + aux);
                        }

                    }
                }

                turn = false;
            }
        }
    }
}