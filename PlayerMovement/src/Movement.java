import java.util.Scanner;

public class Movement {

	
	
	
	public static void main(String[] args) {
		//Opening Message and Instructions
		System.out.println("\t     *Welcome to The Entity*");
		System.out.println("\t*********************************");
		System.out.println("\nYou are stuck in a house, and must get out");
		System.out.println("You are shown using the 'x' character. Good luck!");
		System.out.println("\n");		
		System.out.println("Press 'r' to run game or press 'q' to quit");
		System.out.println("Press 'a' to move left, or press 'd' to move right. ");
		System.out.println("\t******************************");
		System.out.println("\n");
		
	
		Scanner keyinput = new Scanner(System.in);
		
		char ch = keyinput.next().charAt(0);
	
		while(ch != 'q') {
			System.out.println("Go!");
			while(ch != 'q') {
			char ch2 = keyinput.next().charAt(0);
			
			switch(ch2) {
				case 'a':
					//need to add grid in separate method
					//need to show movement and print the grid using method
					//this code is for testing
					System.out.print("|");
					int counter = 1;
					while(counter > 0 && counter <20) {
						System.out.print("_");
						counter += 1;
					}
					System.out.println("|\n");
				break;
				case 'd':
					//need to add grid
					//need to show movement and print grid
					System.out.println("test");
					
				break;
				case 'i':
					
					break;
				case 'q':
					System.out.print("\tThanks for Playing!");
					return;
				
			default:
				System.out.println("Invalid move");
			}
			}
		}
	}
}