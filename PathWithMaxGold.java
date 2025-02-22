//  In a gold mine grid of mxn each cell represents an amount of gold, 0 if empty. Return the maximum no of gold you can collect. You can move left , right, up , 
// down. Never visit a cell with 0. 

public class GoldMine {
    public static void main(String[] args) {
        int[][] grid = {
            {0, 6, 0},
            {5, 8, 7},
            {0, 9, 0}
        };

        GoldMine solution = new GoldMine();
        int maxGold = solution.getMaximumGold(grid);
        System.out.println("Maximum gold collected: " + maxGold);
    }

    public int getMaximumGold(int[][] grid) {
        int maxGold = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        
        // Create a visited array with the same dimensions as grid.
        boolean[][] visited = new boolean[rows][cols];

        // Start DFS from every cell that contains gold.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] > 0) {
                    maxGold = Math.max(maxGold, dfs(grid, visited, i, j));
                }
            }
        }
        return maxGold;
    }

    private int dfs(int[][] grid, boolean[][] visited, int i, int j) {
        // Base case: Check boundaries, visited status, and if cell has gold.
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length ||
            visited[i][j] || grid[i][j] == 0) {
            return 0;
        }

        // Mark the cell as visited.
        visited[i][j] = true;
        int goldCollected = grid[i][j];

        // Explore all four directions.
        int up = dfs(grid, visited, i - 1, j);
        int down = dfs(grid, visited, i + 1, j);
        int left = dfs(grid, visited, i, j - 1);
        int right = dfs(grid, visited, i, j + 1);

        // Backtrack: unmark this cell as visited for other DFS paths.
        visited[i][j] = false;

        // Return the current cell's gold plus the best gold we can collect from one of the directions.
        return goldCollected + Math.max(Math.max(up, down), Math.max(left, right));
    }
}
