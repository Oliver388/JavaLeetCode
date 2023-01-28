package solution;

import java.sql.ResultSet;
import java.util.Arrays;

/**
 * @author linglifan
 * @date 2022/09/28 18:14
 */
public class product238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] L = new int[n];
        int[] R = new int[n];

        L[0] = 1;
        for (int i=1;i<n;i++){
            L[i] = nums[i-1] * L[i-1];
        }

        R[n-1] = 1;
        for (int j=n-2;j>=0;j--){
            R[j] = nums[j+1] * R[j+1];
        }

        for (int i=0;i<n;i++){
            result[i] = L[i] * R[i];
        }
        return result;
    }

    /**
     * 空间复杂度O(1)
     */
    public int[] productExceptSelf2(int[] nums){
        int n = nums.length;
        int[] result = new int[n];

        result[0] = 1;
        for (int i=1;i<n;i++){
            result[i] = nums[i-1] * result[i-1];
        }

        int R =1;
        for (int j=n-1;j>=0;j--){
            result[j] = R * result[j];
            R *= nums[j];

        }

        return result;
    }
}
