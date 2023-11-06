package managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entity.Product;

public class ProductManager {
    private List<Product> productList;
    private Scanner scanner;
    
    public ProductManager() {
        this.productList = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    
    public void addProduct(){
        System.out.println();
        System.out.println("---------------------");
        System.out.println("| Add a new product |");
        System.out.println("---------------------"); 
        
        System.out.print("Product name: ");
        final String pName = scanner.nextLine();
        
        System.out.print("Product type: ");
        final String pType = scanner.nextLine();        
        double pPrice;
        while (true) {
            System.out.print("Enter the price of the product (should be greater than 0 and have 2 decimal places(#.##)): ");
            String pPriceString = scanner.next();
            try {
                pPrice = Double.parseDouble(pPriceString);
                if(pPrice > 0 && Math.abs(pPrice * 100 - (int)(pPrice * 100)) < 1e-9){
                    break;
                } else{
                    System.out.println("Price must be greater than 0 and have exactly 2 decimal places.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid price entry format.");
            }
        }
        System.out.print("Product quantity: ");
        int pQuantity = scanner.nextInt(); scanner.nextLine();
        while(pQuantity<=0){
            System.out.print("Quantity must be greater than 0. Please enter a valid quantity: ");
            pQuantity = scanner.nextInt(); scanner.nextLine();
        }

        Product newProduct = new Product(pName, pType, pPrice, pQuantity);
        productList.add(newProduct);
        System.out.println("The product was successfully added!");
    }

    public void displayAllProducts(){
        System.out.println();
        System.out.println("--------------------");
        System.out.println("| List of Products |");
        System.out.println("--------------------");
        
        if(productList.isEmpty()){
            System.out.println("No products found");
        }else{
            int productNumber = 1;
            for(Product product : productList){
                System.out.print("Product #" + productNumber+", ");
                System.out.print("Name: " +product.getProductName() +", ");
                System.out.print("Type: " +product.getProductType() +", ");
                System.out.print("Price: " +product.getProductPrice() +" EUR, ");
                System.out.print("Quantity: " +product.getProductQuantity() +".");
                System.out.println();
                productNumber++;                    
            }
        }
    }
    public List<Product> geProductList(){
        return productList;
    }
}