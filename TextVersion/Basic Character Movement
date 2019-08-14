import java.util.Collections;
import java.util.Scanner;
		
public class TextVersion {		
		
	public static void grid() {
		System.out.println("==================");
	}
//	public static String moveXLeft(String move, int num) {
//		StringBuilder updateMove = new StringBuilder();
		
//	}

		public static void main(String[] args) {
			//Opening Message and Instructions
			System.out.println("\t     Welcome to The Entity!");
			System.out.println("\t     A game by **TEAM 6**");
			System.out.println("\t******************************");
			System.out.println("\n**This is a text based version of the game**");
			System.out.println("\nYou are stuck in an unkiwn location, and must get out. Find the exit!");
			System.out.println("You are shown using the 'x' character. Good luck!");
			System.out.println("\n");		
			System.out.println("Enter any key to run the game or press 'q' to quit");
			System.out.println("Press 'a' to move left, or press 'd' to move right. ");
			System.out.println("\n\t******************************");
			System.out.println("\n");
			
		
			Scanner keyinput = new Scanner(System.in);
			
			char ch = keyinput.next().charAt(0);
		
			while(ch != 'q') {
				System.out.println("Go!");
				grid();
				System.out.println("x");
				grid();
				
				//give the player the option to quit before the game starts
				while(ch != 'q') {
				char ch2 = keyinput.next().charAt(0);
			
				int move = 0;

				switch(ch2) {
					case 'd':
						move += 1;
						//need to add grid in separate method
						//need to show movement and print the grid using method
						grid();

						if(move > 0 && move < 21) {
							System.out.print(String.join("",Collections.nCopies(move, " ")));
							System.out.println("X");
//							move = move + 1;
							//System.out.println(move);
							//print move for testing
						}
						else {
							System.out.print(String.join("",Collections.nCopies(17, " ")));
							System.out.println("X");
						}
						grid();

					break;
					case 'a':
						
						//need to add grid
						//need to show movement and print grid
						grid();

						if(move > 0 && move < 21) {
							move -= 1;
							System.out.println(String.join(" ", Collections.nCopies(move, " ")));
							System.out.println("X");
							//move -= 1;
							System.out.println(move);

						}
						
						
						grid();
							
				
						
					break;
					case 'q':
						System.out.print("\tThanks for Playing!");
						return;
					
				default:
					System.out.println("Invalid input!");
				}
				}
			}
		}
	}
