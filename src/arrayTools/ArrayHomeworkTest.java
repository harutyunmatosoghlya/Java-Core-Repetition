package arrayTools;

import java.util.Map;

public class ArrayHomeworkTest {
    public static void main(String[] args) {
        int[] nums = {1, 6, 3, 9, 15, 52, -3, 5, 8, 4, 4};
        int n = 6;
        System.out.println(ArrayHomeworkUtil.nQty(n, nums));
        int[] rec = ArrayHomeworkUtil.upsideDown(nums);
        for (int j : rec) {
            System.out.print(j + " ");
        }
        Map<Integer, Integer> map = ArrayHomeworkUtil.repeating(nums);
        System.out.println();
        map.forEach((key, value) -> System.out.println("Number: " + key + " - " + value + " times"));
        char[] chars = {'բ', 'ա', 'ր', 'և', 'ա', 'շ', 'խ', 'ա', 'ր', 'հ'};
        int count = ArrayHomeworkUtil.countArmenianVowels(chars);
        System.out.println(count);
    }
}
