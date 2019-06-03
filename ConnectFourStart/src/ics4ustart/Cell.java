package ics4ustart;

public class Cell {
	private CellState state;
	
	
	/**
	 * Cell object
	 * @param cs
	 */
	public Cell(CellState cs) {
		state = cs;
		
	}
	

	/**
	 * Modifies state to cs
	 * @param cs
	 */
	public void setState (CellState cs){
		state = cs;
	}
	
	/**
	 * Finds state of cell
	 * @return state
	 */
	public CellState getState() {
		return state;
	}

	/**
	 * Places O, X or - depending on CellState P1, P2, or EMPTY
	 */
	public String toString() {
		switch (state) {
		case P1:
			return ("O");
		case P2:
			return "X";
		case EMPTY:
			return "-";
		default:
			return "-";
		}
	}
}
