import java.sql.*;

public class QueryDB {
    public static String frageById(int id) {
        String sql = "SELECT frage FROM karte WHERE id = ?";

        try (Connection con = ConnectDB.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String frage = rs.getString("frage");
                //System.out.println(frage);
                rs.close();
                return frage;
            } else {
                //System.out.println("Kein Eintrag gefunden");
                rs.close();
                return "nichts";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sql;
    }

    public static String antwortById(int id) {
        String sql = "SELECT antwort FROM karte WHERE id = ?";

        try (Connection con = ConnectDB.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                String antwort = rs.getString("antwort");
                //System.out.println(antwort);
                rs.close();
                return antwort;
            } else {
                //System.out.println("Kein Eintrag gefunden.");
                rs.close();
                return "nichts";
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sql;
    }
}
