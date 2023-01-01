package RailwayReservation.Basic;

import RailwayReservation.Database.DatabaseConnection;

import java.util.Scanner;

public class RailwayTicketMain {
    /*
Write a program on Railway ticket reservation systems,

[Hints: consider a class RailwayReservastion, take attributes as ‘passengerName’, ‘passengerAge’, ‘choosenSeat’, ‘typeOfReservasion’ (AC / Non-AC), ‘amountPaid’, ‘isSeniorCitizen’.
             Take input of passengerName, age, seat, and type, while taking input do proper validation like age provided as integer not any other format like float or String and if age > 60 then
             consider passenger as senior citizen and populate ‘isSeniorCitizen’ as true assign the lower berth/seat. And after taking all the input need to calculate the amount to be paid for booking,
             if ‘AC’ is the type of reservation then rate will be $100 and if non-AC the rate will be $60.

1.	Create one table using jdbc named: ‘railway_reservastion’ with column name as ‘passenger_name’, ‘paggenger_age’, ‘choosen_seat’, ‘reservation_type’, ‘is_senior_citizen’, ‘amount_paid’.
2.	Once take input of passengerName, passengerAge, choosenSeat and typeOfReservation, then please insert those records to database.
3.	Once calculated weather the passenger is senior citizen or not then update the same under column name ‘is_senior_citizen’ in the already inserted row (in point 2) with 0 / 1 value (while true value to be saved 1 and 0 while value will be false)
4.	Once amount been calculated then same would be updated under ‘amount_paid’ column for the inserted row (in point 2).
** Make sure you follow the steps mentioned above while inserting and updating the row.

    * */

        public static void main(String[] args) {

            boolean seniorCheck = false;

            RailwayTicket railwayTicket = new RailwayTicket();

            Scanner scan = new Scanner(System.in);

            System.out.println("Enter passengerName");
            String name = scan.next();
            railwayTicket.setPassengerName(name);

            System.out.println("Enter passengerAge");
            int age = scan.nextInt();
            railwayTicket.setPassengerAge(age);

            System.out.println("Enter passengerSeat");
            String seat = scan.next();
            railwayTicket.setChoosenSeat(seat);

            System.out.println("Enter Reservation Type");
            String ResType = scan.next();
            railwayTicket.setTypeOfReservasion(ResType);


            if (("ac").equalsIgnoreCase(railwayTicket.getTypeOfReservasion())) {
                Ac ac = new Ac();
                ac.ticketCharge(railwayTicket);
                if (age > 60) {
                    seniorCheck = true;
                    railwayTicket.setSeniorCitizen(seniorCheck);

                }

            } else if (("NonAc").equalsIgnoreCase(railwayTicket.getTypeOfReservasion())) {
                NonAc nonAc = new NonAc();
                nonAc.ticketCharge(railwayTicket);
                if (age > 60) {
                    seniorCheck = true;
                    railwayTicket.setSeniorCitizen(seniorCheck);
                }
            } else {
                System.out.println("Invalid reservation Type");
            }


            DatabaseConnection databaseStorage = new DatabaseConnection();
            databaseStorage.databaseConnection(railwayTicket);

        }
    }

