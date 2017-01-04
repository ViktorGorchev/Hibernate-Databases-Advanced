import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _7_PrintAllMinionNames {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {

        List<String> minions = getAllMinions();
        System.out.println(minions);

        for (int i = 0; i < minions.size() / 2; i++) {
            String first_minion = minions.get(i);
            String last_minions = minions.get((minions.size() - 1) - i);

            System.out.println(first_minion);
            System.out.println(last_minions);
        }

        if(minions.size() % 2 != 0){
            System.out.println(minions.get(minions.size() / 2));
        }
    }

    private static List<String> getAllMinions() {
        List<String> minions = new ArrayList<>();

        String query_select_minions = "SELECT m.name FROM minions_db.minions AS m ORDER BY m.id";
        try(Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query_select_minions)){
            while (resultSet.next()){
                String minion = resultSet.getString("name");
                minions.add(minion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Collections.unmodifiableList(minions);
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
