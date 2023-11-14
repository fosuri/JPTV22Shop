package managers;

// import java.math.BigDecimal;
// import java.math.RoundingMode;
// import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entity.Product;
import tools.InputFromKeyboard;

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

    public void changeProductPrice(){
        System.out.println();
        System.out.println("------------------------");
        System.out.println("| Change product price |");
        System.out.println("------------------------");     

        displayAllProducts();
        System.out.println("Enter the number of the product you want to change.");
        int productNumber = InputFromKeyboard.inputNumberFromRange(1, productList.size());
        Product selectedProduct = productList.get(productNumber - 1);
        
        boolean changeDetails = true;
        while (changeDetails) {
            System.out.print("Enter the new price of the product (should be greater than 0 and have 2 decimal places (#.##)):");
            double newPPrice =-1;
            while(newPPrice<=0){
                try {
                    newPPrice = Double.parseDouble(scanner.nextLine());
                    if(newPPrice<=0 || Math.abs(newPPrice*100 - Math.round(newPPrice*100))>0.001){
                        System.out.println("Invalid price. Amount should be greater than 0 and have 2 decimal places.");
                        System.out.print("Enter a valid price: ");
                        newPPrice = -1;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Please enter a valid number.");
                    System.out.print("Enter a valid price: ");                
                }
            }

            System.out.println("New product price: "+newPPrice+" EUR");

            System.out.println("Change product details? (y/n)");
            //String change = InputFromKeyboard.inputSympolYesOrNO();
            String change = scanner.nextLine();

            if (change.equalsIgnoreCase("y")) {
                System.out.println("Product details have been changed!");
                selectedProduct.setProductPrice(newPPrice);
                SaveLoadManager.saveProductList(productList, "productList");
                changeDetails = false;
            } else if (change.equalsIgnoreCase("n")){
                System.out.println("0. Exit");
                System.out.println("1. Re-enter");
                System.out.print("Enter task number: ");
                int choice = InputFromKeyboard.inputNumberFromRange(0, 1);
                if (choice == 1){
                    
                }else if (choice == 0){
                    changeDetails = false;
                }else{
                    System.out.println("Invalid symbol. Only \"y\" or \"n\"");
                }

            }

        }
    }
    public void ProductReplenishment(){
        System.out.println();
        System.out.println("-------------------------");
        System.out.println("| Product replenishment |");
        System.out.println("-------------------------");     

        displayAllProducts();
        System.out.println("Enter the number of the product you want to change.");
        int productNumber = InputFromKeyboard.inputNumberFromRange(1, productList.size());
        Product selectedProduct = productList.get(productNumber - 1);
        
        boolean changeDetails = true;
        while (changeDetails) {
            int newPQuantity;
            while(true){
                System.out.print("Product quantity: ");
                if(scanner.hasNextInt()){
                    newPQuantity = scanner.nextInt(); scanner.nextLine();
                    if(newPQuantity<0){
                        System.out.println("Quantity must be greater than 0. Please enter a valid quantity.");
                    } else{
                        break;
                    }
                }else{
                    System.out.println("Invalid input. Please enter a valid quantity.");
                    scanner.nextLine(); 
                }
            }

            System.out.println("New product price: "+newPQuantity+" EUR");

            System.out.println("Confirm product replenishment? (y/n)");
            //String change = InputFromKeyboard.inputSympolYesOrNO();
            String change = scanner.nextLine();

            if (change.equalsIgnoreCase("y")) {
                System.out.println("Product quantity have been changed!");
                selectedProduct.setProductQuantity(selectedProduct.getProductQuantity()+newPQuantity);
                SaveLoadManager.saveProductList(productList, "productList");
                changeDetails = false;
            } else if (change.equalsIgnoreCase("n")){
                System.out.println("0. Exit");
                System.out.println("1. Re-enter");
                System.out.print("Enter task number: ");
                int choice = InputFromKeyboard.inputNumberFromRange(0, 1);
                if (choice == 1){
                    
                }else if (choice == 0){
                    changeDetails = false;
                }else{
                    System.out.println("Invalid symbol. Only \"y\" or \"n\"");
                }

            }

        }
    }
}