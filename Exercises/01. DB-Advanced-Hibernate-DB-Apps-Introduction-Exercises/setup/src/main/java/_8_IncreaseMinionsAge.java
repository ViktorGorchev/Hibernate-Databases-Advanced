import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class _8_IncreaseMinionsAge {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) throws SQLException {
        Scanner reader = new Scanner(System.in);

        String[] input_data = reader.nextLine().split("[\\s+]");

        updateMinion(input_data);

        printMinions();
    }

    private static void printMinions() throws SQLException {
        String query_all_minions = "SELECT m.id, m.name, m.age FROM minions_db.minions AS m";
        try(Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query_all_minions)){

            while (resultSet.next()){
                int minion_id2 = resultSet.getInt("id");
                String minion_name2 = resultSet.getString("name");
                int minion_age2 = resultSet.getInt("age");

                System.out.println(minion_id2 + " " + minion_name2 + " " + minion_age2);
            }
        }
    }

    private static void updateMinion(String[] input_data) {
        StringBuilder ids = new StringBuilder();
        ids.append(Arrays.asList(input_data).toString());
        ids.deleteCharAt(0);
        ids.deleteCharAt(ids.length() - 1);

        String query_update_minions = "UPDATE minions_db.minions " +
                "SET" +
                "  age = age + 1," +
                "  name = CONCAT(UPPER(LEFT(name, 1)), LOWER(SUBSTRING(name FROM 2)))" +
                " WHERE id IN (" + ids.toString() + ")";

        try (Statement statement = getConnection().createStatement()){
            statement.executeUpdate(query_update_minions);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
