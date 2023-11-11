package managers;

// import java.math.BigDecimal;
// import java.math.RoundingMode;
// import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entity.Product;

public class ProductManager {
    private List<Product> productList;
    private Scanner scanner;
    
    public ProductManager() {
        //this.productList = new ArrayList<>();
        this.productList = SaveLoadManager.loadProductList("productList");
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
        // double pPrice;
        // while (true) {
        //     System.out.print("Enter the price of the product (should be greater than 0 and have 2 decimal places(#.##)): ");
        //     String pPriceString = scanner.next();
        //     try {
        //         pPrice = Double.parseDouble(pPriceString);
        //         if(pPrice > 0 && Math.abs(pPrice * 100 - (int)(pPrice * 100)) < 1e-9){
        //             break;
        //         } else{
        //             System.out.println("Price must be greater than 0 and have exactly 2 decimal places.");
        //         }
        //     } catch (NumberFormatException e) {
        //         System.out.println("Invalid price entry format.");
        //     }
        // }

        // double pPrice;

        // while (true) {
        //     System.out.print("Enter the price of the product (should be greater than 0 and have 2 decimal places (#.##)): ");
        //     String pPriceString = scanner.next();

        //     try {
        //         pPrice = Double.parseDouble(pPriceString);
        //         BigDecimal price = BigDecimal.valueOf(pPrice).setScale(2, RoundingMode.HALF_UP);

        //         if (price.compareTo(BigDecimal.ZERO) > 0 && price.scale() == 2) {
        //             break;
        //         } else {
        //             System.out.println("Price must be greater than 0 and have exactly 2 decimal places.");
        //         }
        //     } catch (NumberFormatException e) {
        //         System.out.println("Invalid price entry format.");
        //     }
        // }
        System.out.print("Enter the price of the product (should be greater than 0 and have 2 decimal places (#.##)):");
        double pPrice =-1;
        while(pPrice<=0){
            try {
                pPrice = Double.parseDouble(scanner.nextLine());
                if(pPrice<=0 || Math.abs(pPrice*100 - Math.round(pPrice*100))>0.001){
                    System.out.println("Invalid price. Amount should be greater than 0 and have 2 decimal places.");
                    System.out.print("Enter a valid price: ");
                    pPrice = -1;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                System.out.print("Enter a valid price: ");                
            }
        }

        // System.out.print("Product quantity: ");
        // int pQuantity = scanner.nextInt(); scanner.nextLine();
        // while(pQuantity<=0){
        //     System.out.print("Quantity must be greater than 0. Please enter a valid quantity: ");
        //     pQuantity = scanner.nextInt(); scanner.nextLine();
        // }

        // int pQuantity;

        // while (true) {
        //     try {
        //         System.out.print("Product quantity: ");
        //         pQuantity = scanner.nextInt();
        //         scanner.nextLine();  

        //         if (pQuantity > 0) {
        //             break; 
        //         } else {
        //             System.out.println("Quantity must be greater than 0. Please enter a valid quantity.");
        //         }
        //     } catch (java.util.InputMismatchException e) {
        //         
        //         System.out.println("Invalid input. Please enter a valid quantity.");
        //         scanner.nextLine(); 
        //     }
        // }

        int pQuantity;
        while(true){
            System.out.print("Product quantity: ");
            if(scanner.hasNextInt()){
                pQuantity = scanner.nextInt(); scanner.nextLine();
                if(pQuantity<0){
                    System.out.println("Quantity must be greater than 0. Please enter a valid quantity.");
                } else{
                    break;
                }
            }else{
                System.out.println("Invalid input. Please enter a valid quantity.");
                scanner.nextLine(); 
            }
        }

        Product newProduct = new Product(pName, pType, pPrice, pQuantity);
        productList.add(newProduct);
        System.out.println("The product was successfully added!");
        SaveLoadManager.saveProductList(productList, "productList");
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
                System.out.print("Product #" + productNumber+" - ");
                System.out.print(product.getProductName() +" ");
                System.out.print("("+product.getProductType() +"), ");
                System.out.print(product.getProductPrice() +" EUR, ");
                System.out.print("Qty: "+product.getProductQuantity() +".");
                System.out.println();
                productNumber++;                    
            }
        }
    }
    public List<Product> getProductList(){
        return productList;
    }

    // public Product findProductByName(String productName){
    //     for(Product product: productList){
    //         if(product.getProductName().equals(productName)){
    //             return product;
    //         }
    //     }
    //     return null;
    // }
}