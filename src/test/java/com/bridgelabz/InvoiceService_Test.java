package com.bridgelabz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class InvoiceService_Test {

    public static InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

    /*
    Test Case - 1 (Given Distance And Time Should Return Actual Fare)
     */
    @Test
    public void givenDistanceAndTime_ShouldReturnActualFare() {

        double distance = 2;
        int time = 5;
        double fare = invoiceGenerator.calculateFare(distance, time);
        assertEquals(25, fare);
    }
}
