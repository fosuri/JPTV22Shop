package entity;

import java.io.Serializable;

public class Purchase implements Serializable {
    private String purchasedFirstName;
    private String purchasedLastName;
    private String purchasedLogin;
    private String purchasedProductName;
    private String purchasedProductType;
    private int purchasedProductQuantity;
    private double purchasedProductPrice;
    public Purchase(String purchasedFirstName, String purchasedLastName, String purchasedLogin,
            String purchasedProductName, String purchasedProductType, int purchasedProductQuantity,
            double purchasedProductPrice) {
        this.purchasedFirstName = purchasedFirstName;
        this.purchasedLastName = purchasedLastName;
        this.purchasedLogin = purchasedLogin;
        this.purchasedProductName = purchasedProductName;
        this.purchasedProductType = purchasedProductType;
        this.purchasedProductQuantity = purchasedProductQuantity;
        this.purchasedProductPrice = purchasedProductPrice;
    }
    public String getPurchasedFirstName() {
        return purchasedFirstName;
    }
    public void setPurchasedFirstName(String purchasedFirstName) {
        this.purchasedFirstName = purchasedFirstName;
    }
    public String getPurchasedLastName() {
        return purchasedLastName;
    }
    public void setPurchasedLastName(String purchasedLastName) {
        this.purchasedLastName = purchasedLastName;
    }
    public String getPurchasedLogin() {
        return purchasedLogin;
    }
    public void setPurchasedLogin(String purchasedLogin) {
        this.purchasedLogin = purchasedLogin;
    }
    public String getPurchasedProductName() {
        return purchasedProductName;
    }
    public void setPurchasedProductName(String purchasedProductName) {
        this.purchasedProductName = purchasedProductName;
    }
    public String getPurchasedProductType() {
        return purchasedProductType;
    }
    public void setPurchasedProductType(String purchasedProductType) {
        this.purchasedProductType = purchasedProductType;
    }
    public int getPurchasedProductQuantity() {
        return purchasedProductQuantity;
    }
    public void setPurchasedProductQuantity(int purchasedProductQuantity) {
        this.purchasedProductQuantity = purchasedProductQuantity;
    }
    public double getPurchasedProductPrice() {
        return purchasedProductPrice;
    }
    public void setPurchasedProductPrice(double purchasedProductPrice) {
        this.purchasedProductPrice = purchasedProductPrice;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((purchasedFirstName == null) ? 0 : purchasedFirstName.hashCode());
        result = prime * result + ((purchasedLastName == null) ? 0 : purchasedLastName.hashCode());
        result = prime * result + ((purchasedLogin == null) ? 0 : purchasedLogin.hashCode());
        result = prime * result + ((purchasedProductName == null) ? 0 : purchasedProductName.hashCode());
        result = prime * result + ((purchasedProductType == null) ? 0 : purchasedProductType.hashCode());
        result = prime * result + purchasedProductQuantity;
        long temp;
        temp = Double.doubleToLongBits(purchasedProductPrice);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        Purchase other = (Purchase) obj;
        if (purchasedFirstName == null) {
            if (other.purchasedFirstName != null)
                return false;
        } else if (!purchasedFirstName.equals(other.purchasedFirstName))
            return false;
        if (purchasedLastName == null) {
            if (other.purchasedLastName != null)
                return false;
        } else if (!purchasedLastName.equals(other.purchasedLastName))
            return false;
        if (purchasedLogin == null) {
            if (other.purchasedLogin != null)
                return false;
        } else if (!purchasedLogin.equals(other.purchasedLogin))
            return false;
        if (purchasedProductName == null) {
            if (other.purchasedProductName != null)
                return false;
        } else if (!purchasedProductName.equals(other.purchasedProductName))
            return false;
        if (purchasedProductType == null) {
            if (other.purchasedProductType != null)
                return false;
        } else if (!purchasedProductType.equals(other.purchasedProductType))
            return false;
        if (purchasedProductQuantity != other.purchasedProductQuantity)
            return false;
        if (Double.doubleToLongBits(purchasedProductPrice) != Double.doubleToLongBits(other.purchasedProductPrice))
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Purchase [purchasedFirstName=" + purchasedFirstName + ", purchasedLastName=" + purchasedLastName
                + ", purchasedLogin=" + purchasedLogin + ", purchasedProductName=" + purchasedProductName
                + ", purchasedProductType=" + purchasedProductType + ", purchasedProductQuantity="
                + purchasedProductQuantity + ", purchasedProductPrice=" + purchasedProductPrice + "]";
    }

}