// https://leetcode.com/problems/minimum-number-of-increments-on-subarrays-to-form-a-target-array/description/?envType=daily-question&envId=2025-10-30
public class MinNumberOperations {
    public static void main(String[] args) {
        System.out.println(minNumberOperations(new int[]{1, 2, 3, 2, 1}));
    }

    public static int minNumberOperations(int[] target) {
        int ans = target[0];
        for (int i = 1; i < target.length; i++)
            ans += Math.max(target[i] - target[i - 1], 0);
        return ans;
    }
}
