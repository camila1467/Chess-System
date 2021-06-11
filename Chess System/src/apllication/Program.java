package apllication;

import java.util.Scanner;

import chass.ChessMatch;
import chass.ChessPiece;
import chass.ChessPosition;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ChessMatch chessmatch = new ChessMatch();

		while (true) {

			UI.printBoard(chessmatch.getPieces());
			System.out.println();
			System.out.print("Source: ");

			ChessPosition source = UI.readChessPosition(sc);

			System.out.println();
			System.out.print("Target: ");
			ChessPosition target = UI.readChessPosition(sc);

			ChessPiece capturedPiece = chessmatch.performeChessMove(source, target);

		}

	}
}
