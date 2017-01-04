import java.sql.*;
import java.util.Scanner;

public class _4_AddMinion {
    private static final String URL = "jdbc:mysql://localhost:3306/minions_db?useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    private static final String COUNTRY = "England";
    private static final String EVILNESS_FACTOR = "evil";

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        String[] minion_data = reader.nextLine().split("[\\s+]");
        String town = minion_data[3].trim();
        int age = Integer.parseInt(minion_data[2].trim());
        String minion_name = minion_data[1].trim();

        String[] villain_data = reader.nextLine().split("[\\s+]");
        String villain_name = villain_data[1].trim();

        boolean town_exists = checkIfTownInDatabase(town);
        boolean villain_exists = checkIfVillainInDatabase(villain_name);

        if(! town_exists){
            addTown(town);
            System.out.printf("Town %s was added to the database.%n", town);
        }

        if(! villain_exists){
            addVillain(villain_name);
            System.out.printf("Villain %s was added to the database.%n", villain_name);
        }

        addMinion(minion_name, age, getTownId(town), getVillainId(villain_name));
        System.out.printf("Successfully added %s to be minion of %s.%n", minion_name, villain_name);
    }

    private static void addMinion(String minion_name, int age, int town_id, int villainId) {
        String query_insert_minion = "INSERT INTO minions_db.minions (name, age, town, villan_id) VALUES " +
        "(" + "\"" + minion_name + "\", " + "\"" + age + "\", " + "\"" + town_id + "\", " + "\"" + villainId + "\"" + ")";

        try (Statement statement = getConnection().createStatement()){
            statement.execute(query_insert_minion);

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private static int getVillainId(String villain) {
        int villain_id = 0;

        if(! checkIfVillainInDatabase(villain)){
            return villain_id;
        }

        String query_select_villain_id =
                "SELECT v.id FROM minions_db.villains AS v WHERE v.name = " + "\"" + villain + "\"";

        try (Statement statement = getConnection().createStatement();
            ResultSet resultSet =  statement.executeQuery(query_select_villain_id)){

            while (resultSet.next()){
                villain_id = resultSet.getInt("id");
                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

            return villain_id;
    }


    private static int getTownId(String town) {
        int town_id = 0;

        if(! checkIfTownInDatabase(town)){
            return town_id;
        }

        String query_select_town_id =
                "SELECT t.id FROM minions_db.towns AS t WHERE t.name = " + "\"" + town + "\"";

        try (Statement statement = getConnection().createStatement();
             ResultSet resultSet =  statement.executeQuery(query_select_town_id)){

            while (resultSet.next()){
                town_id = resultSet.getInt("id");
                break;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return town_id;
    }

    private static void addVillain(String villain) {
        String query_insert_villain =
                "INSERT INTO minions_db.villains (name, evilness_factor) " +
                        "VALUES (" + "\"" + villain + "\"," + " \""+ EVILNESS_FACTOR + "\"" + ")";

        try (Statement statement = getConnection().createStatement();){
            statement.execute(query_insert_villain);

        } catch (SQLException e) {
            e.printStackTrace();        }

    }

    private static void addTown(String town) {
        String query_insert_town =
                "INSERT INTO minions_db.towns (name, country) " +
                        "VALUES (" + "\"" + town + "\"," + " \""+ COUNTRY + "\"" + ")";

        try (Statement statement = getConnection().createStatement();){
            statement.execute(query_insert_town);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static boolean checkIfVillainInDatabase(String villain) {
        boolean villain_in_database = false;

        String query_select_villain = "SELECT * FROM minions_db.villains AS v WHERE v.name = \"" + villain + "\"";

        try(Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query_select_villain)) {

            if(resultSet.next()){
                villain_in_database = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return villain_in_database;
    }

    private static boolean checkIfTownInDatabase(String town_name) {
        boolean town_in_database = false;

        String query_select_town = "SELECT * FROM minions_db.towns AS t WHERE t.name = \"" + town_name + "\"";

        try(Statement statement = getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query_select_town)) {

            if(resultSet.next()){
                town_in_database = true;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return town_in_database;
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
