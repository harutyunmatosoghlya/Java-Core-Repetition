package onlineShop.model;

import onlineShop.model.types.OrderType;
import onlineShop.model.types.PaymentMethod;

import java.util.Date;
import java.util.Objects;

public class Order {
    private int id;
    private User user;
    private Product product;
    private Date date;
    private double price;
    private OrderType orderType;
    private int quantity;
    private PaymentMethod paymentMethod;

    public Order(int id, User user, Product product, Date date, OrderType orderType, int quantity, PaymentMethod paymentMethod) {
        this.id = id;
        this.user = user;
        this.product = product;
        this.date = date;
        this.price = price;
        this.orderType = orderType;
        this.quantity = quantity;
        this.paymentMethod = paymentMethod;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public OrderType getOrderType() {
        return orderType;
    }

    public void setOrderType(OrderType orderType) {
        this.orderType = orderType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Double.compare(price, order.price) == 0 && quantity == order.quantity && Objects.equals(user, order.user) && Objects.equals(product, order.product) && Objects.equals(date, order.date) && orderType == order.orderType && paymentMethod == order.paymentMethod;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, product, date, price, orderType, quantity, paymentMethod);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", product=" + product +
                ", date=" + date +
                ", price=" + price +
                ", orderType=" + orderType +
                ", quantity=" + quantity +
                ", paymentMethod=" + paymentMethod +
                '}';
    }
}