package managers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entity.Customer;
import entity.Product;
import entity.Purchase;

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
        this.purchaseList = new ArrayList<>();
        this.customerList = customerManager.getCustomerList();
        this.productList = productManager.getProductList();
        this.scanner = new Scanner(System.in);
    }

    public void purchaseProduct() {
        System.out.println();
        System.out.println("---------------");
        System.out.println("| Purchase a Product |");
        System.out.println("---------------");
    
        System.out.print("Enter your login: ");
        String login = scanner.nextLine();
    
        Customer customer = customerManager.findCustomersByLogin(login);
    
        if (customer == null) {
            System.out.println("Customer with login " + login + " not found.");
            return;
        }
    
        System.out.println("Available products:");
        
        productManager.displayAllProducts();
    
        System.out.print("Enter the number of the product you want to purchase: ");
        int productNumber = scanner.nextInt(); scanner.nextLine();
    
        if (productNumber < 1 || productNumber > productList.size()) {
            System.out.println("Invalid product number.");
            return;
        }
    
        Product selectedProduct = productList.get(productNumber - 1);
    
        System.out.print("Enter the quantity you want to purchase: ");
        int quantityToPurchase = scanner.nextInt(); scanner.nextLine(); 
    
        if (quantityToPurchase <= 0 || quantityToPurchase > selectedProduct.getProductQuantity()) {
            System.out.println("Invalid quantity. Please enter a valid quantity.");
            return;
        }
    
        double totalPrice = quantityToPurchase * selectedProduct.getProductPrice();
        double roundedTotalPrice = Math.round(totalPrice*100.0)/100.0;
        customer.setCustomerBalance(roundedTotalPrice);
    
        System.out.println("Purchase successful. Total cost: $" + roundedTotalPrice);
    
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
    
        displayAllPurchases();
    }
    
    

    public void displayAllPurchases(){
        System.out.println();
        System.out.println("--------------------");
        System.out.println("| |");
        System.out.println("--------------------");   
        if(purchaseList.isEmpty()){
            System.out.println("No products found");
        }else{
            int purchaseNumber = 1;
            for(Purchase purchase : purchaseList){
                System.out.print("Product #" + purchaseNumber+", ");
                System.out.print("fName: " +purchase.getPurchasedFirstName() +", ");
                System.out.print("lName: " +purchase.getPurchasedLastName() +", ");
                System.out.print("login: " +purchase.getPurchasedLogin() +", ");
                System.out.print("pName: " +purchase.getPurchasedProductName() +", ");
                System.out.print("Type: " +purchase.getPurchasedProductType() +", ");
                System.out.print("Quantity: " +purchase.getPurchasedProductQuantity() +", ");
                System.out.print("Price: " +purchase.getPurchasedProductPrice() +" EUR.");
                System.out.println();
                purchaseNumber++;                    
            }
        }
    }
}