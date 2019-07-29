/**
 * Class Map controls the game map. It keeps track of where everything is and provides methods
 * that indicate what is in each location. It also checks to see whether moves are valid or not.
 * It contains one instance variable named grid that is made up of an array of characters.
 */
public class Map {
	private static final int ROW_SIZE = 10;
	private static final int COLUMN_SIZE = 50;
	
	private char [][] grid;
	
	public Map() {}
	
	public Map(char[][] startConfiguration){
		grid = startConfiguration;
	}
	
	public Map(Map toCopy) {
		grid = toCopy.grid;
	}
	
	
	/**
	 * Method displayGrid displays the grid
	 * @param None
	 */
	public void displayGrid() {
		grid = new char [ROW_SIZE][COLUMN_SIZE];
        	for (int row = 0; row < ROW_SIZE; row++){
            	for ( int col = 0; col < COLUMN_SIZE; col++){
                	grid[row][col] = '-';
           		}
        	}
         
    /**
     * Method placeCollectible places an item from the Collectible class (notes, chests, keys) at
     * a certain location in the gird by specifying a row and a column
     * @param None
     */
    public void placeCollectible(Collectible item, int row, int column) {
    	if  (row <= ROW_SIZE && column <= COLUMN_SIZE) {
    		return grid[row][column] = item;
    	}
    }
    /**
     * Method isEmpty checks to see if a certain location in the map is empty to place a
     * collectible item.
     * @param None
     */
    public boolean isEmpty(int row, int column) {
    	return grid[row][column] == '-';
    }
    
    public void move(Location currentLocation, Direction direction) {}
    //TO DO
    
    public boolean isValidMove(Location currentLocation, Direction direction) {}
    //TO DO 

}

