import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/replace-non-coprime-numbers-in-array/description/?envType=daily-question&envId=2025-09-16
public class ReplactNonCoprimeInArr {

    public static void main(String[] args) {
        System.out.println(replaceNonCoprimes(new int[]{6,4,3,2,7,6,2}));
        System.out.println(replaceNonCoprimes(new int[]{2,2,1,1,3,3,3}));
    }

    public static List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> stack= new ArrayList<>();

        for (int num : nums) {
            while (!stack.isEmpty()) {
                int top = stack.getLast();
                int gcd = gcd(top, num);

                // Find any two adjacent numbers in nums that are non-coprime(GCD(x, y) > 1), If no such numbers are found, stop the process
                if (gcd ==1) {
                    break;
                }

                stack.removeLast();
                num = (top/gcd)*num;
            }
            stack.add(num);
        }

        return stack;
    }

    public static int gcd(int a, int b) {
        if (b==0) {
            return a;
        }
        return gcd(b,a%b);
    }
}
