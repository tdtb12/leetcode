package array;

// https://leetcode.com/problems/special-array-i/description/?envType=daily-question&envId=2025-02-01
public class SpecialArray {
    public boolean isArraySpecial(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            int first = nums[i];
            int second = nums[i + 1];
            if ((first + second) % 2 == 0) {
                return false;
            }
        }
        return true;
    }
}
