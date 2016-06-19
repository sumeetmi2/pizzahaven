package com.pizzahaven.application;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.pizzahaven.exception.InvalidPizzaOrderStringException;
import com.pizzahaven.helper.OrderBuilder;
import com.pizzahaven.helper.OrderTaker;
import com.pizzahaven.items.PizzaIngredients;

/**
 * @author SumeetS
 *
 */
public class WelcomeToPizzaHaven {
    public static void main(String[] args) {
	buildModel();
	System.out.println("Welcome to pizza haven.");
	System.out.println("Please select size, base, sauce , toppings, cheese in the order aforementioned");
	System.out.println("You can input your selection in format Small|Normal|Margarita|Paneer,Onion,Jalapeno|Mozzarella,Double and press enter to complete an order.");
	
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	try {
	    while (true) {
		String tmp =null;
		System.out.println("Add new order?(y/n)   [Press d after order done]");
		tmp = br.readLine();
		if(tmp.equalsIgnoreCase("y")){
		    boolean error = false;
		    OrderTaker orderTaker = new OrderTaker();
		    tmp = br.readLine();
		    while(!tmp.equalsIgnoreCase("d")){
			try {
			    orderTaker.addOrder(OrderBuilder.inputOrderString(tmp));
			} catch (InvalidPizzaOrderStringException e) {
			    System.out.println(e.getMessage());
			}
			tmp=br.readLine();
		    }
		    try {
			orderTaker.calculateAllOrder();
		    } catch (InvalidPizzaOrderStringException e) {
			 System.out.println(e.getMessage());
			 error = true;
		    }
		    if(!error){
			System.out.println(orderTaker.generateBill());
		    }
		}else if(tmp.equalsIgnoreCase("n")){
		    break;
		}else{
		    System.out.println("please enter correct option");
		}
	    }
	    br.close();
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    /**
     * 
     */
    public static void buildModel() {
	PizzaIngredients.addCrust("Normal",75);
	PizzaIngredients.addCrust("Pan",100);
	PizzaIngredients.addCrust("Thin",100);
	PizzaIngredients.addCrust("Cheesy", 125);
	
	String sauce = "Margarita, Mexican Salsa";
	for(String t: sauce.split(",")){
	    String tmp = t.replaceAll(" ","").trim();
	    PizzaIngredients.addSauce(tmp);
	}
	
	String toppings = "Capsicum, Onion, Tomato, Corn, Baby Corn, Jalapeno, Black Olive, Paneer, Red Pepper";
	for(String t: toppings.split(",")){
	    String tmp = t.replaceAll(" ","").trim();
	    PizzaIngredients.addTopping(tmp);
	}
	
	String cheese ="Mozzarella, Cream Cheese";
	for(String t: cheese.split(",")){
	    String tmp = t.replaceAll(" ","").trim();
	    PizzaIngredients.addCheese(tmp);
	}
    }
}
