package text;	//current package

import gui.*;	//future package
import logic.*; //future package

import java.util.Random;
import java.util.Scanner;



/** 
 * Class AdventureGameText controls the entire application.
 * It creates one instance for Map and Player called map and playerInfo, respectively. 
 */
public class AdventureGameText  {

	private Map map;
	private Player player; 
	
	/*
	 * Default constructor - takes no arguments
	 * @param None 
	 */
	public AdventureGameText() {}
	
	/**
	 * Constructor takes references from Map and Player and assigns them to the instance variables
	 * @param aMap and aPlayer a map of type Map and a player of type Player
	 */
	public AdventureGameText(Map aMap, Player aPlayer) {
		map = aMap;
		player = aPlayerl
	}
	
	/**
	 * Copy constructor that copies the values an existing object 
	 * @param toCopy an existing object
	 */
	public AdventureGameText(AdventureGameText toCopy) {
		map = toCopy.map;
		player = toCopy.player;
	}
	
	/** 
	 * Method play interacts with the user upon the creation of a new game and asks it for a move,
	 * which is then translated into a shift in the x and y axis. 
	 */
	public void play() {	
	
		displayGrid(); 
		
		Scanner kb = new Scanner(System.in);
		System.out.println("Enter your move: ");
		char ch = kb.nextLine();
		
		while (ch != q) {
			map.move(ch);
			System.out.println("Enter your move: ");
			char ch = kb.nextLine();
		}
		System.out.println("Invalid Move.");
	}
	
	/**
	 * Method displays a functioning menu at the beginning of the app. It asks the user to run the game or exit,
	 * the later which restarts the opening message.
	 */
	public void mainMenu() {
		//Opening Message and Instructions
		System.out.println("\n\t             <<Welcome to The Entity>>");
		System.out.println("\t         *********************************");
		System.out.println("\n");	
		System.out.println("\t   You are stuck in a house, and must get out");
		System.out.println("\tYou are shown using the 'X' character. Good luck!");
		System.out.println("\n");		
		System.out.println("\t   Press 'r' to run game or press 'q' to quit");
		System.out.println("\t 'a' = left, 'd' = right, 'w' = up, 's' = down");
		System.out.println("\n");	
		System.out.println("\t         *********************************");
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
		Map map = new Map();
		Player player = new Player();
	}
	
}
		
		
		
		
		
		
		
		
		
		
		
		
