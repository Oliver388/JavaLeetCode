package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;

/**
 * @author linglifan
 * @date 2022/09/19 14:03
 */
public class DisappearedNumbers448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
//        ArrayList<Integer> list = new ArrayList<>();
//        HashSet<Integer> set = new HashSet<>();
//
//        for (int i=0;i<nums.length;i++){
//            set.add(nums[i]);
//        }
//
//        for (int j=1;j<=nums.length;j++){
//            if (set.add(j)){
//                list.add(j);
//            }
//        }
//        return list;

        /**
         * 原地修改
         * 时间复杂度：O(n);
         * 空间复杂度：O(1)
         */
        int n = nums.length;
        for (int num :
                nums) {
            int x = (num - 1) % n;
            nums[x] += n;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<n;i++){
            if (nums[i] <= n){
                list.add(i+1);
            }
        }
        return list;

    }

    public static void main(String[] args) {
        DisappearedNumbers448 disappearedNumbers448 = new DisappearedNumbers448();
        List<Integer> a = disappearedNumbers448.findDisappearedNumbers(new int[]{4,3,2,7,8,2,3,1});
        System.out.println(a);
    }
}
