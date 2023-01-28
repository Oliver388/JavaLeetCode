package solution;

/**
 * @author linglifan
 * @date 2022/09/18 13:18
 */
public class TargetSum494 {
    int count = 0;
    public int findTargetSumWays(int[] nums, int target) {
        return dfs(nums,target,0,0);
    }

    int dfs(int[] nums,int target,int idx,int sum){
        if (idx == nums.length-1) {
            if (sum == target){
                count++;
            }
        }else {
            dfs(nums,target,idx+1,sum + nums[idx]);
            dfs(nums,target,idx+1,sum - nums[idx]);
        }

        return count;
    }
}
