package solution;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;
import org.omg.CORBA.RepositoryIdHelper;

/**
 * @author linglifan
 * @date 2022/12/01 10:03
 */
public class Hot100_34 {
    public int[] searchRange(int[] nums, int target) {
        int index = binarySearch(nums, target);
        if (index == -1) return new int[]{-1,-1};
        int left = index;
        int right = index;
        while (left-->=0&&nums[left--]==target){
            left--;
        }
        while (right++ < nums.length && nums[right++] == target){
            right++;
        }

        return new int[]{left,right};
    }

    private int binarySearch(int[] nums, int target){
        int left = 0;
        int right = nums.length;
        while (left <= right){
            int mid = left + (right-left)/2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] < target) {
                left = mid + 1;
            }else {
                right = mid+1;
            }
        }
        return -1;
    }

}
