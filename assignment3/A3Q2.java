import java.util.Scanner;

// -----------------------------------------------------
// Assignment #3 / COMP 248
// Question: #2
// File name: A3Q2.java (File 1 of 2)
// Written by: Konstantinos Psimoulis 2XXXXXXX
// For COMP 248 Section EE – Fall 2015
// -----------------------------------------------------

public class A3Q2 {

	public static void main(String[] args) {
		
		// Initialize variables
		Scanner keyboard = new Scanner(System.in);
		Pizza pizza1 = new Pizza(); // Empty pizza
		Pizza pizza2 = new Pizza(); // First order
		Pizza pizza3 = new Pizza(); // Second order
		
		// Welcome message
		System.out.print("---------------------------------------------------------\n");
		System.out.print("            Kosta's Pizza\n");
		System.out.print("---------------------------------------------------------\n\n");		
		
		// Ask Order Details for Pizza2 (First order of pizza since pizza1 will be empty)
		System.out.println("Please place order for 1st pizza:");
		System.out.print("Size: small, medium or large? ");
		pizza2.setSize(getSizeByName(keyboard.next()));
		System.out.print("Indicate the number of each of the following toppings: cheese, pepperoni and mushroom ");
		pizza2.setToppingCheese(keyboard.nextInt());
		pizza2.setToppingPepperoni(keyboard.nextInt());
		pizza2.setToppingMushroom(keyboard.nextInt());

		// Ask Order Details for Pizza3
		System.out.println("Please place order for 2nd pizza:");
		System.out.print("Size: small, medium or large? ");
		pizza3.setSize(getSizeByName(keyboard.next()));
		System.out.print("Indicate the number of each of the following toppings: cheese, pepperoni and mushroom ");
		pizza3.setToppingCheese(keyboard.nextInt());
		pizza3.setToppingPepperoni(keyboard.nextInt());
		pizza3.setToppingMushroom(keyboard.nextInt());
		
		// Show the details of each pizza
		System.out.println("\nHere are the three pizzas:");
		System.out.println(pizza1.toString());
		System.out.println(pizza2.toString());
		System.out.println(pizza3.toString());

		// Compare the 3 pizzas and show the results
		System.out.println("\nResults of comparisons:");
		comparePizza(pizza1, pizza2, pizza3);
		
		// Change the first pizza’s content to be the same as the second one. 
		pizza1 = pizza2;
		
		// Compare again and show results
		System.out.println("\nResults of comparisons after changing one of the pizzas .....");
		comparePizza(pizza1, pizza2, pizza3);
		
		// Closing message
		System.out.println("\nEnjoy the pizzas .... Don't forget your TUMS on the way out.");
		
	}
	
	// Get the proper integer of the pizza size by given size name
    public static int getSizeByName(String size) {
        switch (size) {
        case "small":
        	return 1;
        case "medium":
        	return 2;
        case "large":
        	return 3;
        default:
        	return 0;
        }
    }	
	
    // Compare every combination of 3 pizzas
	public static void comparePizza(Pizza pizza1, Pizza pizza2, Pizza pizza3) {
		if (pizza1.equals(pizza2) && pizza2.equals(pizza3)) {
			System.out.println("All pizzas are the same.");
			System.out.println(pizza1.toString());
		}
		else if(pizza1.equals(pizza2)) {
			System.out.println("First and second pizza are the same.");
			System.out.println("    " + pizza1.toString());
			System.out.println("Pizza 3:");
			System.out.println("    " + pizza3.toString());
		}
		else if(pizza1.equals(pizza3)) {
			System.out.println("First and third pizza are the same.");
			System.out.println("    " + pizza1.toString());
			System.out.println("Pizza 2:");
			System.out.println("    " + pizza2.toString());
		}
		else if (pizza2.equals(pizza3)) {
			System.out.println("Second and third pizza are the same.");
			System.out.println("    " + pizza2.toString());
			System.out.println("Pizza 1:");
			System.out.println("    " + pizza1.toString());
		}
		else {
			System.out.println("None of the pizzas are the same.");
		}
	}

}
