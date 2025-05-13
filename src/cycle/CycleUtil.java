package cycle;

import java.util.ArrayList;
import java.util.List;

public class CycleUtil {
    public static List<Integer> orderList(int first, int last) {
        List<Integer> numbers = new ArrayList();
        for (int i = first; i <= last; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    public static void order(int first, int last) {
        for (int i = first; i <= last; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int sum(int first, int last) {
        int sum = 0;
        for (int i = first; i <= last; i++) {
            sum += i;
        }
        return sum;
    }

    public static List<Integer> upsideDownOrderList(int first, int last) {
        List<Integer> numbers = new ArrayList();
        for (int i = last; i >= first; i--) {
            numbers.add(i);
        }
        return numbers;
    }

    public static void upsideDownOrder(int first, int last) {
        for (int i = last; i >= first; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static List<Integer> oddList(int first, int last) {
        List<Integer> numbers = new ArrayList();
        for (int i = first; i <= last; i++) {
            if (i % 2 != 0) {
                numbers.add(i);
            }
        }
        return numbers;
    }

    public static void odd(int first, int last) {
        for (int i = first; i <= last; i++) {
            if (i % 2 != 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static List<Integer> evenList(int first, int last) {
        List<Integer> numbers = new ArrayList();
        for (int i = first; i <= last; i++) {
            if (i % 2 == 0) {
                numbers.add(i);
            }
        }
        return numbers;
    }

    public static void even(int first, int last) {
        for (int i = first; i <= last; i++) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static int qtyOdd(int first, int last) {
        int qty = 0;
        for (int i = first; i <= last; i++) {
            if (i % 2 != 0) {
                qty++;
            }
        }
        return qty;
    }

    public static int qtyEven(int first, int last) {
        int qty = 0;
        for (int i = first; i <= last; i++) {
            if (i % 2 == 0) {
                qty++;
            }
        }
        return qty;
    }
}