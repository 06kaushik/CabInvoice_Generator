package com.cabservice;


public class InvoiceSummary {
	
	private final int numofRides;
	private final double totalFare;
	private final double averageFare;
	
    public InvoiceSummary(int numofRides,double totalFare,double averageFare ) {
    	this.numofRides=numofRides;
    	this.totalFare = totalFare;
    	this.averageFare= averageFare;
    }
    
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		InvoiceSummary other = (InvoiceSummary) obj;
		if (Double.doubleToLongBits(averageFare) != Double.doubleToLongBits(other.averageFare))
			return false;
		if (numofRides != other.numofRides)
			return false;
		if (Double.doubleToLongBits(totalFare) != Double.doubleToLongBits(other.totalFare))
			return false;
		return true;
	}
    
    
}