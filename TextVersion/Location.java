/**
 * Class Location indicates the location in the map. It contains an instance for row and column.
 */
public class Location {

	private int row;
	private int col;
	
	/*
	 * Default constructor - takes no arguments
	 * @param None 
	 */
	public Location() {}
	/**
	
	 * Constructor takes an argument for row and column and assigns them to the instance variables
	 * @param aRow a row
	 * @param aCol a column
	 */
	public Location(int aRow, int aCol) {
		row = aRow;
		col = aCol;
	}
	
	/**
	 * Copy constructor that copies the values an existing object 
	 * @param toCopy a copy of an existing object
	 */
	public Location(Location toCopy) {
		row = toCopy.row;
		col = toCopy.col;
	}
	
	/**
	 * Gets the current row
	 * @param None
	 */
	public int getRow() {
		return row;
	}
	
	/**
	 * Gets the current column
	 * @param None
	 */
	public int getCol() {
		return col;
	}
	
	/**
	 * Sets the current row
	 * @param aRow a row 
	 */
	public void setRow(int aRow) {
		if (aRow <= 10) {
			row = aRow;
		}
	}
	
	/**
	 * Sets the current column
	 * @param aCol a column 
	 */
	public void setCol(int aCol) {
		if (aCol <= 50) {
			col = aCol;
		}
	}
	
}
