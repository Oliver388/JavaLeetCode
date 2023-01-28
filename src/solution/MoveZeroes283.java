package solution;

/**
 * @author linglifan
 * @date 2022/09/24 18:43
 */
public class MoveZeroes283 {
    public void moveZeroes(int[] nums) {
        int point1 = 0;
        for (int i=0;i<nums.length;i++){
            if (nums[i] != 0){
                int temp = nums[i];
                nums[i] = nums[point1];
                nums[point1] = temp;
                point1++;
            }
        }
    }

}
