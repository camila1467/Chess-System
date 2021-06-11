package chass;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import chass.pieces.King;
import chass.pieces.Rook;

public class ChessMatch {
//regras do jogo
private Board board;
	
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}
	
	public ChessPiece[][] getPieces() {
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		for (int i=0; i<board.getRows(); i++) {
			for (int j=0; j<board.getColumns(); j++) {
				mat[i][j] = (ChessPiece) board.piece(i, j);
			}
		}
		return mat;
	}
	public ChessPiece performeChessMove (ChessPosition sourcePosition,ChessPosition targetPosition)
	{
	Position source=sourcePosition.toPosition();
	Position target=targetPosition.toPosition();
	validateSourcePosition (source);
	Piece capturedPiece=makeMove(source,target);
	return (ChessPiece)capturedPiece;
	}
	
	private void validateSourcePosition (Position position)
	{
		if(!board.thereIsAPiece(position)) {
			throw new ChessException ("there is no piece on source position");
			
		}
	}
	private Piece makeMove (Position source,Position Target) {
		Piece p=board.removePiece(source);
	Piece capturedPiece=board.removePiece(Target);
	board.placePiece(p, Target);
	return capturedPiece;
	}
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {
		placeNewPiece('c', 1, new Rook(board, Color.WHITE));
        placeNewPiece('c', 2, new Rook(board, Color.WHITE));
        placeNewPiece('d', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 2, new Rook(board, Color.WHITE));
        placeNewPiece('e', 1, new Rook(board, Color.WHITE));
        placeNewPiece('d', 1, new King(board, Color.WHITE));

        placeNewPiece('c', 7, new Rook(board, Color.BLACK));
        placeNewPiece('c', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 7, new Rook(board, Color.BLACK));
        placeNewPiece('e', 8, new Rook(board, Color.BLACK));
        placeNewPiece('d', 8, new King(board, Color.BLACK));
	}
}