package bookStorage;

import java.util.Scanner;

public class Library implements CommandsLibrary {
    private static final Scanner scanner = new Scanner(System.in);
    private static final BookStorage bookStorage = new BookStorage();

    public static void main(String[] args) {
        preloadBooks();
        runLibrary();
    }

    private static void preloadBooks() {
        bookStorage.add(new Book("A001", "Book1", "Author1", 100, 10));
        bookStorage.add(new Book("A002", "Book2", "Author2", 200, 20));
        bookStorage.add(new Book("A003", "Book3", "Author3", 300, 30));
        bookStorage.add(new Book("A004", "Book4", "Author4", 400, 40));
        bookStorage.add(new Book("A005", "Book5", "Author5", 500, 50));
    }

    private static void runLibrary() {
        boolean isRunning = true;
        while (isRunning) {
            CommandsLibrary.printCommands();
            String command = prompt("Enter command: ");
            switch (command) {
                case EXIT -> {
                    System.out.println("Library closed.");
                    isRunning = false;
                }
                case ADD -> addBook();
                case PRINT -> bookStorage.print();
                case SEARCH -> searchBooks();
                case UPDATE -> updateBook();
                case DELETE -> deleteBook();
                default -> System.out.println("Unknown command. Try again.");
            }
        }
    }

    private static void addBook() {
        String id = prompt("Enter book ID: ");
        String title = prompt("Enter book TITLE: ");
        String author = prompt("Enter AUTHOR NAME: ");
        double price = readDouble("Enter PRICE: ");
        int quantity = readInt("Enter QUANTITY: ");
        bookStorage.add(new Book(id, title, author, price, quantity));
        System.out.println("Book added successfully!");
    }

    private static void searchBooks() {
        CommandsLibrary.printSearchCommands();
        String option = prompt("Choose search option: ");
        switch (option) {
            case SEARCH_ID -> searchBy("ID");
            case SEARCH_TITLE -> searchBy("TITLE");
            case SEARCH_AUTHOR_NAME -> searchBy("AUTHOR");
            case SEARCH_PRICE -> searchByPriceRange();
            default -> System.out.println("Invalid search option.");
        }
    }

    private static void searchBy(String type) {
        String keyword = prompt("Enter " + type + " keyword: ");
        switch (type) {
            case "ID" -> bookStorage.searchBookByID(keyword);
            case "TITLE" -> bookStorage.searchBookByTitle(keyword);
            case "AUTHOR" -> bookStorage.searchBookByAuthorName(keyword);
        }
    }

    private static void searchByPriceRange() {
        String rangeInput = prompt("Enter price range (e.g., 100-300): ");
        String[] parts = rangeInput.split("-");
        if (parts.length == 2) {
            try {
                double min = Double.parseDouble(parts[0].trim());
                double max = Double.parseDouble(parts[1].trim());
                bookStorage.searchBookByPrice(min, max);
            } catch (NumberFormatException e) {
                System.out.println("Invalid number format.");
            }
        } else {
            System.out.println("Format must be: MIN-MAX");
        }
    }

    private static void updateBook() {
        String id = prompt("Enter book ID to update: ");
        Book book = bookStorage.getBookByID(id);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        CommandsLibrary.printUpdateCommands();
        String updateOption = prompt("Choose what to update: ");
        switch (updateOption) {
            case UPDATE_TITLE -> book.setTitle(prompt("New title: "));
            case UPDATE_AUTHOR_NAME -> book.setAuthorName(prompt("New author: "));
            case UPDATE_PRICE -> book.setPrice(readDouble("New price: "));
            case UPDATE_QUANTITY -> book.setQuantity(readInt("New quantity: "));
            case UPDATE_ALL -> {
                book.setTitle(prompt("New title: "));
                book.setAuthorName(prompt("New author: "));
                book.setPrice(readDouble("New price: "));
                book.setQuantity(readInt("New quantity: "));
            }
            default -> System.out.println("Unknown update option.");
        }
        System.out.println("Book updated.");
    }

    private static void deleteBook() {
        bookStorage.print();
        String id = prompt("Enter BOOK ID to delete: ");
        bookStorage.deleteBook(id);
    }

    private static String prompt(String message) {
        System.out.print(message);
        String input = scanner.nextLine().trim();
        while (input.isEmpty()) {
            System.out.print("Input can't be empty. Try again: ");
            input = scanner.nextLine().trim();
        }
        return input;
    }

    private static double readDouble(String message) {
        while (true) {
            try {
                return Double.parseDouble(prompt(message));
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }

    private static int readInt(String message) {
        while (true) {
            try {
                return Integer.parseInt(prompt(message));
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid integer.");
            }
        }
    }
}