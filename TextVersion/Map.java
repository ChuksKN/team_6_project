/**
 * Class Map controls the game map. It keeps track of where everything is and provides methods
 * that indicate what is in each location. It also checks to see whether moves are valid or not.
 * It contains one instance variable named grid that is made up of an array of characters.
 */
public class Map {
	private static final int ROW_SIZE = 10;
	private static final int COLUMN_SIZE = 50;
	private char [][] grid;
	private Player player;
	private Location location;
	private Direction direction;
	private Collectible collectible;
	private String obstacle;
	
	public Map() {}
	
	public Map(Map toCopy) {}
	//TO DO 
	
	public Map(int rowSize, int colSize,char[][] startConfiguration, Player aPlayer, Location aLocation, Direction aDirection, Collectible anItem, String obs) {
		ROW_SIZE = rowSize;
		COLUMN_SIZE = colSize;
		grid = startConfiguration;
		player = aPlayer;
		location = aLocation;
		direction = aDirection;
		collectible = anItem;
		obstacle = obs;
	}
	
	public String getObstacle() {
		String obstacle = "\";
		return obstacle;
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
	}
   	 public void placePlayer(Player player, int row, int col) {
	 	grid[10][1] = 'X'; 
	 }
	
	public void placeObstacle(String obstacle) {}
	//TO DO 
	
	
	
    	/**
     	* Method placeCollectible places an item from the Collectible class (notes, chests, keys) at
     	* a certain location in the gird by specifying a row and a column
     	* @param None
     	*/
    	public void placeCollectible(Collectible item, int row, int column) {
    		if  (row <= ROW_SIZE && column <= COLUMN_SIZE) {
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
			player.setCurrentLocation(newRow);
		
			
		} else if (direction == Direction.D) {
			int newRow = loc.row += 1;
			player.setCurrentLocation(newRow);
			
		} else if (direction == Direction.W) {
			int newCol = loc.col += 1;
			player.setCurrentLocation(newCol);
		} else if (direction == Direction.S) {
			int newCol = loc.col -= 1;
			player.setCurrentLocation(newCol)
			
		} else if (direction.equals("W")) {
			
		}
	}
			
			
    	public boolean isValidMove(Location currentLocation, Direction direction) {} //checks to see if obstacle is hit
    	//TO DO 



}

