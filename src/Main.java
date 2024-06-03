import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Gib die ID ein: ");
        int id = scanner.nextInt();

        QueryDB.frageById(id);

        scanner.close();
    }
}
