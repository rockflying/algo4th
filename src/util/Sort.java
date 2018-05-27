package util;

public class Sort {

    public static void insertSort(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            for (int j = i-1; j >= 0; --j) {
                if (nums[j+1] < nums[j]) {
                    int tmp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
    }

    public static void insertSort2(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            for (int j = i-1; j >= 0 && nums[j+1] < nums[j]; --j) {
                int tmp = nums[j+1];
                nums[j+1] = nums[j];
                nums[j] = tmp;
            }
        }
    }

    public static void insertSort3(int[] nums) {
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] >= nums[i-1]) {
                continue;
            }
            int val = nums[i];
            int j = i - 1;
            for (; j >= 0 && val < nums[j]; --j) {
                nums[j+1] = nums[j];
            }
            nums[j+1] = val;
        }
    }

    public static void shellInsertSort(int[] nums, int d) {
        for (int i = d; i < nums.length; ++i) {
            if (nums[i] >= nums[i-d]) {
                continue;
            }
            int val = nums[i];
            int j = i - d;
            for (; j >= 0 && val < nums[j]; j -= d) {
                nums[j+d] = nums[j];
            }
            nums[j+d] = val;
        }
    }

    public static void selectSort(int[] nums) {
        for (int i = 0; i < nums.length-1; ++i) {
            int k = i;
            for (int j = k+1; j < nums.length; ++j) {
                if (nums[j] < nums[k]) {
                    k = j;
                }
            }
            if (k != i) {
                int tmp = nums[i];
                nums[i] = nums[k];
                nums[k] = tmp;
            }
        }
    }

    public static void main(String... args) {
        int[] nums = {3,2,5,1,6,8,7,9,4};
        //insertSort3(nums);
        //shellInsertSort(nums, 1);
        selectSort(nums);
        for (int val : nums) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
