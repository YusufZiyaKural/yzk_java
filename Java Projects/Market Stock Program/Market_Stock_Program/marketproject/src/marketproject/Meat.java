package marketproject;

class Meat extends Product {
    private int amount;
    private double price;
    private String name;
    private static int totalMeat;
    private final String TYPE = "Meat";

    public Meat(int amount, double price, String name) {
        this.amount = amount;
        this.price = price;
        this.name = name;
        totalMeat++;
    }

    public Meat(double price, String name) {
        this(0, price, name);
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
    
    public static int getTotal() {
        return totalMeat;
    }

    @Override
    public String getType() {
        return TYPE;
    }
  public static void decreaseTotal(){
        
    	totalMeat--;
    }
}