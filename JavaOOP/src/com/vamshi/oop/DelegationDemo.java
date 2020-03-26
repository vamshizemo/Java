package com.vamshi.oop;

public class DelegationDemo {
    public static void main(String[] args) {
        AgentTicketBooking agent = new AgentTicketBooking(new FlightBooking());
        agent.ticketBooking();
    }
}
