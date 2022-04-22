package com.bridgelabz;

import java.util.Objects;

public class InvoiceSummary {
    private final double totalFare;
    private final int numOfRides;
    private final double averageFare;

    public InvoiceSummary(double totalFare, int numOfRides) {
        this.totalFare = totalFare;
        this.numOfRides = numOfRides;
        this.averageFare = this.totalFare;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return Double.compare(that.totalFare, totalFare) == 0 && numOfRides == that.numOfRides && Double.compare(that.averageFare, averageFare) == 0;
    }
}
