/**
 * Class Inventory contains all the methods that update and retrieve the items collected throughout the game. The player
 * can accesss the inventory at any point in the game. It contains an instance variable of type Player and type Collectible, as 
 * well as an ArrayList of Strings that represents the inventory.
 */
public class Inventory {

    private Player player;
    private Collectible item;
    private ArrayList<String> inv;
    
   /*
	* Default constructor - takes no arguments
	* @param None 
	*/ 
    public Inventory() {}
    
    /**
	 * Copy constructor that copies the values an existing object 
	 * @param toCopy a copy of an existing object
	 */
    public Inventory(Inventory toCopy) {
            player = toCopy.player;
            item = toCopy.item;
	    inv = toCopy.inv;
    }
    
    /**
	 * Constructor takes arguments for player assigns it to the instance variable, and initializes the inventory
	 * @param player the player 
	 */
    public Inventory(Player player, Collectible collectible) {
        this.player = player;
	item = collectible; 
        inv = new ArrayList<Strings>();
    }
    
    /**
     * Method addItems populates the inventory by taking an item and adding it to the ArrayList, depending on the method associated 
     * with the item.
     * @param item an item
     */
    public void addItems(Collectible item) {
         ArrayList<String> inv = new ArrayList<String>(); 
         if player.readNote() {
            inv.add(notes);
        } else if player.pickUpItem() { //for keys and other objects eg. can
            inv.add(items);
        } else if player.openChest() {  //need key to open a chest
            inv.add(chests);
        } 
    }
    
    /**
     * Method removeItem queries and removes an item from the inventory
     * @param item an item
     */
    public void removeItem(Collectible item) {
        if player.useItem() {
            int index = inv.indexOf(item);
            if (index != -1) {
                inv.remove(index);
                displayInventory();
            }
        }
   
    /**
     * Method displayInventory displays the new contents of the inventory
     * @param None
     */
    public displayInventory() {
        System.out.println("Your inventory: ");
        for (String items : inv) {
            System.out.println(items);
        }
    }
        
}
    
