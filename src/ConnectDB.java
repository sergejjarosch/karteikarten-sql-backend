import java.sql.*;

public class ConnectDB {
    private static final String URL = "jdbc:postgresql://localhost:5433/karteikarten-local";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "DataBase";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }
}
