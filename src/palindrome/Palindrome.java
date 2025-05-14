package palindrome;

public class Palindrome {
    public static boolean isPalindrome(String str) {
        String test = new StringBuilder(str).reverse().toString();
        return test.equals(str);
    }
}