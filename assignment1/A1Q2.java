import java.util.Scanner;

// -------------------------------------------------------
// Assignment #1
// Question #2
// Written by: Konstantinos Psimoulis 2XXXXXXXX
// For COMP 248 Section EE – Fall 2015
// --------------------------------------------------------

public class A1Q2 {

	public static void main(String[] args) {
		// Display Welcome message
		System.out.print("---------------------------------------------------------\n");
		System.out.print("            Kosta's Magic Date Program\n");
		System.out.print("---------------------------------------------------------\n");

		// Instantiate Scanner and print the question to the user
		Scanner keyboard = new Scanner(System.in);
		System.out.print("\nEnter a date as mm dd yyyy and I will tell you if it is magic or not:\n");

		// Ask for input
		int month = keyboard.nextInt();
		int day = keyboard.nextInt();
		int year = keyboard.nextInt();

		// Determine whether to compare with the last digit
		// last 2 digits or last 3 digits of the year
		int yearCompare;
		if ((day * month) < 10) {
			yearCompare = year % 10;
		} else if ((day * month) < 100) {
			yearCompare = year % 100;
		} else {
			yearCompare = year % 1000;
		}

		// Evaluate answer
		String answer;
		if ((month * day) == yearCompare) {
			answer = "is a magic year!!!!";
		} else {
			answer = "is NOT a magic year. :(";
		}

		// Show result
		System.out.println(month + "/" + day + "/" + year + " " + answer);
		System.out.print("\nCome back for another try sometime!");

	}

}
