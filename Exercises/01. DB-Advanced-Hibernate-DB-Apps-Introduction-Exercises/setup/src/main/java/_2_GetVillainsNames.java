import java.sql.*;

public class _2_GetVillainsNames {

    private static final String URL = "jdbc:mysql://localhost:3306/minions_db?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {

        String query_select = "SELECT\n" +
                "v.name,\n" +
                "COUNT(m.id) AS minions_count\n" +
                "FROM villains as v\n" +
                "LEFT JOIN minions AS m\n" +
                "  ON v.id = m.villan_id\n" +
                "GROUP BY v.id\n" +
                "HAVING COUNT(m.id) > 3\n" +
                "ORDER BY minions_count DESC ";

        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query_select)){

            while (resultSet.next()){
                String villain = resultSet.getString("name");
                int minions_count = resultSet.getInt("minions_count");
                System.out.println(villain + " " + minions_count);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
