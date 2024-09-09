import java.util.Arrays;

// https://leetcode.com/problems/spiral-matrix-iv/submissions/1383993997/?envType=daily-question&envId=2024-09-09
public class SpiralMatrixV {

    public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] matrix = new int[m][n];
        int row = 0, col = 0, dirIdx = 0;

        for (int i = 0; i < m; i++) {
            Arrays.fill(matrix[i], -1);
        }

        while (head != null) {
            matrix[row][col] = head.val;
            head = head.next;
            int nextRow = row + direction[dirIdx][0];
            int nextCol = col + direction[dirIdx][1];
            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n || matrix[nextRow][nextCol] != -1) {
                dirIdx = (dirIdx + 1) % 4;
            }
            row += direction[dirIdx][0];
            col += direction[dirIdx][1];
        }
        return matrix;
    }
}
