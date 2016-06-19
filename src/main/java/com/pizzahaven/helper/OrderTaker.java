package com.pizzahaven.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import com.pizzahaven.exception.InvalidPizzaOrderStringException;
import com.pizzahaven.items.Cost;
import com.pizzahaven.items.Order;
import com.pizzahaven.items.Receipt;

/**
 * @author SumeetS
 *
 */
public class OrderTaker {
    private static final AtomicInteger cntr = new AtomicInteger(0);
    
    private ArrayList<Order> order = new ArrayList<Order>();
    private Map<Order,Cost> cost = new HashMap<Order,Cost>();
    private Receipt receipt = new Receipt(cntr.incrementAndGet()+"");
    private String bill;
    
    public void addOrder(Order order){
	this.order.add(order);
    }
    
    public  Map<Order,Cost> getCostMap(){
	return cost;
    }
    
    /**
     * ::TODO can be converted to an executor service async job, so next order need not wait
     * 
     * @throws InvalidPizzaOrderStringException
     */
    public void calculateAllOrder() throws InvalidPizzaOrderStringException{
	for(Order order: this.order){
	    OrderCalculator calculator = new OrderCalculator(order);
	    this.cost.put(order, calculator.calculate());
	}
    }
    
    public String generateBill(){
	this.bill=receipt.generateReceipt(this);
	return bill;
    }
    
    public double getTotalCost(){
	int tmp=0;
	for(Cost cst: cost.values()){
	    tmp += cst.getCost();
	}
	return tmp;
    }
}
