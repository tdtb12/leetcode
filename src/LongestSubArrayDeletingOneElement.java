// https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/description/?envType=daily-question&envId=2025-08-24

public class LongestSubArrayDeletingOneElement {
    public static void main(String[] args) {
//        System.out.println(longestSubarray(new int[]{1,1,0,1}));
        System.out.println(longestSubarray(new int[]{0,1,1,1,0,1,1,0,1}));
//        System.out.println(longestSubarray(new int[]{1,1,1}));
    }

    public static int longestSubarray(int[] nums) {
        int left =0;
        int zeroCount = 0;
        int ans =0;

        for (int right = 0; right < nums.length; right++) {
            if (nums[right]==0) {
                zeroCount++;
            }

            while (zeroCount>1) {
                if (nums[left]==0) {
                    zeroCount--;
                }
                left++;
            }

            ans = Math.max(ans, right-left);
        }

        return ans;
    }


}
