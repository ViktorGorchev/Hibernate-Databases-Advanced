import java.sql.*;
import java.util.Scanner;

public class _6_RemoveVillain {

    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        String villainId = reader.nextLine().trim();
        String villainName = getVillainName(villainId);

        if(villainName != null){
            int minionsOfAVillain = minionsCount(villainId);

            removeVillainFromMinions(villainId);
            dropConstraintFkMinionsVillainsIfExists();
            removeVillain(villainId);

            System.out.printf("%s was deleted%n", villainName);
            System.out.printf("%d minions released%n", minionsOfAVillain);

        }else {
            System.out.println("No such villain was found");
        }
    }

    private static void dropConstraintFkMinionsVillainsIfExists() {
        String queryDropConstraint = "CALL udp_drop_minions_villains_fk()";

        try(CallableStatement callStatement = getConnection().prepareCall(queryDropConstraint)){
            callStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void removeVillain(String villainId) {
        String queryRemoveVillain = "DELETE FROM minions_db.villains WHERE id = " + villainId;

        try (Statement statement = getConnection().createStatement()){
            statement.executeUpdate(queryRemoveVillain);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void removeVillainFromMinions(String villainId) {
        String queryUpdateMinions = "UPDATE minions_db.minions\n" +
                                    "SET villan_id = NULL \n" +
                                    "WHERE villan_id = " + villainId;

        try (Statement statement = getConnection().createStatement()){
            statement.executeUpdate(queryUpdateMinions);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String getVillainName(String villainId) {
        String querySelectVillainName = "SELECT name FROM minions_db.villains WHERE id = " + villainId;

        try(Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(querySelectVillainName)){
            if(resultSet.next()){
                return resultSet.getString("name");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static int minionsCount(String villainId) {
        int minionsCount = 0;
        String querySelectMinionsCount =
                "SELECT COUNT(*) AS minions_count FROM minions_db.minions AS m WHERE villan_id = " + villainId;

        try(Statement statement = getConnection().createStatement();
        ResultSet resultSet = statement.executeQuery(querySelectMinionsCount)) {
            if(resultSet.next()){
                minionsCount = resultSet.getInt("minions_count");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return minionsCount;
    }

    private static Connection getConnection() throws SQLException {
        final String url = "jdbc:mysql://localhost:3306/minions_db?useSSL=false";
        final String USER = "root";
        final String password = "1234";

        return DriverManager.getConnection(url, USER, password);
    }
}

/*
DELIMITER $$
CREATE PROCEDURE udp_drop_minions_villains_fk()
  BEGIN
    IF EXISTS(
        SELECT *
        FROM INFORMATION_SCHEMA.STATISTICS
        WHERE INDEX_NAME = 'fk_minions_villains')
    THEN
      ALTER TABLE minions_db.minions
        DROP FOREIGN KEY fk_minions_villains,
        DROP KEY fk_minions_villains;
    END IF;
  END;

DELIMITER ;
 */