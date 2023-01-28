package solution;

/**
 * @author linglifan
 * @date 2022/10/13 09:34
 */
public class SUCU581 {
    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int min = nums[len -1];
        int max = nums[0];
        int begin = 0;
        int end = -1;
        for (int i=0;i<len;i++){
            if (nums[i] < max){
                end = i;
            }else {
                max = nums[i];
            }

            if (nums[len-1-i] > min){
                begin = len-1-i;
            }else {
                min = nums[len-i-1];
            }
        }
        return end-begin+1;
    }
}
