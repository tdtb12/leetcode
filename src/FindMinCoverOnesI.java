// https://leetcode.com/problems/find-the-minimum-area-to-cover-all-ones-i/?envType=daily-question&envId=2025-08-24

public class FindMinCoverOnesI {
    public static void main(String[] args) {
        System.out.println(minimumArea(new int[][]{{0, 1, 0}, {1, 0, 1}}));
    }

    public static int minimumArea(int[][] grid) {
        int left = Integer.MAX_VALUE;
        int right = -1;
        int top = Integer.MAX_VALUE;
        int bottom = -1;

        int i = 0;
        int j = 0;
        while (i < grid.length) {
            while (j < grid[0].length) {
                if (grid[i][j] == 1) {
                    left = Math.min(i, left);
                    right = Math.max(i, right);
                    top = Math.min(j, top);
                    bottom = Math.max(j, bottom);
                }
                j++;
            }
            i++;
            j = 0;
        }
        return (right - left + 1) * (bottom - top + 1);
    }

}
