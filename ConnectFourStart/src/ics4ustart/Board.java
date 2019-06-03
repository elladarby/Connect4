package ics4ustart;

import java.util.Random;

public class Board {
	private Cell[][] board;
	private int rows;
	private int cols;

	/**
	 * Fills the board with rows and columns
	 * @param aRows : number of rows on board
	 * @param aCols : number of columns on board
	 */
	public Board(int aRows, int aCols) {
		board = new Cell[aRows][aCols];
		rows = aRows;
		cols = aCols;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				board[i][j] = new Cell(CellState.EMPTY); // no color
			}
		}
	}

	/**
	 * Modifies number of rows
	 * @return rows
	 */
	public int getRows() {
		return rows;
	}

	/**
	 * Modifies number of columns
	 * @return cols
	 */
	public int getCols() {
		return cols;
	}

	/**
	 * Ensures that the number on x-axis is in between 0 and number of rows.
	 * Ensures that the number on y-axis is in between 0 and number of columns.
	 * @param x 
	 * @param y
	 * @return true if x and y are in the correct range
	 */
	public boolean isValid(int x, int y) {
		return (x >= 0 && x < rows) && (y >= 0 && y < cols);
	}

	/**
	 * Checks if the desired column is full of chips
	 * @param column : desired column from user input
	 * @return true if column is full and a chip cannot be placed
	 */
	public boolean isFull(int column) {
		column = column - 1;
		if (board[0][column].getState() != CellState.EMPTY) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Find CellState of certain row and column on the board
	 * @param i
	 * @param j
	 * @return P1, P2 or EMPTY depending on if and what chip is placed there
	 */
	public CellState getState(int i, int j) {
		return board[i][j].getState();
	}

	/**
	 * Checks for vertical win (four in a row of same player)
	 * @param row : row where chip was just placed
	 * @param column : column where chip was just placed
	 * @return true if there is a vertical win
	 */
	public boolean isVert(int row, int column) {
		int counter = 1;
		row = row-1; // index of bottom row
		column = column - 1; // adjust column to be an index

		for (int r = row; r < (rows - 1); r++) {
			if (board[r][column].getState() == board[r + 1][column].getState()) {
				counter = counter + 1;
			} else {
				counter = 0;
			}
		}
		System.out.println("Vert: " + counter);

		return (counter == 4);

	}

	/**
	 * Checks for horizontal win (four in a row of same player)
	 * @param row : row where chip was just placed
	 * @param column : column where chip was just placed
	 * @return true if there is a horizontal win
	 */
	public boolean isHoriz(int row, int col) {
		int counter = 1;
		int row_start = row-1;
		int col_start = col-1;
		
		int r=row_start;
		int c=col_start;
		
		// look right
		while (c<(cols-2) && board[r][c].getState() == board[r][c+1].getState()) {
				counter = counter +1;
				c++;
			}
		
		//look left
		while (c>=1 && board[r][c].getState() == board[r][c-1].getState()) {
				counter = counter +1;
				c--;
			}
		
		System.out.println("Horiz: " + counter);
		return (counter >= 4);
	}

	/**
	 * Checks for diagonal win to the right (four in a row of same player)
	 * @param row : row where chip was just placed
	 * @param column : column where chip was just placed
	 * @return true if there is a diagonal win to the right
	 */	
	public boolean isDiagRight(int row, int col) {
		int counter = 1;
		int row_start = row-1;
		int col_start = col-1;
		
		int r=row_start;
		int c=col_start;
		
		while (c<(cols-1) && r<(rows-1) && board[r][c].getState() == board[r+1][c+1].getState()) {
			counter = counter +1;
			c++;
			r++;
		}
		r = row_start;
		c = col_start;
		
		while (c>=1 && r>=1 && board[r][c].getState() == board[r-1][c-1].getState()) {
			counter = counter +1;
			c--;
			r--;
		}
		System.out.println("DiagR: " + counter);
		return (counter >= 4);
	}
	
	/**
	 * Checks for diagonal win to the left (four in a row of same player)
	 * @param row : row where chip was just placed
	 * @param column : column where chip was just placed
	 * @return true if there is a diagonal win to the left
	 */	
	public boolean isDiagLeft(int row, int col) {
		int counter = 1;
		int row_start = row-1;
		int col_start = col-1;
		
		int r=row_start;
		int c=col_start;
		
		while (c>=1 && r<(rows-1) && board[r][c].getState() == board[r+1][c-1].getState()) {
			counter = counter +1;
			c--;
			r++;
		}
		r = row_start;
		c = col_start;
		
		while (c<(cols-1) && c>=1 && r>=1 && board[r][c].getState() == board[r-1][c+1].getState()) {
			counter = counter +1;
			c++;
			r--;
		}
		System.out.println("DiagL: " + counter);
		return (counter >= 4);
	}

	/**
	 * Takes player and desired column and places chip if the row and column is empty
	 * @param player : CellState P1, P2 
	 * @param column : desired column from user input
	 * @return row where the chip will be placed
	 */
	public int placeChip(CellState player, int column) {
		int row = rows - 1; // index of bottom row
		column = column - 1; // adjust column to be an index

		while (row > -1) {
			if (board[row][column].getState() == CellState.EMPTY) {
				board[row][column].setState(player);
				return row+1;
			} else {
				row = row - 1;
			}

		}
		return row + 1; // return the actual row and not the index
	}

	/**
	 * Displays the board in console
	 */
	public void display() {
		System.out.println("BOARD");
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				System.out.printf("%s ", board[i][j]);
			}
			System.out.println();
		}
	}
	
}
