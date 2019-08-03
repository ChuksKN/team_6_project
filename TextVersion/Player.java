package text;	

import gui.*;	//future package
import logic.*; //future package

import java.util.ArrayList;

 
/**
 * Class Player contains the code for the character that the user controls and moves around 
 * the screen. It contains information such as items picked up and the character's current 
 * location in the map. 
 */
public class Player {

	private char player = 'X';
	private ArrayList<Collectible> item;
	private Direction direction;
	private Location location = new [5][25];
	
	/*
	 * Default constructor - takes no arguments
	 * @param None 
	 */
	public Player() {}
	
	/**
	 * Constructor takes arguments for item, character, and location assigns them to the instance variables
	 * @param anItem an item from the Collectible class
	 * @param aPlayer a player that represents the user
	 * @param aLocation the current location
	 */
	public Player(ArrayList<Collectible> anItem, char aPlayer, Location startLocation) { //UPDATE
		item = anItem;
		character = aCharacter;
		location = startLocation;
	}
	
	/**
	 * Copy constructor that copies the values an existing object 
	 * @param toCopy a copy of an existing object
	 */
	public Player(Player toCopy) { //UPDATE
		item = toCopy.item;
		character = toCopy.character;
		location = toCopy.location;
	}
	
	
	public Direction getDirection() {
		return direction;
	}
	public void setDirection(Direction aDirection) {
		direction = aDirection;
	}
	
	public void itemsPicked() {}
		// TO DO
	
	public Location getLocation() { //player's current location
		return location;
	}
	public void setLocation(Location aLocation) {
		location = aLocation;
	}
	
	public void pickUpItem(Collectible item) {}	//TO DO
	public void readNote(Collectible note) {}	//TO DO 
	public void useItem(Inventory itemToUse) {}	//TO DO
	public void openChest(Collectible chest) {}	// TO DO
	
}
