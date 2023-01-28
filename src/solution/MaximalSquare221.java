package solution;

import java.rmi.MarshalException;

/**
 * @author linglifan
 * @date 2022/09/15 18:57
 */
public class MaximalSquare221 {
    public int maximalSquare(char[][] matrix) {
        /**
         * dp[i][j]表示以第i行第j列为右下角所能构成的最大正方形边长,
         * 当我们判断以某个点为正方形右下角时最大的正方形时，那它的上方，左方和左上方三个点也一定是某个正方形的右下角，
         * 否则该点为右下角的正方形最大就是它自己了。这是定性的判断，那具体的最大正方形边长呢？我们知道，该点为右下角的正方形的最大边长，
         * 最多比它的上方，左方和左上方为右下角的正方形的边长多1，最好的情况是是它的上方，左方和左上方为右下角的正方形的大小都一样的，
         * 这样加上该点就可以构成一个更大的正方形。 但如果它的上方，左方和左上方为右下角的正方形的大小不一样，合起来就会缺了某个角落，
         * 这时候只能取那三个正方形中最小的正方形的边长加1了。
         */
        int max = 0;
        if (matrix.length ==0 || matrix[0].length == 0 || matrix == null){
            return max;
        }
        char[][] dp = new char[matrix.length][matrix[0].length];
        for (int i=0;i<matrix.length;i++){
            for (int j=0;j<matrix[0].length;j++){
                if (matrix[i][j] == '1'){
                    if (i==0 || j==0){
                        dp[i][j] = '1';
                    }else {
                        dp[i][j] = (char) (1+Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1])));
                    }

                    max = Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;
    }
}
