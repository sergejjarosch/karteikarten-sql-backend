import java.sql.*;

public class QueryDB {
    public static void frageById(int id) {
        String sql = "SELECT frage FROM karte WHERE id = ?";

        try (Connection con = ConnectDB.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String frage = rs.getString("frage");
                System.out.println("Frage: " + frage);
            } else {
                System.out.println("Kein Eintrag gefunden.");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void antwortById(int id) {
        String sql = "SELECT antwort FROM karte WHERE id = ?";

        try (Connection con = ConnectDB.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String antwort = rs.getString("antwort");
                System.out.println("Antwort: " + antwort);
            } else {
                System.out.println("Kein Eintrag gefunden.");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
