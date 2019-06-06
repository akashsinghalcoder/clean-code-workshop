package com.movierental;

import java.util.ArrayList;
import java.util.List;

public class Customer {
  private String name;
  private List<Rental> rentals = new ArrayList<>();

  public Customer(String name) {
    this.name = name;
  }

  public void addRental(Rental arg) {
    rentals.add(arg);
  }

  public String getName() {
    return name;
  }
  
 public int calculateTotalFrequentRenterPoints() {
	  int frequentRenterPoints = 0;
	  for (Rental each : rentals) {
	    	frequentRenterPoints += each.calculateFrequentRenterPoints();
	  }
	  return frequentRenterPoints;
	  
	 
 }
  

  public String statement() {
    String result = "Rental Record for " + getName() + "\n";
    double totalAmount = 0;
	for (Rental each : rentals) {
	    double thisAmount = calculateAmountForEachRental(each);	     
	    result += "\t" + each.getMovie().getTitle() + "\t" +
	    String.valueOf(thisAmount) + "\n";
	    totalAmount += thisAmount;
	}
	int frequentRenterPoints = calculateTotalFrequentRenterPoints() ;
    result += "Amount owed is " + String.valueOf(totalAmount) + "\n";
    result += "You earned " + String.valueOf(frequentRenterPoints)
        + " frequent renter points";
    return result;
  }
  
  private double calculateAmountForEachRental(Rental rental) {
	  return rental.calculateAmount();
	  
  }
  
  
  
}

