import java.sql.*;
import java.util.Scanner;

public class _3_GetMinionNames {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String villain_input_id = reader.nextLine();

        String query_select_villain =
                "SELECT v.name FROM minions_db.villains AS v WHERE v.id = " + villain_input_id;

        boolean no_villain = true;
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query_select_villain);){


            while (resultSet.next()){
                String villain = resultSet.getString("name");
                System.out.println("Villain: " + villain);

                no_villain = false;
            }

            if(no_villain){
                System.out.printf("No villain with ID %s exists in the database.%n", villain_input_id);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        String query_select_minions =
                "SELECT m.name, m.age FROM minions_db.minions AS m WHERE m.villan_id = " + villain_input_id;

        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet2 = statement.executeQuery(query_select_minions)){

            int counter = 0;
            while (resultSet2.next()){
                counter++;

                String minion = resultSet2.getString("name");
                int age = resultSet2.getInt("age");
                System.out.println( counter + " " + minion + " " + age);
            }

            if(counter == 0 && no_villain == false){
                System.out.println("<no minions>");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
