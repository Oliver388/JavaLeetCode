package solution;

import javax.naming.InsufficientResourcesException;
import java.util.Arrays;

/**
 * @author linglifan
 * @date 2022/09/18 09:52
 */
public class LIS300 {
    public int lengthOfLIS(int[] nums) {
        //dp[i]表示第i位元素的最长上升子序列的长度
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        for(int i=0;i<nums.length;i++){
            for (int j=0;j<i;j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
        }
        int res = 0;
        for (int i = 0;i<dp.length;i++){
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
