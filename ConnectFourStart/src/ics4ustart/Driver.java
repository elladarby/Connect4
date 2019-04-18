package ics4ustart;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Driver {

	public static void main(String[] args) throws InterruptedException {

		// Setup constants for the Board
		final int ROWS = 7;
		final int COLS = 7;
		CellState player = CellState.P1;

		// create the board
		Board board = new Board(ROWS, COLS);
		board.display();

		boolean done = false;
		String value = "";

		int column = 0;

		while (!done) {
			column = getColumn();
			board.display();
		}
	}

	private static int getColumn() {
		boolean valid = false;
		int column = 0;
		Scanner in = new Scanner(System.in);

		System.out.print("Which Column (1-7) :");
		column = Integer.parseInt(in.nextLine().trim());
		return column;

	}
}
