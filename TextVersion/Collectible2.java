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
	
	//method to check if we can use the item once we find it, same for different types
	
	public void findItem(String item) {
		if item.equals("note1") {
			item = noteList.get(1);
			System.out.println("You have found note 1/2. It reads:....");
		} else if item.equals("note2") {
			item = noteList.get(2);
			System.out.println("You have found note 2/2. It reads:....");
		} else if item.equals("key1") {
			item = keyList.get(1); //add index 
			System.out.println("You have found Key 1/2.");
		} else if item.equals("key2") {
			item = keyList.get(2); //add index 
			System.out.println("You have found Key 2/2.");
		} else if item.equals("chest1") {
			item = chestList.get(1); //add index 
			System.out.println("You have found chest 1/2. Use the first key to open it.");
		} else if item.equals("chest2") 
			item = chestList.get(2);
			System.out.println("You have found chest 1/2. Use the second key to open it.");
		}
	}
		
			
	public void useItem(String item, Player player) {
		if item.equals("note1") {
			player.readNote();
		} else if item.equals("note2") {
			player.readNote();
		} else if item.equals("key1") {
			player.pickUpKey();
		} else if item.equals("key2") {
			player.pickUpKey();
		} else if item.equals("chest1") {
			player.openChest();
		} else if item.equals("chest2") {
			player.openChest();
		}
					

		
		
		
		
