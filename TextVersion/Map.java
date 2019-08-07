/**
 * Class Map controls the game map. It keeps track of where everything is and provides methods
 * that indicate what is in each location. It also checks to see whether moves are valid or not.
 * It contains one instance variable named grid that is made up of an array of characters.
 */
public class Map {
	private int rowSize = 10;
	private int colSize = 50;
	
	private char [][] grid;
	
	private Player player;
	private Location location;
	private Direction direction;
	private Collectible collectible;
	
	private String obstacle;
	
	public Map() {}
	
	public Map(int row, int col,char[][] startConfiguration, Player aPlayer, Location aLocation, Direction aDirection, Collectible anItem, String obs) {
		rowSize = row;
		colSize = col;
		grid = startConfiguration;
		player = aPlayer;
		location = aLocation;
		direction = aDirection;
		collectible = anItem;
		obstacle = obs;
	}
	
	public Map(Map toCopy) {}
	//TO DO 
	
	public String getObstacle() {
		String obstacle = "\";
		return obstacle;
	}
	
	public void setObstacle(String anObstacle) {
		obstacle = anObstacle;
	}
	
	
	/**
	 * Method displayGrid displays the grid
	 * @param None
	 */
	public void displayGrid() {
		grid = new char [rowSize][colSize];
        	for (int row = 0; row < rowSize; row++){
            	for ( int col = 0; col < colSize; col++){
                	grid[row][col] = '-';
           		}
        	}
	}
	
   	 public void placePlayer() {
	 	grid[10][1] = 'X'; //starting position for player
	 }
	
	public void placeObstacle(String obstacle) {}
	//TO DO 
	
	
	
    	/**
     	* Method placeCollectible places an item from the Collectible class (notes, chests, keys) at
     	* a certain location in the grid by specifying a row and a column
     	* @param None
     	*/
    	public void placeCollectible(Collectible item, int row, int column) {
    		if  (row <= rowSize && column <= colSize) {
    			grid[row][column] = item;
    		}
    	}
    	/**
    	 * Method isEmpty checks to see if a certain location in the map is empty to place a
	 * collectible item.
    	 * @param None
    	 */
    	//public boolean isEmpty(int row, int column) {
		//return grid[row][column] == '-';
    	
    
    	public void move(Location loc, Player player, Direction direction) {
		
    		if (direction == Direction.A) {
			int newRow = loc.row -= 1;
			player.setCurrentLocation(newRow); //add this method in Player class
		
			
		} else if (direction == Direction.D) {
			int newRow = loc.row += 1;
			player.setCurrentLocation(newRow);
			
		} else if (direction == Direction.W) {
			int newCol = loc.col += 1;
			player.setCurrentLocation(newCol);
		} else if (direction == Direction.S) {
			int newCol = loc.col -= 1;
			player.setCurrentLocation(newCol)
			
		} 
			
		
	}
			
			
    	public boolean isValidMove(Location currentLocation, Direction direction) {} //checks to see if obstacle is hit
    	//TO DO 


}

