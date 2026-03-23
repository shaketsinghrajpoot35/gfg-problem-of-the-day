class Solution {
    public int maxProductPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        long MOD = (long)1e9 + 7;
        
        // Only need to keep track of current and previous row
        long[][] maxDp = new long[2][n];
        long[][] minDp = new long[2][n];
        
        maxDp[0][0] = minDp[0][0] = grid[0][0];
        
        // Initialize first row
        for(int j = 1; j < n; j++) {
            maxDp[0][j] = minDp[0][j] = maxDp[0][j-1] * grid[0][j];
        }
        
        for(int i = 1; i < m; i++) {
            int curr = i % 2;
            int prev = (i - 1) % 2;
            
            // First column
            maxDp[curr][0] = minDp[curr][0] = maxDp[prev][0] * grid[i][0];
            
            for(int j = 1; j < n; j++) {
                long currVal = grid[i][j];
                
                long dp1 = maxDp[prev][j] * currVal;
                long dp2 = minDp[prev][j] * currVal;
                long dp3 = maxDp[curr][j-1] * currVal;
                long dp4 = minDp[curr][j-1] * currVal;
                
                maxDp[curr][j] = Math.max(Math.max(dp1, dp2), Math.max(dp3, dp4));
                minDp[curr][j] = Math.min(Math.min(dp1, dp2), Math.min(dp3, dp4));
            }
        }
        
        long ans = maxDp[(m-1) % 2][n-1];
        return ans < 0 ? -1 : (int)(ans % MOD);
    }
}