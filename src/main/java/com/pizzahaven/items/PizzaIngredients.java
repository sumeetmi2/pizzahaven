package com.pizzahaven.items;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author SumeetS
 *
 */
public class PizzaIngredients {
    private static final Map<String,Integer> CRUST_TYPE = new HashMap<String,Integer>();   
    private static final Set<String> TOPPING = new HashSet<String>();
    private static final Set<String> CHEESE = new HashSet<String>();
    private static final Set<String> SAUCE = new HashSet<String>();
    
    public static void addSauce(String sauce){
	SAUCE.add(sauce);
    }
    
    public static boolean checkSauce(String sauce){
	return SAUCE.contains(sauce);
    }
    
    public static String getAllSauce(){
	StringBuilder b = new StringBuilder();
	for(String top: SAUCE){
	    String tmp = top;
	    if(b.toString().length()>0){
		tmp = ","+tmp;
	    }
	    b.append(tmp);
	}
	return b.toString();
    }
    
    public static void addCheese(String cheese){
	CHEESE.add(cheese);
    }
    
    public static boolean checkCheese(String cheese){
	return CHEESE.contains(cheese);
    }
    
    public static String getAllCheese(){
	StringBuilder b = new StringBuilder();
	for(String top: CHEESE){
	    String tmp = top;
	    if(b.toString().length()>0){
		tmp = ","+tmp;
	    }
	    b.append(tmp);
	}
	return b.toString();
    }
    
    public static void addTopping(String topping){
	TOPPING.add(topping);
    }
    
    public static boolean checkTopping(String topping){
	return TOPPING.contains(topping);
    }
    
    public String getAllTopping(){
	StringBuilder b = new StringBuilder();
	for(String top: TOPPING){
	    String tmp = top;
	    if(b.toString().length()>0){
		tmp = ","+tmp;
	    }
	    b.append(tmp);
	}
	return b.toString();
    }
    
    public static void addCrust(String crustType, Integer price){
	CRUST_TYPE.put(crustType, price);
    }
    
    public static String getAllCrustType(){
	StringBuilder b = new StringBuilder();
	for(String top: CRUST_TYPE.keySet()){
	    String tmp = top;
	    if(b.toString().length()>0){
		tmp = ","+tmp;
	    }
	    b.append(tmp);
	}
	return b.toString();
    }
    
    public static int getPrice(String crustType){
	return CRUST_TYPE.get(crustType);
    }
    
    public static boolean checkCrustType(String crustType){
	return CRUST_TYPE.containsKey(crustType);
    }
}
