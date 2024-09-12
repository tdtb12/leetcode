// https://leetcode.com/problems/minimum-bit-flips-to-convert-number/submissions/1386034963/?envType=daily-question&envId=2024-09-11
public class MinBitFlips {
    public int minBitFlips(int start, int goal) {
        int bitwise = start^goal;
        int count = 0;
        while (bitwise != 0) {
            // Check if the last bit is 1
            count += (bitwise & 1);
            // Right shift the number by 1 to check the next bit
            bitwise >>= 1;
        }
        return count;
    }
}
