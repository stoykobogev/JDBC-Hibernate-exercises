import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.StringJoiner;

public class changeTownNames {
    private static final String URL = "jdbc:mysql://localhost:3310/minionsdb?useSSL=false";
    private static final String USER = "root";
    private static final String PASSOWRD = "nokia";

    public static void main(String[] args) {

        String sqlCountry = "SELECT country_id FROM countries WHERE country_name = ?";
        String sqlTowns =
                "SELECT town_id,town_name FROM towns " +
                "WHERE country_id = ? AND town_name NOT LIKE UPPER(town_name)";

        try (
            Connection conn = DriverManager.getConnection(URL, USER, PASSOWRD);
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            PreparedStatement psCountry = conn.prepareStatement(sqlCountry);
            PreparedStatement psTowns = conn.prepareStatement(sqlTowns, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_UPDATABLE);
        ) {
            psCountry.setString(1, reader.readLine());
            ResultSet rs = psCountry.executeQuery();
            int countryId;
            if (rs.next()) {
                countryId = rs.getInt("country_id");
            } else {
                System.out.println("No town names were affected.");
                return;
            }

            psTowns.setInt(1, countryId);
            rs = psTowns.executeQuery();

            if (rs.next()) {
                StringJoiner sj = new StringJoiner(", ");
                int rowsAffected = 0;

                do {
                    String townName = rs.getString("town_name").toUpperCase();
                    rs.updateString("town_name", townName);
                    rs.updateRow();
                    sj.add(townName);
                    rowsAffected++;
                } while (rs.next());

                System.out.printf("%d town names were affected [%s]\n", rowsAffected, sj.toString());

            } else {
                System.out.println("No town names were affected.");
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}
