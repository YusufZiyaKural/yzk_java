package marketproject;

import java.util.ArrayList;
import java.util.Scanner;



public class Main {
	
	static Scanner input = new Scanner(System.in);
	
	ArrayList<Product> productList = new ArrayList<>();
	
	ArrayList<Product> fruitList = new ArrayList<>();
	
	ArrayList<Product> meatList = new ArrayList<>();
	
	ArrayList<Product> vegetableList = new ArrayList<>();
	
	
	public static void main(String[] args) { //MAIN
		
		
		Main main = new Main();
		
		main.userMenu();
		
	}
	
	
	/*LIST MANIPULATION METHODS*/
	
	public void adjustList() {//ADJUSTS LIST AFTER A NEW UPDATE TO THE LIST
		
		productList.clear();
		
		for(int i = 0; i < fruitList.size(); i++) {
			productList.add(fruitList.get(i));
		}
		
		for(int i = 0; i < meatList.size(); i++) {
			productList.add(meatList.get(i));
		}
		
		for(int i = 0; i < vegetableList.size(); i++) {		
			productList.add(vegetableList.get(i));
		}
			
		}
	
	public void createList(){//CREATES THE LIST INTERFACE
		
		String largest = "Unit Price ($)";
		
		for(int i = 0; i < productList.size(); i++) {
			
		if(productList.get(i).getName().length() > largest.length()) {
			largest = productList.get(i).getName();
		}
	
		}
		
		
		
		int s = 0;
		
		System.out.print("  Product");
		for(int a = 0; a < largest.length()-"Product".length();a++) {
			System.out.print(" ");
	    	s++;
		}	
		System.out.print("\t\t");
		System.out.print("Amount");
		for(int b = 0; b < largest.length()-"Amount".length();b++) {
			System.out.print(" ");
	    	s++;
		}	
		System.out.print("\t\t");
		System.out.print("Unit Price ($)");
		for(int c = 0; c < largest.length()-"Unit Price ($)".length();c++) {
			System.out.print(" ");
	    	s++;
		}
		System.out.print("\t\t");
		System.out.print("Type");
		for(int d = 0; d < largest.length()-"Type".length();d++) {
			System.out.print(" ");
			s++;
		}
		System.out.print("\t\t");
		System.out.println("Creation Date \t\t ");
		for(int j = 0; j < s+108 ; j++) {
			System.out.print("-");
			
		}	
		
		for(int i = 0; i < productList.size(); i++) {
			
			System.out.println();
			System.out.print("  ");
			System.out.print(productList.get(i).getName());
			
			for(int j = 0; j < largest.length()-productList.get(i).getName().length();j++) {
				System.out.print(" ");
		    	}	
			System.out.print("\t\t");
			System.out.print(productList.get(i).getAmount());
			
			for(int j = 0; j < largest.length()-(productList.get(i).getAmount()+"").length();j++) {
				System.out.print(" ");
			    }	
			System.out.print("\t\t");
			System.out.print(productList.get(i).getPrice());
			
			for(int j = 0; j < largest.length()-(productList.get(i).getPrice()+"").length();j++) {
				System.out.print(" ");
			    }
			System.out.print("\t\t");
			System.out.print(productList.get(i).getType());
			
			for(int j = 0; j < largest.length()-productList.get(i).getType().length();j++) {
				System.out.print(" ");
			    }
			System.out.print("\t\t");
			System.out.print(productList.get(i).getDate());	
		}
		System.out.println();
		System.out.println();
		System.out.println();
		
	}
	
	public void addList(String type,String name,int amount,double price) {//CREATES AND ADDS A OBJECT TO ARRAYLIST
			
	
	
				if(typeIsValid(type)) {
					
					if(type.equals("Fruit")||type.equals("fruit")) {
						Fruit fruit = new Fruit(amount,price,name);
						fruitList.add(fruit);
						adjustList();
					}
					
					if(type.equals("Meat")||type.equals("meat")) {
						Meat meat = new Meat(amount,price,name);
						meatList.add(meat);
						adjustList();
					}
					
					if(type.equals("Vegetable")||type.equals("vegetable")) {
						Vegetable vegetable = new Vegetable(amount,price,name);
						vegetableList.add(vegetable);
						adjustList();
					}
				}else {
					System.out.println("Type is invalid!");
				 }
			
	
	}
	
