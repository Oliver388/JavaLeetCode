package solution;

import java.beans.beancontext.BeanContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author linglifan
 * @date 2023/01/26 14:11
 */
public class lc39 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> temp = new LinkedList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates,target,0,0);
        return result;
    }

    public void helper(int[] candidates, int target,int sum,int j){
        if (sum > target) return;
        if (sum == target){
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = j; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            sum += candidates[i];
            temp.add(candidates[i]);
            helper(candidates,target,sum,i);
            sum -= candidates[i];
            temp.remove(temp.size() - 1);
        }

    }
}
