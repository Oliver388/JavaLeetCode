package solution;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;

/**
 * @author linglifan
 * @date 2022/09/13 15:04
 */
public class HouseRobber198 {
    public int rob(int[] nums) {
        int n=nums.length;
        if (n==0) return 0;
        if (n==1) return nums[0];
        //dp是考虑下标i（包括i）以内的房屋，最多可以偷窃的金额为dp[i]
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for (int i=2;i<nums.length;i++){
            //dp[i]如果当天偷，那么dp[i]为dp[i-2]+nums[i];如果不偷，那么dp[i]为dp[i-1]
            dp[i] = Math.max(dp[i-2] + nums[i],dp[i-1]);
        }
        return dp[nums.length -1];
    }
}
