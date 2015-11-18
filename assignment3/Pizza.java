// -----------------------------------------------------
// Assignment #3 / COMP 248
// Question: #2
// File name: Pizza.java (File 2 of 2)
// Written by: Konstantinos Psimoulis 2XXXXXXX
// For COMP 248 Section EE – Fall 2015
// -----------------------------------------------------

public class Pizza {

	// Instance variables
	private int size;
	private int toppingCheese;
	private int toppingPepperoni;
	private int toppingMushroom;
	
	// Constructor with size and toppings
    public Pizza(int size, int toppingCheese, int toppingPepperoni, int toppingMushroom)
    {
      this.size = size;
      this.toppingCheese = toppingCheese;
      this.toppingPepperoni = toppingPepperoni;
      this.toppingMushroom = toppingMushroom;
    }

    // Default empty constructor
    public Pizza()
    {
    	this.size = 0;
    	this.toppingCheese = 0;
    	this.toppingPepperoni = 0;
    	this.toppingMushroom = 0;
    }
    
    // equals method that will compare whether they are identical in content or not.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pizza other = (Pizza) obj;
		if (size != other.size)
			return false;
		if (toppingCheese != other.toppingCheese)
			return false;
		if (toppingMushroom != other.toppingMushroom)
			return false;
		if (toppingPepperoni != other.toppingPepperoni)
			return false;
		return true;
	}

	// String method that will display the content of the Pizza in a human readable format
	@Override
	public String toString() {
		String sizeName;
        switch (size) {
        case 1:
        	sizeName = "SMALL";
        	break;
		case 2:
        	sizeName = "MEDIUM";
        	break;
        case 3:
        	sizeName = "LARGE";
        	break;
        default:
        	sizeName = "";
        	break;
        }
		return String.format("A %s pizza with %d cheese topping(s), %d pepperoni toppings(s) and %d mushroom topping(s) cost $%.2f", 
				sizeName, toppingCheese, toppingPepperoni, toppingMushroom, calcCost());
	}    
    
	/*
	 * Calculate the cost based the size of pizza, the topping price and the total number of toppings 
	 */
    public double calcCost() {
    	int t = getTotalTopping();
        switch (size) {
        case 1:
        	return 10 + ( 2.0 * t);
		case 2:
        	return 12 + ( 2.25 * t);
        case 3:
        	return 14 + ( 2.5 * t);
        default:
        	return 0.0;
        }
    }

    /*
     * get the total number of all toppings
     */
    public int getTotalTopping() {
    	return toppingCheese + toppingPepperoni + toppingMushroom;
    }
    
    /*
     * Accessors (Getters) and Mutators (Setters)
     */
    
	public int getToppingCheese() {
		return toppingCheese;
	}

	public void setToppingCheese(int toppingCheese) {
		this.toppingCheese = toppingCheese;
	}

	public int getToppingPepperoni() {
		return toppingPepperoni;
	}

	public void setToppingPepperoni(int toppingPepperoni) {
		this.toppingPepperoni = toppingPepperoni;
	}

	public int getToppingMushroom() {
		return toppingMushroom;
	}

	public void setToppingMushroom(int toppingMushroom) {
		this.toppingMushroom = toppingMushroom;
	}

	public int getSize() {
		return size;
	}
	
	public void setSize(int size) {
		this.size = size;
	}
	
}
