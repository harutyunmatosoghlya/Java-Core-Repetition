package brace;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        BraceChecker checker = new BraceChecker(input);
        checker.check();
    }
}