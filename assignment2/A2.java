// -------------------------------------------------------
// Assignment #2
// Written by: Konstantinos Psimoulis 2XXXXXXX
// For COMP 248 Section EE – Fall 2015
// --------------------------------------------------------

import java.util.Scanner;

public class A2 {

	public static void main(String[] args) {

		Scanner keyboard = new Scanner(System.in);
		int i,j, houseTotal; // Increment variables
		
		System.out.println("---------------------------------------------------------");
		System.out.println("       Kosta's Silly House Drawing Program");
		System.out.println("---------------------------------------------------------");
		System.out.print("What is your name? ");
		// Ask for User's name
		String name = keyboard.next();
		System.out.println("Hello "+name+", welcome to my silly house drawing program.");

		// Ask for User if he wants to draw a house
		System.out.print("Do you want me to draw a simple house for you ? (yes/no) ");
		String drawHouse = keyboard.next();
		houseTotal = 0;
		while (!drawHouse.equals("no")) {
			if (drawHouse.toLowerCase().intern() == "yes") {
				System.out.print("Enter height and width of the house you want me to draw (must be even numbers): ");
				int height = keyboard.nextInt();
				int width = keyboard.nextInt();
				while (!(height % 2 == 0)) {
					System.out.println("You enter " + height + " for height. Not an even number!");
					System.out.print("Please enter an even number for the height of the house: ");
					height = keyboard.nextInt();
				}
				while (!(width % 2 == 0)) {
					System.out.println("You enter " + width + " for width. Not an even number!");
					System.out.print("Please enter an even number for the width of the house: ");
					width = keyboard.nextInt();
				}
				int halfWidth = width/2;
				i = 1;
				// Construct roof
				while (i++ < halfWidth) {
					System.out.print(" ");
				}
				System.out.println("**");
				i = 0;
				int spacesMiddle = 2;
				while (i++ < halfWidth-1) {
					int spacesLeft = halfWidth-i-1;
					j = 0;
					while (j++ < spacesLeft) {
						System.out.print(" ");
					}
					System.out.print("/");
					j = 0;
					while (j++ < spacesMiddle) {
						System.out.print(" ");
					}
					System.out.println("\\");
					spacesMiddle += 2;
				}
				
				// Construct body
				i = 0;
				while (i++ < width) {
					System.out.print("-");
				}
				// Draw first row of the body
				System.out.print("\n|");
				i = 0;
				while (i++ < width - 2 ) {
					System.out.print(" ");
				}
				System.out.println("|");
				// Draw second row of the body
				System.out.print("|");
				i = 0;
				while (i++ < width - 2 ) {
					System.out.print(" ");
				}
				System.out.println("|");
				
				// Draw body according to height
				i = 0;
				while (i++ < height) {
					System.out.print("|");
					j = 0;
					while (j++ < width - 2 ) {
						System.out.print(" ");
					}
					System.out.println("|");
				}

//				// draw bottom row of the house
				i = 0;
				while (i++ < width) {
					System.out.print("-");
				}
				
				houseTotal++;	
			}
			if (houseTotal > 0 ) {
				System.out.print("\n\n"+name+", do you want me to draw another house for you (yes to continue)? ");
			}
			else {
				System.out.print("Do you want me to draw a simple house for you ? (yes/no) ");
			}
			drawHouse = keyboard.next();
			
		}
		if (drawHouse.equals("no")) {
			if (houseTotal == 1 ) {
				System.out.println("\nHope you like your house!");
			}
			else if (houseTotal > 1) {
				System.out.println("\nHope you like your " +houseTotal+ " houses!");
			}
			else {
				System.out.println("\nSorry you have decided not to have any houses drawn!");
			}
		}
		
		// Closing message
		System.out.println("\n\nCome back soon Kosta...");
	}

}
