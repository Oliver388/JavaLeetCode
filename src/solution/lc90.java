package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author linglifan
 * @date 2023/01/29 09:48
 */
public class lc90 {

    List<Integer> list = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (nums.length == 0){
            return Collections.emptyList();
        }
        used = new boolean[nums.length];
        Arrays.fill(used,false);
        Arrays.sort(nums);
        helper(nums,0);
        return result;
    }

    private void helper(int[] nums,int startIndex){
        result.add(new ArrayList<>(list));
        if (startIndex >= nums.length){
            return;
        }

        for (int i = startIndex; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i-1] && !used[i-1]){
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            helper(nums,i+1);
            list.remove(list.size()-1);
            used[i] = false;
        }
    }
}
