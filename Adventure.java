// Ashish Naik
// COP 3330 Section 0002
// Adventurer game

// Import necessary Java functions
import java.util.*;
import java.io.*;

// Create a public class based on file name
public class Adventure {

	// Create a static method for the main function
	public static void main(String[] args) {
		
		// Create a 10x10 grid for the cave
		char[][] cave = new char[10][10];
		
		// Use a random number generator to decide how the rest of the cave will be filled
		// Create a variable to store each number generated
		Random filler = new Random();
		int holder = filler.nextInt(100);
		
		// Use a loop to fill each grid point
		// Fill all 'x' coordinates
		for (int i = 0; i<10; i++) {

			// Fill all 'y' coordinates
			for (int j = 0; j<10; j++) {

				// Obtain value for current grid point
				holder = filler.nextInt(100);

				// Make sure value is valid, otherwise make safe
				if (holder != 0) {
					
					// For values between 1-85, keep the space safe
					// For values between 86-95, block the path
					// For values between 96-100, place a pitfall
					if (holder<=85) {
						cave[i][j] = 46;
					}
					else if (holder<=95) {
						cave[i][j] = 88;
					}
					else if (holder<=100) {
						cave[i][j] = 42;
					}
				}
				else {
					cave[i][j] = 46;
				}
			}

		}

		// Start the Professor in the upper left corner
		// Place the Treasure in the lower right corner
		cave[0][0] = 80;
		cave[9][9] = 84;

		// Create new Scanner and variable to store information
		// Create variables to keep track of the adventurers path
		// Create variable to mark finish or game over sequence
		Scanner user = new Scanner(System.in);
		int task;
		int xtrack = 0;
		int ytrack = 0;
		int game = 0;
		
		// Allow the user to input commands until the game is finished
		while (game == 0) {

			// Display cave layout
			for (int i = 0; i<10; i++) {

				int j = 0;
				while (j<10) {
					System.out.printf("%c", cave[i][j]);
					j = j+1;
				}
				System.out.printf("\n");
			

			}
			System.out.printf("\n");

			// Display user's options
			System.out.println("Choose your next move: 5-Up, 3-Right, 2-Down, 1-Left");

			// Intake user input
			task = user.nextInt();
			
			// Process input
			
			// Moving up the board
			if (task == 5) {
				
				// If the user runs into a grid border, restrict movement beyond
				if (ytrack == 0) {
					System.out.println("There's nowhere to move . . . .");
					continue;
				}
				
				// If the user runs into a caved in spot, restrict movement beyond
				if (cave[ytrack-1][xtrack] == 88) {
					System.out.println("There's nowhere to move . . . .");
					continue;
				}

				// If the user falls into a pit, they recieve a game over
				if (cave[ytrack-1][xtrack] == 42) {
					System.out.println("You fell into a pit! NOOOOOoooo");
					System.out.println("GAME OVER");
					game = 2;
				}
				
				// If the path is clear, move the position of the adventurer and record movement
				cave[ytrack][xtrack] = 46;
				cave[ytrack-1][xtrack] = 80;
				ytrack = ytrack-1;
			}
			
			// Moving to the right
			if (task == 3) {
			
				// If the user runs into a grid border, restrict movement beyond
				if (xtrack == 9) {
					System.out.println("There's nowhere to move . . . .");
					continue;
				}
				
				// If the user runs into a caved in spot, restrict movement beyond
				if (cave[ytrack][xtrack+1] == 88) {
					System.out.println("There's nowhere to move . . . .");
					continue;
				}

				// If the user falls into a pit, they recieve a game over
				if (cave[ytrack][xtrack+1] == 42) {
					System.out.println("You fell into a pit! NOOOOOoooo");
					game = 2;
				}

				// If the user reaches the treasure, they win the game
				if (cave[ytrack][xtrack+1] == 84) {
					System.out.println("You found the lost treasure! Party like crazy!");
					System.out.println("GAME OVER");
					game = 1;
				}
				
				// If the path is clear, move the position of the adventurer and record movement
				cave[ytrack][xtrack] = 46;
				cave[ytrack][xtrack+1] = 80;
				xtrack = xtrack+1;
			}

			// Moving down the board
			if (task == 2) {

				// If the user runs into a grid border, restrict movement beyond
				if (ytrack == 9) {
					System.out.println("There's nowhere to move . . . .");
					continue;
				}

				// If the user runs into a caved in spot, restrict movement beyond
				if (cave[ytrack+1][xtrack] == 88) {
					System.out.println("There's nowhere to move . . . .");
					continue;
				}

				// If the user falls into a pit, they recieve a game over
				if (cave[ytrack+1][xtrack] == 42) {
					System.out.println("You fell into a pit! NOOOOOoooo");
					System.out.println("GAME OVER");
					game = 2;
				}

				// If the user reaches the treasure, they win the game
				if (cave[ytrack+1][xtrack] == 84) {
					System.out.println("You found the lost treasure! Party like crazy!");
					game = 1;
				}
				
				// If the path is clear, move the position of the adventurer and record movement
				cave[ytrack][xtrack] = 46;
				cave[ytrack+1][xtrack] = 80;
				ytrack = ytrack+1;
			}

			// Moving to the left
			if (task == 1) {
				
				// If the user runs into a grid border, restrict movement beyond
				if (xtrack == 0) {
					System.out.println("There's nowhere to move . . . .");
					continue;
				}

				// If the user runs into a caved in spot, restrict movement beyond
				if (cave[ytrack][xtrack-1] == 88) {
					System.out.println("There's nowhere to move . . . .");
					continue;
				}

				// If the user falls into a pit, they recieve a game over
				if (cave[ytrack][xtrack-1] == 42) {
					System.out.println("You fell into a pit! NOOOOOoooo");
					System.out.println("GAME OVER");
					game = 2;
				}
				
				// If the path is clear, move the position of the adventurer and record movement
				cave[ytrack][xtrack] = 46;
				cave[ytrack][xtrack-1] = 80;
				xtrack = xtrack-1;
			}

		}

	}

}