package solution;

/**
 * @author linglifan
 * @date 2022/09/13 20:00
 */
public class MaximumProductSubarray152 {
    public int maxProduct(int[] nums) {
        /**
         * 考虑当前位置如果是一个负数的话，那么我们希望以它前一个位置结尾的某个段的积也是个负数，
         * 这样就可以负负得正，并且我们希望这个积尽可能「负得更多」，即尽可能小。如果当前位置是一个正数的话，
         * 我们更希望以它前一个位置结尾的某个段的积也是个正数，并且希望它尽可能地大。
         */
        int length = nums.length;
        int[] maxF = new int[length];
        int[] minF = new int[length];
        System.arraycopy(nums,0,maxF,0,length);
        System.arraycopy(nums,0,minF,0,length);

        for (int i=1;i<length;i++){
            maxF[i] = Math.max(maxF[i-1]*nums[i],Math.max(nums[i],minF[i-1]*nums[i]));
            minF[i] = Math.min(minF[i-1]*nums[i],Math.min(nums[i],maxF[i-1]*nums[i]));
        }
        int ans = maxF[0];
        for (int i=1;i<length;i++){
            ans = Math.max(ans,maxF[i]);
        }
        return ans;
    }
}
