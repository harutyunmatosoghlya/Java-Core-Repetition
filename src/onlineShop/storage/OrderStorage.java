package onlineShop.storage;

import onlineShop.exeption.OutOfStockException;
import onlineShop.model.Order;
import onlineShop.model.User;
import onlineShop.model.types.OrderType;

import java.util.Arrays;

public class OrderStorage {
    private Order[] orders;
    private int size;
    private final ProductStorage productStorage;

    public OrderStorage() {
        orders = new Order[10];
        size = -1;
        productStorage = new ProductStorage();
    }

    public void add(Order order) throws NullPointerException, OutOfStockException {
        if (size == orders.length) {
            extend();
        }
        order.setId(++size);
        orders[size] = order;
    }

    public void print() throws NullPointerException {
        for (int i = 0; i <= size; i++) {
            System.out.println(orders[i]);
        }
    }

    public void change(int id, String type) throws NullPointerException, OutOfStockException {
        Order order = getOrderById(id);
        OrderType orderType = OrderType.valueOf(type);
        if (order == null) {
            throw new NullPointerException();
        }
        if (orderType == OrderType.DELIVERED) {
            productStorage.reduce(order);
        }
        order.setOrderType(orderType);
    }

    public void cancel(int id) throws NullPointerException, OutOfStockException {
        Order order = getOrderById(id);
        if (order == null) {
            throw new NullPointerException();
        }
        order.setOrderType(OrderType.CANCELED);
    }

    public void printOrderByUser(User user) {
        for (int i = 0; i <= size; i++) {
            if (orders[i].getUser().equals(user)) {
                System.out.println(orders[i]);
            }
        }
    }


    private Order getOrderById(int id) throws OutOfStockException {
        if (id < 0 || id >= orders.length) {
            throw new OutOfStockException("The quantity you specified is more than the quantity of the product in stock or less than zero");
        }
        for (Order order : orders) {
            if (order.getId() == id) {
                return order;
            }
        }
        return null;
    }

    public void extend() {
        orders = Arrays.copyOf(orders, orders.length + 3);
    }
}