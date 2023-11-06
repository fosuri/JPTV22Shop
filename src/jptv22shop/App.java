package jptv22shop;

import managers.CustomerManager;
import managers.ProductManager;
import tools.InputFromKeyboard;

public class App {
    private CustomerManager customerManager;
    private ProductManager productManager;

    public App() {
        this.customerManager = new CustomerManager();
        this.productManager = new ProductManager();
    }

    
    public void run(){
        System.out.println("-------------------------");
        System.out.println("| Welcome to the store! |");
        System.out.println("-------------------------");
        boolean repeat = false;
        do {
            System.out.println("--------------");
            System.out.println("| Store menu |");
            System.out.println("--------------");
            System.out.println("0. Exit\n1. Add a new customer\n2. Add a new product\n3. Display all customers\n4. Display all products");
            System.out.println("5. Purchase\n6. Purchased Products\n7. Total Sales\n8. Replenishment of balance"); 
            System.out.print(">>> ");
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

                    break;
                case 6:
                
                    break;
                case 7:

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