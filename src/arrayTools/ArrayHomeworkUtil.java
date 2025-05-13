package arrayTools;

import java.util.HashMap;
import java.util.Map;

public class ArrayHomeworkUtil {
    public static int nQty(int n, int... nums) {
        int qty = 0;
        for (int num : nums) {
            if (num == n) {
                qty++;
            }
        }
        return qty;
    }

    public static int[] upsideDown(int... nums) {
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = nums[nums.length - 1 - i];
        }
        return res;
    }

    public static Map<Integer, Integer> repeating(int... nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        return map;
    }

    public static int countArmenianVowels(char[] chars) {
        String vowels = "աէըիոև";
        int count = 0;
        for (char ch : chars) {
            if (vowels.indexOf(ch) != -1) {
                count++;
            }
        }

        return count;
    }
}