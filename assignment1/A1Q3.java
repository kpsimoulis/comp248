import java.util.Scanner;

// -------------------------------------------------------
// Assignment #1
// Question #3
// Written by: Konstantinos Psimoulis 2XXXXXXX
// For COMP 248 Section EE – Fall 2015
// --------------------------------------------------------

public class A1Q3 {

	public static void main(String[] args) {
		// Display welcome message
		System.out.print("-----------------------------------------------------");
		System.out.print("\n  Kosta's Internet Use Monthly Bill Program\n");
		System.out.print("\n-----------------------------------------------------\n\n");

		// Assign variables
		Scanner keyboard = new Scanner(System.in);
		int userHours;
		char userPackage;
		boolean invalidPackage = false;
		double baseCostA = 9.95, baseCostB = 13.95, baseCostC = 19.95;
		double overUsageRateA = 2.00, overUsageRateB = 1.00;
		double userTotalA, userTotalB, userTotalC, userTotal;

		// Get user input
		System.out.print("How many hours did you use (whole number please):");
		userHours = keyboard.nextInt();
		System.out.print("Do you have package A, B or C?");
		userPackage = keyboard.next().charAt(0);

		// Calculate Base Cost for all packages
		userTotalA = baseCostA;
		userTotalB = baseCostB;
		userTotalC = baseCostC;

		// Add Overtime to calculated cost
		if (userHours - 10 > 0) {
			userTotalA += overUsageRateA * (userHours - 10);
		}
		if (userHours - 20 > 0) {
			userTotalB += overUsageRateB * (userHours - 20);
		}

		// Calculate userTotal and Package Validity
		if (userPackage == 'A') {
			userTotal = userTotalA;
		} else if (userPackage == 'B') {
			userTotal = userTotalB;
		} else if (userPackage == 'C') {
			userTotal = userTotalC;
		} else {
			userTotal = 0;
			invalidPackage = true;
		}

		// Display total if the package is valid
		if (invalidPackage == true) {
			System.out.print("\nSorry but unable to calculate your monthly bill since Package " + userPackage
					+ " does not exist.");
		} else {
			System.out.print("Your monthly bill with Package " + userPackage + " is $" + userTotal);
		}

		// Calculate and display potential savings
		if (userTotal > userTotalA) {
			System.out.print("\nIf you were on Package A you could have saved $" + (userTotal - userTotalA));
		}
		if (userTotal > userTotalB) {
			System.out.print("\nIf you were on Package B you could have saved $" + (userTotal - userTotalB));
		}
		if (userTotal > userTotalC) {
			System.out.print("\nIf you were on Package C you could have saved $" + (userTotal - userTotalC));
		}

		// Display closing message
		System.out.print("\n\nCome back next month ...");
	}

}
