package RailwayReservation.Basic;

public class RailwayTicket {
    private String passengerName;
    private int passengerAge;
    private String choosenSeat;
    private String typeOfReservasion;
    private float amountPaid;
    private boolean isSeniorCitizen;

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public int getPassengerAge() {
        return passengerAge;
    }

    public void setPassengerAge(int passengerAge) {
        this.passengerAge = passengerAge;
    }

    public String getChoosenSeat() {
        return choosenSeat;
    }

    public void setChoosenSeat(String choosenSeat) {
        this.choosenSeat = choosenSeat;
    }

    public String getTypeOfReservasion() {
        return typeOfReservasion;
    }

    public void setTypeOfReservasion(String typeOfReservasion) {
        this.typeOfReservasion = typeOfReservasion;
    }

    public float getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(float amountPaid) {
        this.amountPaid = amountPaid;
    }

    public boolean isSeniorCitizen() {
        return isSeniorCitizen;
    }

    public void setSeniorCitizen(boolean seniorCitizen) {
        isSeniorCitizen = seniorCitizen;
    }
}


