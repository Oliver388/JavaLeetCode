package solution;

/**
 * @author linglifan
 * @date 2022/09/05 18:36
 */
public class SingleNumber136 {
    public int singleNumber(int[] nums) {
        int size = nums.length;
        int result = 0;
        for (int i=0;i<size;i++){
            result = result^nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber136 singleNumber136 = new SingleNumber136();
        System.out.println(singleNumber136.singleNumber(new int[]{2,2,1}));
    }
}
