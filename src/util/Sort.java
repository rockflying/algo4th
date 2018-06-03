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

    private static void adjust(int[] nums, int pos, int len) {
        int cur = nums[pos];
        for (int j = 2 * pos + 1; j < len; j = 2 * j + 1) {
            if (j+1 < len && nums[j+1] > nums[j]) {
                j++;
            }
            if (nums[j] < cur) {
                break;
            }
            nums[pos] = nums[j];
            nums[j] = cur;
            pos = j;
        }
    }

    public static void heapSort(int[] nums) {
        for (int i = (nums.length-1) / 2; i >= 0; --i) {
            adjust(nums, i, nums.length);
        }
        for (int i = nums.length - 1; i > 0; --i) {
            int tmp = nums[0];
            nums[0] = nums[i];
            nums[i] = tmp;
            adjust(nums, 0, i);
        }
    }

    public static void bubbleSort(int[] nums) {
        for (int i = 0; i < nums.length; ++i) {
            for (int j = 0; j < nums.length - i - 1; ++j) {
                if (nums[j] > nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }

    public static void bubbleSort2(int[] nums) {
        for (int i = 0; i < nums.length - 1; ++i) {
            boolean exchanged = false;
            for (int j = 0; j < nums.length - i - 1; ++j) {
                if (nums[j] > nums[j+1]) {
                    exchanged = true;
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
            if (!exchanged) {
                break;
            }
        }
    }

    // 记录最后一次交换的位置
    public static void bubbleSort3(int[] nums) {
        int i = nums.length - 1;
        while (i > 0) {
            int pos = 0;
            for (int j = 0; j < i; ++j) {
                if (nums[j] > nums[j+1]) {
                    pos = j;
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
            i = pos;
        }
    }

    private static int partition(int[] nums, int low, int high) {
        // TODO
        // 1. 随机取一个数放第一位
        // 2. 两端点和中间值三者取中位数
        int cur = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= cur) --high;
            nums[low] = nums[high];
            while (low < high && nums[low] <= cur) ++low;
            nums[high] = nums[low];
        }
        nums[low] = cur;
        return low;
    }

    public static void quickSort(int[] nums, int low, int high) {
        // TODO
        // high - low > k的时候才使用快排，小于k的时候用直接插入排序
        if (low < high) {
            int part = partition(nums, low, high);
            quickSort(nums, low, part - 1);
            quickSort(nums, part + 1, high);
        }
    }

    public static void quickSort2(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }

        int cur = nums[low];
        int i = low, j = high;
        while (i < j) {
            while (i < j && nums[j] >= cur) --j;
            while (i < j && nums[i] <= cur) ++i;
            if (i < j) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
        }

        nums[low] = nums[i];
        nums[i] = cur;

        quickSort2(nums, low, i - 1);
        quickSort2(nums, i + 1, high);
    }

    private static void merge(int[] nums, int low, int mid, int high) {
        int[] tmp = nums.clone();
        int k = low, i = low, j = mid + 1;
        while (i <= mid && j <= high) {
            if (tmp[i] < tmp[j]) {
                nums[k++] = tmp[i++];
            } else {
                nums[k++] = tmp[j++];
            }
        }
        while (i <= mid) {
            nums[k++] = tmp[i++];
        }
        while (j <= high) {
            nums[k++] = tmp[j++];
        }
    }

    public static void mergeSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = low / 2 + high / 2;
            mergeSort(nums, low, mid);
            mergeSort(nums, mid+1, high);
            merge(nums, low, mid, high);
        }
    }

    // 非递归
    public static void mergeSort2(int[] nums) {
        int step = 1;
        while (step < nums.length) {
            int s = step;
            step *= 2;
            int i = 0;
            while (i + step < nums.length) {
                merge(nums, i, i + s - 1, i + step - 1);
                i += step;
            }

            if (i + s < nums.length) {
                merge(nums, i, i + s - 1, i + nums.length - 1);
            }
        }
    }

    public static void main(String... args) {
        int[] nums = {3,2,5,1,6,8,7,9,4};
        //insertSort3(nums);
        //shellInsertSort(nums, 1);
        //selectSort(nums);
        //heapSort(nums);
        //bubbleSort3(nums);
        //quickSort2(nums, 0, nums.length-1);
        //mergeSort(nums, 0, nums.length - 1);
        mergeSort2(nums);
        for (int val : nums) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
