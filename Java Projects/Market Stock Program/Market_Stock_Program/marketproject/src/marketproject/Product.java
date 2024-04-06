package marketproject;

public abstract class Product {
    
	private static int totalproduct = 0;
    
	private java.util.Date Date = new java.util.Date();
    
    Product(){

    }

    public abstract double getPrice();
        
    public abstract void setPrice(double b);

    public abstract int getAmount();
 
    public abstract void setAmount(int a);

    public abstract String getName();
        
    public abstract String getType();
    
    public java.util.Date getDate() {
    	return Date;
    }
    	
    public static int getTotal() {
    	return totalproduct;
    }
    
    public static void decreaseTotal(){
        
    	totalproduct--;
    }
    
    

}