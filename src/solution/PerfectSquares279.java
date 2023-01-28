package solution;

/**
 * @author linglifan
 * @date 2022/09/18 09:12
 */
public class PerfectSquares279 {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        int max = Integer.MAX_VALUE;
        for (int i=1;i<=n;i++){
            dp[i] = max;
        }
        dp[0] = 0;

        //先遍历背包
        for (int i=1;i<=n;i++){
            //遍历物品
            for (int j=1;j*j < i;j++){
                dp[i] = Math.min(dp[i-j*j] + 1,dp[j]);
            }
        }
        return dp[n];
    }
}
