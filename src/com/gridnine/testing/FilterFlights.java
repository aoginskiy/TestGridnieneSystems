package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class FilterFlights {
    List<Flight> flights ;

    public FilterFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public List<Flight>  build(){
        return flights;
    }

    public FilterFlights filter_1() {
        List<Flight> flight = new ArrayList<>();

        for (Flight flight1 : flights) {
            if(LocalDateTime.now().isBefore(flight1.getSegments().get(0).getDepartureDate())){
                flight.add(flight1);
            }
        }

        flights = flight;
        return this;
    }

    public FilterFlights filter_2() {
        List<Flight> flight = new ArrayList<>();
        m1:
        for (Flight flight1 : flights) {
            for (Segment segment : flight1.getSegments()) {
                if(segment.getDepartureDate().isAfter(segment.getArrivalDate())){
                    continue m1;
                }
            }
            flight.add(flight1);
        }

        flights = flight;
        return this;
    }

    public FilterFlights filter_3(){
        List<Flight> flight = new ArrayList<>();
        m1:
        for(Flight flight1 : flights){
            for(int i = 1; i < flight1.getSegments().size();i++){
                LocalDateTime prevArrival = flight1.getSegments().get(i-1).getArrivalDate().plusHours(2);
                LocalDateTime nextDepart = flight1.getSegments().get(i).getDepartureDate();
                if(!prevArrival.isAfter(nextDepart)){
                    continue m1;
                }
            }
            flight.add(flight1);
        }
        flights = flight;
        return this;
    }
}