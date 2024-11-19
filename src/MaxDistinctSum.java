import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/description/?envType=daily-question&envId=2024-11-19
public class MaxDistinctSum {
    public long maximumSubarraySum(int[] nums, int k) {
        long ans = 0;
        long sum = 0;
        Set<Integer> set = new HashSet<>();
        int left = 0;

        for (int right=0;right<nums.length;right++) {
            int num = nums[right];
            if (!set.contains(num)) {
                sum += num;
                set.add(num);

                if (set.size() == k) {
                    ans = Math.max(ans, sum);
                    int removed = nums[left];
                    sum-=removed;
                    set.remove(removed);
                    left++;
                }
            } else {
                while (nums[left]!=nums[right]) {
                    int removed = nums[left];
                    sum-=removed;
                    set.remove(removed);
                    left++;
                }
                left++;
            }

        }
        return ans;
    }
}
