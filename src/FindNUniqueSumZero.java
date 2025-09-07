import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/find-n-unique-integers-sum-up-to-zero/description/?envType=daily-question&envId=2025-09-07
public class FindNUniqueSumZero {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sumZero(5)));
    }

    public static int[] sumZero(int n) {
        List<Integer> ans = new ArrayList<>();

        for (int i = 1; i <= Math.floor((double) n / 2); i++) {
            ans.add(i);
            ans.add(-1 * i);
        }

        if (n % 2 == 1) {
            ans.add(0);
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
