import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class addMinion {
    private static final String URL = "jdbc:mysql://localhost:3310/minionsdb?useSSL=false";
    private static final String USER = "root";
    private static final String PASSOWRD = "nokia";

    public static void main(String[] args) {

        String townSql =
                "INSERT IGNORE INTO towns (town_name) VALUES (?)";
        String vilSql =
                "INSERT IGNORE INTO villains (villain_name) VALUES (?)";
        String minSql =
                "INSERT INTO minions (minion_name, age, town_id) " +
                "VALUES (?, ?, " +
                "(SELECT town_id FROM towns " +
                " WHERE town_name = ?))";
        String minVilSql =
                "INSERT INTO minions_villains (minion_id, villain_id) " +
                "VALUES (" +
                "(SELECT minion_id FROM minions " +
                "WHERE minions.minion_name = ?), " +
                "(SELECT villain_id FROM villains " +
                "WHERE villains.villain_name = ?))";

        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASSOWRD);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                PreparedStatement townStm = conn.prepareStatement(townSql);
                PreparedStatement vilStm = conn.prepareStatement(vilSql);
                PreparedStatement minStm = conn.prepareStatement(minSql);
                PreparedStatement minVilStm = conn.prepareStatement(minVilSql)
        ) {
            String[] minArgs = null;
            String vilName = null;
            for (;;) {
                System.out.print("Minion: ");
                minArgs = reader.readLine().split("\\s+");

                if (minArgs.length != 3) {
                    System.out.println("Invalid arguments");
                } else {
                    break;
                }
            }

            System.out.print("Villain: ");
            vilName = reader.readLine();

            if (vilName != null) {
                String minName = minArgs[0];
                int age = Integer.parseInt(minArgs[1]);
                String townName = minArgs[2];

                townStm.setString(1, townName);
                vilStm.setString(1, vilName);
                minStm.setString(1, minName);
                minStm.setInt(2, age);
                minStm.setString(3, townName);
                minVilStm.setString(1, minName);
                minVilStm.setString(2, vilName);

                conn.setAutoCommit(false);
                if (townStm.executeUpdate() == 1) {
                    System.out.println(String.format("Town %s was added to DB", townName));
                }

                if (vilStm.executeUpdate() == 1) {
                    System.out.println(String.format("Villain %s was added to DB", vilName));
                }

                if (minStm.executeUpdate() == 1) {
                    System.out.println(String.format("Minion %s was added to DB", minName));
                } else {
                    System.out.println("Rollback");
                    conn.rollback();
                }

                if (minVilStm.executeUpdate() == 1) {
                    System.out.println(String.format("Successfully added %s to be minion of %s", minName, vilName));
                } else {
                    System.out.println("Rollback");
                    conn.rollback();
                }

                conn.commit();
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
