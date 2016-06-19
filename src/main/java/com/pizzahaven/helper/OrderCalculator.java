package com.pizzahaven.helper;

import com.pizzahaven.exception.InvalidPizzaOrderStringException;
import com.pizzahaven.items.Cost;
import com.pizzahaven.items.Order;
import com.pizzahaven.items.PizzaIngredients;
import com.pizzahaven.items.PizzaSize;

/**
 * @author SumeetS
 *
 */
public class OrderCalculator {
    
    private Order order;
    
    public OrderCalculator(Order order){
	this.order = order;
    }
    
    public Cost calculate() throws InvalidPizzaOrderStringException{
	 PizzaSize pizzaSize = null;
	try{
	    pizzaSize= PizzaSize.valueOf(order.getSize().toUpperCase());
	}catch(IllegalArgumentException e){
	    throw new InvalidPizzaOrderStringException("Invalid Pizza Size");
	}
	
	Cost cost = new Cost();
	
	String base = order.getBase();
	if(base.contains(",")){ // multiple bases cant be added
	    throw new InvalidPizzaOrderStringException("Multiple pizza bases cant be added");
	}
	if(!PizzaIngredients.checkCrustType(order.getBase())){
	    throw new InvalidPizzaOrderStringException("Sorry We dont have the base "+ base);
	}
	cost.setCost(PizzaIngredients.getPrice(base));
	pizzaSize.addBase(cost);
	
	String sauce = order.getSauce();
	for(String s: sauce.split(",")){
	    if(!PizzaIngredients.checkSauce(s)){
		throw new InvalidPizzaOrderStringException("Sorry we dont have that sauce "+ s);
	    }
	}
	
	String toppings = order.getTopping();
	for(String s: toppings.split(",")){
	    if(!PizzaIngredients.checkTopping(s)){
		throw new InvalidPizzaOrderStringException("Sorry we dont have that topping "+ s);
	    }else{
		pizzaSize.addTopping(cost);
	    }
	}
	
	String cheese = order.getCheese();
	for(String s: cheese.split(",")){
	    if(!PizzaIngredients.checkCheese(s)){
		throw new InvalidPizzaOrderStringException("Sorry we dont have that cheese "+ s);
	    }else{
		pizzaSize.addCheese(cost);
	    }
	}
	
	if(order.getDoubleCheese()){
	   pizzaSize.doubleCheese(cost);
	}
	
	return cost;
    }
    
}
