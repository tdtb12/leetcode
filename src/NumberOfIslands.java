import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/number-of-islands/description/?envType=daily-question&envId=2024-04-19
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int ans = 0;
        for (int x = 0; x < grid.length; x++) {
            for (int y = 0; y < grid[x].length; y++) {
                if (grid[x][y] == '1') {
                    ans++;
                    dfs(grid, x, y);
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid[0].length || y >= grid.length || grid[x][y] == '0' || grid[x][y] == '2') {
            return;
        }
        grid[x][y] = '2';
        dfs(grid, x - 1, y);
        dfs(grid, x + 1, y);
        dfs(grid, x + 1, y);
        dfs(grid, x, y + 1);
    }

    private void bfs(char[][] grid, int posX, int posY) {
        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(posX);
        queue.offer(posY);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();
            isIsland(grid,x-1,y,queue);
            isIsland(grid,x+1,y,queue);
            isIsland(grid,x,y-1,queue);
            isIsland(grid,x,y+1,queue);

        }
    }

    private boolean isIsland(char[][] grid, int x, int y, Queue<Integer> queue) {
        if (x < 0 || y < 0 || x >= grid[0].length || y >= grid.length || grid[x][y] == '0' || grid[x][y] == '2') {
            return false;
        }
        queue.offer(x);
        queue.offer(y);
        return true;
    }

}
