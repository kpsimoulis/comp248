// -----------------------------------------------------
// Assignment #3 / COMP 248
// Question: #1
// File name: A3Q1.java (File 1 of 1)
// Written by: Konstantinos Psimoulis 2XXXXXXX
// For COMP 248 Section EE – Fall 2015
// -----------------------------------------------------

import java.util.Scanner;

public class A3Q1 {

	// The data of the board
	public static int[] data = new int[9];

	// Array containing wins of X and O
	public static int[][] win = new int[2][1];

	// User keyboard
	public static Scanner keyboard = new Scanner(System.in);

	// Initialize player 1
	public static char player = 'X';

	// Initialize other game data
	public static int turn = 0;
	public static int games = 0;
	public static int position;
	public static String positionError = "";

	public static void main(String[] args) {
		
		// Print board before the game starts
		printBoard();

		// Play until there is a winner or tie
		while (play()) {
			printBoard();
		}

		// Closing message with results
		endGame();
	}

	// Function that will display the board
	public static void printBoard() {
		String v;

		// Loop through the 9 board elements
		// The board array will contain the following:
		// 0 when not set
		// 1 when X
		// 4 when O
		for (int i = 1; i <= 9; i++) {
			if (data[i - 1] == 1) {
				v = "X";
			} else if (data[i - 1] == 4) {
				v = "O";
			} else {
				v = Integer.toString(i);

			}

			// Add a new line every 3 elements
			System.out.print(v + " ");
			if (i % 3 == 0) {
				System.out.println();
			}
		}
	}

	// Show game results, statistics and announce the champion
	public static void endGame() {
		char champion;
		System.out.println("Thank you for playing");
		System.out.println("Total number of games played " + games);
		System.out.printf(
				"Player X has won " + win[0][0] + " (%.2f%%) games; ", win[0][0] * 100 / (double) games);
		System.out.printf(
				"Player O has won " + win[1][0] + " (%.2f%%) games.", win[1][0] * 100 / (double) games);
		if (win[0][0] > win[1][0]) {
			champion = 'X';
		} else {
			champion = 'O';
		}
		System.out.println("The grand champion is player " + champion + "!!!");
	}

	public static boolean play() {
		// Increment number of turns
		turn++;

		// Find who's turn it is depending on the number of turns
		if (turn % 2 == 1) {
			player = 'X';
		} else {
			player = 'O';
		}

		// Ask for position
		System.out.print("Player " + player + " – Enter the position number you wish to mark: ");

		// Keep asking for a valid position available
		while (!isPositionAvailable()) {
			System.out.println(positionError);
			System.out.print("Player " + player + " – Enter the position number you wish to mark: ");
		}

		// Mark the position in the data board with 1 for X and 4 for O
		if (player == 'X') {
			data[position - 1] = 1;
		} else {
			data[position - 1] = 4;
		}

		// End of turn, check if there is a winner
		if (checkWin()) {
			printBoard();
			System.out.println("Player " + player + " won!");
			reset();
			return playAgain();
		}
		// or if the game is a tie
		if (turn == 9) {
			System.out.println("We have a tie");
			reset();
			return playAgain();
		} else {
			return true;
		}

	}

	// Reset the board, the turns and increment the game
	public static void reset() {
		games++;
		data = new int[9];
		turn = 0;
	}

	// Display the results up to now and ask the user if they want to play again
	public static boolean playAgain() {
		System.out.println("Games played to date " + games);
		System.out.println("Player X has won " + win[0][0] + " game(s); Player O has won " + win[1][0] + " game(s).");
		System.out.print("Do you wish to play another game? (yes/no): ");
		String continueGame = keyboard.next();
		if (continueGame.equalsIgnoreCase("yes")) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean isPositionAvailable() {

		// Check the if the user input is an integer and assign it to position
		// variable
		if (keyboard.hasNextInt()) {
			position = keyboard.nextInt();
		}
		// If it is not an integer, then set position to an invalid number
		// that will fail the next condition below e.g. position = 0
		else {
			position = 0;
			keyboard.next();
		}

		// Check if the position input is between 1 and 9
		if (position < 1 || position > 9) {
			positionError = "That is not a valid position – must be between 1 and 9 inclusive";
			return false;
		}
		// Check if the position is already taken which would be a number other
		// the initial value of 0
		else if (data[position - 1] != 0) {
			positionError = "That position is not available";
			return false;
		} else {
			return true;
		}
	}

	// There are 3 possible ways to have a winner
	// (i) Check if the current row is X X X or O O O
	// (ii) Check if the current column is X X X or O O O
	// (iii) Check the 2 diagonals as well
	public static boolean checkWin() {

		// It is not possible to have a winner before 6 moves, so in that case
		// return false
		// Note: turn starts from 0 so we compare if it less than 5
		if (turn < 5) {
			return false;
		}

		// Get the column
		int col = position % 3;
		if (col == 0) {
			col = 3;
		}

		// Get the row
		int row = (int) Math.ceil(position / 3.0);

		// Get the sum of the row and the sum of the column
		int colTotal = data[col - 1] + data[col + 3 - 1] + data[col + 6 - 1];
		int rowTotal = data[3 * row - 1] + data[3 * row - 2] + data[3 * row - 3];

		// Get the total of the 2 diagonals
		int diagonal1 = data[0] + data[4] + data[8];
		int diagonal2 = data[2] + data[4] + data[6];

		// Using two numbers that all their sets inside their power set
		// can never be combined to common sum
		// X = 1, O = 4 so the sum of X X X is 3 and the sum of O O O is 12
		if (colTotal == 3 || rowTotal == 3 || diagonal1 == 3 || diagonal2 == 3) {
			win[0][0]++;
			return true;
		} else if (colTotal == 12 || rowTotal == 12 || diagonal1 == 12 || diagonal2 == 12) {
			win[1][0]++;
			return true;
		} else {
			return false;
		}
	}

}
