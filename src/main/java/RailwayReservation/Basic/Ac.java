package RailwayReservation.Basic;

public class Ac implements TicketingSystem{

    private final float acPrice = 100.0f;


    @Override
    public void ticketCharge(RailwayTicket railwayTicket) {
        railwayTicket.setAmountPaid(acPrice);

        System.out.println("Name :"+ railwayTicket.getPassengerName());
        System.out.println("Ticket charge: " + railwayTicket.getAmountPaid());

    }
}