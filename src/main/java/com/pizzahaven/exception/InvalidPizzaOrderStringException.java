package com.pizzahaven.exception;

/**
 * @author SumeetS
 *
 */
public class InvalidPizzaOrderStringException extends Exception{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    public InvalidPizzaOrderStringException(String msg){
	super(msg);
    }

}
