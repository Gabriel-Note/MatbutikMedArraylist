import java.util.Scanner;

/*
System.out.println("\u001B[31mThis is red text\u001B[0m");
System.out.println("\u001B[32mThis is green text\u001B[0m");
System.out.println("\u001B[34mThis is blue text\u001B[0m");
 */

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FoodProducts foodProducts = new FoodProducts();
        SelectionHandling selection = new SelectionHandling();

        while (true) {
            foodProducts.printSelection();
            int currentSelection = selection.positiveInt();
            switch (currentSelection) {
                case 1:
                    boolean loopCheck = true;
                    while (loopCheck) {
                        foodProducts.printStoreItemsAndPrice();
                        currentSelection = selection.positiveInt();
                        if (currentSelection <= foodProducts.productCatalogue.size() && currentSelection != 0) {
                            System.out.println("Hur många vill ni köpa totalt?");
                            foodProducts.productCatalogue.get(currentSelection-1).inCart = selection.positiveInt();
                        }
                        else if (currentSelection == 0){
                            loopCheck = false;
                        }
                        else {
                            foodProducts.printInvalidInput();
                        }
                    }
                    break;
                case 2:
                    foodProducts.printCart();
                    System.out.println("");
                    break;
                case 3:
                    //System.out.println();
                    foodProducts.printReceipt();
                    return;
                case 4:
                    System.out.println("Tack för att ni använde DinMatbutik Inc.");
                    return;
                default:
                    foodProducts.printInvalidInput();
            }
        }
    }
}







