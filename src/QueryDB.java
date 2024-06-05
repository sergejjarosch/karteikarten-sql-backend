import java.sql.*;

public class QueryDB {

    //zählt alle Einträge in der Tabelle karte. Summe aller Einträge.
    public static int sumQuestions(){
        String sql ="SELECT COUNT(frage) FROM karte";
        try {
            Connection con = ConnectDB.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            int summe = rs.getInt("count");
            rs.close();
            return summe;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    //Abfrage der Kategorie der jeweiligen Frage nach ID
    public static String getKategorie(int id){
        String sql ="SELECT kategorie.name from karte " +
                "JOIN kategorie ON karte.fk_kategorie = kategorie.id " +
                "WHERE karte.id = ?";
        try {
            Connection con = ConnectDB.getConnection();
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
            rs.next();

            String kategorie = rs.getString("name");
            rs.close();
            return kategorie;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "keine Kategorie zugeordnet";
    }

    //wissensstand setzen
    public static void setKnowledge(int knowledge, int id) {
        String sql = "UPDATE karte SET wissensstand = ? WHERE ID = ?;";

        try (Connection con = ConnectDB.getConnection();
                PreparedStatement pst = con.prepareStatement(sql)) {
            pst.setInt(1, knowledge);
            pst.setInt(2, id);
            int affectedRows = pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int getKnowledge(int id){
            String sql ="SELECT wissensstand FROM karte WHERE id = ?";
            try {
                Connection con = ConnectDB.getConnection();
                PreparedStatement pst = con.prepareStatement(sql);
                pst.setInt(1, id);
                ResultSet rs = pst.executeQuery();
                rs.next();

                int wissensstand = rs.getInt("wissensstand");
                rs.close();
                return wissensstand;

            } catch (SQLException e) {
                e.printStackTrace();
            }
            return 0;
    }

    // Abfrage für die Frage aus der DB
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
                return "nichts";//Übergabewort um die ID auf 1 zu setzen
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sql;
    }

    // Abfrage für die Antwort aus der DB
    public static String antwortById(int id) {//Abf
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
                return "nichts";//Übergabewort um die ID auf 1 zu setzen
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sql;
    }
}
