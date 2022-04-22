package com.bridgelabz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvoiceService_Test {

    public static InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
    public static double fare;
    /*
    Test Case - 1 (Given Distance And Time Should Return Actual Fare)
     */
    @Test
    public void givenDistanceAndTime_ShouldReturnActualFare() {

        double distance = 2;
        int time = 5;
        fare = invoiceGenerator.calculateFare(distance, time);
        assertEquals(25, fare);
    }

    /*
    Test Case - 2 (Given MIN Distance And MIN Time Should Return MINIMAL Fare)
     */
    @Test
    public void givenDistanceAndTime_ShouldReturnMinFare() {
        double distance = 0.1;
        int time = 1;
        fare = invoiceGenerator.calculateFare(distance, time);
        assertEquals(5, fare);
    }

    /*
    Test Case -3 (Inhanced Invoice)
     */
    @Test
    public void givenMultipleRide_ShouldReturnInvoiceSummary(){
        Ride[] rides = {
                new Ride(2,5),
                new Ride(0.1,1)
        };
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(30.0,2);
        assertEquals(expectedInvoiceSummary,summary);
    }
}
