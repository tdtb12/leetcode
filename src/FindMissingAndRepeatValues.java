import java.util.Arrays;

// https://leetcode.com/problems/find-missing-and-repeated-values/?envType=daily-question&envId=2025-03-06
public class FindMissingAndRepeatValues {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findMissingAndRepeatedValues(new int[][]{{1, 3}, {2,2}})));
    }

        public static int[] findMissingAndRepeatedValues(int[][] grid) {
            int n = grid.length;
            boolean[] isExist = new boolean[n * n];
            int missing = 0;
            int repeated = 0;

            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    int value = grid[row][col];
                    if (isExist[value - 1]) {
                        repeated = value;
                    }
                    isExist[value - 1] = true;
                }
            }

            for (int i = 0; i < isExist.length; i++) {
                if (!isExist[i]) {
                    missing = i + 1;
                }
            }

            return new int[]{repeated, missing};
        }
}
