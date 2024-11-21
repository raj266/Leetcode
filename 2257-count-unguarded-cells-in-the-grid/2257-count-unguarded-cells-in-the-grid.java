class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] grid = new char[m][n];
        
        // Initialize grid
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = 'U'; // Unoccupied cell
            }
        }
        
        // Mark guards and walls
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 'G';
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 'W';
        }
        
        // Mark cells guarded by guards
        for (int[] guard : guards) {
            int r = guard[0];
            int c = guard[1];
            
            // Move north
            for (int i = r - 1; i >= 0; i--) {
                if (grid[i][c] == 'W' || grid[i][c] == 'G') {
                    break;
                }
                grid[i][c] = 'X';
            }
            
            // Move south
            for (int i = r + 1; i < m; i++) {
                if (grid[i][c] == 'W' || grid[i][c] == 'G') {
                    break;
                }
                grid[i][c] = 'X';
            }
            
            // Move west
            for (int j = c - 1; j >= 0; j--) {
                if (grid[r][j] == 'W' || grid[r][j] == 'G') {
                    break;
                }
                grid[r][j] = 'X';
            }
            
            // Move east
            for (int j = c + 1; j < n; j++) {
                if (grid[r][j] == 'W' || grid[r][j] == 'G') {
                    break;
                }
                grid[r][j] = 'X';
            }
        }
        
        // Count unoccupied and unguarded cells
        int unguardedCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'U') {
                    unguardedCount++;
                }
            }
        }
        
        return unguardedCount;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int m1 = 4, n1 = 6;
        int[][] guards1 = {{0, 0}, {1, 1}, {2, 3}};
        int[][] walls1 = {{0, 1}, {2, 2}, {1, 4}};
        System.out.println(sol.countUnguarded(m1, n1, guards1, walls1)); // Output: 7

        int m2 = 3, n2 = 3;
        int[][] guards2 = {{1, 1}};
        int[][] walls2 = {{0, 1}, {1, 0}, {2, 1}, {1, 2}};
        System.out.println(sol.countUnguarded(m2, n2, guards2, walls2)); // Output: 4
    }
}
