package com.pizzahaven.helper;

import java.util.concurrent.atomic.AtomicInteger;

import com.pizzahaven.exception.InvalidPizzaOrderStringException;
import com.pizzahaven.items.Order;

/**
 * @author SumeetS
 *
 */
public class OrderBuilder {
    
    private static AtomicInteger counter = new AtomicInteger(0);
    
    public static Order inputOrderString(String orderStr) throws InvalidPizzaOrderStringException{
	String[] input = orderStr.split("\\|");
	if(input.length!=5){
	    throw new InvalidPizzaOrderStringException("Insufficient parameters for the order, 5 options needed");
	}
	boolean doubleCheese = false;
	if(input[4].contains(",Double")){
	    doubleCheese = true;
	    input[4]= input[4].replaceAll(",Double","");
	}
	Order order = new Order.Builder().id(counter.incrementAndGet()).inputString(orderStr).size(input[0]).base(input[1]).sauce(input[2])
		.topping(input[3]).cheese(input[4]).doubleCheese(doubleCheese).build();
	return order;
    }
}
