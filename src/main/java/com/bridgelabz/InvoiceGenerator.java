package com.bridgelabz;

public class InvoiceGenerator {

    /*
    Constants
     */
    private static final int COST_PER_MIN = 1;
    private static final double COST_PER_KM = 10;

    /*
    Method To get Actual Fare
     */
    public double calculateFare(double distance, int time) {
        return (distance * COST_PER_KM) + (time * COST_PER_MIN);
    }
}
