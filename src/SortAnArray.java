import java.util.Arrays;

// https://leetcode.com/problems/sort-an-array/description/?envType=daily-question&envId=2024-07-25
public class SortAnArray {
    public static void main(String[] args) {
        int[] nums = new int[]{5, 1, 1, 2, 0, 0};
        mergeSort(0, nums.length - 1, nums,new int[nums.length]);
        System.out.println(Arrays.toString(nums));
    }

    private static void mergeSort(int start, int end, int[] nums, int[] temp) {
        if (end <= start) return;
        int mid = start + (end - start) / 2;
        mergeSort(start, mid, nums,temp);
        mergeSort(mid + 1, end, nums,temp);
        merge(start, mid, end, nums, temp);
    }

    private static void merge(int start, int mid, int end, int[] nums, int[] temp) {
        int left = start;
        int right = mid + 1;

        for (int i = start; i <= end; i++) {
            // comparison of left side is done
            if (left > mid) {
                temp[i] = nums[right];
                right++;
            }
            // comparison of right side is done
            else if (right > end) {
                temp[i] = nums[left];
                left++;
            } else if (nums[left] < nums[right]) {
                temp[i] = nums[left];
                left++;
            } else {
                temp[i] = nums[right];
                right++;
            }
        }

        for (int i = start; i <= end; i++) {
            nums[i] = temp[i];
        }
        System.out.println(Arrays.toString(temp));
    }


}
