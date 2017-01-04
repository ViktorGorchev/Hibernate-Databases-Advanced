import java.sql.*;
import java.util.Scanner;

public class _9_IncreaseAgeStoredProcedure {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int minionId = Integer.parseInt(reader.nextLine().trim());

        updateMinionAge(minionId);
        printMinion(minionId);
    }

    private static void printMinion(int minionId) {
        String query_select_minions =
                "SELECT m.name, m.age FROM minions_db.minions AS m WHERE m.id = " + minionId;

        try (Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query_select_minions)){
            if(resultSet.next()){
                String minionName = resultSet.getString("name");
                int minionAge = resultSet.getInt("age");
                System.out.println(minionName + " " + minionAge);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateMinionAge(int minionId) {
        String queryUpdateMinion = "CALL usp_get_older(?)";

        try (CallableStatement callableStatement = getConnection().prepareCall(queryUpdateMinion)){
            callableStatement.setInt(1, minionId);
            callableStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static Connection getConnection() throws SQLException {
        final String url = "jdbc:mysql://localhost:3306/minions_db?useSSL=false";
        final String USER = "root";
        final String password = "1234";

        return DriverManager.getConnection(url, USER, password);
    }
}
