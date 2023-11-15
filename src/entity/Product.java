package entity;

import java.io.Serializable;

public class Product implements Serializable {
    private String productName;
    private String productType;
    private double productPrice;
    private int productQuantity;
    private int productRating;
    public Product(String productName, String productType, double productPrice, int productQuantity,
            int productRating) {
        this.productName = productName;
        this.productType = productType;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productRating = productRating;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public String getProductType() {
        return productType;
    }
    public void setProductType(String productType) {
        this.productType = productType;
    }
    public double getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }
    public int getProductQuantity() {
        return productQuantity;
    }
    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
    public int getProductRating() {
        return productRating;
    }
    public void setProductRating(int productRating) {
        this.productRating = productRating;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((productName == null) ? 0 : productName.hashCode());
        result = prime * result + ((productType == null) ? 0 : productType.hashCode());
        long temp;
        temp = Double.doubleToLongBits(productPrice);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + productQuantity;
        result = prime * result + productRating;
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
        Product other = (Product) obj;
        if (productName == null) {
            if (other.productName != null)
                return false;
        } else if (!productName.equals(other.productName))
            return false;
        if (productType == null) {
            if (other.productType != null)
                return false;
        } else if (!productType.equals(other.productType))
            return false;
        if (Double.doubleToLongBits(productPrice) != Double.doubleToLongBits(other.productPrice))
            return false;
        if (productQuantity != other.productQuantity)
            return false;
        if (productRating != other.productRating)
            return false;
        return true;
    }
    @Override
    public String toString() {
        return "Product [productName=" + productName + ", productType=" + productType + ", productPrice=" + productPrice
                + ", productQuantity=" + productQuantity + ", productRating=" + productRating + "]";
    }

}