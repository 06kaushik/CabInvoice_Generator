package com.cabservice;

import java.util.ArrayList;
import java.util.List;

public class InvoiceGenerator {

	private static final int costPerMinute =1;
	private static final double minCostPerKm =10;
	private static final double minfare = 5;
	
	public double calculateFare(double distance, int minute) {
		double totalfare = (distance * minCostPerKm) + (minute * costPerMinute);
		
		if(distance < 1.0 && minute <= 5) {
			return totalfare;
		}else if(distance < 0.5 && minute <= 2) {
			return minfare;
		}
		return totalfare;
	}
	
	public double calculateFare(String choice, double distance, int minute) {
		if(choice.equalsIgnoreCase("Normal")) {
			int costPerMinute =1;
			double minCostPerKm =10;
			double minfare = 5;
			double totalfare = (distance * minCostPerKm) + (minute * costPerMinute);
			return totalfare;
		}else if(choice.equalsIgnoreCase("Premium")) {
			int costPerMinute =2;
			double minCostPerKm =15;
			double minfare = 20;
			double totalfare = (distance * minCostPerKm) + (minute * costPerMinute);
			return totalfare;
		}
		double totalfare = (distance * minCostPerKm) + (minute * costPerMinute);
		return totalfare;
	}

	public double calculateFare(Ride[] ride) {
		double totalfare = 0;
		for(Ride rides: ride) {
			totalfare += this.calculateFare(rides.distance, rides.minute);	
		}
		return totalfare;
	}
	
	public InvoiceSummary calculateTotalFare(Ride[] ride) {
		double totalfare = 0;
		double averageFare = 0;
		for(Ride rides: ride) {
			totalfare += this.calculateFare(rides.distance, rides.minute);	
		}
		 averageFare = totalfare/ride.length;
		return new InvoiceSummary(ride.length, totalfare, averageFare);
	}
	
	
}