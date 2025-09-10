import java.util.Scanner;

public class SelectionHandling {

    Scanner scan = new Scanner(System.in);

    // Validering användarinput som ett positivt heltal
    public int positiveInt(){
        while (true) {
            try {
                int input = scan.nextInt();
                if (input < 0){
                    System.out.println("\u001B[31mfår inte vara negativa värden, försök igen\u001B[0m");
                    scan.nextLine();
                }
                else {
                    return input;
                }
            } catch (Exception e) {
                System.out.println("\u001B[31mOgiltigt val, försök igen\u001B[0m");
                scan.nextLine();
            }
        }
    }
}