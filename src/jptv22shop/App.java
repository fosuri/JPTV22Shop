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
            System.out.println("0. Exit");
            System.out.println("1. Add a new customer");
            System.out.println("2. Display all customers");
            System.out.println("3. Replenishment of balance");
            System.out.println("4. Change customer details");
            System.out.println("---------------------------");
            System.out.println("5. Add a new product");
            System.out.println("6. Display all products");
            System.out.println("7. Change product price");
            System.out.println("8. Product replenishment");
            System.out.println("---------------------------");
            System.out.println("9. Purchase");
            System.out.println("10. Purchased Products");
            System.out.println("11. Total sales");
            System.out.println("12. Customer rating by number of purchases");
            System.out.println("13. Product sales rating");

            System.out.print("Enter task number: ");
            int task = InputFromKeyboard.inputNumberFromRange(0, 13);
            System.out.println("Selected task is "+task+". Are you sure? Y/N");
            String continueRun = InputFromKeyboard.inputSympolYesOrNO();
            if(continueRun.equalsIgnoreCase("n")){
                continue;
            }
            
            switch (task) {
                case 0:
                    System.out.println("You left the store.");
                    repeat = false;
                    break;
                case 1:
                    customerManager.addCustomer();
                    break;
                case 2:
                    customerManager.displayAllCustomers();
                    break;
                case 3:
                    customerManager.replenishmentOfBalance();
                    break;
                case 4:
                    customerManager.changeCustomerDetails();
                    break;
                case 5:
                	productManager.addProduct();
                    break;
                case 6:
                    productManager.displayAllProducts();
                    break;
                case 7:
                    productManager.changeProductPrice();
                    break;
                case 8:
                    productManager.ProductReplenishment();
                    break;
                case 9:
                    storeManager.purchaseProduct();
                    break;
                case 10:
                    storeManager.displayPurchasesByLogin();
                    break;
                case 11:
                    storeManager.displayTotalPurchaseAmount();
                    break;
                case 12:
                    customerManager.customerRatingByNumberOfPurchases();
                    break;
                case 13:
                    productManager.productSalesRating();
                    break;
                default:
                    break;
            }           
        } while (repeat);        
    }
}