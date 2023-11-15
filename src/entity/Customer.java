package entity;

import java.io.Serializable;

public class Customer implements Serializable {
    private String customerFirstname;
    private String customerLastname;
    private String customerLogin;
    private double customerBalance;
    private int customerNumberOfPurchases;
    public Customer(String customerFirstname, String customerLastname, String customerLogin, double customerBalance,
            int customerNumberOfPurchases) {
        this.customerFirstname = customerFirstname;
        this.customerLastname = customerLastname;
        this.customerLogin = customerLogin;
        this.customerBalance = customerBalance;
        this.customerNumberOfPurchases = customerNumberOfPurchases;
    }
    public String getCustomerFirstname() {
        return customerFirstname;
    }
    public void setCustomerFirstname(String customerFirstname) {
        this.customerFirstname = customerFirstname;
    }
    public String getCustomerLastname() {
        return customerLastname;
    }
    public void setCustomerLastname(String customerLastname) {
        this.customerLastname = customerLastname;
    }
    public String getCustomerLogin() {
        return customerLogin;
    }
    public void setCustomerLogin(String customerLogin) {
        this.customerLogin = customerLogin;
    }
    public double getCustomerBalance() {
        return customerBalance;
    }
    public void setCustomerBalance(double customerBalance) {
        this.customerBalance = customerBalance;
    }
    public int getCustomerNumberOfPurchases() {
        return customerNumberOfPurchases;
    }
    public void setCustomerNumberOfPurchases(int customerNumberOfPurchases) {
        this.customerNumberOfPurchases = customerNumberOfPurchases;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customerFirstname == null) ? 0 : customerFirstname.hashCode());
        result = prime * result + ((customerLastname == null) ? 0 : customerLastname.hashCode());
        result = prime * result + ((customerLogin == null) ? 0 : customerLogin.hashCode());
        long temp;
        temp = Double.doubleToLongBits(customerBalance);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + customerNumberOfPurchases;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Customer other = (Customer) obj;
        if (customerFirstname == null) {
            if (other.customerFirstname != null)
                return false;
        } else if (!customerFirstname.equals(other.customerFirstname))
            return false;
        if (customerLastname == null) {
            if (other.customerLastname != null)
                return false;
        } else if (!customerLastname.equals(other.customerLastname))
            return false;
        if (customerLogin == null) {
            if (other.customerLogin != null)
                return false;
        } else if (!customerLogin.equals(other.customerLogin))
            return false;
        if (Double.doubleToLongBits(customerBalance) != Double.doubleToLongBits(other.customerBalance))
            return false;
        if (customerNumberOfPurchases != other.customerNumberOfPurchases)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Customer [customerFirstname=" + customerFirstname + ", customerLastname=" + customerLastname
                + ", customerLogin=" + customerLogin + ", customerBalance=" + customerBalance
                + ", customerNumberOfPurchases=" + customerNumberOfPurchases + "]";
    }

}