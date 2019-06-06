package com.movierental;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class CustomerTest {
	
	
    @Test
    public void testStatementForRentalsOfLengthZero(){
    	Customer customer = new Customer("Akash");
    	String statement = customer.statement();
    	String name = customer.getName();
    	String expected ="Rental Record for " + name + "\n" + "Amount owed is " + "0.0" + "\n"+ "You earned " + String.valueOf(0)
        + " frequent renter points";
    
    	assertEquals("It should be zero",expected ,statement);
    }
    
    @Test
    public void testStatementForRentalsContainingRegularMovieForLessThanOrEqualTo2days() {
    	Customer customer = new Customer("Akash");
    	customer.addRental(new Rental(new Movie("xyz", Movie.REGULAR),2));
    	String statement = customer.statement();
    	String name = customer.getName();
    	String expected ="Rental Record for " + name + "\n" + "\t" + "xyz" + "\t" +
    	         "2.0" + "\n"+ "Amount owed is " + "2.0" + "\n"+ "You earned " + String.valueOf(1)
        + " frequent renter points";
    

    	assertEquals("",expected ,statement);	
    }
    
    @Test
    public void testStatementForRentalsContainingRegularMovieForMoreThan2days() {
    	Customer customer = new Customer("Akash");
    	customer.addRental(new Rental(new Movie("xyz", Movie.REGULAR),3));
    	String statement = customer.statement();
    	String name = customer.getName();
    	String expected ="Rental Record for " + name + "\n" + "\t" + "xyz" + "\t" +
    	         "3.5" + "\n"+ "Amount owed is " + "3.5" + "\n"+ "You earned " + String.valueOf(1)
        + " frequent renter points";
    	

    	assertEquals("",expected ,statement);	
    }
    
    @Test
    public void testStatementForRentalsContainingNewReleaseMovieForMoreThan1days() {
    	Customer customer = new Customer("Akash");
    	customer.addRental(new Rental(new Movie("xyz", Movie.NEW_RELEASE),3));
    	String statement = customer.statement();
    	String name = customer.getName();
    	String expected ="Rental Record for " + name + "\n" + "\t" + "xyz" + "\t" +
    	         "9.0" + "\n"+ "Amount owed is " + "9.0" + "\n"+ "You earned " + String.valueOf(2)
        + " frequent renter points";


    	assertEquals("",expected ,statement);	
    }
    
    
    @Test
    public void testStatementForRentalsContainingChildrenMovieForLessThanOrEqualTo3days() {
    	Customer customer = new Customer("Akash");
    	customer.addRental(new Rental(new Movie("xyz", Movie.CHILDRENS),3));
    	String statement = customer.statement();
    	String name = customer.getName();
    	String expected ="Rental Record for " + name + "\n" + "\t" + "xyz" + "\t" +
    	         "1.5" + "\n"+ "Amount owed is " + "1.5" + "\n"+ "You earned " + String.valueOf(1)
        + " frequent renter points";
    

    	assertEquals("",expected ,statement);	
    }
    
    @Test
    public void testStatementForRentalsContainingChildrenMovieForMoreThan3days() {
    	Customer customer = new Customer("Akash");
    	customer.addRental(new Rental(new Movie("xyz", Movie.CHILDRENS),5));
    	String statement = customer.statement();
    	String name = customer.getName();
    	String expected ="Rental Record for " + name + "\n" + "\t" + "xyz" + "\t" +
    	         "4.5" + "\n"+ "Amount owed is " + "4.5" + "\n"+ "You earned " + String.valueOf(1)
        + " frequent renter points";
    	

    	assertEquals("",expected ,statement);	
    }
    
    

}