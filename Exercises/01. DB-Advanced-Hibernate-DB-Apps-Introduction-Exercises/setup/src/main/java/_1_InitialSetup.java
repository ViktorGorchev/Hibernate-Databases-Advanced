import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class _1_InitialSetup {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {

        String query_create_towns = "CREATE TABLE towns(" +
                "id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(50)," +
                "country VARCHAR(50));";

        String query_create_minions = "CREATE TABLE minions(" +
                "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255)," +
                "age INT, " +
                "town INT," +
                "CONSTRAINT fk_minions_towns FOREIGN KEY (town) REFERENCES towns(id));";

        String query_create_villains = "CREATE TABLE villains(" +
                                        "id INT AUTO_INCREMENT PRIMARY KEY," +
                                        "name VARCHAR(50)," +
                                        "evilness_factor ENUM(\"good\", \"bad\", \"evil\", \"super evil\"));";

        String query_insert_towns = "INSERT INTO towns (name, country) VALUES " +
                                    "(\"Sofia\", \"Bulgaria\")," +
                                    "(\"Paris\", \"France\")," +
                                    "(\"Berlin\", \"Germany\")," +
                                    "(\"Solson\", \"Greece\")," +
                                    "(\"Provadia\", \"Bulgaria\");";

        String query_insert_minions = "INSERT INTO minions (name, age, town) VALUES " +
                                    "(\"m1\", 1, 1)," +
                                    "(\"m2\", 2, 2)," +
                                    "(\"m3\", 3, 3)," +
                                    "(\"m4\", 4, 4)," +
                                    "(\"m5\", 5, 5);";

        String query_insert_villains = "INSERT INTO villains (name, evilness_factor) VALUES" +
                                        " (\"v1\", \"good\")," +
                                        "(\"v2\", \"bad\")," +
                                        "(\"v3\", \"evil\")," +
                                        "(\"v4\", \"super evil\")," +
                                        "(\"v5\", \"evil\")";

        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();){

            statement.execute(query_create_towns);
            statement.execute(query_create_minions);
            statement.execute(query_create_villains);

            statement.execute(query_insert_towns);
            statement.execute(query_insert_minions);
            statement.execute(query_insert_villains);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
