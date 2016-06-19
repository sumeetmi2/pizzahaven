package com.pizzahaven.items;

/**
 * @author SumeetS
 *
 */
public class Order {
    private String size;
    private String base;
    private String sauce;
    private String topping;
    private String cheese;
    private boolean doubleCheese;
    private int id;
    private String inputString;
    
    public int getId(){
	return id;
    }
    
    
    public String getInputString(){
	return inputString;
    }
    
    public boolean getDoubleCheese(){
	return doubleCheese;
    }
    
    /**
     * @return the size
     */
    public String getSize() {
        return size;
    }

    /**
     * @return the base
     */
    public String getBase() {
        return base;
    }

    /**
     * @return the sauce
     */
    public String getSauce() {
        return sauce;
    }

    /**
     * @return the topping
     */
    public String getTopping() {
        return topping;
    }

    /**
     * @return the cheese
     */
    public String getCheese() {
        return cheese;
    }

    public static class Builder{
	private String size;
	private String base;
	private String sauce;
	private String topping;
	private String cheese;
	private boolean doubleCheese;
	private int id;
	private String inputString;
    
	public Builder id(int id){this.id=id;return this;}
	public Builder inputString(String inpt){this.inputString=inpt;return this;}
	public Builder size(String size){this.size=size;return this;}
	public Builder base(String base){this.base=base;return this;}
	public Builder sauce(String sauce){this.sauce=sauce;return this;}
	public Builder topping(String topping){this.topping=topping;return this;}
	public Builder cheese(String cheese){this.cheese=cheese;return this;}
	public Builder doubleCheese(boolean dbleCheese){this.doubleCheese = dbleCheese;return this;}
	
	public Order build(){
	    return new Order(this);
	}
    }
    
    private Order(Builder builder){
	this.size= builder.size;
	this.base=builder.base;
	this.sauce=builder.sauce;
	this.topping=builder.topping;
	this.cheese= builder.cheese;
	this.doubleCheese = builder.doubleCheese;
	this.id=builder.id;
	this.inputString=builder.inputString;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return id;
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Order){
            Order t = (Order) obj;
            return t.id == this.id;
        }
	return false;
    }
}
