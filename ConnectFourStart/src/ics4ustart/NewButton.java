package ics4ustart;

import javafx.scene.control.Button;

public class NewButton extends Button {
	private int row;
	private int col;
	
	/**
	 * NewButton object
	 * @param c
	 */
	public NewButton (int c){
		super();
		col = c;
	}
	
	/**
	 * Finds number of column in terms on index
	 * @return column number plus one
	 */
	public int getCol(){
		return col+1;
	}
	
	@Override
	public String toString(){
		return "String.valueOf(String.valueOf(getCol())";
	}
}
