import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        flashCardProgramm();


    }
    public static void frageAntwort () {
        Scanner scanner = new Scanner(System.in);
        int id = 1;
        QueryDB.frageById(id);
        System.out.println("Willst du die Antwort sehen?\n"+
                "ja: -> zeigt die Antwort\n" +
                "nein: -> nächste Frage");

        String weiterOderNicht = scanner.nextLine();
        switch(weiterOderNicht) {
            case "ja" -> QueryDB.antwortById(id);
            case "nein" -> { System.out.print("nächste ");
                            QueryDB.frageById(id + 1);}
        }
        scanner.close();
    }

    public static void flashCardProgramm () {
        int id = 1;
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println
                    ("1: Frage zeigen\n"+
                            "2: Antwort zeigen\n"+
                            "3: Nächste Frage\n"+
                            "4: Vorhärige Frage\n"+
                            "5: Beenden");

            int choice = scanner.nextInt();

            if ( choice == 1){
                System.out.println("Frage Nr.: " + id );
                QueryDB.frageById(id);
            } else if ( choice == 2 ) {
                System.out.println("Antwort Nr.: " + id );
                QueryDB.antwortById(id);
            } else if ( choice == 3) {
                id = id +1;
                System.out.println("Frage Nr.: " + id );
                QueryDB.frageById(id);
            } else if ( choice == 4) {
                if (id > 1) {
                    id = id -1;
                    System.out.println("Frage Nr.: " + id );
                    QueryDB.frageById(id);
                } else {
                    id = 1;
                    System.out.println("Frage Nr.: " + id );
                    QueryDB.frageById(id);
                }
            } else if ( choice == 5) {
                break;
            } else {
                System.out.println("Ungültige Auswahl, bitte versuchen Sie es erneut");
            }
        }
    }
}
