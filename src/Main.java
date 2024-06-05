import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        flashCardProgramm();

    }
    /*ToDo -Wissensstand Einträge ermöglichen.
    nach ausgabe der **Antwort** soll es möglich sein Bewerung zu geben
    es soll von 0 bis 5 gewertet werden und gespeichert durch eintragung in DB -> fk_wissensstand
    beim nächsten Aufruf der frage wird der wissensstand **Angezeigt** mit sternen ⭐️⭐️⭐️⭐️⭐️
     */
    /*ToDo Kategorie der Fragen Anzeigen
    Kategorie ->    Planen, Vorbereiten und Durchführen von Arbeitsaufgaben
                    Frage Nr. 1
    Frage ->        Mit welchen Werkzeugen kann man ein Projekt planen und überwachen
     */


    public static void flashCardProgramm () {
        try {
            int id = 1;
            int rangeQuestions = QueryDB.sumQuestions();
            String kategorie = QueryDB.getKategorie(id);

            while (true){
                Scanner scanner = new Scanner(System.in);
                System.out.println
                        ("------------------------\n"+
                                "•1• Frage zeigen       ❔\n"+
                                "•2• Antwort zeigen     ❕\n"+
                                "•3• Nächste Frage      ➡️\n"+
                                "•4• Vorherige Frage    ⬅️\n"+
                                "•5• Beenden            ❌\n"+
                                "------------------------");

                int choice = scanner.nextInt();
                if ( choice == 1){ // Frage mit der ID 1 wird aufgerufen
                    System.out.println("Kategorie: " + kategorie);
                    System.out.println("Frage Nr.: " + id );
                    System.out.println(QueryDB.frageById(id));

                } else if ( choice == 2 ) { // Antwort mit der ID 1 wird aufgerufen
                    System.out.println("Antwort Nr.: " + id );
                    System.out.println(QueryDB.antwortById(id));

                } else if ( choice == 3) {
                    if (id == rangeQuestions) { //wenn die ID gleich der Menge der Fragen ist
                        id = 1;
                        System.out.println("Frage Nr.: " + id );
                        System.out.println(QueryDB.frageById(id));
                    } else { //wenn frageById Frage verfügbar - wird die frage ausgegeben
                        id = id + 1;
                        System.out.println("Frage Nr.: " + id );
                        System.out.println(QueryDB.frageById(id));
                    }

                } else if ( choice == 4) {// Vorherige Frage anzeigen
                    if (id > 1) {//wenn die ID größer als 1 dann -1
                        id = id -1;
                        System.out.println("Frage Nr.: " + id );
                        System.out.println(QueryDB.frageById(id));
                    } else { // wenn die ID 1 wird die ID auf 1 gesetzt
                        id = rangeQuestions;
                        System.out.println("Frage Nr.: " + id );
                        System.out.println(QueryDB.frageById(id));
                    }

                } else if ( choice == 5) {//Methode wird Geshloßen
                    System.out.println("Programm wird beendet...");
                    break;
                }
            }
        } catch (Exception e) {//bei ungültiger Eingabe, falscher eingabe wird es ge
            System.out.println("Ungültige Auswahl, bitte versuchen Sie es erneut");
            flashCardProgramm();
        }
    }
}
