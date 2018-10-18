import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class increaseAgeSP {
    private static final String URL = "jdbc:mysql://localhost:3310/minionsdb?useSSL=false";
    private static final String USER = "root";
    private static final String PASSOWRD = "nokia";

    public static void main(String[] args) {
        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASSOWRD);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                CallableStatement cs = conn.prepareCall("{CALL usp_get_older(?, ?, ?)}")
        ) {
            int id = Integer.parseInt(reader.readLine());
            cs.setInt(1, id);
            cs.registerOutParameter(2, Types.INTEGER);
            cs.registerOutParameter(3, Types.VARCHAR);

            cs.execute();
            System.out.println(cs.getString(3) + " " + cs.getInt(2));
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}