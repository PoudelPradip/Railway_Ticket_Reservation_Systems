package RailwayReservation.Basic;

public class NonAc implements TicketingSystem{
    private final float NonAcPrice = 60.0f;// ticket price assigned

    @Override
    public void ticketCharge(RailwayTicket railwayTicket) {//RailwayTicket reference needed to set price and get price

        //railwayTicket.setAmountPaid(60); //another way to set price.

        railwayTicket.setAmountPaid(NonAcPrice);//to set ticket price
        System.out.println("Name :"+ railwayTicket.getPassengerName());//to display on console
        System.out.println("Ticket charge: " + railwayTicket.getAmountPaid());//to display on console


    }
}