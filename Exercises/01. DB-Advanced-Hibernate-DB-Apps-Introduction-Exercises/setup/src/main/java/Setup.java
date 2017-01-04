import java.sql.*;
import java.util.Scanner;

public class Setup {
    //private static final String URL = "jdbc:mysql://localhost:3306/ams";
    private static final String URL = "jdbc:mysql://localhost:3306/ams?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {

        Scanner reader = new Scanner(System.in);

        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();){
            String query_update = "UPDATE airlines\n" +
                                "    SET rating = 9\n" +
                                "WHERE airline_name = \"Bad Airlines\"";

            statement.executeUpdate(query_update);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query = "SELECT * FROM airlines AS a";

        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query)){

            while (resultSet.next()){
                int rating = resultSet.getInt("rating");
                String name = resultSet.getString("airline_name");
                System.out.print(name + " --> " + rating +"\n");
            }

            String query_update = "UPDATE airlines\n" +
                    "    SET rating = 9\n" +
                    "WHERE airline_name = \"Bad Airlines\"";

            statement.executeUpdate(query_update);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}