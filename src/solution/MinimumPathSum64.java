package solution;

import java.sql.Array;

/**
 * @author linglifan
 * @date 2022/08/30 17:11
 */
public class MinimumPathSum64 {
    /**
     * 动态规划 dp[i][j]代表走到i行j列的时候总和最小值
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int depth = grid.length;
        int width = grid[0].length;
        if (depth == 0 || width == 0) return 0;
        int dp[][] = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        for (int i=0;i< dp.length;i++){
            for (int j=0;j<dp[i].length;j++){
                if (j >0 && i>0){
                    dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1]) + grid[i][j];
                } else if (j > 0) {
                    dp[i][j] = dp[i][j-1] + grid[i][j];
                }else if (i > 0){
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }
            }
        }
        return dp[grid.length - 1][grid[0].length - 1];
    }

    public static void main(String[] args) {
        MinimumPathSum64 minimumPathSum64 = new MinimumPathSum64();
        System.out.println(minimumPathSum64.minPathSum(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));

    }
}
