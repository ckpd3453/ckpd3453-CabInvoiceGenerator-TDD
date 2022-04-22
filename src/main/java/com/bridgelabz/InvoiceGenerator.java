package com.bridgelabz;

public class InvoiceGenerator {

    /*
    Constants
     */
    private static final int COST_PER_MIN = 1;
    private static final double COST_PER_KM = 10;
    private static final double MIN_FARE = 5;

    /*
    Method To get Actual Fare
     */
    public double calculateFare(double distance, int time) {
        double fare = (distance * COST_PER_KM) + (time * COST_PER_MIN);
        if (fare < MIN_FARE)
            return MIN_FARE;
        return fare;
    }

    /*
    Method to get Multiple ride total fare
     */
    public InvoiceSummary calculateFare(Ride[] rides) {
        double totalFare = 0;
        for (Ride ride:rides){
            totalFare += this.calculateFare(ride.distance, ride.time);
        }
        return new InvoiceSummary(totalFare,rides.length);
    }

}
