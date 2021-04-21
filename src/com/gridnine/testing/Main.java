package com.gridnine.testing;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        FilterFlights filterFlights_1 = new FilterFlights(flights);
        FilterFlights filterFlights_2 = new FilterFlights(flights);
        FilterFlights filterFlights_3 = new FilterFlights(flights);
        List<Flight> after_1 = filterFlights_1.filter_1().build();
        List<Flight> after_2 = filterFlights_2.filter_2().build();
        List<Flight> after_3 = filterFlights_3.filter_3().build();
        System.out.println(flights);
        System.out.println(after_1);
        System.out.println(after_2);
        System.out.println(after_3);
    }
}