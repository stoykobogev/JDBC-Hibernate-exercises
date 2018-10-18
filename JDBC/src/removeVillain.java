import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class removeVillain {
    private static final String URL = "jdbc:mysql://localhost:3310/minionsdb?useSSL=false";
    private static final String USER = "root";
    private static final String PASSOWRD = "nokia";

    public static void main(String[] args) {

        String minionsSql =
                "SELECT v.villain_name, COUNT(mv.minion_id) AS count FROM villains AS v " +
                "LEFT OUTER JOIN minions_villains AS mv " +
                "ON v.villain_id = mv.villain_id " +
                "WHERE v.villain_id = ? " +
                "GROUP BY v.villain_id";
        String villainSql =
                "DELETE FROM villains " +
                "WHERE villain_id = ?";

        try (
            Connection conn = DriverManager.getConnection(URL, USER, PASSOWRD);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PreparedStatement minPs = conn.prepareStatement(minionsSql);
            PreparedStatement vilPs = conn.prepareStatement(villainSql)
        ) {
            int id = Integer.parseInt(reader.readLine());
            minPs.setInt(1, id);
            ResultSet rs = minPs.executeQuery();

            if (rs.next()) {
                int minCount = rs.getInt("count");
                String vilName = rs.getString("villain_name");
                vilPs.setInt(1, id);
                vilPs.executeUpdate();

                System.out.printf("%s was deleted\n%d minions released\n",vilName, minCount);
            } else {
                System.out.println("Invalid ID");
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}