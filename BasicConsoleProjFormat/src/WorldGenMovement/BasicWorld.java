package WorldGenMovement;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class BasicWorld {
	
	private static int MIN_SIZE = 25;
	private static int MAX_SIZE = 50;
	
	private static int worldSize = ThreadLocalRandom.current().nextInt(MIN_SIZE, MAX_SIZE + 1);
	
	
	private static String[] newWorld = new String[worldSize];
	private static String PLAYER = "X";
	private static String interactableDoorEx = "|";
	
	public BasicWorld() {
		
	}
	
	public static void initiateWorld() {
		Arrays.fill(newWorld, " ");
		
		int firstWallPos = 0;
		
		int lastWallPos = worldSize - 1;
		
		newWorld[firstWallPos] = "[";
		newWorld[lastWallPos] = "]";
		
		newWorld[lastWallPos - 2] = interactableDoorEx;
		newWorld[firstWallPos + 1] = PLAYER;
		
		for (String i : newWorld) {
			System.out.print(i);
		}
	}

	
	public static void main(String args[]) {
		initiateWorld();
	}

}
