package com.vamshi.oop;

public interface TravelBooking {
    public void ticketBooking();
}
class AgentTicketBooking implements TravelBooking{
    TravelBooking t;
    public AgentTicketBooking(TravelBooking t){
        this.t=t;
    }

    @Override
    public void ticketBooking() {
        t.ticketBooking();
    }
}
class TrainBooking implements TravelBooking{

    @Override
    public void ticketBooking() {
        System.out.println("Train Ticket booked");

    }
}

class FlightBooking implements TravelBooking{

    @Override
    public void ticketBooking() {
        System.out.println("FLight tickets booked");
    }
}
