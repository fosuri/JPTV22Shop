package jptv22shop;

import managers.CustomerManager;
import managers.ProductManager;
import managers.StoreManager;
import tools.InputFromKeyboard;

public class App {
    private CustomerManager customerManager;
    private ProductManager productManager;
    private StoreManager storeManager;

    public App() {
        this.customerManager = new CustomerManager();
        this.productManager = new ProductManager();
        this.storeManager = new StoreManager(customerManager, productManager);
    }

    public void run(){
        System.out.println("-------------------------");
        System.out.println("| Welcome to the store! |");
        System.out.println("-------------------------");
        boolean repeat = true;
        do {
            System.out.println("--------------");
            System.out.println("| Store menu |");
            System.out.println("--------------");
            System.out.println("0. Exit\n1. Add a new customer\n2. Add a new product\n3. Display all customers\n4. Display all products");
            System.out.println("5. Purchase\n6. Purchased Products\n7. Total Sales\n8. Replenishment of balance"); 
            int task = InputFromKeyboard.inputNumberFromRange(0, 8);
            switch (task) {
                case 0:
                    System.out.println("You left the store.");
                    repeat = false;
                    break;
                case 1:
                    customerManager.addCustomer();
                    break;
                case 2:
                    productManager.addProduct();
                    break;
                case 3:
                    customerManager.displayAllCustomers();
                    break;
                case 4:
                    productManager.displayAllProducts();
                    break;
                case 5:
                	storeManager.purchaseProduct();
                    break;
                case 6:

                    break;
                case 7:
                    //
                    break;
                case 8:
                    customerManager.replenishmentOfBalance();
                    break;
                default:
                    break;
            }           
        } while (repeat);        
    }
}