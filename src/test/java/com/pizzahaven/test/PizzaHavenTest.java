package com.pizzahaven.test;

import org.junit.Test;

import com.pizzahaven.application.WelcomeToPizzaHaven;
import com.pizzahaven.exception.InvalidPizzaOrderStringException;
import com.pizzahaven.helper.OrderBuilder;
import com.pizzahaven.helper.OrderTaker;
import com.pizzahaven.items.Order;

import junit.framework.TestCase;

/**
 * @author SumeetS
 *
 */
public class PizzaHavenTest extends TestCase {
    
    OrderTaker orderTaker = new OrderTaker();
    
    /* (non-Javadoc)
     * @see junit.framework.TestCase#setUp()
     */
    @Override
    protected void setUp() throws Exception {
	WelcomeToPizzaHaven.buildModel();
    }
    
    @Test
    public void testPrice() throws InvalidPizzaOrderStringException{
	String inputStr = "Large|Pan|Margarita|Capsicum,Onion,Jalapeno|Mozzarella";
	Order order = OrderBuilder.inputOrderString(inputStr);
	orderTaker.addOrder(order);
	
	inputStr = "Small|Normal|Margarita|Paneer,Onion,Jalapeno|Mozzarella,Double";
	Order order2 = OrderBuilder.inputOrderString(inputStr);
	orderTaker.addOrder(order2);
	
	orderTaker.calculateAllOrder();
	assertEquals((285.0+165.0),orderTaker.getTotalCost());
	
	System.out.println(orderTaker.generateBill());
    }
    
//    @Test
//    public void testPrice1() throws InvalidPizzaOrderStringException{
//	String inputStr = "Small|Normal|Margarita|Paneer,Onion,Jalapeno|Mozzarella,Double";
//	order = OrderBuilder.inputOrderString(inputStr);
//	calculator = new OrderCalculator(order);
//	assertEquals(165.0,calculator.calculate().getCost());
//    }
}
