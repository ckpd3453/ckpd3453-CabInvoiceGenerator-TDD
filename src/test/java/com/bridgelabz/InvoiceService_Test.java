package com.bridgelabz;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

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
    public void givenMultipleRide_ShouldReturnInvoiceSummary() {
        Ride[] rides = {
                new Ride(CategoryRide.REGULAR, 2, 5),
                new Ride(CategoryRide.REGULAR, 0.1, 1)
        };
        InvoiceSummary summary = invoiceGenerator.calculateFare(rides);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(30.0, 2);
        assertEquals(expectedInvoiceSummary, summary);
    }

    /*
    Test Case - 4 (Given UserID And Rides should return invoice generator)
     */
    @Test
    public void givenUserIDAndRides_ShouldReturnInvoiceSummary() {
        Map<String, Ride[]> rideBook = new HashMap<>();
        Ride[] rides = {
                new Ride(CategoryRide.REGULAR, 2.0, 5),
                new Ride(CategoryRide.REGULAR, 0.1, 1)
        };
        Ride[] rides1 = {
                new Ride(CategoryRide.REGULAR, 3.0, 5),
                new Ride(CategoryRide.REGULAR, 0.1, 1)
        };
        rideBook.put("ckpd3453", rides);
        rideBook.put("srk123", rides1);
        String userID = "ckpd3453";
        InvoiceSummary summary = invoiceGenerator.calculateFare(userID, rideBook);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(30.0, 2);
        assertEquals(expectedInvoiceSummary, summary);
    }

    /*
    Test Case - 5 (Given UserId And Rides of different categories of ride Should return invoice generator)
     */
    @Test
    public void givenNormalAndPremiumRideRate_ShouldReturnTotalFare() {
        Map<String, Ride[]> rideBook = new HashMap<>();
        Ride[] rides = {
                new Ride(CategoryRide.PREMIUM, 2.0, 5),
                new Ride(CategoryRide.REGULAR, 0.1, 1)
        };
        Ride[] rides1 = {
                new Ride(CategoryRide.PREMIUM, 3.0, 5),
                new Ride(CategoryRide.REGULAR, 0.1, 1)
        };
        rideBook.put("ckpd3453", rides);
        rideBook.put("patel123", rides1);
        String userID = "patel123";
        InvoiceSummary summary = invoiceGenerator.calculateFare(userID, rideBook);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(60.0, 2);
        assertEquals(expectedInvoiceSummary, summary);
    }
}
