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
	
		// board.display();

		boolean done = false;
		String value = "";

		int column = 0;
		int row =0;
		boolean isWinner=false;

		while (!done) {
			board.display();
			boolean is_valid = false;
			while (!is_valid) {
				column = getColumn();
				if (board.isFull(column)) {
					System.out.println("Column is full. Please choose another");
				} else {
					is_valid = true;
				}
			}
			row  = board.placeChip(player, column);
			board.display();
			//System.out.println("row:" + row + "col:" + column);
			
			// switch players
			if (player == CellState.P1) {
				player = CellState.P2;
			} else {
				player = CellState.P1;
			}
			
			// check for winning conditions
			if (board.isVert(row,column)) {
				System.out.println("winner!");
				done = true;
				isWinner = true;
			}
			
			if (board.isHoriz(row,column)) {
				System.out.println("winner!");
				done = true;
				isWinner = true;
			}
			if (board.isDiagRight(row,column)) {
				System.out.println("winner!");
				done = true;
				isWinner = true;
			}
			if (board.isDiagLeft(row,column)) {
				System.out.println("winner!");
				done = true;
				isWinner = true;
			}
			
			
		}
		if (isWinner) {

			if (player == CellState.P1) {
				System.out.println("Player 1 is the big winner");
			} else {
				System.out.println("Player 2 is the big winner");
			}
		}

	}

	/**
	 * Asks user for column number which they would like to place a chip
	 * @return column number that the user wants to place chip
	 */
	private static int getColumn() {
		boolean valid = false;
		int column = 0;
		Scanner in = new Scanner(System.in);

		while (!valid) {
			System.out.print("Which Column (1-7) :");
			if (in.hasNextInt()) {
				column = in.nextInt();
				if (column > 7 || column < 1) {
					in.nextLine();
					System.out.println("An integer 1-7 is expected. Try Again.");

				} else {
					valid = true;
				}
			}
		}
		return column;
	}

}
