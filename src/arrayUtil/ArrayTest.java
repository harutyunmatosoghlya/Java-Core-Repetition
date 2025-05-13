package arrayUtil;

public class ArrayTest {
    public static void main(String[] args) {
        int[] nums = {1, 6, 3, 9, 15, 52, -3, 5, 8};
        ArrayUtil.printArray(nums);
        System.out.println(ArrayUtil.first(nums));
        System.out.println(ArrayUtil.last(nums));
        System.out.println(ArrayUtil.length(nums));
        System.out.println(ArrayUtil.min(nums));
        System.out.println(ArrayUtil.max(nums));
        ArrayUtil.middle(nums);
        System.out.println(ArrayUtil.qtyEven(nums));
        System.out.println(ArrayUtil.qtyOdd(nums));
        System.out.println(ArrayUtil.sum(nums));
        System.out.println(ArrayUtil.average(nums));
    }
}
