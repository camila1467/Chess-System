package chass.pieces;

import boardgame.Board;
import chass.ChessPiece;
import chass.Color;

public class Rook extends ChessPiece {

	public Rook(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "R";
	}
	
	
	

}
