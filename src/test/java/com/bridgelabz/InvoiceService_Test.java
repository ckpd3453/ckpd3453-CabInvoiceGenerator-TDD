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
    Test Case -3 (Given Multiple Rides Should Return Total Fare)
     */
    @Test
    public void givenMultipleRides_ShouldReturnTotalFare() {
        Ride[] rides = {new Ride(2, 5),
                new Ride(0.1, 1)
        };
        fare = invoiceGenerator.calculateFare(rides);
        assertEquals(30,fare);
    }
}
