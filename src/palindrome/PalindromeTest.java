package palindrome;

import java.util.Scanner;

public class PalindromeTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word;
        System.out.print("Enter a word: ");
        if (Palindrome.isPalindrome(word = sc.nextLine())) {
            System.out.print("The word: " + "\"" + word + "\"" + " - is a palindrome");
        } else {
            System.out.print("The word: " + "\"" + word + "\"" + " - is not a palindrome");
        }
    }
}