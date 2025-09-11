import java.util.Scanner;

public class SelectionHandling {


    // Validering användarinput som ett positivt heltal
    static int positiveInt(){
        Scanner scan = new Scanner(System.in);
        while (true) {
            try {
                int input = scan.nextInt();
                if (input < 0){
                    System.out.println("\u001B[31m får inte vara negativa värden, försök igen \u001B[0m");
                    scan.nextLine();
                }
                else {
                    return input;
                }
            } catch (Exception e) {
                System.out.println("\u001B[31m Ogiltigt val, försök igen\u001B[0m");
                scan.nextLine();
            }
        }
    }
}