package solution;

/**
 * @author linglifan
 * @date 2022/08/30 19:00
 */
public class SortColors75 {
    public void sortColors(int[] nums) {
        int size = nums.length;
        for (int i=0;i<size;i++){
            for (int j=i+1;j<size-1;j++){
                if (nums[j] > nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }
    
}
