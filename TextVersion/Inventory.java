public class Inventory {

    private Player player;
    private ArrayList<Strings> items;
    

    public Inventory(Player Player) {
        this.player = player;
        inv = new ArrayList<Strings>();
    }

    // populate items
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

    // query and remove an item
    public void removeItem(Collectible item) {
        if player.useItem() {
            int index = inv.indexOf(item);
            if (index != -1) {
                inv.remove(index);
                displayInventory();
            }
        }
   
    // display new contents of inventory
    public displayInventory() {
        System.out.println("Your inventory: ");
        for (String items : inv) {
            System.out.println(items);
        }
    }


}
    
