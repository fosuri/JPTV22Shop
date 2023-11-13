package managers;

// import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entity.Customer;
import entity.Product;
import entity.Purchase;
import tools.InputFromKeyboard;

public class StoreManager {
    private CustomerManager customerManager;
    private ProductManager productManager;
    private List<Purchase> purchaseList;
    private List<Customer> customerList;
    private List<Product> productList;
    private final Scanner scanner;

    public StoreManager(CustomerManager customerManager, ProductManager productManager) {
        this.customerManager = customerManager;
        this.productManager = productManager;
        //this.purchaseList = new ArrayList<>();
        this.purchaseList = SaveLoadManager.loadPurchaseList("purchaseList");
        this.customerList = customerManager.getCustomerList();
        this.productList = productManager.getProductList();
        this.scanner = new Scanner(System.in);
    }

    public void purchaseProduct() {
        System.out.println();
        System.out.println("----------------------");
        System.out.println("| Purchase a Product |");
        System.out.println("----------------------");
    
        System.out.print("Enter your login: ");
        String login = scanner.nextLine();
    
        Customer customer = customerManager.findCustomersByLogin(login);
    
        if (customer == null) {
            System.out.println("Customer with login " + login + " not found.");
            return;
        }
    
        System.out.println("Available products:");
        
        productManager.displayAllProducts();
    
        System.out.println("Enter the number of the product you want to purchase.");
        //int productNumber = scanner.nextInt(); scanner.nextLine();
        int productNumber = InputFromKeyboard.inputNumberFromRange(1, productList.size());
    
        if (productNumber < 1 || productNumber > productList.size()) {
            System.out.println("Invalid product number.");
            return;
        }
    
        Product selectedProduct = productList.get(productNumber - 1);
    
        // System.out.print("Enter the quantity you want to purchase: ");
        //int quantityToPurchase = InputFromKeyboard.inputNumberFromRange(0, selectedProduct.getProductQuantity()); 

        // int quantityToPurchase;
        // while (true) {
        //     System.out.print("Enter the quantity to purchase: ");
        //     quantityToPurchase = scanner.nextInt(); scanner.nextLine(); 
        
        //     if (quantityToPurchase <= 0 || quantityToPurchase > selectedProduct.getProductQuantity()) {
        //         System.out.println("Invalid quantity. Please enter a valid quantity.");
        //     } else {
        //         break;
        //     }
        // }
        int quantityToPurchase;
        while (true) {
            System.out.print("Enter the quantity to purchase: ");
            
            if (scanner.hasNextInt()) {
                quantityToPurchase = scanner.nextInt(); scanner.nextLine(); 
                
                if (quantityToPurchase==0) {
                    break;
                } else if(quantityToPurchase <= 0 || quantityToPurchase > selectedProduct.getProductQuantity()) {
                    System.out.println("Invalid quantity. Please enter a valid quantity.");
                } else{
                    double totalPrice = quantityToPurchase * selectedProduct.getProductPrice();
                    double roundedTotalPrice = Math.round(totalPrice*100.0)/100.0;
                    if(roundedTotalPrice<=customer.getCustomerBalance()){
                        //customer.setCustomerBalance(customer.getCustomerBalance() - roundedTotalPrice);
                        customer.setCustomerBalance(Math.round((customer.getCustomerBalance() - roundedTotalPrice)*100.0)/100.0);
                        System.out.println("Purchase successful. Total cost: " + roundedTotalPrice + " EUR");
                        selectedProduct.setProductQuantity(selectedProduct.getProductQuantity() - quantityToPurchase);
                        Purchase newPurchase = new Purchase(
                            customer.getCustomerFirstname(),
                            customer.getCustomerLastname(),
                            customer.getCustomerLogin(),
                            selectedProduct.getProductName(),
                            selectedProduct.getProductType(),
                            quantityToPurchase,
                            totalPrice
                        );
                        purchaseList.add(newPurchase);
                        SaveLoadManager.saveCustomerList(customerList, "customerList");
                        SaveLoadManager.saveProductList(productList, "productList");
                        SaveLoadManager.savePurchaseList(purchaseList, "purchaseList");
                    
                    }else{       
                        System.out.println("Not enough money to buy!");
                    }
                    break;
                }
            } else {
                System.out.println("Invalid input. Please enter a valid integer quantity.");
                scanner.nextLine(); 
            }
        }
    

    
    
        //displayAllPurchases();
    }

    public List<Purchase> getPurchaseList(){
        return purchaseList;
    }
    
    public void displayPurchasesByLogin(){
        System.out.println();
        System.out.println("---------------------");
        System.out.println("| Purchases by Login|");
        System.out.println("---------------------");           
        System.out.print("Enter your login: ");
        String login = scanner.nextLine();  
        
        System.out.println("Purchases for customer with login: " + login);

        for(Purchase purchase: purchaseList){
            if(purchase.getPurchasedLogin().equals(login)){
                int purchaseNumber =1;
                System.out.print("Purchase #" + purchaseNumber+" - ");
                System.out.print(purchase.getPurchasedFirstName()+" ");
                System.out.print(purchase.getPurchasedLastName()+" ");
                System.out.print("("+purchase.getPurchasedLogin()+") ");
                System.out.print("-> "+purchase.getPurchasedProductName()+" ");
                System.out.print("("+purchase.getPurchasedProductType()+") ");
                System.out.print("Qty: "+purchase.getPurchasedProductQuantity()+", ");
                System.out.print(purchase.getPurchasedProductPrice() + " EUR.");
                System.out.println();
                
            }

        }
    }

    public void displayTotalPurchaseAmount(){
        displayAllPurchases();
        double totalAmount = 0.0;
        for(Purchase purchase : purchaseList){
            totalAmount += purchase.getPurchasedProductPrice();
        }
        double roundedTotalAmount = Math.round(totalAmount*100.0)/100.0;
        System.out.println("");
        System.out.println("Total purchase amount: " + roundedTotalAmount+" EUR.");
        System.out.println("");

    }

    private void displayAllPurchases(){
        System.out.println();
        System.out.println("-----------------");
        System.out.println("| All Purchases |");
        System.out.println("-----------------");   
        if(purchaseList.isEmpty()){
            System.out.println("No products found");
        }else{
            int purchaseNumber = 1;
            for(Purchase purchase : purchaseList){
                System.out.print("Purchase #" + purchaseNumber+" - ");
                System.out.print(purchase.getPurchasedFirstName()+" ");
                System.out.print(purchase.getPurchasedLastName()+" ");
                System.out.print("("+purchase.getPurchasedLogin()+") ");
                System.out.print("-> "+purchase.getPurchasedProductName()+" ");
                System.out.print("("+purchase.getPurchasedProductType()+") ");
                System.out.print("Qty: "+purchase.getPurchasedProductQuantity()+" ");
                System.out.print(purchase.getPurchasedProductPrice() + " EUR.");
                System.out.println();
                purchaseNumber++;                    
            }
        }
    }
}