	public void removeList(String productname) {//REMOVES A OBJECT FROM ARRAYLIST
		
    	if(productCheckList(productname) >= 0) {
    		
    	
			if(fruitCheckList(productname) >= 0) {
				
				fruitList.remove(fruitCheckList(productname));
			    Fruit.decreaseTotal();
				adjustList();
			}
			if(meatCheckList(productname) >= 0) {
				
				meatList.remove(meatCheckList(productname));
				Meat.decreaseTotal();
				adjustList();
			}
			if(vegetableCheckList(productname) >= 0) {
				
				vegetableList.remove(vegetableCheckList(productname));
				Vegetable.decreaseTotal();
				adjustList();
			}
				}else {
					System.out.println("That product is already not in the list!");
				 }
    	}
	
    
    /*MENU METHODS*/
	
    public void userMenu() {//CREATES THE MENU
		String stringinput = "";
		createList();
		while(true) {
		System.out.println("Please choose a command");
		System.out.println("-Add");
		System.out.println("-Remove");
		System.out.println("-Total");
		System.out.println("-Setprice");
		System.out.println("-Setamount");
		System.out.println("-Exit");
		
		stringinput = input.next();
		
		while(commandIsValid(stringinput) == false) {
			
			System.out.println("Your input is Invalid.");
			
			System.out.println("Please choose a command");
			System.out.println("-Add");
			System.out.println("-Remove");
			System.out.println("-Total");
			System.out.println("-Setprice");
			System.out.println("-Setamount");
			System.out.println("-Exit");
			
			stringinput = input.next();
		}
	
		if(stringinput.equals("Add")||stringinput.equals("add")) {
			
			userCreateProduct();
			createList();
		}
		if(stringinput.equals("Remove")||stringinput.equals("remove")) {
			
			userDeleteProduct();
			createList();
		}
		if(stringinput.equals("Total")||stringinput.equals("total")) {
			
			userGetTotal();
			
		}
		if(stringinput.equals("Exit")||stringinput.equals("exit")) {
			System.out.println("Terminated successfully.");
			userEndProgram();
			
		}
		if(stringinput.equals("Setamount")||stringinput.equals("setamount")) {
			userSetAmount();
			createList();
		}
		if(stringinput.equals("Setprice")||stringinput.equals("setprice")) {
		
			userSetPrice();
			createList();
		}
		 }
	}

	public void userCreateProduct() {//GETS PRODUCT PARAMETERS AND CREATES A PRODUCT
	   	String stringinput1 = "";
		String stringinput2 = "";
		int intinput;
		double doubleinput;
	   
		System.out.println("Enter a type for a new product (Fruit, Meat, Vegetable)");
		
		stringinput1 = input.next();
		
		while(typeIsValid(stringinput1) == false) {
			System.out.println("Type must be (Fruit, Meat, Vegetable).");
			stringinput1 = input.next();
		}
			
		System.out.println("Enter a name for the new product.");
	
		stringinput2 = input.next();
		while(productCheckList(stringinput2)>=0) {
			System.out.println("There is already a product called "+stringinput2+" in the list!");
			stringinput2 = input.next();
		}
		System.out.println("Enter a amount for the new product. INPUT TYPE MUST BE INTEGER");
		
		intinput= input.nextInt();

		System.out.println("Enter a price for the new product. INPUT TYPE MUST BE DOUBLE");
		
		doubleinput = input.nextDouble();
		
		addList(stringinput1, stringinput2, intinput, doubleinput);
   }
	
    public void userDeleteProduct() {//GETS A PRODUCT NAME FROM USER AND REMOVES THAT PRODUCT FROM LIST
    	if(productList.isEmpty() == false) {
    	System.out.println("Enter product name.");
    	String stringinput = input.next();
    	
    	removeList(stringinput);
    	}else {
		System.out.println("There is no product in the list.");
    	}	
    }
    
