package managers;

import java.util.Comparator;
// import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import entity.Customer;
import tools.InputFromKeyboard;


public class CustomerManager {
    private List<Customer> customerList;
    private final Scanner scanner;

    public CustomerManager() {
        //this.customerList = new ArrayList<>();
        this.customerList = SaveLoadManager.loadCustomerList("customerList");
        this.scanner = new Scanner(System.in);
    }

    public void addCustomer(){
        System.out.println();
        System.out.println("------------------");
        System.out.println("| Add a new user |");
        System.out.println("------------------");

        System.out.print("Enter your first name: ");
        final String fname = scanner.nextLine();
        
        System.out.print("Enter your last name: ");
        final String lname = scanner.nextLine();
        
        String login = "";
        boolean repeat = true;

        while (repeat) {
            System.out.print("Enter your login: ");
            login = scanner.nextLine();
            if(isLoginTaken(login)){
                System.out.println("This login is already taken. Enter a different login.");
            } else {
                repeat = false;
            }
        } 
        
        final double balance = 0.00;

        Customer newCustomer = new Customer(fname, lname, login, balance, 0);
        customerList.add(newCustomer);
        System.out.println("The customer was successfully added!");
        SaveLoadManager.saveCustomerList(customerList, "customerList");
    }

    private boolean isLoginTaken(String login){
        return findCustomersByLogin(login) != null;
    }

    public Customer findCustomersByLogin(String login){
        for(Customer customer: customerList){
            if(customer.getCustomerLogin().equals(login)){
                return customer;
            }
        }
        return null;
    }

    public void displayAllCustomers(){
        System.out.println();
        System.out.println("---------------------");
        System.out.println("| List of Customers |");
        System.out.println("---------------------");

        if (customerList.isEmpty()){
            System.out.println("No customers found.");
        } else{
            int customerNumber = 1;
            for (Customer customer : customerList){
                System.out.print("Customer #" + customerNumber+" - ");
                System.out.print(customer.getCustomerFirstname()+" ");
                System.out.print(customer.getCustomerLastname()+", ");
                System.out.print("(" + customer.getCustomerLogin()+"), ");
                System.out.print(customer.getCustomerBalance()+" EUR, ");
                System.out.print(customer.getCustomerNumberOfPurchases()+".");
                System.out.println();
                customerNumber++;                
            }
        }
        System.out.println(customerList.size());
    }

    public void replenishmentOfBalance(){
        System.out.println();
        System.out.println("-----------------------------------");
        System.out.println("| Replenishment of client balance |");
        System.out.println("-----------------------------------");     

        System.out.print("Enter the customer's login: ");
        String login = scanner.nextLine();

        Customer customer = findCustomersByLogin(login);

        if(customer==null){
            System.out.println("Customer with the provided login not found.");
            return;
        }
        System.out.print("Enter the deposit amount (should be greater than 0 and have 2 decimal places(#.##)): ");
        double depositAmount = -1;

        while(depositAmount<=0){
            try {
                depositAmount = Double.parseDouble(scanner.nextLine());
                if(depositAmount==0){
                    break;
                }else if (depositAmount<=0 || Math.abs(depositAmount*100 - Math.round(depositAmount*100))>0.001){
                    System.out.println("Invalid amount. Amount should be greater than 0 and have 2 decimal places.");
                    System.out.print("Enter a valid deposit amount: ");
                    depositAmount=-1;                    
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                System.out.print("Enter a valid deposit amount: ");                 
            }
        }

        customer.setCustomerBalance(Math.round((customer.getCustomerBalance()+depositAmount)*100.0)/100.0);
        System.out.println("Deposit successful. New balance for " + customer.getCustomerFirstname() + " " +
        customer.getCustomerLastname() + " (" + customer.getCustomerLogin() + ") is " + customer.getCustomerBalance() + " EUR.");
        SaveLoadManager.saveCustomerList(customerList, "customerList");
    }
    
    public List<Customer> getCustomerList(){
        return customerList;
    }

    public void changeCustomerDetails(){
        System.out.println();
        System.out.println("---------------------------");
        System.out.println("| Change customer details |");
        System.out.println("---------------------------");     

        System.out.print("Enter the customer's login: ");
        String login = scanner.nextLine();
        Customer customer = findCustomersByLogin(login);
        if(customer==null){
            System.out.println("Customer with the provided login not found.");
            return;
        }
        
        boolean changeDetails = true;
        while (changeDetails) {
            System.out.print("Enter a new first name: ");
            String newFirstName = scanner.nextLine();
            System.out.print("Enter a new last name: ");
            String newLastName = scanner.nextLine();
            System.out.print("Enter a new login: ");
            String newLogin = scanner.nextLine();

            System.out.println("Your new first name: "+newFirstName);
            System.out.println("Your new last name: "+newLastName);
            System.out.println("Your new login: "+newLogin);

            System.out.println("Change account details? (y/n)");
            //String change = InputFromKeyboard.inputSympolYesOrNO();
            String change = scanner.nextLine();
            
            if (change.equalsIgnoreCase("y")) {
                System.out.println("Customer details have been changed!");
                customer.setCustomerFirstname(newFirstName);
                customer.setCustomerLastname(newLastName);
                customer.setCustomerLogin(newLogin);
                SaveLoadManager.saveCustomerList(customerList, "customerList");
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

    public void customerRatingByNumberOfPurchases(){
        System.out.println();
        System.out.println("------------------------------------------");
        System.out.println("| Customer rating by number of purchases |");
        System.out.println("------------------------------------------");
        List<Customer> sortedList = customerList.stream()
                    .sorted(Comparator.comparingInt(Customer::getCustomerNumberOfPurchases).reversed())
                    .toList();
        sortedList.forEach(customer -> System.out.println(customer.getCustomerFirstname() +" "+ customer.getCustomerLastname()+" (" + customer.getCustomerLogin()+") : " + customer.getCustomerNumberOfPurchases()));
    }
}