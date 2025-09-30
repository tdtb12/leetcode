import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// https://leetcode.com/problems/find-triangular-sum-of-an-array/description/?envType=daily-question&envId=2025-09-30
public class TriangularSum {
    public static void main(String[] args) {
        System.out.println(triangularSum(new int[]{1, 2, 3, 4, 5}));
    }

    public static int triangularSum(int[] nums) {
        List<Integer> list = Arrays.stream(nums).boxed().collect(Collectors.toList());

        while (list.size() > 1) {
            List<Integer> next = new ArrayList<>();
            for (int idx = 0; idx < list.size() - 1; idx++) {
                next.add((list.get(idx) + list.get(idx + 1)) % 10);
            }
            list = next;
        }
        return list.getFirst();
    }

}
