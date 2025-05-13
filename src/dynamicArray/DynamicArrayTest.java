package dynamicArray;

public class DynamicArrayTest {
    public static void main(String[] args) {
        DynamicArrayUtil da = new DynamicArrayUtil();
        for (int i = 0; i <= 20; i++) {
            da.add(i);
        }
        System.out.println(da.getByIndex(5));
        da.print();
        da.deleteByIndex(5);
        da.print();
        da.set(5, 5);
        da.print();
        da.add(6, 6);
        da.print();
        System.out.println(da.exists(9));
        System.out.println(da.exists(50));
        System.out.println(da.getIndexByValue(1));
    }
}