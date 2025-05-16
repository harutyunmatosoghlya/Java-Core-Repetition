package onlineShop;

import onlineShop.model.User;
import onlineShop.storage.OrderStorage;
import onlineShop.storage.ProductStorage;
import onlineShop.storage.UserStorage;

import java.util.Scanner;

public interface ShopCommands {
    Scanner scanner = new Scanner(System.in);
    ProductStorage productStorage = new ProductStorage();
    UserStorage userStorage = new UserStorage();
    OrderStorage orderStorage = new OrderStorage();
    String EXIT = "exit";

    String LOGIN = "0";
    String REGISTER = "1";

    String LOGOUT = "0";
    String ADD_PRODUCT = "1";
    String REMOVE_PRODUCT_BY_ID = "2";
    String PRINT_PRODUCTS = "3";
    String PRINT_USERS = "4";
    String PRINT_ORDERS = "5";
    String CHANGE_ORDER_STATUS = "6";

    String PRINT_ALL_PRODUCTS = "1";
    String BUY_PRODUCT = "2";
    String PRINT_MY_ORDERS = "3";
    String CANCEL_ORDER_BY_ID = "4";

    static void printAuthCommands() {
        System.out.println("Please input '" + EXIT + "' to exit");
        System.out.println("Please input '" + LOGIN + "' to login.");
        System.out.println("Please input '" + REGISTER + "' to register.");
    }

    static void printAdminCommands() {
        System.out.println("Please input '" + EXIT + "' to exit");
        System.out.println("Please input '" + LOGOUT + "' to logout.");
        System.out.println("Please input '" + ADD_PRODUCT + "' to add a product.");
        System.out.println("Please input '" + REMOVE_PRODUCT_BY_ID + "' to remove a product by ID.");
        System.out.println("Please input '" + PRINT_PRODUCTS + "' to print all products.");
        System.out.println("Please input '" + PRINT_USERS + "' to print all users.");
        System.out.println("Please input '" + PRINT_ORDERS + "' to print all orders.");
        System.out.println("Please input '" + CHANGE_ORDER_STATUS + "' to change order status.");
    }

    static void printUserCommands() {
        System.out.println("Please input '" + EXIT + "' to exit");
        System.out.println("Please input '" + LOGOUT + "' to logout.");
        System.out.println("Please input '" + PRINT_ALL_PRODUCTS + "' to view available products.");
        System.out.println("Please input '" + BUY_PRODUCT + "' to buy a product.");
        System.out.println("Please input '" + PRINT_MY_ORDERS + "' to view your orders.");
        System.out.println("Please input '" + CANCEL_ORDER_BY_ID + "' to cancel an order by ID.");
    }
}