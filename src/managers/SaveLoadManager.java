package managers;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import entity.Customer;
import entity.Product;
import entity.Purchase;

public class SaveLoadManager {
    public static void saveCustomerList(List<Customer> customerList, String filename){
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(customerList);
            System.out.println("The customer list has been saved to the "+filename+" file!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static List<Customer> loadCustomerList(String filename){
        List<Customer> customerList = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            customerList = (List<Customer>) inputStream.readObject();
            System.out.println("The cuscomer list has been loaded from the "+filename+" file!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Customer list is empty.");
            //e.printStackTrace();
        }
        if (customerList == null){
            customerList = new ArrayList<>();
        }
        return customerList;
    }

    public static void saveProductList(List<Product> productList, String filename){
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(productList);
            System.out.println("The product list has been saved to the "+filename+" file!");
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }

    @SuppressWarnings("unchecked")
    public static List<Product> loadProductList(String filename){
        List<Product> productList = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            productList = (List<Product>) inputStream.readObject();
            System.out.println("The product list has been loaded from the "+filename+" file!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Product list is empty.");
            //e.printStackTrace();
        }
        if (productList == null){
            productList = new ArrayList<>();
        }
        return productList;
    }


    public static void savePurchaseList(List<Purchase> purchaseList, String filename){
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(filename))) {
            outputStream.writeObject(purchaseList);
            System.out.println("The purchase list has been saved to the "+filename+" file!");
        } catch (IOException e) {
            e.printStackTrace();
        }        
    }

    @SuppressWarnings("unchecked")
    public static List<Purchase> loadPurchaseList(String filename){
        List<Purchase> purchaseList = new ArrayList<>();
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(filename))) {
            purchaseList = (List<Purchase>) inputStream.readObject();
            System.out.println("The purchase list has been loaded from the "+filename+" file!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Purchase list is empty.");
            //e.printStackTrace();
        }
        if (purchaseList == null){
            purchaseList = new ArrayList<>();
        }
        return purchaseList;
    }
}