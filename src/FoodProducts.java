import java.util.ArrayList; // Import the ArrayList class
public class FoodProducts {

    FoodProduct product1 = new FoodProduct("Mjölk", 10, 5, 0);
    FoodProduct product2 = new FoodProduct("Bröd", 20, 5, 0);
    FoodProduct product3 = new FoodProduct("Ägg",25, 5, 0);
    FoodProduct product4 = new FoodProduct("Smör", 40, 5, 0);
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
        System.out.println("3. Betala");
        System.out.println("4. Avsluta");
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
