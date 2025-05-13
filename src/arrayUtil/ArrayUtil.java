package arrayUtil;

public class ArrayUtil {
    public static void printArray(int... nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) {
                System.out.print(nums[i]);
                break;
            }
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    public static int first(int... nums) {
        return nums[0];
    }

    public static int last(int... nums) {
        return nums[nums.length - 1];
    }

    public static int length(int... nums) {
        return nums.length;
    }

    public static int min(int... nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }

    public static int max(int... nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }

    public static void middle(int... nums) {
        if (nums.length <= 2) {
            System.out.println("can't print middle values");
        }
        if (nums.length % 2 == 0) {
            System.out.print(nums[nums.length / 2  - 1]);
            System.out.println(" " + nums[nums.length / 2]);
        } else {
            System.out.println(nums[nums.length / 2]);
        }
    }

    public static int qtyEven(int... nums) {
        int qty = 0;
        for (int num : nums) {
            if (num % 2 == 0) {
                qty++;
            }
        }
        return qty;
    }

    public static int qtyOdd(int... nums) {
        int qty = 0;
        for (int num : nums) {
            if (num % 2 != 0) {
                qty++;
            }
        }
        return qty;
    }

    public static int sum(int... nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static double average(int... nums) {
        double average = sum(nums);
        return average / nums.length;
    }
}