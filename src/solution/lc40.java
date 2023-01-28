package solution;

import java.util.*;

/**
 * @author linglifan
 * @date 2023/01/28 10:19
 */
public class lc40 {

    List<List<Integer>> result = new ArrayList<>();
    List<Integer> temp = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.fill(used,false);
        Arrays.sort(candidates);
        helper(candidates,target,0,0);
        return result;
    }

    public void helper(int[] candidates, int target, int startIndex, int sum){
        if (sum == target){
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) continue;
            if (i > 0 && candidates[i] == candidates[i-1] && !used[i-1]){
                continue;
            }
            sum += candidates[i];
            temp.add(candidates[i]);
            helper(candidates,target,i+1,sum);
            sum -= candidates[i];
            temp.remove(temp.size() -1);
        }
    }
}
