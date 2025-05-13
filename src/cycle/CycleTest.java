package cycle;

public class CycleTest {
    public static void main(String[] args) {
        CycleUtil.order(5, 100);
        System.out.println(CycleUtil.sum(1, 1000));
        CycleUtil.upsideDownOrder(1, 50);
        System.out.println(CycleUtil.orderList(1, 100));
        System.out.println(CycleUtil.upsideDownOrderList(1, 100));
        System.out.println(CycleUtil.oddList(1, 20));
        CycleUtil.odd(1, 20);
        System.out.println(CycleUtil.evenList(1, 20));
        CycleUtil.even(1, 20);
        System.out.println(CycleUtil.qtyOdd(1, 100));
        System.out.print(CycleUtil.qtyEven(1, 100));
    }
}