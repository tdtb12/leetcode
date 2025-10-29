// https://leetcode.com/problems/make-array-elements-equal-to-zero/submissions/1813915668/?envType=daily-question&envId=2025-10-28
public class CountValidSelections {
    public int countValidSelections(int[] nums) {
        int[] prefixSum = new int[nums.length];

        int cnt = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (num > 0) {
                cnt += num;
            }
            prefixSum[i] = cnt;
        }

        int leftSum = 0;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] == 0) {
                int diff = leftSum - (prefixSum[nums.length - 1] - prefixSum[i]);
                if (diff == 0) {
                    ans += 2;
                }
                if (Math.abs(diff) == 1) {
                    ans++;
                }
            }
            leftSum+=nums[i];
        }
        return ans;
    }
}
