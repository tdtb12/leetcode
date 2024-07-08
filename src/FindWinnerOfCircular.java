import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/find-the-winner-of-the-circular-game/description/?envType=daily-question&envId=2024-07-08
public class FindWinnerOfCircular {
    public static void main(String[] args) {
        System.out.println(findTheWinner(5, 3));
    }

    public static int findTheWinner(int n, int k) {
        if (k == 1) return n;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        System.out.println(queue);
        int i = 1;
        while (queue.size() > 1) {
            if (i == k) {
                queue.remove();
                i = 1;
            } else {
                queue.offer(queue.poll());
                i++;
            }

        }
        return queue.poll();
    }
}
