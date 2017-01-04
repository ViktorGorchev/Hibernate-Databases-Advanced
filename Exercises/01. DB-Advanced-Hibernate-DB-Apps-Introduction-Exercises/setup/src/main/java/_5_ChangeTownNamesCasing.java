import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class _5_ChangeTownNamesCasing {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String country_input = reader.nextLine().trim();

        List<String> towns = getTowns(country_input);
        if(towns.size() > 0){
            changeTownsToUpper(towns);
            System.out.printf("%d town names were affected.%n", towns.size());

            List<String> townsToUpper = getTowns(country_input);
            System.out.println(townsToUpper);

        }else {
            System.out.println("No town names were affected.");
        }
    }

    private static void changeTownsToUpper(List<String> towns) {
        for (String town : towns) {
            String query_select_towns = "UPDATE minions_db.towns SET name = UPPER (name) WHERE name = \"" + town + "\"";

            try(Statement statement = getConnection().createStatement()){
                statement.executeUpdate(query_select_towns);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static List<String> getTowns(String country_input) {
        List<String> towns = new ArrayList<>();

        String query_select_towns =
                "SELECT t.name FROM minions_db.towns AS t WHERE t.country = " + "\"" + country_input + "\"";

        try(Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query_select_towns)){

            while (resultSet.next()){
                String town = resultSet.getString("name");
                towns.add(town);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Collections.unmodifiableList(towns);
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}