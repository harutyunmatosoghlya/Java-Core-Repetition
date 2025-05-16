package onlineShop.model;

import onlineShop.model.types.ProductType;

import java.util.Objects;

public class Product {
    private int id;
    private String name;
    private String description;
    private double price;
    private int quantity;
    private ProductType productType;

    public Product(int id, String name, String description, double price, int quantity, ProductType productType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.productType = productType;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ProductType getType() {
        return productType;
    }

    public void setType(ProductType productType) {
        this.productType = productType;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Double.compare(price, product.price) == 0 && quantity == product.quantity && Objects.equals(name, product.name) && Objects.equals(description, product.description) && productType == product.productType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, price, quantity, productType);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", type=" + productType +
                '}';
    }
}