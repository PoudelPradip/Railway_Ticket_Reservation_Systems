package RailwayReservation.Database;
import RailwayReservation.Basic.RailwayTicket;

import java.sql.*;
public class DatabaseConnection {

    public void databaseConnection(RailwayTicket railwayTicket) {
        String url = "jdbc:mysql://localhost:3306/railwaysystem";//url and schema name
        String userName = "root";//Database login username
        String passWord = "Java@2022";//Database login password
        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //Driver Name
            connection = DriverManager.getConnection(url, userName, passWord); //connection details
            System.out.println("Connection Established with Database Successful!!!");

            statement = connection.createStatement();//connection

            //to check if DB table exists;
            /*String checkDbTableExists = "select count(*) from Railway_Reservation.tables where table_name = ?";
            preparedStatement = connection.prepareStatement(checkDbTableExists);
            preparedStatement.setString(1, "");
            boolean ifTableExists = false;
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                if (resultSet.getInt(1) != 0) {
                    ifTableExists =true;
                }
            }
            System.out.println("If Table exists ::"+ ifTableExists);

            if (!ifTableExists) {

                //table creation in database
                String createQuery = "create table Railway_Reservation (passenger_name varchar(50), passenger_age int(20), chosen_seat varchar(50), reservation_type varchar(50), is_senior_citizen BIT (1), amount_paid decimal(20,2))";
                int numberOfRows = statement.executeUpdate(createQuery);
                System.out.println("Created  Number of Rows :: " + numberOfRows);
                System.out.println("table created");

}*/


            //insert statement

            String insertQuery = "insert into Railway_Reservation values(?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1,railwayTicket.getPassengerName());
            preparedStatement.setInt(2, railwayTicket.getPassengerAge());
            preparedStatement.setString(3,railwayTicket.getChoosenSeat());
            preparedStatement.setString(4, railwayTicket.getTypeOfReservasion());
            preparedStatement.setBoolean(5,railwayTicket.isSeniorCitizen());
            preparedStatement.setFloat(6, railwayTicket.getAmountPaid());
            int noOfInsertedRows = preparedStatement.executeUpdate();
            System.out.println("No of Inserted Rows : "+ noOfInsertedRows);


        } catch (Exception e) {
            System.err.println("Error Details ::" + e.getMessage());
            e.printStackTrace();

        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
                System.out.println("Connection successfully closed!!");
            } catch (SQLException e) {
                System.err.println("Error ::" + e.getMessage());
                e.printStackTrace();
            }


        }

    }

}
