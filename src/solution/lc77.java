package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linglifan
 * @date 2023/01/17 21:57
 */
public class lc77 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        helper(n,k,0);
        return result;
    }

    public void helper(int n,int k,int start){
        if (list.size() == k){
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = start;i<=n-(k-list.size())+1;i++){
            list.add(i);
            helper(n,k,i+1);
            list.remove(list.size() - 1);
        }

    }
}
