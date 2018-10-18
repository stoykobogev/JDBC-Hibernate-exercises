import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;

public class temp {
    private static final String URL = "jdbc:mysql://localhost:3310/minionsdb?useSSL=false";
    private static final String USER = "root";
    private static final String PASSOWRD = "nokia";

    public static void main(String[] args) {


        try (
                Connection conn = DriverManager.getConnection(URL, USER, PASSOWRD);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ) {

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}