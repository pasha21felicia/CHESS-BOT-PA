.SUFFIXES: .java .class
.java.class:
	javac -g $*.java

CLASSES = \
    Pair.java \
    Piece.java \
	Pawn.java \
	King.java \
    Knight.java \
    Rook.java \
    Bishop.java \
    Queen.java \
    Board.java \
    ConvertMoves.java \
    Move.java \
	Main.java

build: classes

classes: $(CLASSES:.java=.class)

run:
	java Main

clean:
	$(RM) *.class