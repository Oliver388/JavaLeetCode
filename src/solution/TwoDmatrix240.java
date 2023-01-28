package solution;

/**
 *
 * @author linglifan
 * @date 2022/09/29 10:23
 */
public class TwoDmatrix240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        for (int[] nums : matrix) {
            int index = binarySearch(nums, target);
            if (index >= 0) return true;
        }
        return false;
    }


    /*
    因为每一行都是按照顺序从小到大的，因此我们可以对每一行进行二分查找
     */
    public int binarySearch(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
        while (low <= high){
            int mid = (high - low)/2 + low;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] >target){
                high = mid - 1;
                
            }else {
                low = mid +1;
            }
        }
        return -1;
    }
}
