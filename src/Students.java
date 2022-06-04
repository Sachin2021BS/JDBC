import java.sql.*;

import static java.lang.Class.forName;

public class Students {
    public static void main(String[] args) throws ClassNotFoundException {

        try {
            //load the driver
            Class.forName("com.mysql.jdbc.Driver");

            //create the connection
            String username = "root";
            String password = "Password@123";
            String url ="jdbc:mysql://localhost:3306/student_management?characterEncoding=latin1";
            String query ="SELECT * FROM students";
//            String query1 = "SELECT Student_ID FROM students where Student_age = 23";
            Connection connection = DriverManager.getConnection(url,username,password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()){
                System.out.println(resultSet.getString("Student_ID") +" "+ resultSet.getString("Student_Name")+" "
                + resultSet.getString("Student_age")+" "+ resultSet.getString("Student_city")+" "+ resultSet.getString("Gender"));
            }

            } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }
}
