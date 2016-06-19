package com.pizzahaven.items;

/**
 * @author SumeetS
 *
 */
public enum PizzaSize {
    SMALL{

	@Override
	public void addBase(Cost cost) {
	}
	
	@Override
	public void addTopping(Cost cost){
	    cost.setCost(cost.getCost()+10);
	}

	@Override
	public void addCheese(Cost cost) {
	    cost.setCost(cost.getCost()+30);
	}

	@Override
	public void doubleCheese(Cost cost) {
	    cost.setCost(cost.getCost()+30);
	}
	
    },MEDIUM{

	@Override
	public void addBase(Cost cost) {
	    cost.setCost(cost.getCost()*1.2);
	}
	
	@Override
	public void addTopping(Cost cost){
	    cost.setCost(cost.getCost()+15);
	}

	@Override
	public void addCheese(Cost cost) {
	    cost.setCost(cost.getCost()+60);
	}

	@Override
	public void doubleCheese(Cost cost) {
	    cost.setCost(cost.getCost()+40);
	}
	
    },LARGE{
	@Override
	public void addBase(Cost cost) {
	    cost.setCost(cost.getCost()*1.3);
	}
	
	@Override
	public void addTopping(Cost cost){
	    cost.setCost(cost.getCost()+25);
	}

	@Override
	public void addCheese(Cost cost) {
	    cost.setCost(cost.getCost()+80);
	}

	@Override
	public void doubleCheese(Cost cost) {
	    cost.setCost(cost.getCost()+60);
	}
    };
    
    public abstract void addBase(Cost cost); 
    public abstract void addTopping(Cost cost);
    public abstract void addCheese(Cost cost);
    public abstract void doubleCheese(Cost cost);
}
