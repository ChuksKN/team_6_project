package text;

import gui.*;	//future package
import logic.*; //future package

import java.util.Random;
import java.util.Scanner;


/** 
 * Class AdventureGameText controls the entire application.
 * It creates one instance for Map and Player called map and playerInfo, respectively. 
 * Both the map and player location will be updated with every game iteration. 
 * 
 */
public class AdventureGameText  {

	private Map map;
	private Player playerInfo; //
	
	
	/**
	 * Method placeCollectible creates a randomly-generated x and y coordinates for items
	 * in the Collectible class (e.g. notes, chests and keys). It uses a constructor from Location 
	 * to place said items.
	 */
	public void placeCollectible(Collectible item) {

		int x = (int)Math.random();
		int y = (int)Math.random();
		Location coordinates = new Location(item, x, y); //update class diagram to add this constructor 
	}
	
	/** 
	 * Method play interacts with the user upon the creation of a new game and asks for a move,
	 * which is then translated into a shift in the x and y axis. It also asks the user if it wants to use a collectible item,
	 * which then invokes the appropriate method in the Collectible class. 
	 */
	
	public void play() {	
	
		displayGrid(); 
		
		System.out.println("Enter your first move ('a' for left, 'd' for right, 'w' for up, 's' for down, 'd' to quit: ");
		Scanner kb = new Scanner(System.in);
		char ch = kb.nextLine();
		map.move(ch);

	/*
	 * Method displays a functioning menu at the beginning of the app. It asks the user to run the game or exit,
	 * the later which restarts the opening message.
	 */
	publci void displayMenu() {
	  //Opening Message and Instructions
		System.out.println("\t *Welcome to The Entity*");
		System.out.println("\t*********************************");
		System.out.println("\nYou are stuck in a house, and must get out");
		System.out.println("You are shown using the 'X' character. Good luck!");
		System.out.println("\n");		
		System.out.println("Press 'r' to run game or press 'q' to quit");
		System.out.println("Press 'a' to move left, or press 'd' to move right. ");
		System.out.println("\t******************************");
		System.out.println("\n");
		
		Scanner kb = new Scanner(System.in);
		char ch = kb.nextLine();
		if (ch != q) {
			play();
		} else {
			System.out.print("\tThanks for Playing!");
			mainMenu();
		}
		
	}
	
	
    public static void main(String[] args) {
    //Launches app
 }
		
