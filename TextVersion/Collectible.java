import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Collectible {
	//Here we store the key and note strings.
	String[] keys = {"key1", "key"};
	String[] chests = {"chest1", "chest2"};
	String[] notes = {"note1", "note2"};
	
	//Here we add the the key strings into their list.
	List<String> keyList = new ArrayList<String>();
	for(String keyAsset: keys) {
		keyList.add(keyAsset);
		}
	
	//Here we add the the note strings into their list.
	List<String> noteList = new ArrayList<String>();
	for(String noteAsset: notes) {
		noteList.add(noteAsset);
		}
	//Here we add the chest strings into their list
	List<String> chestList = new ArrayList<String>();
	for(String chestAsset: chests) {
		chestList.add(chestAsset);
		}
	
	
	
	
	
	public Collectible(String Room, int Xcoordinate, int Ycoordinate, String itemType, int itemIndex) {
		//This code checks itemType to determine which list to use.
		String collectable;
		if(itemType == "key") {
			collectable = keyList.get(itemIndex);
		}
		if(itemType == "note") {
			collectable = noteList.get(itemIndex);
		}
		int pickupRange = 1;
		boolean elementFound = false;
		boolean withinRange;
		boolean withinY = false;
		boolean withinX = false;
		boolean itemAv = true;
		boolean conditionsMet = false;
		//Remember to add a value in the while loop that checks the room match. (to save CPU).
		while(itemAv == true) {
			//These if conditions check if the item is within range.
			if(Xcoordinate - pickupRange <= getXCoord() && Xcoordinate + pickupRange >= getXCoord()) {
				withinX = true;
		}
			if(Ycoordinate - pickupRange <= getYCoord() && Ycoordinate + pickupRange >= getYCoord()) {
				withinY = true;
		}
			//These if conditions check if the item is out of range.
			if(Xcoordinate - pickupRange > getXCoord() && Xcoordinate + pickupRange < getXCoord()) {
				withinX = false;
		}
			if(Ycoordinate - pickupRange > getYCoord() && Ycoordinate + pickupRange < getYCoord()) {
				withinY = false;
		}
			//Here I'm simply simplifying the range element.
			if(withinX == true && withinY == true) {
				withinRange = true;
			}
			if(withinX == false || withinY == false) {
				withinRange = false;
			}
			if(withinRange == true && itemAv == true) {
				conditionsMet = true;
			}
		Scanner in = new Scanner(System.in);
		String com = in.nextLine();
		if(com == "p" && conditionsMet == true) {
			elementFound = true;
			itemAv = false;
			}
		}
		}
		
		
		
	}
