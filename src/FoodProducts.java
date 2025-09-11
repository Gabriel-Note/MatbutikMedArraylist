import java.util.ArrayList; // Import the ArrayList class
public class FoodProducts {

    FoodProduct product1 = new FoodProduct("Mjölk", 10, 13, 0);
    FoodProduct product2 = new FoodProduct("Bröd", 20, 2, 0);
    FoodProduct product3 = new FoodProduct("Ägg",25, 5, 0);
    FoodProduct product4 = new FoodProduct("Smör", 40, 7, 0);
    ArrayList<FoodProduct> productCatalogue = new ArrayList<>();

    public FoodProducts (){
        productCatalogue.add(product1);
        productCatalogue.add(product2);
        productCatalogue.add(product3);
        productCatalogue.add(product4);
    }

    static boolean validInputs (int i){
        boolean result = switch (i) {
            case 1, 2, 3, 4 -> true;
            default -> false;
        };
        return result;
    }

    public void printSelection(){
        System.out.println("1. Visa varor och handla");
        System.out.println("2. Visa varukorg");
        System.out.println("3. Visa lagersaldo");
        System.out.println("4. Betala");
        System.out.println("5. Avsluta");
    }

    public void inStockCheck(int numberOfItemsPurchased, int selectedItem){
        boolean loopCheck = true;
        selectedItem -= 1;
        while (loopCheck){
            if ((productCatalogue.get(selectedItem).stock + productCatalogue.get(selectedItem).inCart) >= (numberOfItemsPurchased)){
                productCatalogue.get(selectedItem).stock -= numberOfItemsPurchased;
                loopCheck = false;
            }
            else {
                System.out.println("\u001B[31m Out of stock \u001B[0m");
                System.out.println("Including the items in your cart we have " + (productCatalogue.get(selectedItem).stock + productCatalogue.get(selectedItem).inCart) + " items in stock");
                System.out.println("Hur många vill ni köpa totalt?");
                numberOfItemsPurchased = SelectionHandling.positiveInt();
            }
        }
    }

    public void printStoreItemsAndPrice(){
        String format4_2 = "%-10s%s%n";
        int i = 1;
        for (FoodProduct product : productCatalogue) {
            System.out.printf(
                    format4_2,
                    i + ". " + product.name + ": ",
                    product.price + " kr"
            );
            i++;
        }
        System.out.println("");
        System.out.println("0. För att gå tillbaka");
    }

    public void printStoreStock(){
        String format4_2 = "%-10s%s%n";
        int i = 1;
        for (FoodProduct product : productCatalogue) {
            System.out.printf(
                    format4_2,
                    i + ". " + product.name + ": ",
                    product.stock + " st"
            );
            i++;
        }
        System.out.println("");
    }

    public void printReceipt() {
        String format4_2 = "%-18s%s%n";
        int sum = 0;
        for (FoodProduct product : productCatalogue){
            if (product.inCart != 0){
                System.out.printf(
                        format4_2,
                        product.inCart + "x " + product.name + " à " + product.price + " kr",
                        "= " + (product.inCart * product.price) + " kr"
                );
                sum += (product.inCart * product.price);
            }
        }
        System.out.println("");
        System.out.println("\u001B[32mTotalt pris: " + sum + " kr\u001B[0m");
        System.out.println("");
        System.out.println("Tack för att ni använde DinMatbutik Inc.");
    }

    public void printCart(){
        String format4_2 = "%-10s%s%n";
        for (FoodProduct product : productCatalogue) {
            System.out.printf(
                    format4_2,
                    product.name + ": ",
                    product.inCart + " st"
            );
        }
    }

    public void printInvalidInput (){
        System.out.println("\u001B[31mOgiltigt val\u001B[0m");
        System.out.println("");
    }
}
