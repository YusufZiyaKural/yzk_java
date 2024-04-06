package marketproject;

public class Vegetable extends Product {

    private int amount;
    private double price;
    private String name;

    private static int totalVegetable=0;

    private final String TYPE = "Vegetable";

    public Vegetable(int amount, double price, String name) {
        
    	this.amount = amount;
        this.price = price;
        this.name = name;
        totalVegetable+=1;
    }

    public Vegetable(double price, String name) {
        
    	this.amount = 1; 
        this.price = price;
        this.name = name;
        totalVegetable+=1;
    }

    public double getPrice() {
        
    	return price;
    }

    public void setPrice(double price) {
        
    	this.price = price;
    }

    public int getAmount() {
        
    	return amount;
    }

    public void setAmount(int amount) {
        
    	this.amount = amount;
    }

    public String getName() {
        
    	return name;
    }
    @Override
    public String getType() {
        
    	return TYPE;
    }
   
    public static int getTotal() {
        
    	return totalVegetable;
    }
    public static void decreaseTotal(){
          
      	totalVegetable--;
    }
} 
