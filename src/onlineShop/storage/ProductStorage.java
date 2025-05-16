package onlineShop.storage;

import onlineShop.exeption.OutOfStockException;
import onlineShop.model.Order;
import onlineShop.model.Product;

import java.util.Arrays;

public class ProductStorage {
    private Product[] products;
    private int size;

    public ProductStorage() {
        products = new Product[10];
        size = -1;
    }

    public void add(Product product) throws NullPointerException {
        if (product == null) {
            throw new NullPointerException();
        }
        if (size == products.length) {
            extend();
        }
        products[++size] = product;
    }

    public void print() {
        for (int i = 0; i <= size; i++) {
            System.out.println(products[i]);
        }
    }

    public void removeProductById(int id) throws NullPointerException {
        int index = getIndexProductById(id);
        if (index == -1) {
            throw new NullPointerException();
        }
        for (int i = index; i < size - 1; i++) {
            products[i] = products[i + 1];
        }
        size--;
    }

    public double getPriceByQuantity(int id, int quantity) throws NullPointerException, OutOfStockException {
        Product product = products[getIndexProductById(id)];
        if (product == null) {
            throw new NullPointerException();
        }
        if (quantity <= 0 || quantity > product.getQuantity()) {
            throw new OutOfStockException("The quantity you specified is more than the quantity of the product in stock or less than zero");
        }
        if (product.getQuantity() <= quantity || product.getQuantity() > 0) {
            return product.getPrice() * quantity;
        }
        return -1;
    }

    public void reduce(Order order) throws NullPointerException, OutOfStockException {
        if (order == null) {
            throw new NullPointerException();
        }
        if (order.getQuantity() <= 0 || order.getQuantity() > products.length) {
            throw new OutOfStockException("The quantity you specified is more than the quantity of the product in stock or less than zero");
        }
        int productIndex = getIndexProductById(order.getProduct().getId());
        Product product = products[productIndex];
        product.setQuantity(product.getQuantity() - order.getQuantity());
    }

    public Product getProductById(int id) throws OutOfStockException {
        if (id < 0 || id > products.length) {
            throw new OutOfStockException("The quantity you specified is more than the quantity of the product in stock or less than zero");
        }
        return products[getIndexProductById(id)];
    }

    private int getIndexProductById(int id) {
        for (int i = 0; i <= size; i++) {
            if (products[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    private void extend() {
        products = Arrays.copyOf(products, products.length + 10);
    }
}