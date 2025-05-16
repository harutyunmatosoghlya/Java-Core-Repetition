package onlineShop;

import onlineShop.exeption.OutOfStockException;
import onlineShop.model.Order;
import onlineShop.model.Product;
import onlineShop.model.User;
import onlineShop.model.types.OrderType;
import onlineShop.model.types.PaymentMethod;
import onlineShop.model.types.ProductType;
import onlineShop.model.types.UserType;

import java.util.Date;

public class Shop implements ShopCommands {
    private static User currentUser;
    private static boolean isRun = true;

    public static void main(String[] args) {
        User user = new User(1, "User", "User", "User", UserType.USER);
        User admin = new User(2, "Admin", "Admin", "Admin", UserType.ADMIN);
        userStorage.register(user);
        userStorage.register(admin);
        run();
    }

    private static void addOrder() {
        int id = Integer.parseInt(prompt("Enter product id: "));
        int quantity = Integer.parseInt(prompt("Enter product quantity: "));
        double price = 0;
        PaymentMethod paymentMethod = PaymentMethod.valueOf(prompt("Enter payment method (card, cash or paypal): ").toUpperCase());
        boolean done = true;
        while (done) {
            try {
                price = productStorage.getPriceByQuantity(id, quantity);
                done = false;
                System.out.println("Price: " + price);
                String command = prompt("Do you want to buy this product in such quantity and at such a price? (y/n): ");
                if (command.equalsIgnoreCase("y")) {
                    Order order = new Order();
                    order.setQuantity(quantity);
                    order.setPrice(price);
                    order.setPaymentMethod(paymentMethod);
                    order.setOrderType(OrderType.NEW);
                    order.setUser(currentUser);
                    order.setDate(new Date());
                    order.setProduct(productStorage.getProductById(id));
                    orderStorage.add(order);
                }
            } catch (OutOfStockException e) {
                System.out.println(e.getMessage() + ". Please enter a valid product id.");
            }
        }
    }

    private static Product addProduct() {
        int id = Integer.parseInt(prompt("Enter ID: "));
        String name = prompt("Enter name: ");
        String description = prompt("Enter description: ");
        double price = Double.parseDouble(prompt("Enter price: "));
        int quantity = Integer.parseInt(prompt("Enter quantity: "));
        ProductType productType = ProductType.valueOf(prompt("Enter product type (electronics, clothing or books): ").toUpperCase());
        return new Product(id, name, description, price, quantity, productType);
    }

    private static User register() {
        int id = Integer.parseInt(prompt("Enter ID: "));
        String name = prompt("Enter name: ");
        String email = prompt("Enter email: ");
        String password = prompt("Enter password: ");
        UserType userType = UserType.valueOf(prompt("Enter user type (user or admin): ").toUpperCase());
        return new User(id, name, email, password, userType);
    }

    private static String login() {
        System.out.print("Enter Username and Password (e.g., username-password): ");
        return scanner.nextLine();
    }

    private static String prompt(String message) {
        System.out.print(message);
        String input = scanner.nextLine().trim();
        while (input.isEmpty()) {
            System.out.print("Nothing entered. Try again: ");
            input = scanner.nextLine().trim();
        }
        return input;
    }

    private static void shutdown() {
        System.out.println("shop center is now closed.");
        isRun = false;
    }

    private static void run() {
        if (currentUser == null) {
            authCommands();
        } else if (currentUser.getUserType() == UserType.ADMIN) {
            adminCommands();
        } else {
            userCommands();
        }
    }

    private static void userCommands() {
        while (isRun) {
            ShopCommands.printUserCommands();
            String command = prompt("Enter command: ");
            switch (command) {
                case EXIT -> shutdown();
                case LOGOUT -> {
                    currentUser = null;
                    run();
                }
                case PRINT_ALL_PRODUCTS -> productStorage.print();
                case BUY_PRODUCT -> addOrder();
                case PRINT_MY_ORDERS -> orderStorage.printOrderByUser(currentUser);
                case CANCEL_ORDER_BY_ID -> {
                    boolean done = true;
                    while (done) {
                        try {
                            orderStorage.cancel(Integer.parseInt(prompt("Enter product ID: ")));
                            done = false;
                        } catch (OutOfStockException e) {
                            System.out.println(e.getMessage() + ". Try again.");
                        }
                    }
                }
            }
        }
    }

    private static void adminCommands() {
        while (isRun) {
            ShopCommands.printAdminCommands();
            String command = prompt("Enter command: ");
            switch (command) {
                case EXIT -> shutdown();
                case LOGOUT -> {
                    currentUser = null;
                    run();
                }
                case ADD_PRODUCT -> productStorage.add(addProduct());
                case REMOVE_PRODUCT_BY_ID ->
                        productStorage.removeProductById(Integer.parseInt(prompt("Enter product ID: ")));
                case PRINT_PRODUCTS -> productStorage.print();
                case PRINT_USERS -> userStorage.print();
                case PRINT_ORDERS -> orderStorage.print();
                case CHANGE_ORDER_STATUS -> {
                    boolean done = true;
                    while (done) {
                        try {
                            orderStorage.change(Integer.parseInt(prompt("Enter order id: ")), prompt("Enter new order type (new, delivered or canceled): ").toUpperCase());
                            done = false;
                        } catch (OutOfStockException e) {
                            System.out.println(e.getMessage() + ". Try again.");
                        }
                    }
                }
            }
        }
    }

    private static void authCommands() {
        while (isRun) {
            ShopCommands.printAuthCommands();
            String command = prompt("Enter command: ");
            switch (command) {
                case EXIT -> shutdown();
                case LOGIN -> {
                    currentUser = userStorage.login(login());
                    run();
                }
                case REGISTER -> {
                    currentUser = userStorage.register(register());
                    run();
                }
            }
        }
    }
}