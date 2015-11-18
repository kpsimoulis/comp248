
// -------------------------------------------------------
// Assignment #1
// Question #1
// Written by: Konstantinos Psimoulis 2XXXXXXX
// For COMP 248 Section EE – Fall 2015
// --------------------------------------------------------

import java.util.Scanner;

public class A1Q1 {

	public static void main(String[] args) {
		// Welcome message
		System.out.print("---------------------------------------------------------\n");
		System.out.print("            Kosta's Male/Female Ratio Program\n");
		System.out.print("---------------------------------------------------------\n");

		// Ask for User Input
		Scanner keyboard = new Scanner(System.in);
		System.out.print("\nHow many female students are registered for your course?\n");
		int numberOfFemaleStudents = keyboard.nextInt();
		System.out.print("\nHow many male students are registered for your course?\n");
		int numberOfMaleStudents = keyboard.nextInt();

		// Perform necessary calculations
		int numberOfTotalStudents = numberOfFemaleStudents + numberOfMaleStudents;
		double pctOfFemaleStudents = numberOfFemaleStudents / (double) numberOfTotalStudents;
		double pctOfMaleStudents = numberOfMaleStudents / (double) numberOfTotalStudents;

		// Print Result and closing message
		System.out.print("Congratulations! You have " + (numberOfFemaleStudents + numberOfMaleStudents)
				+ " students registered in your course.");
		System.out.print("\n      Percentage of females = " + pctOfFemaleStudents + " or ~"
				+ (int) (pctOfFemaleStudents * 100) + "%");
		System.out.print(
				"\n      Percentage of males = " + pctOfMaleStudents + " or ~" + (int) (pctOfMaleStudents * 100) + "%");
		System.out.print("\nHave a good term!!!");
	}

}
