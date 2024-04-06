package marketproject;

class Fruit extends Product {
    private int amount = 0;
    private double price = 0;
    private String name;
    private static int totalFruit = 0;
    private final String TYPE = "Fruit";

    Fruit(double price, String name){
        
    	amount = 1;
        this.price = price;
        this.name = name;
        totalFruit++;
    }

    Fruit(int amount, double price, String names){
       
    	this.amount = amount;
        this.price = price;
        this.name = names;
        totalFruit++;
    }

    public double getPrice(){
        
    	return price;
    }
    public void setPrice(double newprice){
        
    	price = newprice;

    }
    public int getAmount(){
       
    	return amount;
    }
    public void setAmount(int newamount){
        
    	amount = newamount;
    }
    public String getName(){
        
    	return name;
    }
    @Override
    public String getType(){
        
    	return this.TYPE;
    }

    public static int getTotal(){
        
    	return totalFruit;
    }
    
    public static void decreaseTotal(){
        
    	totalFruit--;
    }
}