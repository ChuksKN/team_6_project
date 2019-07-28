/**
 * Class Map controls the game map. It keeps track of where everything is and provides methods
 * that indicate what is in each location. It also checks to see whether moves are valid or not.
 * It contains one instance variable named grid that is made up of an array of characters.
 */
public class Map {
	private static final int ROW_SIZE = 10;
	private static final int COLUMN_SIZE = 50;
	
	private char [][] grid = new char [ROW_SIZE][COLUMN_SIZE];	//provide constants for grid size
	
	/**
	 * Method displayGrid displays the grid
	 * @param None
	 */
	public void displayGrid() {
        for (int i = 0; i < grid.length; i++){
            for ( int j = 0; j < grid[i].length; j++){
                grid[i][j] = '-';
            }
        }
         
        for (int i = 0; i < grid.length; i++){
            System.out.println();
            for ( int j = 0; j < grid[i].length; j++){
                System.out.print(grid[i][j]);
            }
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
    
    public boolean isEmpty(int row, int column) {
    	return grid[row][column] = '-';
    }
    
    
    	
    
    
    
    


}