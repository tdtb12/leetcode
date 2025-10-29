// https://leetcode.com/problems/smallest-number-with-all-set-bits/submissions/?envType=daily-question&envId=2025-10-29
public class SmallestNumber {
    public int smallestNumber(int n) {
        int ans = 1;
        while (n > 0) {
            n = n >>> 1;
            ans = ans << 1;
        }
        return ans - 1;
    }
}