    public void userEndProgram() {// ENDS PROGRAM
    	System.exit(0);
    }
    
    public void userGetTotal() {//GETS TYPE FROM USER AND GIVES THAT TYPES TOTAL
    	System.out.println("Enter type for total. (Fruit, Meat, Vegetable or Product.");
    	
    	String stringinput = input.next();
    	
    	if(stringinput.equals("Fruit")||stringinput.equals("fruit")) {
    		System.out.println("Total fruit product created is "+Fruit.getTotal());
    	}
        if(stringinput.equals("Vegetable")||stringinput.equals("vegetable")) {
        	System.out.println("Total vegetable product created is "+Vegetable.getTotal());
    	}
        if(stringinput.equals("Meat")||stringinput.equals("meat")) {
        	System.out.println("Total meat product created is "+Meat.getTotal());
    	}
        if(stringinput.equals("Product")||stringinput.equals("product")) {
    		System.out.println("Total product created is "+Product.getTotal());
    	}
    }

    public void userSetPrice() {//CHANGE PRODUCT PRICE
    	if(productList.isEmpty() == false) {
    	System.out.println("Enter the product name.");
    	String stringinput = input.next();
    	System.out.println("Enter the new price.");
    	double doubleinput = input.nextDouble();
    	
    	productList.get(productCheckList(stringinput)).setPrice(doubleinput);
    	}else {
    		System.out.println("There is no product in the list.");
    	}
    }
    
    public void userSetAmount() {//CHANGE PRODUCT AMOUNT
    	if(productList.isEmpty() == false) {
    	System.out.println("Enter the product name.");
    	String stringinput = input.next();
    	System.out.println("Enter the new amount.");
    	int intinput = input.nextInt();
    	
    	productList.get(productCheckList(stringinput)).setAmount(intinput);
    	}else {
    		System.out.println("There is no product in the list.");
    	}
    }
    
    /*CONTROL METHODS*/
    public boolean typeIsValid(String producttype) {//CHECK IF INPUT IS VALID
	   if(producttype.equals("Meat")||producttype.equals("meat")||producttype.equals("Fruit")||producttype.equals("fruit")||producttype.equals("Vegetable")||producttype.equals("vegetable")) {
		   return true;
	   }else {
		   return false;
	   }
   }

    public boolean commandIsValid(String stringinput) {//CHECK IF INPUT IS VALID
    	if(stringinput.equals("Add")||stringinput.equals("add")||stringinput.equals("Remove")||stringinput.equals("remove")||stringinput.equals("Total")||stringinput.equals("total")||stringinput.equals("Exit")||stringinput.equals("exit")||stringinput.equals("Setprice")||stringinput.equals("setprice")||stringinput.equals("Setamount")||stringinput.equals("setamount")) {
    		   return true;
 	   }else {
 		   return false;
 	   }
    	
    }
    
    public int productCheckList(String name) {//LINEAR SEARCH TO FIND A OBJECT AND GET ITS INDEX VALUE
	  
	  for(int i = 0; i < productList.size(); i++) {
			
		    if((productList.get(i).getName()).equals(name)) {
				return i;
			}
			
	}
	  return -1;
    }

    public int meatCheckList(String name) {//LINEAR SEARCH TO FIND A OBJECT AND GET ITS INDEX VALUE
	  
	  for(int i = 0; i < meatList.size(); i++) {
			
		    if(meatList.get(i).getName().equals(name)) {
				return i;
			}
			
	  }
	  return -1;
  }

    public int vegetableCheckList(String name) {//LINEAR SEARCH TO FIND A OBJECT AND GET ITS INDEX VALUE
	  
	  for(int i = 0; i < vegetableList.size(); i++) {
			
		    if((vegetableList.get(i).getName()).equals(name)) {
				return i;
			}
			
	  }
	  return -1;
}

    public int fruitCheckList(String name) {//LINEAR SEARCH TO FIND A OBJECT AND GET ITS INDEX VALUE
	  
	  for(int i = 0; i < fruitList.size(); i++) {
			
		    if((fruitList.get(i).getName()).equals(name)) {
				return i;
			}
			
	  }
	 return -1;
}  
  
  
  



}
