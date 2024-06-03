import java.sql.*;


public class ConnectDB {
    public static void main(String[] args) {
        int id = 3;
        String sql = "SELECT frage, antwort FROM karte WHERE id = ?";
        String url = "jdbc:postgresql://localhost:5433/karteikarten-local";
        String username = "postgres";
        String password = "DataBase";

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) { // Überprüfen, ob es ein Ergebnis gibt
                String frage = rs.getString("frage");
                String antwort = rs.getString("antwort");
                System.out.println("Frage: " + frage + ", \nAntwort:" + antwort);
            } else {
                System.out.println("Kein Eintrag gefunden.");
            }

            rs.close();
            pst.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);;
        }
    }
}
