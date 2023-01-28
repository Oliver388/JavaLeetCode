package solution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author linglifan
 * @date 2023/01/18 09:44
 */
public class lc216 {
    List<Integer> list = new LinkedList<>();
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        helper(k,n,1,0);
        return result;
    }

    public void helper(int k,int n,int start,int sum){
        if (sum > n) return;
        if (list.size() > k) return;
        if (sum == n && list.size() == k){

                result.add(new ArrayList<>(list));
                return;


        }
        for (int i= start;i<=9;i++){
            list.add(i);
            sum += i;
            helper(k,n,i+1,sum);
            sum -= i;
            list.remove(list.size()-1);

        }

    }

    public static void main(String[] args) {
        lc216 lc216 = new lc216();
        List<List<Integer>> lists = lc216.combinationSum3(3, 7);
        System.out.println(lists);
    }
}
