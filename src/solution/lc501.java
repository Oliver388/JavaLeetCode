package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author linglifan
 * @date 2023/01/14 21:40
 */
public class lc501 {

//    TreeNode pre;
//    int count;
//    int maxCount;
//    List<Integer> list = new ArrayList<>();
//    public int[] findMode(TreeNode root) {
//        pre = null;
//        count = 0;
//        maxCount = 0;
//        helper(root);
//        int[] res = new int[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            res[i] = list.get(i);
//        }
//        return res;
//
//    }
//
//    public void helper(TreeNode root){
//        if (root == null) return;
//        helper(root.left);
//        if (pre == null || root.val != pre.val ){
//            count = 1;
//        }else {
//            count++;
//        }
//
//        if (count > maxCount){
//            list.clear();
//            list.add(root.val);
//            maxCount = count;
//        }else if (count == maxCount){
//            list.add(root.val);
//        }
//        pre = root;
//        helper(root.right);
//    }

//    public int[] findMode(TreeNode root) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//        List<Integer> list  = new ArrayList<>();
//        if (root == null) return list.stream().mapToInt(Integer::intValue).toArray();
//        //获取频率map
//        helper(root,map);
//        map.entrySet().stream().sorted((c1,c2) -> )
//    }
//
//    void helper(TreeNode root, Map<Integer,Integer> map){
//
//    }
}
