package employee;

public class EmployeeDemo implements CommandsEmployeeDemo {
    public static void main(String[] args) {
        boolean isRunning = true;
        while (isRunning) {
            CommandsEmployeeDemo.printCommands();
            String command = prompt("Enter command: ");
            switch (command) {
                case EXIT -> isRunning = exit();
                case ADD -> addEmployee();
                case PRINT -> employeeStorage.print();
                case SEARCH_ID -> searchById();
                case SEARCH_COMPANY -> searchByCompany();
                default -> System.out.println("Unknown command. Try again.");
            }
        }
    }

    private static boolean exit() {
        System.out.println("Application closed.");
        return false;
    }

    private static void addEmployee() {
        String name = getEmployeeName();
        String surname = getEmployeeSurname();
        String id = getUniqueId();
        double salary = readSalary();
        String company = getEmployeeCompany();
        String position = getEmployeePosition();
        Employee employee = new Employee(name, surname, id, salary, company, position);
        employeeStorage.add(employee);
        System.out.println("Employee added successfully!");
    }

    private static void searchById() {
        String keyword = prompt("Enter ID to search: ");
        employeeStorage.searchEmployeeById(keyword);
    }

    private static void searchByCompany() {
        String keyword = prompt("Enter COMPANY name to search: ");
        employeeStorage.searchEmployeeByCompany(keyword);
    }

    private static String getEmployeeName() {
        return prompt("Enter EMPLOYEE NAME: ");
    }

    private static String getEmployeeSurname() {
        return prompt("Enter EMPLOYEE SURNAME: ");
    }

    private static String getUniqueId() {
        String id = prompt("Enter EMPLOYEE ID: ");
        while (employeeStorage.checkId(id)) {
            id = prompt("ID already exists. Enter a new ID: ");
        }
        return id;
    }

    private static String getEmployeeCompany() {
        return prompt("Enter EMPLOYEE COMPANY: ");
    }

    private static String getEmployeePosition() {
        return prompt("Enter EMPLOYEE POSITION: ");
    }

    private static double readSalary() {
        while (true) {
            try {
                double salary = Double.parseDouble(prompt("Enter EMPLOYEE SALARY: "));
                if (salary <= 0) {
                    System.out.println("Salary must be a positive number.");
                    continue;
                }
                return salary;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private static String prompt(String message) {
        System.out.print(message);
        String input = scanner.nextLine().trim();
        while (input.isEmpty()) {
            System.out.print("Empty input. Try again: ");
            input = scanner.nextLine().trim();
        }
        return input;
    }
}