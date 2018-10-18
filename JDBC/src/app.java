import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class app {

    private static final String URL = "jdbc:mysql://localhost:3310/minionsdb?useSSL=false";
    private static final String USER = "root";
    private static final String PASSOWRD = "nokia";

    public static void main(String[] args) {

        String sql =
                "SELECT v.villain_name, m.minion_name, m.age FROM villains AS v " +
                "INNER JOIN minions_villains AS mv " +
                "ON v.villain_id = mv.villain_id " +
                "INNER JOIN minions AS m " +
                "ON mv.minion_id = m.minion_id " +
                "WHERE v.villain_id = ?";

        try (
            Connection conn = DriverManager.getConnection(URL, USER, PASSOWRD);
            PreparedStatement stm = conn.prepareStatement(sql);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ) {
            int id = Integer.parseInt(reader.readLine());
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                String name = rs.getString("villain_name");
                System.out.println("Villain: " + name);
                do {
                    int row = rs.getRow();
                    String minionName = rs.getString("minion_name");
                    int age = rs.getInt("age");
                    System.out.println(String.format("%d. %s %d", row, minionName, age));
                } while(rs.next());
            } else {
                System.out.println(String.format("No villain with %d exists in the database.", id));
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
