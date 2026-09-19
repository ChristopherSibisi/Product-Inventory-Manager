import java.util.Scanner;
import java.text.DecimalFormat;

public class ProductInventory {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);

        String[] productNames = { "Sugar","Laptop","Book","Dress","Sphahlo","Panado"};
        String[] productCategories = {"Food","Electronics","Stationery","Clothing","Food","Health"};

        double[] productPrices = new double[productNames.length];
        int[] productQuantities = new int[productNames.length];

        addProduct(productNames, productPrices, productQuantities);

        int option;

        do {

            viewProducts(productNames,productCategories,productPrices, productQuantities);

            System.out.print("Choose an option or press 6 to exit: ");
            option = kb.nextInt();
            kb.nextLine();

            if (option == 1) {
               addProduct(productNames,productPrices,productQuantities);

            }
            else if (option == 2) {

                viewProducts(productNames,productCategories,productPrices,productQuantities);

            }
            else if (option == 3) {

                int index = searchProduct(productNames);

                if (index != -1) {
                    System.out.println("Product found:");
                    System.out.println("Name: " + productNames[index]);
                    System.out.println("Price: " + productPrices[index]);
                    System.out.println("Quantity: " + productQuantities[index]);
                }
                else {
                    System.out.println("Product not found.");
                }

            }
            else if (option == 4) {

                sortProducts(productNames,productCategories,productPrices,productQuantities);

                System.out.println("Products sorted by name.");

            }
            else if (option == 5) {

                updateStockQuantity(productNames,productQuantities);

            }
            else if (option == 6) {

                System.out.println("Exit");

            }
            else {

                System.out.println("Invalid option.");

            }

        } while (option != 6);

        
    }


    public static void addProduct(String[] productNames,double[] productPrices,int[] productQuantities){

        Scanner kb = new Scanner(System.in);

        for (int i = 0; i < productNames.length; i++) {

            System.out.print("Enter the price for " + productNames[i] + ": ");
            productPrices[i] = kb.nextDouble();

            System.out.print("Enter the quantity for " + productNames[i] + ": ");
            productQuantities[i] = kb.nextInt();
        }
    }


    public static void viewProducts(String[] productNames,String[] productCategories,double[] productPrices,int[] productQuantities){

		DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("\n=== PRODUCT INVENTORY MANAGER ===");

        System.out.println("1. Add product");
        System.out.println("2. View All products");
        System.out.println("3. Search product by name");
        System.out.println("4. Sort products by name");
        System.out.println("5. Update Stock Quantity");
        System.out.println("6. Exit");

        System.out.println("No.\tName\t\tCategory\tPrice\tQuantity");

        int number = 1;

        for (int i = 0; i < productNames.length; i++) {

            System.out.println(number++ + "\t" + productNames[i] + "\t\t" + productCategories[i] + "\t\t" +df.format(productPrices[i]) + "\t" +productQuantities[i]);
        }
    }


    public static int searchProduct(String[] productNames) {

        Scanner kb = new Scanner(System.in);

        System.out.print("Enter product name to search: ");
        String searchName = kb.nextLine();

        int index = -1;

        for (int i = 0; i < productNames.length; i++) {

            if (productNames[i].equalsIgnoreCase(searchName)) {
                index = i;
                break;
            }
        }

        return index;
    }


    public static void updateStockQuantity(String[] productNames,int[] productQuantities){

        Scanner kb = new Scanner(System.in);

        System.out.print("Enter the product name to update: ");
        String searchName = kb.nextLine();

        boolean found = false;

        for (int i = 0; i < productNames.length; i++) {

            if (productNames[i].equalsIgnoreCase(searchName)) {

                found = true;

                System.out.print("Enter new quantity: ");
                int quantity = kb.nextInt();

                productQuantities[i] = quantity;

                System.out.println("Stock updated.");

                break;
            }
        }

        if (!found) {
            System.out.println("ERROR: PRODUCT NOT FOUND.");
        }
    }


    public static void sortProducts(String[] productNames,String[] productCategories,double[] productPrices,int[] productQuantities){

        for (int x = 0; x < productNames.length - 1; x++){

            for (int i = 0; i < productNames.length - x - 1; i++) {

                if (productNames[i].compareToIgnoreCase(productNames[i + 1]) > 0){

                    String tempNames = productNames[i];
                    productNames[i] = productNames[i + 1];
                    productNames[i + 1] = tempNames;

                    String tempCats = productCategories[i];
                    productCategories[i] = productCategories[i + 1];
                    productCategories[i + 1] = tempCats;

                    double tempPrices = productPrices[i];
                    productPrices[i] = productPrices[i + 1];
                    productPrices[i + 1] = tempPrices;

                    int tempQuantity = productQuantities[i];
                    productQuantities[i] = productQuantities[i + 1];
                    productQuantities[i + 1] = tempQuantity;
                }
            }
        }
    }
}