import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        flashCardProgramm();
    }


    public static void flashCardProgramm () {
        try {
            int id = 1;
            while (true){
                Scanner scanner = new Scanner(System.in);
                System.out.println
                        ("\n1: Frage zeigen\n"+
                                "2: Antwort zeigen\n"+
                                "3: Nächste Frage\n"+
                                "4: Vorhärige Frage\n"+
                                "5: Beenden");

                int choice = scanner.nextInt();
                if ( choice == 1){ // Frage mit der ID 1 wird aufgerufen
                    System.out.println("Frage Nr.: " + id );
                    System.out.println(QueryDB.frageById(id));

                } else if ( choice == 2 ) { // Antwort mit der ID 1 wird aufgerufen
                    System.out.println("Antwort Nr.: " + id );
                    System.out.println(QueryDB.antwortById(id));

                } else if ( choice == 3) { //Nächste Frage die ID + 1
                    id = id +1; // Id wird um 1 hochgesetzt
                    String availability = QueryDB.frageById(id);//availability ist return für"nichts"
                    QueryDB.frageById(id); //wird aufgerufen "nichts" um id wieder auf 1 zu setzen
                    if (availability == "nichts") { //wenn frageById = "nichts" dann ID = 1
                        id = 1;
                        System.out.println("Frage Nr.: " + id );
                        System.out.println(QueryDB.frageById(id));
                    } else { //wenn frageById Frage verfügbar - wird die frage ausgegeben
                        System.out.println("Frage Nr.: " + id );
                        System.out.println(QueryDB.frageById(id));
                    }

                } else if ( choice == 4) {// Vorherige Frage anzeigen
                    if (id > 1) {//wenn die ID größer als 1 dann -1
                        id = id -1;
                        System.out.println("Frage Nr.: " + id );
                        System.out.println(QueryDB.frageById(id));
                    } else { // wenn die ID 1 wird die ID auf 1 gesetzt
                        id = 1;
                        System.out.println("Frage Nr.: " + id );
                        System.out.println(QueryDB.frageById(id));
                    }

                } else if ( choice == 5) {//Methode wird Geshloßen
                    System.out.println("Programm wird beendet...");
                    break;
                }
            }
        } catch (Exception e) {//bei ungültiger Eingabe, falscher eingabe wird es gecatcht und die Methode neu gestartet
            System.out.println("Ungültige Auswahl, bitte versuchen Sie es erneut");
            flashCardProgramm();
        }
    }
}
