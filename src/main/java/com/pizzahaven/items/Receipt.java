package com.pizzahaven.items;

import java.util.Map;

import com.pizzahaven.helper.OrderTaker;

/**
 * @author SumeetS
 *
 */
public class Receipt {
    private static final double SERVICE_TAX = 0.05;
    private static final double VAT = 0.06;
    private String orderId;
    
    public Receipt(String orderId){
	this.orderId = orderId;
    }
    
    public String generateReceipt(OrderTaker orderTaker){
	Map<Order,Cost> orderCostMap = orderTaker.getCostMap();
	StringBuilder b = new StringBuilder();
	b.append("Order ").append(orderId).append("\n");
	for(Order order: orderCostMap.keySet()){
	    b.append(order.getInputString()).append(" ").append(orderCostMap.get(order).getCost());
	    b.append("\n");
	}
	
	int totalCost =(int)orderTaker.getTotalCost();
	b.append("Order Total").append("\n").append(totalCost).append("\n");
	
	int st = (int) (totalCost * SERVICE_TAX);
	b.append("Service Tax("+SERVICE_TAX*100+"%)").append("\n").append(st+"").append("\n");
	int vt =(int) (totalCost * VAT);
	b.append("VAT("+VAT*100+"%)").append("\n").append(vt).append("\n");
	b.append("Total").append("\n");
	b.append((totalCost+st+vt));
	return b.toString();
    }
}
